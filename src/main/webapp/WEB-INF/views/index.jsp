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
    <title>测试前端库</title>
    <%@include file="beImportJSP.jsp" %>
</head>
<body>
<%@include file="titleJSP.jsp" %>

<div class="row">
    <div class="col-md-4">
        <%--产品数量变化折线图--%>
        <div id="ProductCount" style="width: 600px;height:400px;">

        </div>

    </div>

    <div class="col-md-4">
        <%--收入支出折线图--%>
        <div id="ObillPic" style="width: 600px;height:400px;">
            测试
        </div>
    </div>

    <div class="col-md-4">
        <%--产品总量占比饼图--%>
        <div id="countPic" style="width: 600px;height:400px;">
            测试
        </div>
    </div>
</div>

<script language="JavaScript">
    var obillPic = echarts.init(document.getElementById('ObillPic'));
    var productCount = echarts.init(document.getElementById('ProductCount'));
    var countPic = echarts.init(document.getElementById('countPic'));

    optionProductCountPic = {
        title: {
            text: '产品总量变化折线图'
        },
        xAxis: {
            type: 'category',
            data: [${requestScope.ProductOptionValue.xAxis}]
        },
        yAxis: {
            type: 'value'
        },
        series: [{
            data: [${requestScope.ProductOptionValue.data}],
            type: 'line'
        }]
    };

    // 指定图表的配置项和数据
    optionObillPic = {
        title: {
            text: '收入支出折线图'
        },
        xAxis: {
            type: 'category',
            data: [${requestScope.ObillPicOptionValue.xAxis}]
        },
        yAxis: {
            type: 'value'
        },
        series: [{
            data: [${requestScope.ObillPicOptionValue.data}],
            type: 'line'
        }]
    };

    optionCountPic = {
        title : {
            text: '产品类别数量占比饼图',
            x:'center'
        },
        tooltip : {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
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
    obillPic.setOption(optionObillPic);
    productCount.setOption(optionProductCountPic);
    countPic.setOption(optionCountPic)

</script>

<hr />

<div class="row">
    <div class="col-md-4">
        <h3>最新变化信息</h3>
        <div class="list-group">
            <a href="#" class="list-group-item list-group-item-action active">
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
            <a href="#" class="list-group-item list-group-item-action active">
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
            <a href="#" class="list-group-item list-group-item-action active">
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
            <a href="#" class="list-group-item list-group-item-action">产品列表</a>
            <a href="#" class="list-group-item list-group-item-action">产品库存变化列表</a>
            <a href="#" class="list-group-item list-group-item-action">产品价格变化日志</a>
            <a href="#" class="list-group-item list-group-item-action">操作日志历史纪录</a>
            <a href="#" class="list-group-item list-group-item-action">导入数据</a>
            <a href="#" class="list-group-item list-group-item-action">下载库存产品数据</a>
            <a href="#" class="list-group-item list-group-item-action">关于我们</a>
        </div>
    </div>
</div>


<%@include file="footerJSP.jsp" %>
</body>
</html>
