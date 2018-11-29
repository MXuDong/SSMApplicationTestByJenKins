<%--
  Created by IntelliJ IDEA.
  User: Dong
  Date: 2018/11/5
  Time: 20:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="beImportJSP.jsp" %>
</head>
<body>
<%@ include file="titleJSP.jsp" %>

<div class="row">
    <div class="col-md-1"></div>

    <div class="col-md-4">
        <div class="jumbotron">
            <h1 class="display-4">${requestScope.ProductInfo.productName}</h1>
            <p class="lead">${requestScope.ProductInfo.productDisc}</p>
            <hr class="my-4">
            <button type="button" class="btn btn-outline-primary btn-block" data-toggle="modal"
                    data-target="#changeProductPic"
                    id="changePicButton">更换图片
            </button>

            <!-- Modal -->
            <div class="modal fade" id="changeProductPic" tabindex="-1" role="dialog"
                 aria-labelledby="changeProductPicHeader"
                 aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <form action="${pageContext.request.contextPath}/product/updateProductPic?productId=${requestScope.ProductInfo.productId}"
                          method="post" enctype="multipart/form-data">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="changeProductPicHeader">选择文件</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">

                                <p>文件格式必须为:jpg, jepg, png中的一种！</p>

                                <div class="input-group mb-3">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text">上传</span>
                                    </div>
                                    <div class="custom-file">
                                        <input type="file" class="custom-file-input" id="uploadInput" name="file">
                                        <label class="custom-file-label" for="uploadInput">选择文件</label>
                                    </div>
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
                                <input type="submit" class="btn btn-primary" value="开始上传">
                            </div>
                        </div>
                    </form>
                </div>
            </div>

            <br/>
            <img src="${pageContext.request.contextPath}${requestScope.ProductInfo.productPic}" class="img-thumbnail">
            <hr class="my-4">
            <p class="lead">单价:${requestScope.ProductInfo.productPrice}</p>
            <p class="lead">当前库存总量:${requestScope.ProductInfo.productCount}</p>
            <p class="lead">当前库存状态:${requestScope.ProductInfo.productStatus}</p>
            <p class="lead">库存推荐最大值:${requestScope.ProductInfo.productMaxCount}</p>
            <p class="lead">库存推荐最小值:${requestScope.ProductInfo.productMinCount}</p>

            <%--修改产品数量--%>
            <button type="button" class="btn btn-outline-primary btn-block" data-toggle="modal"
                    data-target="#changeProductCount"
                    id="changeProductCountButton">修改产品数量
            </button>

            <!-- Modal -->
            <div class="modal fade" id="changeProductCount" tabindex="-1" role="dialog"
                 aria-labelledby="changeProductCountHeader"
                 aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <form action="${pageContext.request.contextPath}/product/changeProductCount?productID=${requestScope.ProductInfo.productId}"
                          method="post" id="changeCountForm">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="changeProductCountHeader">修改产品数量</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">

                                <p>请输入产品数量</p>

                                <div class="input-group mb-3">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text" id="inputGroup-sizing-default">产品数量</span>
                                    </div>
                                    <input id="input_changeProductCount" type="text" name="productCount" class="form-control" aria-label="Default" aria-describedby="inputGroup-sizing-default">
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
                                <button type="button" class="btn btn-primary" onclick="checkChangeCount()">确认修改</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
            <br />

            <%--修改产品价格--%>
            <button type="button" class="btn btn-outline-primary btn-block" data-toggle="modal"
                    data-target="#changeProductPrice"
                    id="changeProductPriceButton">修改产品价格
            </button>

            <!-- Modal -->
            <div class="modal fade" id="changeProductPrice" tabindex="-1" role="dialog"
                 aria-labelledby="changeProductPriceHeader"
                 aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <form action="${pageContext.request.contextPath}/product/changeProductPrice?productID=${requestScope.ProductInfo.productId}"
                          method="post" id="changePriceForm">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="changeProductPriceHeader">修改产品价格</h5>
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                            <div class="modal-body">

                                <p>请输入产品价格</p>

                                <div class="input-group mb-3">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text" id="changeProductPriceInput">产品价格</span>
                                    </div>
                                    <input id="input_changeProductPrice" type="text" name="productPrice" class="form-control" aria-label="Default" aria-describedby="changeProductPriceInput">
                                </div>
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-dismiss="modal" >关闭</button>
                                <button type="button" class="btn btn-primary" onclick="checkChangePrice()">确认修改</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <div class="col-md-7">
        <div id="productCountChange" style="width: 100%;height:400px;">
        </div>

        <div id="productPriceChange" style="width: 100%;height:400px;">
        </div>
    </div>
</div>

<script language="JavaScript">
    var ProductCountPic = echarts.init(document.getElementById('productCountChange'));
    var ProductPricePic = echarts.init(document.getElementById('productPriceChange'));

    function checkIsNumber(param){
        var docCount = 0;
        var i;
        for (i = 0; i < param.length; i++) {
            if (param[i] == '.') {
                docCount++;
                continue;
            }
            if (!(param[i] >= '0' && param[i] <= '9')) {
                break;
            }
        }

        return i == param.length;
    }

    function checkChangeCount(){
        var form = $("#changeCountForm");
        var input_count = $("#input_changeProductCount");

        if(checkIsNumber(input_count.val())){
            if(input_count.val().length != 0){
                form.submit();
            }
        }
    }

    function checkChangePrice(){
        var form = $("#changePriceForm");
        var input_price = $("#input_changeProductPrice");

        if(checkIsNumber(input_price.val())){
            if(input_price.val().length != 0) {
                form.submit();
            }
        }
    }

    ProductPricePic.setOption(option = {
        title: {
            text: '产品总量变化折线图'
        },
        xAxis: {
            type: 'category',
            data: [${requestScope.productXAxisData}]
        },
        toolbox: {
            left: 'center',
            feature: {
                saveAsImage: {}
            }
        },
        yAxis: {
            type: 'value'
        },
        series: [{
            data: [${requestScope.productSeriesData}],
            type: 'line'
        }]
    });

    ProductCountPic.setOption(option = {
        title: {
            text: '产品价格变化图'
        },
        tooltip: {
            trigger: 'axis'
        },
        xAxis: {
            data: [${requestScope.xAxisData}]
        },
        yAxis: {
            splitLine: {
                show: false
            }
        },
        toolbox: {
            left: 'center',
            feature: {
                dataZoom: {
                    yAxisIndex: 'none'
                },
                restore: {},
                saveAsImage: {}
            }
        },
        dataZoom: [{
            startValue: ${requestScope.startValue}
        }, {
            type: 'inside'
        }],
        visualMap: {
            top: 10,
            right: 10,
            pieces: [{
                gt: 0,
                lte: ${requestScope.minValue},
                color: '#0000ff'
            }, {
                gt: ${requestScope.minValue},
                lte: ${requestScope.maxValue},
                color: '#ff0000'
            }, {
                gt: ${requestScope.maxValue},
                color: '#00ff00'
            }],
            outOfRange: {
                color: '#999'
            }
        },
        series: {
            name: '库存数量',
            type: 'line',
            data: [${requestScope.seriesData}],
            markLine: {
                silent: true,
                data: [{
                    yAxis:${requestScope.minValue}
                }, {
                    yAxis:${requestScope.maxValue}
                }]
            }
        }
    });
</script>

<%@ include file="footerJSP.jsp" %>
</body>
</html>