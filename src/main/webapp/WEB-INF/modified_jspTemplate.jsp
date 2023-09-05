<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--session認證頁面--%>
<%
    if (session.getAttribute("loggedInUser") == null) {
        response.sendRedirect("/jsp/login.jsp");
        return;
    }
%>
<%--session認證頁面--%>


<!DOCTYPE html>
<html>


<head>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@10"></script>
    <meta charset="UTF-8">
    <title>黑豆皮購物平台-登入會員</title>
    <style>
        .error-container {
            max-width: 600px;
            margin: 50px auto;
            padding: 20px;
            border: 1px solid #f2f2f2;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        header {
            background-color: #f9f9f9;
            padding: 20px 50px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .title-container {
            display: flex;
            align-items: center;
        }

        .title-container img {
            margin-right: 20px;
        }

        header h1 {
            margin: 0;
        }

        header h2 {
            margin: 0;
            color: #777;
        }

        nav {
            display: flex;
            justify-content: space-between;
            padding: 10px 50px;
            background-color: #f2f2f2;
        }

        nav a {
            margin: 0 10px;
            text-decoration: none;
            color: #333;
        }

        .login-container {
            display: flex;
            align-items: center;
        }

        .login-container input {
            padding: 5px;
            margin-right: 10px;
        }

        .button-30 {
            align-items: center;
            appearance: none;
            background-color: #FCFCFD;
            border-radius: 4px;
            border-width: 0;
            box-shadow: rgba(45, 35, 66, 0.4) 0 2px 4px, rgba(45, 35, 66, 0.3) 0 7px 13px -3px, #D6D6E7 0 -3px 0 inset;
            box-sizing: border-box;
            color: #36395A;
            cursor: pointer;
            display: inline-flex;
            font-family: "JetBrains Mono", monospace;
            height: 48px;
            justify-content: center;
            line-height: 1;
            list-style: none;
            overflow: hidden;
            padding-left: 16px;
            padding-right: 16px;
            position: relative;
            text-align: left;
            text-decoration: none;
            transition: box-shadow .15s, transform .15s;
            user-select: none;
            -webkit-user-select: none;
            touch-action: manipulation;
            white-space: nowrap;
            will-change: box-shadow, transform;
            font-size: 18px;
        }

        .button-30:focus {
            box-shadow: #D6D6E7 0 0 0 1.5px inset, rgba(45, 35, 66, 0.4) 0 2px 4px, rgba(45, 35, 66, 0.3) 0 7px 13px -3px, #D6D6E7 0 -3px 0 inset;
        }

        .button-30:hover {
            box-shadow: rgba(45, 35, 66, 0.4) 0 4px 8px, rgba(45, 35, 66, 0.3) 0 7px 13px -3px, #D6D6E7 0 -3px 0 inset;
            transform: translateY(-2px);
        }

        .button-30:active {
            box-shadow: #D6D6E7 0 3px 7px inset;
            transform: translateY(2px);
        }

        .button-3 {
            appearance: none;
            background-color: #2ea44f;
            border: 1px solid rgba(27, 31, 35, .15);
            border-radius: 6px;
            box-shadow: rgba(27, 31, 35, .1) 0 1px 0;
            box-sizing: border-box;
            color: #fff;
            cursor: pointer;
            display: inline-block;
            font-family: -apple-system, system-ui, "Segoe UI", Helvetica, Arial, sans-serif, "Apple Color Emoji", "Segoe UI Emoji";
            font-size: 14px;
            font-weight: 600;
            line-height: 20px;
            padding: 6px 16px;
            position: relative;
            text-align: center;
            text-decoration: none;
            user-select: none;
            -webkit-user-select: none;
            touch-action: manipulation;
            vertical-align: middle;
            white-space: nowrap;
        }

        .button-3:focus:not(:focus-visible):not(.focus-visible) {
            box-shadow: none;
            outline: none;
        }

        .button-3:hover {
            background-color: #2c974b;
        }

        .button-3:focus {
            box-shadow: rgba(46, 164, 79, .4) 0 0 0 3px;
            outline: none;
        }

        .button-3:disabled {
            background-color: #94d3a2;
            border-color: rgba(27, 31, 35, .1);
            color: rgba(255, 255, 255, .8);
            cursor: default;
        }

        .button-3:active {
            background-color: #298e46;
            box-shadow: rgba(20, 70, 32, .2) 0 1px 0 inset;
        }
    </style>
</head>
<body>
<header>
    <div class="title-container">
        <a href="/jsp/index.jsp">
            <img src="https://i.imgur.com/6Vf7r1Z.jpg" alt="商標" width="100">
        </a>
        <div>
            <h1>黑豆皮購物平台</h1>
            <h2>輕鬆選購，輕鬆享受</h2>
        </div>
    </div>
</header>
<nav>
    <div>
        <button class="button-3" role="button">
            <a href="${pageContext.request.contextPath}/jsp/register.jsp">註冊會員</a>
        </button>
        <button class="button-3" role="button">
            <a href="${pageContext.request.contextPath}/allusers">會員管理</a>
        </button>
        <button class="button-3" role="button">
            <a href="${pageContext.request.contextPath}/GetProductAll">商品管理</a>
        </button>

        <c:choose>
            <c:when test="${not empty sessionScope.loggedInUser}">
                <button class="button-3" role="button">
                    <a href="${pageContext.request.contextPath}/logout">登出</a>
                </button>
            </c:when>
            <c:otherwise>
                <button class="button-3" role="button">
                    <a href="${pageContext.request.contextPath}/jsp/login.jsp">登入會員</a>
                </button>
            </c:otherwise>
        </c:choose>

    </div>

<div class="login-container">
    <div>
        <c:choose>
            <c:when test="${not empty sessionScope.loggedInUser}">
                <a href="/logout">
                    <H2>登出</H2>
                </a>
            </c:when>
            <c:otherwise>
                <h2>登入會員</h2>
                <form action="/login" method="post">
                    <input class="inputbox" type="text" name="email" placeholder="email" required>
                    <input class="inputbox" type="password" name="passwd" placeholder="passwd" required>
                    <input class="inputbox" type="submit" value="Login">
                </form>
            </c:otherwise>
        </c:choose>
    </div>
</div>
</nav>


</body>
</html>