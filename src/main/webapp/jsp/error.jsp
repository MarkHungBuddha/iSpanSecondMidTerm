<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../WEB-INF/header.jsp" %>

<div class="error-container">
  <h2>Error Occurred</h2>
  <p>Sorry, an error has occurred while processing your request. Please try again later or contact the administrator.</p>
  <input type ="button" onclick="javascript:location.href='/allusers'" value="會員管理"></input>
  <button onclick="relogin()">重新登入</button>
</div>

<%@ include file="../WEB-INF/footer.jsp" %>

