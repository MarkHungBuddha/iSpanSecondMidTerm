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
import java.util.Date;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String username = request.getParameter("username");
            String gender = request.getParameter("gender");
            String birthdate = request.getParameter("birthdate");
            System.out.println("birthdate:  "+birthdate);
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");
            String passwd = request.getParameter("passwd");
            String membercreationdate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            System.out.println("membercreationdate:  "+membercreationdate);
            String country = request.getParameter("country");
            String city = request.getParameter("city");
            String region = request.getParameter("region");
            String street = request.getParameter("street");
            String postalcode = request.getParameter("postalcode");

            MemberData member = new MemberData();
            member.setUsername(username);
            member.setGender(gender);
            member.setBirthdate(birthdate);
            member.setPhone(phone);
            member.setEmail(email);
            member.setPasswd(passwd);
            member.setMembercreationdate(membercreationdate);
            member.setCountry(country);
            member.setCity(city);
            member.setRegion(region);
            member.setStreet(street);
            member.setPostalcode(postalcode);

            MemberDAO dao = new MemberDAO();
            if (dao.isExistMember(username)) {
                request.setAttribute("error", "Username already exists!");
                request.getRequestDispatcher("/jsp/register.jsp").forward(request, response);
                return;
            }

            if (dao.isExistEmail(email)) {
                request.setAttribute("error", "Email already exists!");
                request.getRequestDispatcher("/jsp/register.jsp").forward(request, response);
                return;
            }
            dao.save(member);

            response.sendRedirect("/jsp/login.jsp?showAlert=true");
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the error appropriately, maybe redirect to an error page
        }
    }
}
