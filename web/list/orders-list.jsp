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
    <title>订单信息管理系统</title>

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
        function deleteOrder(id) {
            if(confirm("是否确定删除?")){
                window.location.href = "${pageContext.request.contextPath}/OrdersDeleteServlet?id="+id+"&currentPage=${page.currentPage}&rows=${page.rows}&sender_name=${condition.sender_name[0]}&recipient_name=${condition.recipient_name[0]}";
            }
        }

        window.onload = function () {
            document.getElementById("deleteSelected").onclick = function () {
                if(confirm("确定删除选中数据？")){
                    let cbs = document.getElementsByName("oid");
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
    <h3 style="text-align: center">订单信息列表</h3>

    <div style="float: left;margin: 5px">
        <form class="form-inline" action="${pageContext.request.contextPath}/OrdersFindByPageServlet" method="post">
            <div class="form-group">
                <label for="sender_name_condition">寄件人</label>
                <input type="text" class="form-control" value="${condition.sender_name[0]}" id="sender_name_condition" name="sender_name_condition">
            </div>
            <div class="form-group">
                <label for="recipient_name_condition">收件人</label>
                <input type="text" class="form-control" value="${condition.recipient_name[0]}" id="recipient_name_condition" name="recipient_name_condition">
            </div>
            <button type="submit" class="btn btn-default">查询</button>
        </form>
    </div>

    <div style="float: right;margin: 5px">
        <a class="btn btn-primary" href="${pageContext.request.contextPath}/add/orders-add.jsp?currentPage=${page.currentPage}&rows=${page.rows}&sender_name=${condition.sender_name[0]}&recipient_name=${condition.recipient_name[0]}">添加订单</a>
        <a class="btn btn-primary" href="javascript:void(0);" id="deleteSelected">删除选中</a>
    </div>

    <form id="form" action="${pageContext.request.contextPath}/OrdersSelectedDeleteServlet">
        <input type="hidden" name="currentPage" value="${page.currentPage}">
        <input type="hidden" name="rows" value="${page.rows}">
        <input type="hidden" name="sender_name" value="${condition.sender_name[0]}">
        <input type="hidden" name="recipient_name" value="${condition.recipient_name[0]}">

        <table border="1" class="table table-bordered table-hover">
            <tr class="success">
                <th> </th>
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

            <c:forEach items="${page.list}" var="order" varStatus="s">
                <tr>
                    <td><input type="checkbox"v name="oid" value="${order.id}"></td>
                    <td>${s.count + (page.currentPage - 1) * page.rows}</td>
                    <td>${order.sender_name}</td>
                    <td>${order.recipient_name}</td>
                    <td>${order.type}</td>
                    <td>${order.price}</td>
                    <td>${order.weight}</td>
                    <td>${order.status}</td>
                    <td>
                        <f:formatDate value="${order.date}" pattern="yyyy年MM月dd日" />
                    </td>
                    <td><a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/OrdersFindServlet?id=${order.id}&currentPage=${page.currentPage}&rows=${page.rows}&sender_name_condition=${condition.sender_name[0]}&recipient_name_condition=${condition.recipient_name[0]}">修改</a>&nbsp;
                        <a class="btn btn-default btn-sm" href="javascript:deleteOrder(${order.id})">删除</a></td>
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
                    <a href="${pageContext.request.contextPath}/OrdersFindByPageServlet?currentPage=${page.currentPage - 1}&rows=${page.rows}&sender_name=${condition.sender_name[0]}&recipient_name=${condition.recipient_name[0]}" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>


                <c:forEach begin="1" end="${page.totalPage}" var="i">
                    <c:if test="${page.currentPage != i}">
                        <li><a href="${pageContext.request.contextPath}/OrdersFindByPageServlet?currentPage=${i}&rows=${page.rows}&sender_name=${condition.sender_name[0]}&recipient_name=${condition.recipient_name[0]}">${i}</a></li>
                    </c:if>
                    <c:if test="${page.currentPage == i}">
                        <li class="active"><a href="${pageContext.request.contextPath}/OrdersFindByPageServlet?currentPage=${i}&rows=${page.rows}&sender_name=${condition.sender_name[0]}&recipient_name=${condition.recipient_name[0]}">${i}</a></li>
                    </c:if>
                </c:forEach>

                <c:if test="${page.currentPage == page.totalPage}">
                <li class="disabled">
                    </c:if>
                    <c:if test="${page.currentPage != page.totalPage}">
                <li>
                    </c:if>
                    <a href="${pageContext.request.contextPath}/OrdersFindByPageServlet?currentPage=${page.currentPage + 1}&rows=${page.rows}&sender_name=${condition.sender_name[0]}&recipient_name=${condition.recipient_name[0]}" aria-label="Next">
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
        <a class="btn btn-primary" href="${pageContext.request.contextPath}/index.jsp " style="float: right">返回</a>
    </div>
</div>
</body>
</html>

