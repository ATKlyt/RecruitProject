<%--
  Created by IntelliJ IDEA.
  User: linlt
  Date: 2019/5/4
  Time: 11:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>选择时间</title>
    <%-- 导入bootstrap --%>
    <script src="../../js/jquery-3.4.0.min.js"></script>
    <script src="../../js/jquery.form.js"></script>
    <link href="../../css/bootstrap.min.css" rel="stylesheet">
    <script src="../../js/bootstrap.min.js"></script>
</head>
<body>

<%--  0 未激活 1 激活 2 报名 3 笔试时间选择完成 4 已经笔试完成 5 通过笔试 6 面试时间选择完成 7 面试完成--%>

<c:if test="${user.role == '用户'}">
    <c:if test="${type == '1'}">
        <c:if test="${studentInfo.status == '5'}">
            <div class="container">
                <h3 style="text-align: center">面试时间列表</h3>

                <c:if test="${user.role != '用户'}">
                    <div style="float: right; margin: 5px;">
                        <a class="btn btn-primary" href="${pageContext.request.contextPath}/time/addTime.do?type=${type}">添加时间段</a>
                    </div>
                </c:if>
                <form id="timeForm" method="post">
                    <table border="1" class="table table-bordered table-hover">
                        <tr class="success">
                            <th>编号</th>
                            <th>时间段</th>
                            <th>当前人数</th>
                            <th>人数限制</th>
                            <th>操作</th>
                        </tr>
                        <c:forEach items="${times}" var="time" varStatus="s">
                            <tr>
                                <td>${s.count}</td>
                                <td>${time.beginTime}--${time.endTime}</td>
                                <td>${time.amount}</td>
                                <td>${time.amountLimit}</td>
                                <td>
                                    <c:if test="${user.role == '用户'}">
                                        <a class="btn btn-default btn-sm"
                                           href="${pageContext.request.contextPath}/time/toChooseTime.do?id=${time.id}">选择</a>
                                    </c:if>
                                    <c:if test="${user.role != '用户'}">
                                        <a class="btn btn-danger btn-sm"
                                           href="${pageContext.request.contextPath}/time/deleteTime.do?id=${time.id}">删除</a>
                                    </c:if>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </form>
                <div>
                    <nav aria-label="Page navigation">
                        <ul class="pagination">
                            <c:if test="${page.pageNum == 1}"><li class="disabled"></c:if>
                            <c:if test="${page.pageNum != 1}"><li></c:if>
                            <a href="${pageContext.request.contextPath}/time/getTypeTime.do?page=${page.prePage}&type=${type}&name=${condition.name[0]}"
                               aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                            <c:forEach begin="1" end="${page.pages}" var="i">
                                <c:if test="${page.pageNum == i}">
                                    <li class="active">
                                        <a href="${pageContext.request.contextPath}/time/getTypeTime.do?page=${i}&type=${type}&name=${condition.name[0]}">${i}</a>
                                    </li>
                                </c:if>
                                <c:if test="${page.pageNum != i}">
                                    <li>
                                        <a href="${pageContext.request.contextPath}/time/getTypeTime.do?page=${i}&type=${type}&name=${condition.name[0]}">${i}</a>
                                    </li>
                                </c:if>
                            </c:forEach>
                            <c:if test="${page.pageNum == page.pages}"><li class="disabled"></c:if>
                            <c:if test="${page.pageNum != page.pages}"><li></c:if>
                            <a href="${pageContext.request.contextPath}/time/getTypeTime.do.do?page=${page.nextPage}&type=${type}&name=${condition.name[0]}"
                               aria-label="Next"> <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                            <span style="font-size: 25px; margin-left: 5px;">
						共${page.total}条记录，共${page.pages}页 </span>
                        </ul>
                    </nav>
                </div>
            </div>
        </c:if>
        <c:if test="${studentInfo.status > '5'}">
            <div style="text-align: center; padding:11% 0;">
                <p style="font-size: 20px; font-weight: 300; color: #999;">你已经选过面试时间了！</p>
            </div>
        </c:if>
    </c:if>
    <c:if test="${type == '0'}">
        <c:if test="${entryForm.id != null}">
            <c:if test="${entryForm.dateId == null}">
                <div class="container">
                    <h3 style="text-align: center">笔试时间列表</h3>

                    <c:if test="${user.role != '用户'}">
                        <div style="float: right; margin: 5px;">
                            <a class="btn btn-primary" href="${pageContext.request.contextPath}/time/addTime.do?type=${type}">添加时间段</a>
                        </div>
                    </c:if>
                    <form id="timeForm" method="post">
                        <table border="1" class="table table-bordered table-hover">
                            <tr class="success">
                                <th>编号</th>
                                <th>时间段</th>
                                <th>当前人数</th>
                                <th>人数限制</th>
                                <th>操作</th>
                            </tr>
                            <c:forEach items="${times}" var="time" varStatus="s">
                                <tr>
                                    <td>${s.count}</td>
                                    <td>${time.beginTime}--${time.endTime}</td>
                                    <td>${time.amount}</td>
                                    <td>${time.amountLimit}</td>
                                    <td>
                                        <c:if test="${user.role == '用户'}">
                                            <a class="btn btn-default btn-sm"
                                               href="${pageContext.request.contextPath}/time/toChooseTime.do?id=${time.id}">选择</a>
                                        </c:if>
                                        <c:if test="${user.role != '用户'}">
                                            <a class="btn btn-danger btn-sm"
                                               href="${pageContext.request.contextPath}/time/deleteTime.do?id=${time.id}">删除</a>
                                        </c:if>
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                    </form>
                    <div>
                        <nav aria-label="Page navigation">
                            <ul class="pagination">
                                <c:if test="${page.pageNum == 1}"><li class="disabled"></c:if>
                                <c:if test="${page.pageNum != 1}"><li></c:if>
                                <a href="${pageContext.request.contextPath}/time/getTypeTime.do?page=${page.prePage}&type=${type}&name=${condition.name[0]}"
                                   aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                                <c:forEach begin="1" end="${page.pages}" var="i">
                                    <c:if test="${page.pageNum == i}">
                                        <li class="active">
                                            <a href="${pageContext.request.contextPath}/time/getTypeTime.do?page=${i}&type=${type}&name=${condition.name[0]}">${i}</a>
                                        </li>
                                    </c:if>
                                    <c:if test="${page.pageNum != i}">
                                        <li>
                                            <a href="${pageContext.request.contextPath}/time/getTypeTime.do?page=${i}&type=${type}&name=${condition.name[0]}">${i}</a>
                                        </li>
                                    </c:if>
                                </c:forEach>
                                <c:if test="${page.pageNum == page.pages}"><li class="disabled"></c:if>
                                <c:if test="${page.pageNum != page.pages}"><li></c:if>
                                <a href="${pageContext.request.contextPath}/time/getTypeTime.do.do?page=${page.nextPage}&type=${type}&name=${condition.name[0]}"
                                   aria-label="Next"> <span aria-hidden="true">&raquo;</span>
                                </a>
                            </li>
                                <span style="font-size: 25px; margin-left: 5px;">
						共${page.total}条记录，共${page.pages}页 </span>
                            </ul>
                        </nav>
                    </div>
                </div>
            </c:if>
            <c:if test="${entryForm.dateId != null}">
                <div style="text-align: center; padding:11% 0;">
                    <p style="font-size: 20px; font-weight: 300; color: #999;">你已经选过笔试时间了！</p>
                </div>
            </c:if>
        </c:if>

    </c:if>
    <div style="text-align: center">
        <a class="btn btn-default" href="${pageContext.request.contextPath}/user/home.do">返回</a>
    </div>
