<%--
  Created by IntelliJ IDEA.
  User: Dong
  Date: 2018/11/1
  Time: 11:19
  Web HTML Header Title Bar
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="#">水产品交易管理系统</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="/">首页<span class="sr-only">(Home)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">账单管理</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">
                    产品管理
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="/product/ProductList">浏览产品信息</a>
                    <a class="dropdown-item" href="/log/productPriceLog">显示产品变动信息</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="/product/addProducts">增加数据</a>
                    <a class="dropdown-item" href="#">导出数据</a>
                </div>
            </li>
            <li class="nav-item">
                <c:if test="${requestScope.UserInfor != null}"><a class="nav-link" href="#">注销</a></c:if>
                <c:if test="${requestScope.UserInfor == null}"><a class="nav-link" href="/login">登陆</a></c:if>
            </li>
        </ul>
        <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>