package tw.blackbean.servlet.productServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import tw.blackbean.dao.ProductDAO;
import tw.blackbean.model.ProductBasicDataBean;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

@WebServlet("/InsertProduct")
public class InsertProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
//		int sellermemberid = Integer.parseInt(request.getParameter("sellermemberid"));
		String productname = request.getParameter("productname");
		int price = 0;
		int specialPrice = 0;
		int categoryid = Integer.parseInt(request.getParameter("categoryid"));
		int productdetailid = 0;
		int quantity = 0;
		String description = request.getParameter("description");

		// 檢查價格是否轉換為整數
		String priceParam = request.getParameter("price");
		if (priceParam != null && !priceParam.isEmpty()) {
			price = Integer.parseInt(priceParam);
		}

		// 檢查特價是否轉換為整數
		String specialPriceParam = request.getParameter("specialprice");
		if (specialPriceParam != null && !specialPriceParam.isEmpty()) {
			specialPrice = Integer.parseInt(specialPriceParam);
		}

		// 檢查產品詳細ID是否轉換為整數
		String productdetailidParam = request.getParameter("productdetailid");
		if (productdetailidParam != null && !productdetailidParam.isEmpty()) {
			productdetailid = Integer.parseInt(productdetailidParam);
		}

		// 檢查數量是否轉換為整數
		String quantityParam = request.getParameter("quantity");
		if (quantityParam != null && !quantityParam.isEmpty()) {
			quantity = Integer.parseInt(quantityParam);
		}
			// 創建一個新的 BlackBean 對象
			ProductBasicDataBean product = new ProductBasicDataBean();
//			product.setSellermemberid(sellermemberid);
			product.setProductname(productname);
			product.setPrice(BigDecimal.valueOf(price));
			product.setSpecialprice(BigDecimal.valueOf(specialPrice));
			product.setCategoryid(categoryid);
			product.setProductdetailid(productdetailid);
			product.setQuantity(quantity);
			product.setDescription(description);


			ProductDAO blackbeanDao = new ProductDAO();
			blackbeanDao.insert(product);



			response.sendRedirect("/GetProductAll");


		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}