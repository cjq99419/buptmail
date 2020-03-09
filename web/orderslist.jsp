<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>用户信息管理系统</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>
</head>
<body>
<div class="container">
    <h3 style="text-align: center">订单信息列表</h3>
    <table border="1" class="table table-bordered table-hover">
        <tr class="success">
            <th>编号</th>
            <th>寄件人</th>
            <th>收件人</th>
            <th>类型</th>
            <th>运费</th>
            <th>重量</th>
            <th>状态</th>
            <th>日期</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${orders}" var="order" varStatus="s">
            <tr>
                <td>${s.count}</td>
                <td>${order.sender_name}</td>
                <td>${order.recipient_name}</td>
                <td>${order.type}</td>
                <td>${order.price}</td>
                <td>${order.weight}</td>
                <td>${order.status}</td>
                <td>
                    <f:formatDate value="${order.date}" pattern="yyyy年MM月dd日" />
                </td>
                <td><a class="btn btn-default btn-sm" href="update.html">修改</a>&nbsp;<a class="btn btn-default btn-sm" href="">删除</a></td>
            </tr>
        </c:forEach>

        <tr>
            <td colspan="9" align="center"><a class="btn btn-primary" href="add.html">添加订单</a></td>
        </tr>
    </table>
</div>
</body>
</html>

