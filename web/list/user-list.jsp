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
    <title>用户信息管理系统</title>

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
        function deleteUser(id) {
            if(confirm("是否确定删除?")){
                window.location.href = "${pageContext.request.contextPath}/UserDeleteServlet?id="+id+"&currentPage=${page.currentPage}&rows=${page.rows}&name=${condition.name[0]}&tel=${condition.tel[0]}";
            }
        }

        window.onload = function () {
            document.getElementById("deleteSelected").onclick = function () {
                if(confirm("确定删除选中数据？")){
                    let cbs = document.getElementsByName("uid");
                    let flag = false;
                    for(let i = 0; i < cbs.length; i++){
                        if(cbs[i].checked){
                            flag = true;
                            break;
                        }
                    }
                    if(flag) document.getElementById("form").submit();
                }
            }
        }
    </script>
</head>

<body>
<div class="container">
    <h3 style="text-align: center">用户信息列表</h3>

    <div style="float: left;margin: 5px">
        <form class="form-inline" action="${pageContext.request.contextPath}/UserFindByPageServlet" method="post">
            <div class="form-group">
                <label for="name_condition">用户名</label>
                <input type="text" class="form-control" value="${condition.name[0]}" name="name_condition" id="name_condition">
            </div>
            <div class="form-group">
                <label for="tel_condition">电话号</label>
                <input type="text" class="form-control" value="${condition.tel[0]}" name="tel_condition" id="tel_condition">
            </div>
            <button type="submit" class="btn btn-default">查询</button>
        </form>
    </div>

    <div style="float: right;margin: 5px">
        <a class="btn btn-primary" href="${pageContext.request.contextPath}/add/user-add.jsp?currentPage=${page.currentPage}&rows=${page.rows}&name=${condition.name[0]}&tel=${condition.tel[0]}">添加用户</a>
        <a class="btn btn-primary" href="javascript:void(0);" id="deleteSelected">删除选中</a>
    </div>

    <form id="form" action="${pageContext.request.contextPath}/UserSelectedDeleteServlet">
        <input type="hidden" name="currentPage" value="${page.currentPage}">
        <input type="hidden" name="rows" value="${page.rows}">
        <input type="hidden" name="name" value="${condition.name[0]}">
        <input type="hidden" name="tel" value="${condition.tel[0]}">

        <table border="1" class="table table-bordered table-hover">
            <tr class="success">
                <th> </th>
                <th>编号</th>
                <th>姓名</th>
                <th>手机号</th>
                <th>邮箱</th>
                <th>操作</th>
            </tr>

            <c:forEach items="${page.list}" var="user" varStatus="s">
                <tr>
                    <td><input type="checkbox" name="uid" value="${user.id}"></td>
                    <td>${s.count + (page.currentPage - 1) * page.rows}</td>
                    <td>${user.name}</td>
                    <td>${user.tel}</td>
                    <td>${user.email}</td>
                    <td><a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/UserFindServlet?id=${user.id}&currentPage=${page.currentPage}&rows=${page.rows}&name_condition=${condition.name[0]}&tel_condition=${condition.tel[0]}">修改</a>&nbsp;
                        <a class="btn btn-default btn-sm" href="javascript:deleteUser(${user.id})">删除</a></td>
                </tr>
            </c:forEach>
        </table>
    </form>

    <div>
        <nav aria-label="Page navigation" style="float: left">
            <ul class="pagination">
                <c:if test="${page.currentPage == 1}">
                <li class="disabled">
                    </c:if>
                    <c:if test="${page.currentPage != 1}">
                <li>
                    </c:if>
                    <a href="${pageContext.request.contextPath}/UserFindByPageServlet?currentPage=${page.currentPage - 1}&rows=${page.rows}&name=${condition.name[0]}&tel=${condition.tel[0]}" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>


                <c:forEach begin="1" end="${page.totalPage}" var="i">
                    <c:if test="${page.currentPage != i}">
                        <li><a href="${pageContext.request.contextPath}/UserFindByPageServlet?currentPage=${i}&rows=${page.rows}&name=${condition.name[0]}&tel=${condition.tel[0]}">${i}</a></li>
                    </c:if>
                    <c:if test="${page.currentPage == i}">
                        <li class="active"><a href="${pageContext.request.contextPath}/UserFindByPageServlet?currentPage=${i}&rows=${page.rows}&name=${condition.name[0]}&tel=${condition.tel[0]}">${i}</a></li>
                    </c:if>
                </c:forEach>

                <c:if test="${page.currentPage == page.totalPage}">
                <li class="disabled">
                    </c:if>
                    <c:if test="${page.currentPage != page.totalPage}">
                <li>
                    </c:if>
                    <a href="${pageContext.request.contextPath}/UserFindByPageServlet?currentPage=${page.currentPage + 1}&rows=${page.rows}&name=${condition.name[0]}&tel=${condition.tel[0]}" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
                <span style="font-size: 20px">
                    共
                    <c:if test="${empty page}">
                        0
                    </c:if>
                    <c:if test="${not empty page}">
                        ${page.totalCount}
                    </c:if>
                    条记录,共
                     <c:if test="${empty page}">
                         0
                     </c:if>
                    <c:if test="${not empty page}">
                        <f:formatNumber value="${page.totalPage}" pattern="0"/>
                    </c:if>
                    页
                </span>
            </ul>
        </nav>
        <a class="btn btn-primary" href="${pageContext.request.contextPath}/index.jsp" style="float: right">返回</a>
    </div>

</div>
</body>
</html>
