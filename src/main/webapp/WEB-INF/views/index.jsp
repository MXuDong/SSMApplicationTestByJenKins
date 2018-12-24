<%--
  Created by IntelliJ IDEA.
  User: Dong
  Date: 2018/10/31
  Time: 17:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="beImportJSP.jsp" %>
</head>
<body>
<%@include file="titleJSP.jsp" %>

<div class="row">
    <div class="col-md-3">
        <div class="jumbotron">
            <h1 class="display-4">快速结账!</h1>
            <p class="lead">本次结账金额：${requestScope.accountAttribute.totalChangeMoney}</p>
            <hr class="my-4">
            <p>浏览详细信息请转至：账单管理</p>
            <p>注意，当结账金额为0的时候，则忽略记录</p>
            <br><br>
            <p class="lead">
                <a class="btn btn-primary btn-lg btn-block" href="/doAccount" role="button">结账</a>
            </p>
        </div>
    </div>

    <div class="col-md-5">
        <%--产品总量占比饼图--%>
        <div id="countPic" style="width: 700px;height:600px;">
        </div>
    </div>

    <div class="col-md-1"></div>
    <div class="col-md-3">
        <div class="jumbotron">
            <h1 class="display-4">最新消息</h1>
            <p class="lead">日期：2018年12月4日 20点41分</p>
            <hr class="my-4">
            <p>隶属类型：通知</p>
            <p class="lead">
                欢迎使用本产品，感谢您对本产品的大力支持。您在使用过程中有任何问题请尽快联系我方，避免造成不必要的后果。
                <br>
                一切后果由使用者承担！本项目产品概不负责！
            </p>
        </div>
    </div>

</div>

<script language="JavaScript">
    var countPic = echarts.init(document.getElementById('countPic'));

    optionCountPic = {
        title : {
            text: '产品类别数量占比饼图',
            x:'center'
        },
        tooltip : {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        toolbox: {
            right: '0',
            feature: {
                saveAsImage: {}
            }
        },
        legend: {
            orient: 'vertical',
            left: 'left',
            data: [${requestScope.ProductBingPic.legendData}]
        },
        series : [
            {
                name: '类别名称',
                type: 'pie',
                radius : '55%',
                center: ['50%', '60%'],
                data:[${requestScope.ProductBingPic.seriesData}
                ],
                itemStyle: {
                    emphasis: {
                        shadowBlur: 10,
                        shadowOffsetX: 0,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                }
            }
        ]
    };


    // 使用刚指定的配置项和数据显示图表。
    countPic.setOption(optionCountPic)

</script>

<hr />

<div class="row">
    <div class="col-md-4">
        <h3>最新变化信息</h3>
        <div class="list-group">
            <a href="${pageContext.request.contextPath}/log/logManager" class="list-group-item list-group-item-action active">
                查看更多
            </a>
            <c:forEach items="${requestScope.Opers}" var="oper">
                <a href="#" class="list-group-item list-group-item-action"><c:out value="${oper}" /></a>
            </c:forEach>
        </div>
    </div>
    <div class="col-md-3">
        <h3>库存告急列表</h3>
        <div class="list-group">
            <a href="${pageContext.request.contextPath}/product/lessProductList" class="list-group-item list-group-item-action active">
                查看更多
            </a>
            <c:forEach items="${requestScope.LessProduct}" var="lp">
                <a href="#" class="list-group-item list-group-item-action"><c:out value="${lp}" /></a>
            </c:forEach>
        </div>
    </div>
    <div class="col-md-3">
        <h3>库存冗余列表</h3>
        <div class="list-group">
            <a href="${pageContext.request.contextPath}/product/moreProductList" class="list-group-item list-group-item-action active">
                查看更多
            </a>
            <c:forEach items="${requestScope.MoreProduct}" var="mp">
                <a href="#" class="list-group-item list-group-item-action"><c:out value="${mp}" /></a>
            </c:forEach>
        </div>
    </div>
    <div class="col-md-2">
        <h3>快速链接</h3>
        <div class="list-group">
            <a href="${pageContext.request.contextPath}/product/ProductList" class="list-group-item list-group-item-action">产品列表</a>
            <a href="${pageContext.request.contextPath}/log/productCountLog" class="list-group-item list-group-item-action">产品库存变化列表</a>
            <a href="${pageContext.request.contextPath}/log/productPriceLog" class="list-group-item list-group-item-action">产品价格变化日志</a>
            <a href="${pageContext.request.contextPath}/log/logManager" class="list-group-item list-group-item-action">操作日志历史纪录</a>
            <a href="${pageContext.request.contextPath}/product/addProducts" class="list-group-item list-group-item-action">导入数据</a>
            <a href="${pageContext.request.contextPath}/download/allProductInfo" class="list-group-item list-group-item-action">下载库存产品数据</a>
            <a href="${pageContext.request.contextPath}/about" class="list-group-item list-group-item-action">关于我们</a>
        </div>
    </div>
</div>


<%@include file="footerJSP.jsp" %>
</body>
</html>
