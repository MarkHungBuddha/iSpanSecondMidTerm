package tw.blackbean.servlet.productServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tw.blackbean.dao.ProductDAO;
import tw.blackbean.model.ProductBasicDataBean;

import java.io.IOException;
import java.util.List;

@WebServlet("/GetProductAll")
public class GetProductAll extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");


//		try {
//			if (resultBean != null) {
//
//				request.setAttribute("resultBean", resultBean);
//				request.getRequestDispatcher("/work/GetProductAll.jsp").forward(request, response);
//			} else {
//				response.setContentType("text/html;charset=UTF-8");
//				PrintWriter out = response.getWriter();
//				out.println("<script>alert('無資料');window.history.back();</script>");
//				out.close();
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//
//		}
		try {
			ProductDAO productDAO = new ProductDAO();
			List<ProductBasicDataBean> resultBean = productDAO.selectAll();
			request.setAttribute("resultBean", resultBean);
			request.getRequestDispatcher("/jsp/product/GetProductAll.jsp").forward(request, response);

		}catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("/jsp/error.jsp");
		}
	}


}
