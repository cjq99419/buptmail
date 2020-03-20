<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- HTML5文档-->
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
    <title>添加订单</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="${pageContext.request.contextPath}/js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</head>

<body>
<div class="container">
    <h3>添加订单</h3>
    <form action="${pageContext.request.contextPath}/OrdersAddServlet" method="post">
        <div class="form-group">
            <label for="sender_name">寄件人姓名：</label>
            <input type="text" class="form-control" id="sender_name" name="sender_name" placeholder="请输入寄件人姓名">
        </div>

        <div class="form-group">
            <label for="sender_tel">寄件人联系方式：</label>
            <input type="text" class="form-control" id="sender_tel" name="sender_tel" placeholder="请输入寄件人联系方式">
        </div>

        <div class="form-group">
            <label for="sender_address">寄件人地址：</label>
            <input type="text" class="form-control" id="sender_address" name="sender_address" placeholder="请输入寄件人地址">
        </div>

        <div class="form-group">
            <label for="recipient_name">收件人姓名：</label>
            <input type="text" class="form-control" id="recipient_name" name="recipient_name" placeholder="请输入收件人姓名">
        </div>

        <div class="form-group">
            <label for="recipient_tel">收件人联系方式：</label>
            <input type="text" class="form-control" id="recipient_tel" name="recipient_tel" placeholder="请输入收件人联系方式">
        </div>

        <div class="form-group">
            <label for="recipient_address">收件人地址：</label>
            <input type="text" class="form-control" id="recipient_address" name="recipient_address" placeholder="请输入收件人地址">
        </div>

        <div class="form-group">
            <label for="type">类型：</label>
            <select name="type" class="form-control" id="type">
                <option value="toy">玩具</option>
                <option value="book">书</option>
                <option value="other">其他</option>
            </select>
        </div>

        <div class="form-group">
            <label for="weight">重量：</label>
            <input type="text" class="form-control" id="weight" name="weight" placeholder="请输入重量">
        </div>

        <div class="form-group">
            <label for="mode_payment">支付方式：</label>
            <select name="mode_payment" class="form-control" id="mode_payment">
                <option value="cash">现金</option>
                <option value="on line">线上支付</option>
            </select>
        </div>

        <%
            String currentPage = request.getParameter("currentPage");
            String rows = request.getParameter("rows");
            String sender_name = request.getParameter("sender_name");
            String recipient_name = request.getParameter("recipient_name");
        %>

        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交" />
            <input class="btn btn-default" type="reset" value="重置" />
            <input class="btn btn-default" type="button" onclick="window.location.href='${pageContext.request.contextPath}/OrdersFindByPageServlet?currentPage=<%=currentPage%>&rows=<%=rows%>&sender_name=<%=sender_name%>&recipient_name=<%=recipient_name%>'" value="返回" />
        </div>
    </form>
</div>
</body>
</html>