package tw.blackbean.servlet;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tw.blackbean.dao.MemberDAO;

import java.io.BufferedReader;
import java.io.IOException;

@WebServlet("/checkUsername")
public class CheckUsername {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            StringBuilder sb = new StringBuilder();
            BufferedReader reader = request.getReader();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            String username = sb.toString();

            MemberDAO dao = new MemberDAO();
            boolean isExistMember = dao.isExistMember(username);

            response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");

            response.getWriter().write(String.valueOf(isExistMember));

        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("Error processing request");
        }
    }
}
