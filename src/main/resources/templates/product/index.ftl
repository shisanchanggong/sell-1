<html>
<head>
    <meta charset="UTF-8">
    <title>微信点餐系统后台订单列表</title>
        <#include "../common/header.ftl">
</head>
<body>

<div id="wrapper" class="toggled">
<#--边栏sidebar-->
         <#include "../common/nav.ftl">
<#--主要内容-->
    <div id="page-content-wrapper">
        <div class="container-fluid">
                <div class="row clearfix">
                    <div class="col-md-12 column">
                        <form role="form" method="post" action="/sell/seller/product/save">
                            <div class="form-group">
                                <label>名称</label><input type="text" name="productName" class="form-control"  value="${(productInfo.productName)!''}"/>
                            </div>
                            <div class="form-group">
                                <label>价格</label><input type="text" name="productPrice" class="form-control"  value="${(productInfo.productPrice)!''}"/>
                            </div>
                            <div class="form-group">
                                <label>库存</label><input type="number" name="productStock" class="form-control"  value="${(productInfo.productStock)!''}"/>
                            </div>
                            <div class="form-group">
                                <label>描述</label><input type="text" name="productDescription" class="form-control"  value="${(productInfo.productDescription)!''}"/>
                            </div>
                            <div class="form-group">
                                <label>图片</label>
                                <img src="${(productInfo.productIcon)!''}">
                                <input type="text" name="productIcon" class="form-control"  value="${(productInfo.productIcon)!''}"/>
                            </div>
                            <div class="form-group">
                                <label>类目</label>
                                <select name="categoryType" class="form-control">
                                    <#list categoryList as category>
                                        <option value="${category.categoryType}"
                                                <#if (productInfo.categoryType)?? && productInfo.categoryType == category.categoryType>
                                                    selected
                                                </#if>
                                        >${category.categoryName}</option>
                                    </#list>
                                </select>
                            </div>
                            <input type="hidden" name="productId" value="${(productInfo.productId)!''}">
                            <button type="submit" class="btn btn-default">提交</button>
                        </form>
                    </div>
                </div>
    </div>
</div>
</body>
</html>
