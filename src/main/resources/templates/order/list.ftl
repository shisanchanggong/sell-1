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
                        <table class="table table-bordered table-hover table-condensed">
                            <thead>
                            <tr align="center">
                                <th>订单Id</th>
                                <th>姓名</th>
                                <th>手机号</th>
                                <th>地址</th>
                                <th>金额</th>
                                <th>订单状态</th>
                                <th>支付状态</th>
                                <th>创建时间</th>
                                <th colspan="2">操作</th>
                            </tr>
                            </thead>
                            <tbody>
                        <#list orderDTOPage.content as orderDTO>
                        <tr>
                            <td>${orderDTO.orderId}</td>
                            <td>${orderDTO.buyerName}</td>
                            <td>${orderDTO.buyerPhone}</td>
                            <td>${orderDTO.buyerAddress}</td>
                            <td>${orderDTO.orderAmount}</td>
                            <td>${orderDTO.getOrderStatusEnum().msg}</td>
                            <td>${orderDTO.getPayStatusEnum().msg}</td>
                            <td>${orderDTO.createTime}</td>
                            <td>
                                <a href="/sell/seller/order/detail?orderId=${orderDTO.orderId}">详情</a>
                            </td>
                            <td>
                            <#if orderDTO.getOrderStatusEnum().msg =="新订单">
                                <a href="/sell/seller/order/cancel?orderId=${orderDTO.orderId}">取消</a>
                            </#if>
                            </td>
                        </tr>
                        </#list>
                            </tbody>
                        </table>
                        <ul class="pagination pull-right">
                        <#if curretPage lte 1>
                            <li class="disabled">
                                <a href="#">上一页</a>
                            </li>
                        <#else>
                            <li>
                                <a href="/sell/seller/order/list?page=${curretPage - 1}&size=${size}">上一页</a>
                            </li>
                        </#if>
                        <#list 1..orderDTOPage.getTotalPages() as index>
                            <#if curretPage == index>
                                <li class="disabled">
                                    <a href="#">${index}</a>
                                </li>
                            <#else>
                                <li>
                                    <a href="/sell/seller/order/list?page=${index}&size=${size}">${index}</a>
                                </li>
                            </#if>
                        </#list>
                        <#if curretPage gte orderDTOPage.getTotalPages()>
                            <li class="disabled">
                                <a href="#">下一页</a>
                            </li>
                        <#else>
                            <li>
                                <a href="/sell/seller/order/list?page=${curretPage + 1}&size=${size}">下一页</a>
                            </li>
                        </#if>


                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script>
        var websocket = null;
        if('WebSocket' in window) {
            websocket = new WebSocket('ws://');
        }else{
            alert("该浏览器不支持websocket!")
        }
        websocket.onopen = function (event) {
            console.log("建立连接");
        }
        websocket.onclose = function (event) {
            console.log("连接关闭")
        }
        websocket.onmessage = function (event) {
            console.log("收到消息" + event.data)

        }
        websocket.onerror = function (event) {
           alert("websocket错误");
        }
        window.onbeforeunload = function () {
            websocket.close();
        }
    </script>
    </body>
</html>
