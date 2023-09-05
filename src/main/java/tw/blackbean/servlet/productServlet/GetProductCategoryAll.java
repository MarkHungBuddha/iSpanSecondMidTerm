package tw.blackbean.servlet.productServlet;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tw.blackbean.dao.ProductCategoryDAO;
import tw.blackbean.model.ProductCategoryDataBean;

import java.io.IOException;
import java.util.List;

@WebServlet("/GetProductAllCategory")
public class GetProductCategoryAll {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String referrer = request.getParameter("referrer");
        try {
            ProductCategoryDAO dao = new ProductCategoryDAO();
            List<ProductCategoryDataBean> productCategoryDataBeans = dao.selectAll(); // Assuming you have this method in DAO
            for (ProductCategoryDataBean productCategoryDataBean : productCategoryDataBeans) {
                System.out.println(productCategoryDataBean.toString());
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher(referrer);
            request.setAttribute("productCategoryDataBeans", productCategoryDataBeans);
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("/jsp/error.jsp");
        }
    }
}
