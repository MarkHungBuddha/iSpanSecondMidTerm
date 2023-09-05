package tw.blackbean.servlet;

import jakarta.servlet.RequestDispatcher;
import tw.blackbean.dao.MemberDAO;
import tw.blackbean.dao.ProductCategoryDAO;
import tw.blackbean.model.MemberData;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tw.blackbean.model.ProductCategoryDataBean;

import java.io.IOException;
import java.util.List;

@WebServlet("/allusers")
public class ListMembersServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            MemberDAO dao = new MemberDAO();
            List<MemberData> MemberData = dao.findAll(); // Assuming you have this method in DAO
            for (MemberData member: MemberData) {
                System.out.println(member.toString());
            }
            request.setAttribute("MemberData", MemberData);
            request.getRequestDispatcher("/jsp/listMembers.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("/jsp/error.jsp");
        }
    }

//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        String referrer = request.getParameter("referrer");
//        try {
//            ProductCategoryDAO dao = new ProductCategoryDAO();
//            List<ProductCategoryDataBean> productCategoryDataBeans = dao.selectAll(); // Assuming you have this method in DAO
//            RequestDispatcher dispatcher = request.getRequestDispatcher(referrer);
//            request.setAttribute("productCategoryDataBeans", productCategoryDataBeans);
//            dispatcher.forward(request, response);
//        } catch (Exception e) {
//            e.printStackTrace();
//            response.sendRedirect("/jsp/error.jsp");
//        }
//    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String referrer = request.getParameter("referrer");
        try {
            MemberDAO dao = new MemberDAO();
            List<MemberData> members = dao.findAll(); // Assuming you have this method in DAO


            RequestDispatcher dispatcher = request.getRequestDispatcher(referrer);
            request.setAttribute("MemberData", members);
            dispatcher.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("/jsp/error.jsp");
        }


    }

}
