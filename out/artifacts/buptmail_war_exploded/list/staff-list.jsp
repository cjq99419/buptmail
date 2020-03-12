<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
    <title>职员信息管理系统</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="${pageContext.request.contextPath}/js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>

    <script type="text/javascript">
        function deleteStaff(id) {
            if(confirm("是否确定删除?")){
                window.location.href = "${pageContext.request.contextPath}/StaffDeleteServlet?id="+id;
            }
        }
    </script>
</head>
<body>
<div class="container">
    <h3 style="text-align: center">职员信息列表</h3>

    <div style="float: left;margin: 5px">
        <form class="form-inline">
            <div class="form-group">
                <label for="exampleInputName2">编号</label>
                <input type="text" class="form-control" id="exampleInputName2">
            </div>
            <div class="form-group">
                <label for="exampleInputEmail2">姓名</label>
                <input type="email" class="form-control" id="exampleInputEmail2">
            </div>
            <button type="submit" class="btn btn-default">查询</button>
        </form>
    </div>

    <div style="float: right;margin: 5px">
        <a class="btn btn-primary" href="${pageContext.request.contextPath}/add/staff-add.jsp">添加职员</a>
        <a class="btn btn-primary" href="../add.html">删除选中</a>
    </div>

    <table border="1" class="table table-bordered table-hover">
        <tr class="success">
            <th> </th>
            <th>编号</th>
            <th>姓名</th>
            <th>手机号</th>
            <th>邮箱</th>
            <th>负责区域</th>
            <th>薪资</th>
            <th>职位</th>
            <th>操作</th>
        </tr>
        <c:forEach items="${staffs}" var="staff" varStatus="s">
            <tr>
                <td><input type="checkbox"></td>
                <td>${s.count}</td>
                <td>${staff.staff_name}</td>
                <td>${staff.tel}</td>
                <td>${staff.email}</td>
                <td>${staff.address_region}</td>
                <td>${staff.salary}</td>
                <td>${staff.position}</td>
                <td><a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/StaffFindServlet?id=${staff.id}">修改</a>&nbsp;
                    <a class="btn btn-default btn-sm" href="javascript:deleteStaff(${staff.id})">删除</a></td>
            </tr>
        </c:forEach>
    </table>

    <div>
        <nav aria-label="Page navigation" style="float: left">
            <ul class="pagination">
                <li>
                    <a href="#" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
                <li><a href="#">1</a></li>
                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li><a href="#">4</a></li>
                <li><a href="#">5</a></li>
                <li>
                    <a href="#" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
                <span style="font-size: 20px">
                    共
                    <c:if test="${empty staffs}">
                        0
                    </c:if>
                    <c:if test="${not empty staffs}">
                        ${staffs.size()}
                    </c:if>
                    条记录,共
                    <f:formatNumber value="${staffs.size()/4+1}" pattern="0"/>
                    页
                </span>
            </ul>
        </nav>
        <a class="btn btn-primary" href="${pageContext.request.contextPath}/index.jsp" style="float: right">返回</a>
    </div>

</div>
</body>
</html>