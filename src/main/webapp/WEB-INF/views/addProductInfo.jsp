<%--
  Created by IntelliJ IDEA.
  User: Dong
  Date: 2018/11/6
  Time: 19:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="beImportJSP.jsp" %>
</head>
<body>
<%@include file="titleJSP.jsp" %>

<%--表单信息--%>
<%--
    产品名称：productName
    产品价格：productPrice
    产品导入数量：producCount
    产品推荐最大容量：productMaxCount
    产品推荐最小容量：productMinCount
    产品类别：productType
    产品描述：productDisc
    产品图片：productPic
--%>
<div class="row">
    <div class="col-md-1"></div>
    <div class="col-md-5">
        <form method="post" enctype="multipart/form-data">
            <div>
                <h1 style="text-align: center;">单产品添加</h1>
                <hr />
                <%--产品名称--%>
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="productNameHint">产品名称</span>
                    </div>
                    <input type="text" class="form-control" aria-label="Default"
                           aria-describedby="inputGroup-sizing-default" name="productName">
                </div>
                <%--价格--%>
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="productPriceHint">产品价格</span>
                    </div>
                    <input type="text" class="form-control" aria-label="Default"
                           aria-describedby="inputGroup-sizing-default" name="productPrice">
                    <div class="input-group-append">
                        <span class="input-group-text">单位：人民币</span>
                    </div>
                </div>
                <%--产品数量--%>
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="productCountHint">入库数量</span>
                    </div>
                    <input type="text" class="form-control" aria-label="Default"
                           aria-describedby="inputGroup-sizing-default" name="productCount">
                </div>
                <%--产品推荐最值数量--%>
                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="productMinMaxCount">产品推荐最大值|最小值</span>
                    </div>
                    <input type="text" class="form-control" placeholder="推荐最大值" name="productMaxCount">
                    <input type="text" class="form-control" placeholder="推荐最小值" name="productMinCount">
                </div>
                <br />
                <%--添加新类别--%>
                <div class="input-group">
                    <select class="custom-select" name="productType">
                        <option selected>默认产品</option>
                        <c:forEach items="${requestScope.typeList}" var="res">
                            <option value="${res}">${res}</option>
                        </c:forEach>
                    </select>
                    <div class="input-group-append">
                        <button class="btn btn-outline-secondary" type="button">新建类别</button>
                    </div>
                </div>
                <br />
                <%--产品描述--%>
                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text">产品描述</span>
                    </div>
                    <textarea class="form-control" aria-label="With textarea" name="productDisc"></textarea>
                </div>
                <br />
                <%--上传图片--%>
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text">产品图片</span>
                    </div>
                    <div class="custom-file">
                        <input type="file" class="custom-file-input" id="productPic" name="productPic">
                        <label class="custom-file-label" for="productPic">选择文件</label>
                    </div>
                </div>
            </div>
            <input type="reset" class="btn btn-outline-warning btn-block" value="重置">
            <input type="submit" class="btn btn-outline-primary btn-block" value="提交">
        </form>
    </div>
    <div class="col-md-5">
        <%--上传批量导入文件--%>
    </div>
    <div class="col-md-1"></div>
</div>
<%@include file="footerJSP.jsp" %>
</body>
</html>
