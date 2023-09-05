<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../WEB-INF/logincheck.jsp" %>
<%@ include file="../WEB-INF/header.jsp" %>
<div>
    <!-- Main content of the page goes here -->
</div>
<div class="logout-container">
    <h2>Confirm Logout</h2>
    <p>Are you sure you want to logout?</p>
    <button onclick="performLogout()">Yes, Logout</button>
    <button onclick="window.history.back()">No, Go Back</button>
</div>
<%@ include file="../WEB-INF/footer.jsp" %>
