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
import java.util.List;

@WebServlet("/GetProductByName")
public class GetProductByName extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		processAction(request, response);
	}

	private void processAction(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			String keyword = request.getParameter("productname");


			// 關鍵字名字查詢
			ProductDAO blackBeanDao = new ProductDAO();
			List<ProductBasicDataBean> resultBean = blackBeanDao.selectByName(keyword);

			if (resultBean != null) {
				request.setAttribute("resultBean", resultBean);
				request.getRequestDispatcher("/work/GetProductByName.jsp").forward(request, response);

			} else {
				out.println("<script>alert('無符合條件的資料');window.history.back();</script>");
			}

		} catch (Exception e) {
			e.printStackTrace();
			out.println("<script>alert('輸入格式錯誤'); window.history.back();</script>");

		} finally {
			out.close();
		}


	}
}
