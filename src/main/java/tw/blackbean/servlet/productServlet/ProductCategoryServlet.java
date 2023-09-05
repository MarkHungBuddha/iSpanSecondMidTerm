package tw.blackbean.servlet.productServlet;

import tw.blackbean.dao.ProductCategoryDAO;
import tw.blackbean.model.ProductCategoryDataBean;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/productCategories")
public class ProductCategoryServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProductCategoryDAO productCategoryDAO = new ProductCategoryDAO();
        List<ProductCategoryDataBean> categories = productCategoryDAO.selectAll();

        request.setAttribute("categories", categories);
        request.getRequestDispatcher("/UpdateGetProduct.jsp").forward(request, response);
    }
}



