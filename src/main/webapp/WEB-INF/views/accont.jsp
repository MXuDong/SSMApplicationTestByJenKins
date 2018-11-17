<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="beImportJSP.jsp" %>
</head>
<body>
<%@include file="titleJSP.jsp" %>
<div class="row">
    <div class="col-md-1"></div>
    <div class="col-md-10">
        <h1 style="text-align: center">账目管理</h1>
        <h3>上次结账后所发生的仓库金额变动（数量和价格变动，价格变动为次要条件，不算在结账内）</h3>
        <h5>上次结账时间：</h5>
        <hr />
    </div>
    <div class="col-md-1"></div>
</div>
<%@include file="footerJSP.jsp" %>
</body>
</html>