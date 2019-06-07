package panda.web.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter({
        "/faces/view/home.xhtml",
        "/faces/view/admin/create-package.xhtml",
        "/faces/view/admin/pending.xhtml"
})
public class GuestUserFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        HttpSession session = req.getSession();

        if (session.getAttribute("username") == null) {
            resp.sendRedirect("/faces/view/index.xhtml");
        } else {
            chain.doFilter(req, resp);
        }

    }
}
