package tw.blackbean.servlet.productServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import tw.blackbean.dao.ProductDAO;
import tw.blackbean.model.ProductBasicDataBean;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/GetProductById")
public class GetProductById extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        try {
            String productidStr = request.getParameter("productid");
            int productId = Integer.parseInt(productidStr);


            ProductDAO blackBeanDao = new ProductDAO();
            ProductBasicDataBean resultBean = blackBeanDao.selectById(productId);

//			BlackBean resultBean = session.get(BlackBean.class, productId);


            if (resultBean != null) {
                request.setAttribute("resultBean", resultBean);
                request.getRequestDispatcher("/work/GetProductById.jsp").forward(request, response);
            } else {
                response.setContentType("text/html;charset=UTF-8");
//				response.sendRedirect("/HibernateWebBlackBeans/BlackBean/dashboard.jsp?showAlert=true");
                PrintWriter out1 = response.getWriter();

                out1.println("<script>alert('無資料');window.history.back();</script>");
                out1.close();
            }

        } catch (Exception e) {
            e.printStackTrace();

            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out1 = response.getWriter();
            out1.println("<script>alert('輸入格式錯誤'); window.history.back();</script>");
            out1.close();
        } finally {
            out.close();

        }
    }
}
