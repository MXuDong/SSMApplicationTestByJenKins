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
        <%--收入支出折线图--%>
        <div id="countPic" style="width: 600px;height:400px;">
            测试
        </div>
    </div>
</div>

<script language="JavaScript">
    var obillPic = echarts.init(document.getElementById('ObillPic'));
    var productCount = echarts.init(document.getElementById('ProductCount'));
    var countPic = echarts.init(document.getElementById('countPic'));

    // 指定图表的配置项和数据
    optionObillPic = {
        title: {
            text: '测试折线图'
        },
        xAxis: {
            type: 'category',
            data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
        },
        yAxis: {
            type: 'value'
        },
        series: [{
            data: [820, 932, 901, 934, 1290, 1330, 1320],
            type: 'line'
        }]
    };

    optionProductCountPic = {
        title: {
            text: '测试折线图'
        },
        xAxis: {
            type: 'category',
            data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
        },
        yAxis: {
            type: 'value'
        },
        series: [{
            data: [820, 932, 901, 934, 1290, 1330, 1320],
            type: 'line'
        }]
    };
    optionCountPic = {
        title : {
            text: '某站点用户访问来源',
            subtext: '纯属虚构',
            x:'center'
        },
        tooltip : {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        legend: {
            orient: 'vertical',
            left: 'left',
            data: ['直接访问','邮件营销','联盟广告','视频广告','搜索引擎']
        },
        series : [
            {
                name: '访问来源',
                type: 'pie',
                radius : '55%',
                center: ['50%', '60%'],
                data:[
                    {value:335, name:'直接访问'},
                    {value:310, name:'邮件营销'},
                    {value:234, name:'联盟广告'},
                    {value:135, name:'视频广告'},
                    {value:1548, name:'搜索引擎'}
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
            <c:forEach items="${sessionScope.Opers}" var="oper">
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
            <c:forEach items="${sessionScope.LessProduct}" var="lp">
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
            <c:forEach items="${sessionScope.MoreProduct}" var="mp">
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
