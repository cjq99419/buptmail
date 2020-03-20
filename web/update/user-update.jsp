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
    <title>修改用户信息</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="${pageContext.request.contextPath}/js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</head>

<body>
<div class="container">
    <h3>修改用户信息</h3>
    <form action="${pageContext.request.contextPath}/UserUpdateServlet" method="post">

        <input type="hidden" name="id" value="${user.id}">
        <input type="hidden" name="currentPage" value="${currentPage}">
        <input type="hidden" name="rows" value="${rows}">
        <input type="hidden" name="name_condition" value="${name_condition}">
        <input type="hidden" name="tel_condition" value="${tel_condition}">


        <div class="form-group">
            <label for="name">姓名：</label>
            <input type="text" class="form-control" value="${user.name}" id="name" name="name" readonly="readonly" placeholder="请输入姓名">
        </div>

        <div class="form-group">
            <label for="tel">联系方式：</label>
            <input type="text" class="form-control" value="${user.tel}" id="tel" name="tel" placeholder="请输入联系方式">
        </div>

        <div class="form-group">
            <label for="password">密码：</label>
            <input type="text" class="form-control" value="${user.password}" id="password" name="password" placeholder="请输入密码"/>
        </div>

        <div class="form-group">
            <label for="email">邮箱：</label>
            <input type="text" class="form-control" value="${user.email}" id="email" name="email" placeholder="请输入邮箱"/>
        </div>

        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交" />
            <input class="btn btn-default" type="button" onclick="window.location.href='${pageContext.request.contextPath}/UserFindByPageServlet?currentPage=${currentPage}&rows=${rows}&name=${name_condition}&tel=${tel_condition}'" value="返回" />
        </div>
    </form>
</div>
</body>
</html>