</c:if>

<c:if test="${user.role != '用户'}">
    <c:if test="${type == '1'}">
        <div class="container">
                <h3 style="text-align: center">面试时间列表</h3>

                <c:if test="${user.role != '用户'}">
                    <div style="float: right; margin: 5px;">
                        <a class="btn btn-primary" href="${pageContext.request.contextPath}/time/addTime.do?type=${type}">添加时间段</a>
                    </div>
                </c:if>
                <form id="timeForm" method="post">
                    <table border="1" class="table table-bordered table-hover">
                        <tr class="success">
                            <th>编号</th>
                            <th>时间段</th>
                            <th>当前人数</th>
                            <th>人数限制</th>
                            <th>操作</th>
                        </tr>
                        <c:forEach items="${times}" var="time" varStatus="s">
                            <tr>
                                <td>${s.count}</td>
                                <td>${time.beginTime}--${time.endTime}</td>
                                <td>${time.amount}</td>
                                <td>${time.amountLimit}</td>
                                <td>
                                    <c:if test="${user.role == '用户'}">
                                        <a class="btn btn-default btn-sm"
                                           href="${pageContext.request.contextPath}/time/toChooseTime.do?id=${time.id}">选择</a>
                                    </c:if>
                                    <c:if test="${user.role != '用户'}">
                                        <a class="btn btn-danger btn-sm"
                                           href="${pageContext.request.contextPath}/time/deleteTime.do?id=${time.id}">删除</a>
                                    </c:if>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </form>
                <div>
                    <nav aria-label="Page navigation">
                        <ul class="pagination">
                            <c:if test="${page.pageNum == 1}"><li class="disabled"></c:if>
                            <c:if test="${page.pageNum != 1}"><li></c:if>
                            <a href="${pageContext.request.contextPath}/time/getTypeTime.do?page=${page.prePage}&type=${type}&name=${condition.name[0]}"
                               aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                            <c:forEach begin="1" end="${page.pages}" var="i">
                                <c:if test="${page.pageNum == i}">
                                    <li class="active">
                                        <a href="${pageContext.request.contextPath}/time/getTypeTime.do?page=${i}&type=${type}&name=${condition.name[0]}">${i}</a>
                                    </li>
                                </c:if>
                                <c:if test="${page.pageNum != i}">
                                    <li>
                                        <a href="${pageContext.request.contextPath}/time/getTypeTime.do?page=${i}&type=${type}&name=${condition.name[0]}">${i}</a>
                                    </li>
                                </c:if>
                            </c:forEach>
                            <c:if test="${page.pageNum == page.pages}"><li class="disabled"></c:if>
                            <c:if test="${page.pageNum != page.pages}"><li></c:if>
                            <a href="${pageContext.request.contextPath}/time/getTypeTime.do.do?page=${page.nextPage}&type=${type}&name=${condition.name[0]}"
                               aria-label="Next"> <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                            <span style="font-size: 25px; margin-left: 5px;">
						共${page.total}条记录，共${page.pages}页 </span>
                        </ul>
                    </nav>
                </div>
            </div>
    </c:if>
    <c:if test="${type == '0'}">
        <div class="container">
                    <h3 style="text-align: center">笔试时间列表</h3>

                    <c:if test="${user.role != '用户'}">
                        <div style="float: right; margin: 5px;">
                            <a class="btn btn-primary" href="${pageContext.request.contextPath}/time/addTime.do?type=${type}">添加时间段</a>
                        </div>
                    </c:if>
                    <form id="timeForm" method="post">
                        <table border="1" class="table table-bordered table-hover">
                            <tr class="success">
                                <th>编号</th>
                                <th>时间段</th>
                                <th>当前人数</th>
                                <th>人数限制</th>
                                <th>操作</th>
                            </tr>
                            <c:forEach items="${times}" var="time" varStatus="s">
                                <tr>
                                    <td>${s.count}</td>
                                    <td>${time.beginTime}--${time.endTime}</td>
                                    <td>${time.amount}</td>
                                    <td>${time.amountLimit}</td>
                                    <td>
                                        <c:if test="${user.role == '用户'}">
                                            <a class="btn btn-default btn-sm"
                                               href="${pageContext.request.contextPath}/time/toChooseTime.do?id=${time.id}">选择</a>
                                        </c:if>
                                        <c:if test="${user.role != '用户'}">
                                            <a class="btn btn-danger btn-sm"
                                               href="${pageContext.request.contextPath}/time/deleteTime.do?id=${time.id}">删除</a>
                                        </c:if>
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                    </form>
                    <div>
                        <nav aria-label="Page navigation">
                            <ul class="pagination">
                                <c:if test="${page.pageNum == 1}"><li class="disabled"></c:if>
                                <c:if test="${page.pageNum != 1}"><li></c:if>
                                <a href="${pageContext.request.contextPath}/time/getTypeTime.do?page=${page.prePage}&type=${type}&name=${condition.name[0]}"
                                   aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                                <c:forEach begin="1" end="${page.pages}" var="i">
                                    <c:if test="${page.pageNum == i}">
                                        <li class="active">
                                            <a href="${pageContext.request.contextPath}/time/getTypeTime.do?page=${i}&type=${type}&name=${condition.name[0]}">${i}</a>
                                        </li>
                                    </c:if>
                                    <c:if test="${page.pageNum != i}">
                                        <li>
                                            <a href="${pageContext.request.contextPath}/time/getTypeTime.do?page=${i}&type=${type}&name=${condition.name[0]}">${i}</a>
                                        </li>
                                    </c:if>
                                </c:forEach>
                                <c:if test="${page.pageNum == page.pages}"><li class="disabled"></c:if>
                                <c:if test="${page.pageNum != page.pages}"><li></c:if>
                                <a href="${pageContext.request.contextPath}/time/getTypeTime.do.do?page=${page.nextPage}&type=${type}&name=${condition.name[0]}"
                                   aria-label="Next"> <span aria-hidden="true">&raquo;</span>
                                </a>
                            </li>
                                <span style="font-size: 25px; margin-left: 5px;">
						共${page.total}条记录，共${page.pages}页 </span>
                            </ul>
                        </nav>
                    </div>
                </div>
    </c:if>
<div style="text-align: center">
    <a class="btn btn-default" href="${pageContext.request.contextPath}/user/manager.do">返回</a>
</div>
</c:if>


</body>
</html>
