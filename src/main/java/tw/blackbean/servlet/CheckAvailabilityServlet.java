package tw.blackbean.servlet;

import tw.blackbean.dao.MemberDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/checkAvailability")
public class CheckAvailabilityServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String email = request.getParameter("email");

        MemberDAO memberDAO = new MemberDAO();
        String result = "available";

        if (username != null && memberDAO.isExistMember(username)) {
            result = "Username already exists!";
        } else if (email != null && memberDAO.isExistEmail(email)) {
            result = "Email already exists!";
        }

        response.getWriter().write(result);
    }
}