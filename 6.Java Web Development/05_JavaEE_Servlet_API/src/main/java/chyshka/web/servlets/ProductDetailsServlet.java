package chyshka.web.servlets;

import chyshka.domain.models.view.ProductDetailsViewModel;
import chyshka.service.ProductService;
import chyshka.util.HtmlReader;
import chyshka.util.ModelMapper;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/products/details")
public class ProductDetailsServlet extends HttpServlet {

    private final static String PRODUCT_DETAILS_HTML_FILE_PATH = "D:\\Programming stuff\\IdeaUltimateProjects\\Java Web Development\\05_JavaEE_Servlet_API\\src\\main\\resources\\views\\details-product.html";

    private final ProductService productService;
    private final HtmlReader htmlReader;
    private final ModelMapper modelMapper;

    @Inject
    public ProductDetailsServlet(ProductService productService, HtmlReader htmlReader, ModelMapper modelMapper) {
        this.productService = productService;
        this.htmlReader = htmlReader;
        this.modelMapper = modelMapper;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ProductDetailsViewModel productDetailsViewModel =
                this.modelMapper
                        .map(this.productService.findProductByName(req.getQueryString().split("=")[1]), ProductDetailsViewModel.class);


        String htmlFileContent = this.htmlReader.readHtmlFile(PRODUCT_DETAILS_HTML_FILE_PATH)
                .replace("{{productName}}", productDetailsViewModel.getName())
                .replace("{{productDescription}}", productDetailsViewModel.getDescription())
                .replace("{{productType}}", productDetailsViewModel.getType());

        resp.getWriter().println(htmlFileContent);

    }
}
