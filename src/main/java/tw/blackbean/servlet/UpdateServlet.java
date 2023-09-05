package tw.blackbean.servlet;

import jakarta.servlet.annotation.WebServlet;
import tw.blackbean.dao.MemberDAO;
import tw.blackbean.model.MemberData;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;



@WebServlet("/update")
public class UpdateServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String memberId = request.getParameter("id");
        if (memberId != null) {
            MemberDAO dao = new MemberDAO();
            MemberData member = dao.findById(Integer.parseInt(memberId));

            System.out.println("member.toString()"+member.toString());
            if (member != null) {
                request.setAttribute("member", member);
                request.getRequestDispatcher("/jsp/update.jsp").forward(request, response);
            } else {
                response.getWriter().write("Member not found!");
            }
        } else {
            response.getWriter().write("Member ID is required!");
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Long memberId = Long.parseLong(request.getParameter("memberid"));
            String username = request.getParameter("username");
            String gender = request.getParameter("gender");
            String birthdate =request.getParameter("birthdate");
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");
            String passwd = request.getParameter("passwd");
            String country = request.getParameter("country");
            String city = request.getParameter("city");
            String region = request.getParameter("region");
            String street = request.getParameter("street");
            String postalcode = request.getParameter("postalcode");

            MemberDAO dao = new MemberDAO();
            MemberData member = dao.findById(memberId); // Assuming you have this method in DAO



            if (member != null) {
                member.setUsername(username);
                member.setGender(gender);
                member.setBirthdate(birthdate);
                member.setPhone(phone);
                member.setEmail(email);
                member.setPasswd(passwd);
                member.setCountry(country);
                member.setCity(city);
                member.setRegion(region);
                member.setStreet(street);
                member.setPostalcode(postalcode);


                dao.update(member); // Assuming you have this method in DAO

                response.sendRedirect("/allusers"); // Redirect to a list or a success page
            } else {
                // Handle the case where the member is not found
                response.sendRedirect("/jsp/error.jsp"); // Redirect to an error page
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the error appropriately, maybe redirect to an error page
            response.sendRedirect("/jsp/error.jsp");
        }
    }
}