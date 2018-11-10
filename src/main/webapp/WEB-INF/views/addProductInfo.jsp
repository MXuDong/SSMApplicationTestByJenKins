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
        <form method="post" action="/product/addOneProduct.up" id="productForm">
            <div>
                <h1 style="text-align: center;">单产品添加</h1>
                <h6>如果您希望为产品添加图片，请在商品详情页为其添加，谢谢</h6>
                <hr />
                <%--产品名称--%>
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="productNameHint">产品名称</span>
                    </div>
                    <input id="input_productName" type="text" class="form-control" aria-label="Default"
                           aria-describedby="inputGroup-sizing-default" name="productName">
                </div>
                <%--价格--%>
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="productPriceHint">产品价格</span>
                    </div>
                    <input id="input_productPrice" type="text" class="form-control" aria-label="Default"
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
                    <input id="input_productCount" type="text" class="form-control" aria-label="Default"
                           aria-describedby="inputGroup-sizing-default" name="productCount">
                </div>
                <%--产品推荐最值数量--%>
                <div class="input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="productMinMaxCount">产品推荐最大值|最小值</span>
                    </div>
                    <input id="input_productMaxCount" type="text" class="form-control" placeholder="推荐最大值" name="productMaxCount">
                    <input id="input_productMinCount" type="text" class="form-control" placeholder="推荐最小值" name="productMinCount">
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
            </div>
            <input type="reset" class="btn btn-outline-warning btn-block" value="重置">
            <button type="button" onclick="forSubmitForm()" class="btn btn-outline-primary btn-block" id="SubmitForm">提交</button>
        </form>
    </div>
    <script language="JavaScript">
        function forSubmitForm(){
            //控件绑定
            var productName = $("#input_productName");
            var productPrice = $("#input_productPrice");
            var productCount = $("#input_productCount");
            var productMaxCount = $("#input_productMaxCount");
            var productMinCount = $("#input_productMinCount");
            var productForm = $("#productForm");

            var message = "";

            // 判断产品名称是否为空
            if(productName.val() == ""){
                message = message + "产品名称不能为空\n";
            }
            // 判断产品价格是否为空
            if(productPrice.val() == ""){
                message = message + "产品价格不能为空\n";
            }else{
                var docCount = 0;
                for(var i = 0; i < productPrice.val().length; i++){
                    if(productPrice.val()[i] == '.'){
                        docCount++;
                        continue;
                    }
                    if(!(productPrice.val()[i] >= '0' && productPrice.val()[i] <= '9')){
                        break;
                    }
                }

                if(i == productPrice.val().length){
                    if(docCount > 1){
                        message = message + "产品价格为非正常数字！\n";
                    }
                }else{
                    message = message + "产品价格中存在非法字符\n";
                }

            }
            // 判断产品数量是否为空
            if(productCount.val() == ""){
                message = message + "产品数量不能为空\n";
            }else{
                var i;
                for(i = 0; i < productCount.val().length; i++){
                    if(!(productCount.val()[i] >= '0' && productCount.val()[i] <= '9')){
                        break;
                    }
                }

                if(i != productCount.val().length){
                    message = message + "产品数量存在非法字符！";
                }
            }
            //判断推荐最大值是否合法
            if(productMaxCount != ""){
                var i;
                for(i = 0; i < productMaxCount.val().length; i++){
                    if(!(productMaxCount.val()[i] >= '0' && productMaxCount.val()[i] <= '9')){
                        break;
                    }
                }

                if(i != productMaxCount.val().length){
                    message = message + "产品推荐最大值存含有非法字符\n";
                }
            }
            //判断推荐最小值是否合法
            if(productMinCount != ""){
                var i;
                for(i = 0; i < productMinCount.val().length; i++){
                    if(!(productMinCount.val()[i] >= '0' && productMinCount.val()[i] <= '9')){
                        break;
                    }
                }

                if(i != productMinCount.val().length){
                    message = message + "产品推荐最小值含有非法字符\n";
                }
            }

            if(message != ""){
                alert(message);
            }else {
                productForm.submit();
            }
        }
    </script>
    <div class="col-md-5">
        <%--上传批量导入文件--%>
    </div>
    <div class="col-md-1"></div>
</div>
<%@include file="footerJSP.jsp" %>
</body>
</html>
