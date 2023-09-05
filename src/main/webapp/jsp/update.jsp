<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../WEB-INF/logincheck.jsp" %>
<%@ include file="../WEB-INF/header.jsp" %>

<div class="update-container">
    <div class="container mt-5">
        <h2>Update Member Information</h2>
        <form action="/update" method="post"><div class="form-group">
            <label>
                MemberID: </label>
            <input class="form-control" type="text" readonly="readonly" name="memberid" value="${member.memberid}" >
        </div><div class="form-group">
            <label>
                Username: </label>
            <input class="form-control" type="text" name="username" placeholder="Username" value="${member.username}" required pattern="^[a-zA-Z0-9]{1,50}$">
        </div><div class="form-group">
            <label>
                Gender: </label>
            <input class="form-control" type="text" name="gender" placeholder="Gender" value="${member.gender}" maxlength="10" required pattern="^[a-zA-Z]{1,10}$">
        </div><div class="form-group">
            <label>
                Birthdate: </label>
            <input class="form-control" type="date" name="birthdate" value="${member.birthdate}" required>
        </div><div class="form-group">
            <label>
                Phone: </label>
            <input class="form-control" type="text" name="phone" placeholder="Phone" value="${member.phone}" required pattern="^\d{10}$">
        </div><div class="form-group">
            <label>
                Email: </label>
            <input class="form-control" type="email" name="email" placeholder="Email" value="${member.email}" required>
        </div><div class="form-group">
            <label>
                Passward: </label>
            <input class="form-control" type="password" name="passwd" placeholder="passwd" value="${member.passwd}" required pattern="^.{1,50}$">
        </div><div class="form-group">
            <label>
                Country: </label>
            <input class="form-control" type="text" name="country" placeholder="Country" value="${member.country}" required pattern="^.{1,50}$">
        </div><div class="form-group">
            <label>
                City: </label>
            <input class="form-control" type="text" name="city" placeholder="City" value="${member.city}" required pattern="^.{1,50}$">
        </div><div class="form-group">
            <label>
                Region: </label>
            <input class="form-control" type="text" name="region" placeholder="Region" value="${member.region}" required pattern="^.{1,50}$">
        </div><div class="form-group">
            <label>
                Street: </label>
            <input class="form-control" type="text" name="street" placeholder="Street" value="${member.street}" required pattern="^.{1,50}$">
        </div><div class="form-group">
            <label>
                Postal Code: </label>
            <input class="form-control" type="text" name="postalcode" placeholder="Postal Code" value="${member.postalcode}" required pattern="^.{1,20}$">
        </div>
            <input type="submit" value="Update">
        </form>
    </div>

</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>


<%@ include file="../WEB-INF/footer.jsp" %>
