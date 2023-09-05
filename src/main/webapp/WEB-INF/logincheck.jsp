<%--session認證頁面--%>
<%
    if (session.getAttribute("loggedInUser") == null) {
        response.sendRedirect("/jsp/login.jsp");
        return;
    }
%>
<%--session認證頁面--%>