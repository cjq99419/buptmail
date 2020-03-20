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
     <title>添加职员</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="${pageContext.request.contextPath}/js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</head>

<body>
<div class="container">
    <h3>添加职员</h3>
    <form action="${pageContext.request.contextPath}/StaffAddServlet" method="post">

        <div class="form-group">
            <label for="staff_name">姓名：</label>
            <input type="text" class="form-control" id="staff_name" name="staff_name" placeholder="请输入姓名">
        </div>

        <div class="form-group">
            <label for="tel">联系方式：</label>
            <input type="text" class="form-control" id="tel" name="tel" placeholder="请输入联系方式">
        </div>

        <div class="form-group">
            <label for="password">密码：</label>
            <input type="text" class="form-control" id="password" name="password" placeholder="请输入密码"/>
        </div>

        <div class="form-group">
            <label for="email">邮箱：</label>
            <input type="text" class="form-control" id="email" name="email" placeholder="请输入邮箱"/>
        </div>

        <div class="form-group">
            <label for="address_region">负责区域：</label>
            <input type="text" class="form-control" id="address_region" name="address_region" placeholder="请输入负责区域">
        </div>

        <div class="form-group">
            <label for="position">职位：</label>
            <select name="position" class="position" id="position">
                <option value="staff">职员</option>
                <option value="manager">经理</option>
            </select>
        </div>

        <%
          String currentPage = request.getParameter("currentPage");
          String rows = request.getParameter("rows");
          String staff_name = request.getParameter("staff_name");
          String position = request.getParameter("position");
        %>
        
        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交" />
            <input class="btn btn-default" type="reset" value="重置" />
            <input class="btn btn-default" type="button" onclick="window.location.href='${pageContext.request.contextPath}/StaffFindByPageServlet?currentPage=<%=currentPage%>&rows=<%=rows%>&staff_name=<%=staff_name%>&position=<%=position%>'"  value="返回" />
        </div>
    </form>
</div>
</body>
</html>