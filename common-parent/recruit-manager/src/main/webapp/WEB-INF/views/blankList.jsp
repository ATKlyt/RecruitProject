<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: linlt
  Date: 2019/5/8
  Time: 23:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>笔试阅卷</title>
    <%-- 导入bootstrap --%>
    <script src="../../js/jquery-3.4.0.min.js"></script>
    <script src="../../js/jquery.form.js"></script>
    <link href="../../css/bootstrap.min.css" rel="stylesheet">
    <script src="../../js/bootstrap.min.js"></script>
</head>
<body>
<c:if test="${blankAnswerList != null}">
    <div class="container">
        <h3 style="text-align: center">考生填空答案列表</h3>
        <div style="float: right; margin: 5px;">
            <a class="btn btn-default" href="${pageContext.request.contextPath}/user/manager.do">返回</a>
        </div>
        <form id="timeForm" method="post">
            <table border="1" class="table table-bordered table-hover">
                <tr class="success">
                    <th>编号</th>
                    <th>题目</th>
                    <th>考生答案</th>
                    <th>题目分数</th>
                    <th>操作</th>
                </tr>
                <c:forEach items="${blankAnswerList}" var="blankAnswer" varStatus="s">
                    <tr>
                        <td>${s.count}</td>
                        <td>${blankAnswer.questionName}</td>
                        <td>${blankAnswer.blankAnswer}</td>
                        <td>${blankAnswer.blankScore}</td>
                        <td><a class="btn btn-default btn-sm"
                               href="${pageContext.request.contextPath}/blank/examination.do?id=${blankAnswer.id}">评分</a>
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
                    <a href="${pageContext.request.contextPath}/time/getTypeTime.do?page=${page.prePage}"
                       aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
                    <c:forEach begin="1" end="${page.pages}" var="i">
                        <c:if test="${page.pageNum == i}">
                            <li class="active">
                                <a href="${pageContext.request.contextPath}/time/getTypeTime.do?page=${i}">${i}</a>
                            </li>
                        </c:if>
                        <c:if test="${page.pageNum != i}">
                            <li>
                                <a href="${pageContext.request.contextPath}/time/getTypeTime.do?page=${i}">${i}</a>
                            </li>
                        </c:if>
                    </c:forEach>
                    <c:if test="${page.pageNum == page.pages}"><li class="disabled"></c:if>
                    <c:if test="${page.pageNum != page.pages}"><li></c:if>
                    <a href="${pageContext.request.contextPath}/time/getTypeTime.do.do?page=${page.nextPage}"
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
<c:if test="${blankAnswerList == null}">
    当前无待阅试题
</c:if>
</body>
</html>
