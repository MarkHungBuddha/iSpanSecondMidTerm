<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.css">
<script type="text/javascript" charset="utf8" src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.js"></script>
<script>
    $(document).ready(function() {
        $('#membersTable').DataTable();
    });
</script>

<%@ include file="../WEB-INF/logincheck.jsp" %>
<%@ include file="../WEB-INF/header.jsp" %>
<input type="hidden" name="referrer" value="listMember.jsp">


<h2>會員列表</h2>
<table id="membersTable" class="display">
    <thead>
    <tr>
        <th>Edit</th>
        <th>ID</th>
        <th>帳號</th>
        <th>性別</th>
        <th>生日</th>
        <th>手機</th>
        <th>信箱</th>
        <th>Delete</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="MemberData" items="${MemberData}">
        <tr>
            <td><button class="button-30" role="button"><a href="/update?id=${MemberData.memberid}">編輯</a></button></td>
            <td>${MemberData.memberid}</td>
            <td>${MemberData.username}</td>
            <td>${MemberData.gender}</td>
            <td>${MemberData.birthdate}</td>
            <td>${MemberData.phone}</td>
            <td>${MemberData.email}</td>
            <td><button class="button-30" role="button" onclick="confirmDeletion('${MemberData.memberid}')">刪除</button></td>
        </tr>
    </c:forEach>
    </tbody>
</table>



<script>

    function confirmDeletion(memberId) {
        Swal.fire({
            title: '確認刪除?',
            text: "請確認是否要刪除此會員。",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: '是',
            cancelButtonText: '否',
            input: 'checkbox',
            inputValue: 0,
            inputPlaceholder: '確認刪除',
            inputValidator: (result) => {
                return !result && '請勾選確認刪除!'
            }
        }).then((result) => {
            if (result.isConfirmed && result.value) {
                window.location.href = '/delete?memberid=' + memberId;
            }
        });
    }
</script>

<%@ include file="../WEB-INF/footer.jsp" %>

