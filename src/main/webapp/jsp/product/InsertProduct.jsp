<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../../WEB-INF/logincheck.jsp" %>
<%@ include file="../../WEB-INF/header.jsp" %>

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

<div class="container mt-5">
  <div class="container mt-5">
    <h2>新增產品</h2>
    <form action="/InsertProduct" method="post">
      <input type="hidden" name="referrer" value="InsertProduct.jsp">

      <!-- 銷售人員下拉選單 -->
      <div class="form-group">
        <label for="sellermemberid">銷售人員:</label>
        <select class="form-control" name="members" id="sellermemberid">
          <c:forEach var="member" items="${MemberData}">
            <option value="${member.memberid}" ${member.memberid == member.memberid ? 'selected' : ''}>${member.username}</option>
          </c:forEach>
        </select>
      </div>
      <div class="form-group">
        <label for="productname">產品名稱:</label>
        <input type="text" class="form-control" id="productname" name="productname" placeholder="產品名稱" required pattern="^[^&lt;&gt;&amp;&quot;']+$">
      </div>
      <div class="form-group">
        <label for="price">價格:</label>
        <input type="text" class="form-control" id="price" name="price" placeholder="價格" required pattern="^\d+(\.\d{1,2})?$">
      </div>
      <div class="form-group">
        <label for="specialprice">特價:</label>
        <input type="text" class="form-control" id="specialprice" name="specialprice" required pattern="^\d+(\.\d{1,2})?$">
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
        <input type="text" class="form-control" id="quantity" name="quantity" placeholder="數量" required pattern="^\d+$">
      </div>
      <div class="form-group">
        <label for="description">描述:</label>
        <input type="text" class="form-control" id="description" name="description" placeholder="描述" required pattern="^[^&lt;&gt;&amp;&quot;']+$">
      </div>

      <button type="submit" class="btn btn-primary">新增</button>
    </form>
  </div>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

<%@ include file="../../WEB-INF/footer.jsp" %>
