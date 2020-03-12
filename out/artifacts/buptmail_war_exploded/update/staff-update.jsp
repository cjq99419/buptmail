<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>修改职员信息</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="${pageContext.request.contextPath}/js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <h3>修改职员信息</h3>
    <form action="${pageContext.request.contextPath}/StaffUpdateServlet" method="post">

        <input type="hidden" name="id" value="${staff.id}">

        <div class="form-group">
            <label for="staff_name">姓名：</label>
            <input type="text" class="form-control" value="${staff.staff_name}" id="staff_name" name="staff_name" readonly="readonly" placeholder="请输入姓名">
        </div>

        <div class="form-group">
            <label for="tel">联系方式：</label>
            <input type="text" class="form-control" value="${staff.tel}" id="tel" name="tel" placeholder="请输入联系方式">
        </div>

        <div class="form-group">
            <label for="password">密码：</label>
            <input type="text" class="form-control" value="${staff.password}" id="password" name="password" placeholder="请输入密码"/>
        </div>

        <div class="form-group">
            <label for="email">邮箱：</label>
            <input type="text" class="form-control" value="${staff.email}" id="email" name="email" placeholder="请输入邮箱"/>
        </div>

        <div class="form-group">
            <label for="address_region">负责区域：</label>
            <input type="text" class="form-control" value="${staff.address_region}" id="address_region" name="address_region" placeholder="请输入负责区域">
        </div>

        <div class="form-group">
            <label for="position">职位：</label>
            <select name="position" class="position" id="position">
                <c:if test="${staff.position == 'manager'}">
                    <option value="staff">职员</option>
                    <option value="manager" selected>经理</option>
                </c:if>
                <c:if test="${staff.position == 'staff'}">
                    <option value="staff" selected>职员</option>
                    <option value="manager">经理</option>
                </c:if>
            </select>
        </div>

        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交" />
            <input class="btn btn-default" type="button" onclick="window.location.href='${pageContext.request.contextPath}/StaffListServlet'" value="返回" />
        </div>
    </form>
</div>
</body>
</html>