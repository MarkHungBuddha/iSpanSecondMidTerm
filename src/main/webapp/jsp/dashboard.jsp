<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../WEB-INF/logincheck.jsp" %>
<%@ include file="../WEB-INF/header.jsp" %>

<h2>index but has nothing</h2>


<%
    String showAlert = request.getParameter("showAlert");
    if ("true".equals(showAlert)) {
%>
<script>
    Swal.fire({
        icon: 'success',
        title: '登入成功',
        text: '歡迎回來！',
        confirmButtonText: '確認'
    });
</script>

<%
    }
%>

<%@ include file="../WEB-INF/footer.jsp" %>
