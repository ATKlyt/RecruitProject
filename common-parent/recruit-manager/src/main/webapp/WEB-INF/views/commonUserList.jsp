<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: linlt
  Date: 2019/5/7
  Time: 22:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="../../css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <h3 style="text-align: center">用户信息列表</h3>
    <div style="float: left;">
        <form class="form-inline"
              action="${pageContext.request.contextPath}/user/commonUserList.do"
              method="post">
            <div class="form-group">
                <label for="name">姓名：</label>
                <input type="text" name="name" class="form-control" id="name" value="${condition.name[0]}">
            </div>
            <div class="form-group">
                <label for="email">邮箱：</label>
                <input type="text" name="email" class="form-control" id="email" value="${condition.email[0]}">
            </div>
            <button type="submit" class="btn btn-default">查询</button>
        </form>
    </div>

    <div style="float: right; margin: 5px;">
        <a class="btn btn-default" href="${pageContext.request.contextPath}/user/manager.do">返回</a>
    </div>
    <form id="form" method="post">
        <table border="1" class="table table-bordered table-hover">
            <tr class="success">
                <th>编号</th>
                <th>头像</th>
                <th>用户名</th>
                <th>姓名</th>
                <th>昵称</th>
                <th>身份</th>
                <th>阶段</th>
                <th>邮箱</th>
                <th>电话</th>
                <th>学校</th>
                <th>操作</th>
            </tr>

            <c:forEach items="${commonUserList}" var="commonUser" varStatus="s">
                <tr>
                    <td>${s.count}</td>
                    <td><img src="${commonUser.avatar}" width="20px" height="20px"/></td>
                    <td>${commonUser.username}</td>
                    <td>${commonUser.name}</td>
                    <td>${commonUser.nickname}</td>
                    <td>${commonUser.role}</td>
                    <td>${commonUser.status}</td>
                    <td>${commonUser.email}</td>
                    <td>${commonUser.telephone}</td>
                    <td>${commonUser.school}</td>
                    <td><a class="btn btn-default btn-sm"
                           href="${pageContext.request.contextPath}/user/adminFind.do?userId=${commonUser.id}">查看</a>&nbsp;
                        <c:if test="${user.role == '超级管理员'}">
                        <a class="btn btn-default btn-sm"
                           href="${pageContext.request.contextPath}/?userId=${commonUser.id}">修改</a>&nbsp;
                        <a class="btn btn-default btn-sm"
                           href="${pageContext.request.contextPath}/user/delete.do?userId=${commonUser.id}">删除</a></td>
                    </c:if>
                </tr>
            </c:forEach>
        </table>
    </form>

    <div>
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <c:if test="${page.pageNum == 1}"><li class="disabled"></c:if>
                <c:if test="${page.pageNum != 1}"><li></c:if>
                <a href="${pageContext.request.contextPath}/user/commonUserList.do?page=${page.prePage}&name=${condition.name[0]}&email=${condition.email[0]}"
                   aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
                <c:forEach begin="1" end="${page.pages}" var="i">
                    <c:if test="${page.pageNum == i}">
                        <li class="active">
                            <a href="${pageContext.request.contextPath}/user/commonUserList.do?page=${i}&name=${condition.name[0]}&email=${condition.email[0]}">${i}</a>
                        </li>
                    </c:if>
                    <c:if test="${page.pageNum != i}">
                        <li>
                            <a href="${pageContext.request.contextPath}/user/commonUserList.do?page=${i}&name=${condition.name[0]}&email=${condition.email[0]}">${i}</a>
                        </li>
                    </c:if>
                </c:forEach>
                <c:if test="${page.pageNum == page.pages}"><li class="disabled"></c:if>
                <c:if test="${page.pageNum != page.pages}"><li></c:if>
                <a href="${pageContext.request.contextPath}/user/commonUserList.do?page=${page.nextPage}&name=${condition.name[0]}&email=${condition.email[0]}"
                   aria-label="Next"> <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
                <span style="font-size: 25px; margin-left: 5px;">
						共${page.total}条记录，共${page.pages}页 </span>

            </ul>
        </nav>


    </div>

</div>
</body>
</html>
