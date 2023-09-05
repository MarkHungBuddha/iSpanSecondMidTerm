package tw.blackbean.servlet;

import jakarta.servlet.http.HttpSession;
import tw.blackbean.dao.MemberDAO;
import tw.blackbean.model.MemberData;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String email = request.getParameter("email");
            String passwd = request.getParameter("passwd");
            System.out.println("email="+email);
            System.out.println("passwd="+passwd);

            MemberDAO dao = new MemberDAO();
            MemberData member = dao.findByemailAndpasswd(email, passwd); // Assuming you have this method in DAO

            if (member != null) {
                // Login successful
                HttpSession session = request.getSession();
                session.setAttribute("loggedInUser", member);
                session.setMaxInactiveInterval(30 * 60); // 30 minutes
                response.sendRedirect("/jsp/dashboard.jsp?showAlert=true");
            } else {
                // Login failed
                request.setAttribute("errorMessage", "Invalid username or email");
                request.getRequestDispatcher("/jsp/login.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the error appropriately, maybe redirect to an error page
            response.sendRedirect("/jsp/error.jsp");
        }
    }
}