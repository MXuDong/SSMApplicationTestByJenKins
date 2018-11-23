<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="beImportJSP.jsp" %>
</head>
<body style="background: #c6c8ca;">
<%--登录界面--%>
<br><br><br><br><br><br><br>

<div class="row" >
    <div class="col-md-7"></div>
    <div class="col md-2">
        <form action="${pageContext.request.contextPath}/doLogin" style="background-color: antiquewhite;box-shadow: 10px 10px #383d41;margin: 10px; padding: 10px; border-radius: 10px;">
            <h1 style="margin-left: 10px; padding-left: 10px;">请登录</h1>
            <hr />
            <div class="form-group row">
                <label for="inputEmail3" class="col-sm-2 col-form-label">用户ID</label>
                <div class="col-sm-10">
                    <input type="email" class="form-control" id="inputEmail3" placeholder="ID Number">
                </div>
            </div>
            <div class="form-group row">
                <label for="inputPassword3" class="col-sm-2 col-form-label">密码</label>
                <div class="col-sm-10">
                    <input type="password" class="form-control" id="inputPassword3" placeholder="Password">
                </div>
            </div>
            <div class="form-group row">
                <div class="col-sm-10">
                    <button type="submit" class="btn btn-primary">Sign in</button>
                </div>
            </div>
        </form>
    </div>
    <div class="col-md-1"></div>
</div>

<%@include file="footerJSP.jsp" %>
</body>
</html>
