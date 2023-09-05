package tw.blackbean.servlet.productServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tw.blackbean.dao.MemberDAO;
import tw.blackbean.dao.ProductDAO;
import tw.blackbean.model.ProductBasicDataBean;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

@WebServlet("/UpdateProduct")
public class UpdateProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String productid = request.getParameter("id");
		if (productid != null) {
			ProductDAO dao = new ProductDAO();
			ProductBasicDataBean product = dao.selectById(Integer.parseInt(productid));

			if (product != null) {
				request.setAttribute("product", product);
				request.getRequestDispatcher("/jsp/product/UpdateGetProduct.jsp").forward(request, response);
			} else {
				response.getWriter().write("Product not found!");
			}
		} else {
			response.getWriter().write("Product ID is required!");
		}
	}
//		processAction(request, response);


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			System.out.println("Integer sellermemberid = Integer.parseInt(request.getParameter(\"sellermemberid\"))=="+request.getParameter("sellermemberid"));
			// Fetching product details from request parameters
			Integer productid = Integer.parseInt(request.getParameter("productid"));
			Integer sellermemberid = Integer.parseInt(request.getParameter("sellermemberid"));
			String productname = request.getParameter("productname");
			String price = request.getParameter("price");
			String specialprice = request.getParameter("specialprice");
			Integer categoryid = Integer.parseInt(request.getParameter("categoryid"));
			Integer productdetailid = Integer.parseInt(request.getParameter("productdetailid"));
			Integer quantity = Integer.parseInt(request.getParameter("quantity"));
			String description = request.getParameter("description");

			// Assuming you have a ProductDAO for Product operations
			ProductDAO dao = new ProductDAO();
			ProductBasicDataBean product = dao.selectById(productid); // Assuming you have this method in DAO


			if (product != null) {
				product.setSellermemberid(sellermemberid);
				product.setProductname(productname);
				BigDecimal number = new BigDecimal(price);
				product.setPrice(number);
				number = new BigDecimal(specialprice);
				product.setSpecialprice(number);
				product.setCategoryid(categoryid);
				product.setProductdetailid(productdetailid);
				product.setQuantity(quantity);
				product.setDescription(description);

				dao.update(product);// Assuming you have this method in DAO

				response.sendRedirect("/GetProductAll"); // Redirect to a list or a success page
			} else {
				// Handle the case where the member is not found
				response.sendRedirect("/jsp/error.jsp"); // Redirect to an error page
			}
		} catch (Exception e) {
			e.printStackTrace();
			// Handle the error appropriately, maybe redirect to an error page
			response.sendRedirect("/jsp/error.jsp");
		}
//		processAction(request, response);
	}

}
//	private void processAction(HttpServletRequest request, HttpServletResponse response) throws IOException {
//		response.setContentType("text/html;charset=UTF-8");
//		PrintWriter out = response.getWriter();
//
//		SessionFactory factory = HibernateUtil.getSessionFactory();
//		Session session = factory.getCurrentSession();
//
//		int productId = Integer.parseInt(request.getParameter("productid"));
//		// 获取要更新的记录的ID
//
//		try {
//			ProductBasicDataBean product = session.get(ProductBasicDataBean.class, productId);
//			if (product != null) {
//
//				// 獲取要新增的 BlackBean 資料 int 莫認為0
//				int sellermemberid = Integer.parseInt(request.getParameter("sellermemberid"));
//				String productname = request.getParameter("productname");
//				int price = 0;
//				int specialPrice = 0;
//				int categoryid = Integer.parseInt(request.getParameter("categoryid"));
//				int productdetailid = 0;
//				int quantity = 0;
//				String description = request.getParameter("description"); // 默認描述為空字符串
//
//				//  檢查價格是否轉換為整數
//				String priceParam = request.getParameter("price");
//				if (priceParam != null && !priceParam.isEmpty()) {
//					price = Integer.parseInt(priceParam);
//				}
//
//				//  檢查特價是否轉換為整數
//				String specialPriceParam = request.getParameter("specialprice");
//				if (specialPriceParam != null && !specialPriceParam.isEmpty()) {
//					specialPrice = Integer.parseInt(specialPriceParam);
//				}
//
//				//  檢查產品詳細ID是否轉換為整數
//				String productdetailidParam = request.getParameter("productdetailid");
//				if (productdetailidParam != null && !productdetailidParam.isEmpty()) {
//					productdetailid = Integer.parseInt(productdetailidParam);
//				}
//
//				//  檢查數量是否轉換為整數
//				String quantityParam = request.getParameter("quantity");
//				if (quantityParam != null && !quantityParam.isEmpty()) {
//					quantity = Integer.parseInt(quantityParam);
//				}
//
//				// 值存入
//				product.setSellermemberid(sellermemberid);
//				product.setProductname(productname);
//				product.setPrice(price);
//				product.setSpecialprice(specialPrice);
//				product.setCategoryid(categoryid);
//				product.setProductdetailid(productdetailid);
//				product.setQuantity(quantity);
//				product.setDescription(description);
//
//				BlackBeanService blackBeanDao = new BlackBeanService(session);
//				BlackBean resultBean = blackBeanDao.update(product);
//				// 儲存新增的 BlackBean 紀錄
//				if(resultBean!=null) {
//					out.println("<script>alert('更新成功');window.history.back();</script>");
//				}else {
//					out.println("<script>alert('新增失敗');window.history.back();</script>");
//				}
//
//
////				request.setAttribute("black", session);
////				request.getRequestDispatcher("/work/GetProduct.jsp").forward(request, response);
//			}
//
//		} catch (Exception e) {
//			out.write("新增記錄時發生錯誤。<br/>");
//			e.printStackTrace();
//		} finally {
//			out.close();
//		}
//	}
