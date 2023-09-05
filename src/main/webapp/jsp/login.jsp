<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../WEB-INF/header.jsp" %>

<h2>請登入^_^</h2>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<%
    String showAlert = request.getParameter("showAlert");
    if ("true".equals(showAlert)) {
%>
<script>
    Swal.fire({
        icon: 'success',
        title: '註冊成功',
        text: '請重新登入',
        confirmButtonText: '確認'
    });
</script>

<%
    }
%>

</body>
</html>