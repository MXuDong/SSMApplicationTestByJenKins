<%--
  Created by IntelliJ IDEA.
  User: Dong
  Date: 2018/11/4
  Time: 21:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="beImportJSP.jsp" %>
</head>
<body>
<%@ include file="titleJSP.jsp" %>
<%--库存信息展示页--%>
<div class="row">
    <div class="col-md-1"></div>
    <div class="col-md-10">
        <h1 style="text-align: center;">产品明细表</h1>

        <hr/>
        <a href="${pageContext.request.contextPath}/product/lessProductList" class="btn btn-outline-primary">告急库存明细</a>
        <a href="${pageContext.request.contextPath}/product/moreProductList" class="btn btn-outline-primary">冗余库存明细</a>
        <a href="${pageContext.request.contextPath}/product/ProductList" class="btn btn-outline-primary">产品列表</a>
        <hr/>

        <h2>${requestScope.PageHeader}</h2>

        <table class="table table-bordered table-hover">
            <thead class="thead-light">
            <tr>
                <c:forEach items="${requestScope.ProductHeader}" var="lth">
                    <th scope="col"><c:out value="${lth}"></c:out></th>
                </c:forEach>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${requestScope.ProductInfo}" var="lti">
                <tr onclick="window.location='${pageContext.request.contextPath}/product/info?id=${lti[0]}'"  >
                    <c:forEach items="${lti}" var="ltb" begin="1">
                        <td><c:out value="${ltb}"/></td>
                    </c:forEach>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="col-md-1"></div>
</div>
<%@ include file="footerJSP.jsp" %>
</body>
</html>
