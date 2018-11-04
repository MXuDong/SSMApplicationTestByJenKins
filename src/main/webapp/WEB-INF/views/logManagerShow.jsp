<%--
  Created by IntelliJ IDEA.
  User: Dong
  Date: 2018/11/4
  Time: 21:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="beImportJSP.jsp"%>
</head>
<body>
    <%@ include file="titleJSP.jsp"%>
    <%--日志信息页--%>

    <div class="row">
        <div class="col-md-1"></div>
        <div class="col-md-10">

            <h1 style="text-align: center">日志详细信息</h1>

            <table class="table table-bordered table-hover">
                <thead class="thead-light">
                <tr>
                    <c:forEach items="${requestScope.LogTableHeader}" var="lth">
                        <th scope="col"><c:out value="${lth}"></c:out></th>
                    </c:forEach>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${requestScope.LogTableInfo}" var="lti" >
                    <tr>
                        <c:forEach items="${lti}" var="ltb">
                            <td><c:out value="${ltb}" /></td>
                        </c:forEach>
                    </tr>
                </c:forEach>
                <tr>
                    <th scope="row">1</th>
                    <td>Mark</td>
                    <td>Otto</td>
                    <td>@mdo</td>
                    <td>Mark</td>
                    <td>Mark</td>
                    <td>Mark</td>
                </tr>
                </tbody>
            </table>
            </table>
        </div>
        <div class="col-md-1"></div>
    </div>

    <%@ include file="footerJSP.jsp"%>
</body>
</html>
