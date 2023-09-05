<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="tw.blackbean.dao.MemberDAO, tw.blackbean.dao.ProductCategoryDAO, java.util.List, tw.blackbean.model.MemberData, tw.blackbean.model.ProductCategoryDataBean" %>

<%
	// Initialize DAOs
	MemberDAO memberDAO = new MemberDAO();
	ProductCategoryDAO productCategoryDAO = new ProductCategoryDAO();

	// Fetch the lists
	List<MemberData> memberDataList = memberDAO.findAll();
	List<ProductCategoryDataBean> productCategoryDataBeansList = productCategoryDAO.selectAll();

	// Set the lists in the request scope for later use
	request.setAttribute("MemberData", memberDataList);
	request.setAttribute("productCategoryDataBeans", productCategoryDataBeansList);
%>

<%@ include file="../../WEB-INF/logincheck.jsp" %>
<%@ include file="../../WEB-INF/header.jsp" %>

<div class="container mt-5">
	<div class="container mt-5">
		<h2>修改商品資料</h2>
		<form action="/UpdateProduct" method="post" >
			<input type="hidden" name="referrer" value="UpdateGetProduct.jsp">

			<div class="form-group">
				<label for="productid">商品ID:</label>
				<input type="text" id="productid" readonly="readonly" class="form-control" name="productid" value="${product.productid}">
			</div>

			<!-- 銷售人員下拉選單 -->
			<div class="form-group">
				<label for="sellermemberid">銷售人員:</label>
				<select class="form-control" name="sellermemberid" id="sellermemberid">
					<c:forEach var="member" items="${MemberData}">
						<option value="${member.memberid}" ${member.memberid == member.memberid ? 'selected' : ''}>${member.username}</option>
					</c:forEach>
				</select>
			</div>


			<div class="form-group">
				<label for="productname">產品名稱:</label>
				<input type="text" class="form-control" id="productname"  name="productname" placeholder="productname" value="${product.productname}" required pattern="^[^&lt;&gt;&amp;&quot;']+$">
			</div>

			<div class="form-group">
				<label for="price">價格:</label>
				<input type="text" class="form-control" id="price" name="price" placeholder="price" value="${product.price}" required pattern="^\d+(\.\d{1,2})?$">
			</div>

			<div class="form-group">
				<label for="specialprice">特價:</label>
				<input type="text" class="form-control" id="specialprice" name="specialprice" value="${product.specialprice}" required pattern="^\d+(\.\d{1,2})?$">
			</div>



			<!-- 類別ID 下拉選單 -->
			<div class="form-group">
				<label for="categoryid">類別ID:</label>
				<select class="form-control" name="categoryid" id="categoryid">
					<c:forEach var="category" items="${productCategoryDataBeans}" begin="8">
						<option value="${category.categoryid}" ${category.categoryid == product.categoryid ? 'selected' : ''}>${category.categoryname}</option>
					</c:forEach>
				</select>
			</div>


			<div class="form-group">
				<label for="quantity">數量:</label>
				<input type="text" class="form-control"  id="quantity" name="quantity" placeholder="quantity" value="${product.quantity}" required pattern="^\d+$">
			</div>



			<div class="form-group">
				<label for="description">描述:</label>
				<input type="text" class="form-control" id="description" name="description" placeholder="description" value="${product.description}" required pattern="^[^&lt;&gt;&amp;&quot;']+$">
			</div>


			<input type="text" id="productdetailid" hidden="hidden"  name="productdetailid" value="${product.productdetailid}">


			<button type="submit" class="btn btn-primary">Update</button>
		</form>
	</div>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>


<%@ include file="../../WEB-INF/footer.jsp" %>

<%--<div>--%>
<%--	<jsp:useBean id="resultBean" scope="request"--%>
<%--				 class="tw.blackbean.model.ProductBasicDataBean"/>--%>
<%--	<form method="post" action="UpdateProduct">--%>
<%--		<table border="1">--%>

<%--			<tr>--%>
<%--				<th>商品ID</th>--%>
<%--				<td><input type="text" name="productid" value="${resultBean.productid}" readonly></td>--%>


<%--				<th>銷售人員</th>--%>
<%--				<td>--%>
<%--					<select name="sellermemberid">--%>
<%--						<option value="1" ${resultBean.sellermemberid == 1 ? 'selected' : ''}>cristinaaguilar</option>--%>
<%--						<option value="2" ${resultBean.sellermemberid == 2 ? 'selected' : ''}>gonzaloanguiano</option>--%>
<%--						<option value="3" ${resultBean.sellermemberid == 3 ? 'selected' : ''}>patriciabonilla</option>--%>
<%--						<!-- 继续添加更多选项 -->--%>
<%--					</select>--%>
<%--				</td>--%>
<%--				<th>產品名稱</th>--%>
<%--				<td><input type="text" name="productname" value="${resultBean.productname}"></td>--%>
<%--				<th>價格</th>--%>
<%--				<td><input type="text" name="price" value="${resultBean.price}"></td>--%>
<%--				<th>特價</th>--%>
<%--				<td><input type="text" name="specialprice" value="${resultBean.specialprice}"></td>--%>
<%--				<th>類別ID</th>--%>
<%--				<td>--%>
<%--					<select name="categoryid">--%>
<%--						<option value="1" ${resultBean.categoryid == 1 ? 'selected' : ''}>電腦資訊</option>--%>
<%--						<option value="2" ${resultBean.categoryid == 2 ? 'selected' : ''}>電腦周邊</option>--%>
<%--						<option value="3" ${resultBean.categoryid == 3 ? 'selected' : ''}>行動通訊</option>--%>
<%--						<!-- 继续添加更多选项 -->--%>
<%--					</select>--%>
<%--				</td>--%>
<%--			</tr>--%>
<%--			<tr>--%>
<%--				<th>產品詳細訊息</th>--%>
<%--				<td><input type="text" name="productdetailid" value="${resultBean.productdetailid}"></td>--%>
<%--				<th>數量</th>--%>
<%--				<td><input type="text" name="quantity" value="${resultBean.quantity}"></td>--%>
<%--				<th>描述</th>--%>
<%--				<td><input type="text" name="description" value="${resultBean.description}"></td>--%>
<%--			</tr>--%>


<%--		</table>--%>
<%--		<input type="submit" value="確定"/>--%>
<%--	</form>--%>
<%--</div>--%>
