package sbojgb.web.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter({
        "/faces/view/home.xhtml",
        "/faces/view/add-job.xhtml",
        "/faces/view/delete-job.xhtml",
        "/faces/view/details-job.xhtml"
})
public class GuestFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        HttpSession session = req.getSession();

        if (session.getAttribute("username") == null) {
            resp.sendRedirect("/faces/view/login.xhtml");
        } else {
            chain.doFilter(req, resp);
        }
    }
}
