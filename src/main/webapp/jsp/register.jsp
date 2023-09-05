<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<%@ include file="../WEB-INF/header.jsp" %>
<%--<div>--%>
<%--    <form action="/register" method="post">--%>
<%--        Username: <input type="text" name="username"><br>--%>
<%--        Gender: <input type="text" name="gender"><br>--%>
<%--        Birthdate: <input type="date" name="birthdate"><br>--%>
<%--        Phone: <input type="text" name="phone"><br>--%>
<%--        Email: <input type="email" name="email">--%>
<%--        <button type="button" onclick="checkEmail()">檢查Email是否使用</button><br>--%>
<%--        Passward:<input type="password" name="passwd"><br>--%>
<%--        Country: <input type="text" name="country"><br>--%>
<%--        City: <input type="text" name="city"><br>--%>
<%--        Region: <input type="text" name="region"><br>--%>
<%--        Street: <input type="text" name="street"><br>--%>
<%--        Postal Code: <input type="text" name="postalcode"><br>--%>
<%--        <input type="submit" value="Register">--%>
<%--    </form>--%>
<%--</div>--%>

<div class="container mt-5">
    <h2>Register</h2>
    <form action="/register" method="post"  onsubmit="return validateForm()">
            <div class="form-group">
                <label for="username">Username:</label>
                <input type="text" class="form-control" id="username" name="username" pattern="^[a-zA-Z0-9]{1,50}$">
        <div id="usernameFeedback" style="color: red;"></div>
        </div>
        <div class="form-group">
            <label for="gender">Gender:</label>
            <input type="text" class="form-control" id="gender" name="gender" pattern="^[a-zA-Z]{1,10}$">
        </div>
        <div class="form-group">
            <label for="birthdate">Birthdate:</label>
            <input type="date" class="form-control" id="birthdate" name="birthdate">
        </div>
        <div class="form-group">
            <label for="phone">Phone:</label>
            <input type="text" class="form-control" id="phone" name="phone" pattern="^\d{10}$">
        </div>
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" class="form-control" id="email" name="email">
        <div id="emailFeedback" style="color: red;"></div>
        </div>
        <div class="form-group">
            <label for="passwd">Password:</label>
            <input type="password" class="form-control" id="passwd" name="passwd" pattern="^.{1,50}$">
        </div>
        <div class="form-group">
            <label for="country">Country:</label>
            <input type="text" class="form-control" id="country" name="country" pattern="^.{1,50}$">
        </div>
        <div class="form-group">
            <label for="city">City:</label>
            <input type="text" class="form-control" id="city" name="city" pattern="^.{1,50}$">
        </div>
        <div class="form-group">
            <label for="region">Region:</label>
            <input type="text" class="form-control" id="region" name="region" pattern="^.{1,50}$">
        </div>
        <div class="form-group">
            <label for="street">Street:</label>
            <input type="text" class="form-control" id="street" name="street" pattern="^.{1,50}$">
        </div>
        <div class="form-group">
            <label for="postalcode">Postal Code:</label>
            <input type="text" class="form-control" id="postalcode" name="postalcode" pattern="^.{1,20}$">
        </div>
        <button type="submit" class="btn btn-primary" id="registerButton">Register</button>
    </form>
</div>


<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<script>
    document.addEventListener("DOMContentLoaded", function() {
        let usernameInput = document.getElementById("username");
        let emailInput = document.getElementById("email");
        let registerButton = document.getElementById("registerButton");

        let checkAvailability = function(inputType, inputElement, feedbackElement) {
            let data = new FormData();
            data.append(inputType, inputElement.value);

            fetch("/checkAvailability", {
                method: "POST",
                body: data
            })
                .then(response => response.text())
                .then(text => {
                    if (text !== "available") {
                        inputElement.style.borderColor = "red";
                        feedbackElement.textContent = text;
                        registerButton.disabled = true;  // Disable the register button
                    } else {
                        inputElement.style.borderColor = "";
                        feedbackElement.textContent = "";
                        registerButton.disabled = false;  // Enable the register button
                    }
                });
        };

        usernameInput.addEventListener("input", function() {
            setTimeout(function() {
                checkAvailability("username", usernameInput, document.getElementById("usernameFeedback"));
            }, 500);
        });

        emailInput.addEventListener("input", function() {
            setTimeout(function() {
                checkAvailability("email", emailInput, document.getElementById("emailFeedback"));
            }, 500);
        });

        document.querySelector("form").addEventListener("submit", function(event) {
            if (document.getElementById("usernameFeedback").textContent || document.getElementById("emailFeedback").textContent) {
                alert("Please fix the errors before registering.");
                event.preventDefault();  // Prevent form submission
            }
        });
    });
</script>

<%@ include file="../WEB-INF/footer.jsp" %>


