package tw.blackbean.servlet;

import jakarta.servlet.annotation.WebServlet;
import tw.blackbean.dao.MemberDAO;
import tw.blackbean.model.MemberData;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

            Long memberId = Long.parseLong(request.getParameter("memberid"));
            System.out.println("memberId: "+ memberId);

            MemberDAO dao = new MemberDAO();
            dao.delete(memberId); // Assuming you have this method in DAO

            response.sendRedirect("/allusers"); // Redirect to the list of members after deletion
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the error appropriately, maybe redirect to an error page
            response.sendRedirect("/jsp/error.jsp");

        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Long memberId = Long.parseLong(request.getParameter("memberid"));

            MemberDAO dao = new MemberDAO();
            dao.delete(memberId); // Assuming you have this method in DAO

            response.sendRedirect("/allusers"); // Redirect to the list of members after deletion
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the error appropriately, maybe redirect to an error page
            response.sendRedirect("/jsp/error.jsp");
        }
    }
}