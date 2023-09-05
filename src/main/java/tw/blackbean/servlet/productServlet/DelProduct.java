package tw.blackbean.servlet.productServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import tw.blackbean.dao.HibernateUtil;
import tw.blackbean.dao.MemberDAO;
import tw.blackbean.dao.ProductDAO;


import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/DelProduct")
public class DelProduct extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {

			Long productid = Long.parseLong(request.getParameter("productid"));
			System.out.println("productid:"+productid);
			System.out.println("productid: "+ productid);

			ProductDAO dao = new ProductDAO();
			dao.delectById(Math.toIntExact(productid)); // Assuming you have this method in DAO

			response.sendRedirect("/GetProductAll"); // Redirect to the list of members after deletion
		} catch (Exception e) {
			e.printStackTrace();
			// Handle the error appropriately, maybe redirect to an error page
			response.sendRedirect("/jsp/error.jsp");

		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Long productid = Long.parseLong(request.getParameter("productid"));

			MemberDAO dao = new MemberDAO();
			dao.delete(productid); // Assuming you have this method in DAO

			response.sendRedirect("/GetProductAll"); // Redirect to the list of members after deletion
		} catch (Exception e) {
			e.printStackTrace();
			// Handle the error appropriately, maybe redirect to an error page
			response.sendRedirect("/jsp/error.jsp");
		}
	}

//	private static final long serialVersionUID = 1L;
//
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		SessionFactory factory = HibernateUtil.getSessionFactory();
//		Session session = factory.getCurrentSession();
//		PrintWriter out = response.getWriter();
//		response.setContentType("text/html;charset=UTF-8");
//
//
//
//		try {
//			String prouductIdStr = request.getParameter("productid");
//
//			int prouductIdToDelete = Integer.parseInt(prouductIdStr);
//
//			ProductDAO productDAO = new ProductDAO();
//			boolean resultBean = productDAO.delectById(prouductIdToDelete);
//
//			if (resultBean) {
//				out.write("刪除成功");
//			} else {
//				out.write("無此資料，刪除失敗<br/>");
//			}
//
//		} catch (NumberFormatException e) {
//			out.write("輸入格式錯誤。<br/>");
//		} catch (Exception e) {
//			out.write("刪除記錄時發生錯誤。<br/>");
//			e.printStackTrace();
//		} finally {
//			out.close();
//		}
//	}
}

