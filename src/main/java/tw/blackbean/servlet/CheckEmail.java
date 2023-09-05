package tw.blackbean.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

import java.io.BufferedReader;
import java.io.IOException;
import tw.blackbean.dao.MemberDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/checkEmail")
public class CheckEmail extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // 從前端獲取 email 字串
            StringBuilder sb = new StringBuilder();
            BufferedReader reader = request.getReader();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            String email = sb.toString();

            MemberDAO dao = new MemberDAO();
            boolean isEmailExist = dao.isExistEmail(email);

            response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");

            // 如果郵箱存在，返回 "true"，否則返回 "false"
            response.getWriter().write(String.valueOf(isEmailExist));

        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("Error processing request");
        }
    }


}
