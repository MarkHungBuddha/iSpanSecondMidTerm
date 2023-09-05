<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*,tw.blackbean.model.ProductBasicDataBean" %>
<%@ page import="tw.blackbean.model.ProductBasicDataBean" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.css">
<script type="text/javascript" charset="utf8" src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.js"></script>
<script>
	$(document).ready(function() {
		$('#productsTable').DataTable();
	});
</script>

<%@ include file="../../WEB-INF/logincheck.jsp" %>
<%@ include file="../../WEB-INF/header.jsp" %>


<table id="productsTable" class="display">
	<thead>
	<tr >
		<th>Edit</th>
		<th>商品ID</th>
		<th>銷售人員</th>
		<th>產品名稱</th>
		<th>價格</th>
		<th>特價</th>
		<th>類別ID</th>
		<th>產品詳細訊息</th>
		<th>數量</th>
		<th>描述</th>
		<th>Delete</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="product" items="${resultBean}">
		<tr>
			<td>
				<button class="button-30" role="button"><a href="/UpdateProduct?id=${product.productid}">編輯</a>
				</button>
			</td>
			<td>${product.productid}</td>
			<td>${product.sellermemberid}</td>
			<td>${product.productname}</td>
			<td>${product.price}</td>
			<td>${product.specialprice}</td>
			<td>${product.categoryid}</td>
			<td>${product.productdetailid}</td>
			<td>${product.quantity}</td>
			<td>${product.description}</td>
			<td>
				<button class="button-30" role="button" onclick="confirmDeletion('${product.productid}')">刪除</button>
			</td>
		</tr>
	</c:forEach>
	</tbody>
	<%--		<tr>--%>
	<%--			<td><%= product.getProductid() %></td>--%>
	<%--			<td><%= product.getSellermemberid() %></td>--%>
	<%--			<td><%= product.getProductname() %></td>--%>
	<%--			<td><%= product.getPrice() %></td>--%>
	<%--			<td><%= product.getSpecialprice() %></td>--%>
	<%--			<td><%= product.getCategoryid() %></td>--%>
	<%--			<td><%= product.getProductdetailid() %></td>--%>
	<%--			<td><%= product.getQuantity() %></td>--%>
	<%--			<td><%= product.getDescription() %></td>--%>
	<%--		</tr>--%>
	<%--		<% } %>--%>
</table>

<script>

	function confirmDeletion(productid) {
		Swal.fire({
			title: '確認刪除?',
			text: "請確認是否要刪除此商品。",
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
				window.location.href = '/DelProduct?productid=' + productid;
			}
		});
	}
</script>


<%@ include file="../../WEB-INF/footer.jsp" %>

