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
        <h5>上次结账后所发生的仓库金额变动（数量和价格变动，价格变动为次要条件，不算在结账内）</h5>
        <h5 style="text-align: right">上次结账时间：
            ${requestScope.accountAttribute.lastChangeTime}
        </h5>
        <p class="lead">~.当天发生的变动不会记录在内</p>
        <p class="lead">~.结账不可选择，列表中不可取消，请认真核对后再结账</p>
        <hr/>
        <div class="row">
            <div class="col-md-6" style="text-align: center;"><h2>
                本次结账金额：${requestScope.accountAttribute.totalChangeMoney}</h2></div>
            <div class="col-md-6" style="text-align: center;">
                <a href="/doAccount" class="btn btn-danger btn-lg">结账</a>
            </div>
        </div>

        <hr/>
        <br><br><br>
        <h2 style="text-align: center">结账明细表</h2>
        <table class="table">
            <thead class="thead-light">
            <tr>
                <td scope="col">#</td>
                <td scope="col">产品名称</td>
                <td scope="col">变动类型</td>
                <td scope="col">变动数量</td>
                <td scope="col">变动时金额</td>
                <td scope="col">变动日期</td>
                <td scope="col">结果金额</td>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${requestScope.accountAttribute.accountInfos}" var="accountInfo">
                <tr>
                    <td scope="row">${accountInfo.numberOfThisInfo}</td>
                    <td>${accountInfo.productName}</td>
                    <td>${accountInfo.changeType}</td>
                    <td>${accountInfo.changeCount}</td>
                    <td>${accountInfo.changeTimePrice}</td>
                    <td>${accountInfo.changeTime}</td>
                    <td>${accountInfo.changeRes}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="col-md-1"></div>
</div>
<%@include file="footerJSP.jsp" %>
</body>
</html>