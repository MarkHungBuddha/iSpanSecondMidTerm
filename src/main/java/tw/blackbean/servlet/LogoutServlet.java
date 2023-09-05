package tw.blackbean.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Invalidate the session and remove all attributes
            request.getSession().invalidate();

            // Redirect to the login page or home page
            response.sendRedirect("/jsp/login.jsp");
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the error appropriately, maybe redirect to an error page
            response.sendRedirect("/jsp/error.jsp");
        }
    }
}