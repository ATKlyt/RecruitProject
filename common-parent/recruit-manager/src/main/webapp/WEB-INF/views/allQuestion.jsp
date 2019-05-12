<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: linlt
  Date: 2019/5/9
  Time: 17:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>题目列表</title>
    <%-- 导入bootstrap --%>
    <script src="../../js/jquery-3.4.0.min.js"></script>
    <script src="../../js/jquery.form.js"></script>
    <link href="../../css/bootstrap.min.css" rel="stylesheet">
    <script src="../../js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <h3 style="text-align: center">题目列表</h3>
    <div style="float: left;">
        <form class="form-inline"
              action="${pageContext.request.contextPath}/question/findAllQuestion.do"
              method="post">
            <div class="form-group">
                <label for="questionName">题目：</label>
                <input type="text" name="questionName" class="form-control" id="questionName" value="${condition.questionName[0]}">
            </div>
            <button type="submit" class="btn btn-default">查询</button>
        </form>
    </div>
    <div style="float: right; margin: 5px;">
        <a class="btn btn-default" href="${pageContext.request.contextPath}/user/manager.do">返回</a>
        <a class="btn btn-primary"
           href="${pageContext.request.contextPath}/question/toAddChoiceQuestion.do">添加选择题</a>
        <a class="btn btn-primary"
           href="${pageContext.request.contextPath}/question/toAddBlankQuestion.do">添加填空题</a>
    </div>

    <form id="updateQuestionForm" method="post" >
        <table border="1" class="table table-bordered table-hover">
            <tr class="success">
                <th>编号</th>
                <th>题目类型</th>
                <th>题目</th>
                <th>选项A</th>
                <th>选项B</th>
                <th>选项C</th>
                <th>选项D</th>
                <th>正确答案</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${subjectList}" var="subject" varStatus="s">
                <tr>
                    <td>${s.count}</td>
                    <c:if test="${subject.type == '1'}">
                        <td>选择题</td>
                        <td>${subject.questionName}</td>
                        <c:forEach items="${subject.options}" var="option" varStatus="i">
                            <td>${option}</td>
                        </c:forEach>
                        <td><c:forEach items="${subject.rightOptions}" var="rightOption" >
                            ${rightOption}&nbsp;
                        </c:forEach></td>
                        <td><a class="btn btn-default btn-sm"
                               href="${pageContext.request.contextPath}/question/delete.do?questionId=${subject.questionId}">删除</a>
                            <a class="btn btn-default btn-sm"
                               href="${pageContext.request.contextPath}/question/findQuestionByQuestionId.do?questionId=${subject.questionId}">修改</a>
                        </td>
                    </c:if>
                    <c:if test="${subject.type == '0'}">
                        <td>填空题</td>
                        <td>${subject.questionName}</td>
                        <c:forEach begin="0" end="4" >
                            <td></td>
                        </c:forEach>
                        <td><a class="btn btn-default btn-sm"
                               href="${pageContext.request.contextPath}/question/delete.do?questionId=${subject.questionId}">删除</a>
                            <a class="btn btn-default btn-sm"
                               href="${pageContext.request.contextPath}/question/findQuestionByQuestionId.do?questionId=${subject.questionId}">修改</a>
                        </td>
                    </c:if>
                </tr>
            </c:forEach>
        </table>
    </form>
<%--    <div>--%>
<%--        <nav aria-label="Page navigation">--%>
<%--            <ul class="pagination">--%>
<%--                <c:if test="${page.pageNum == 1}"><li class="disabled"></c:if>--%>
<%--                <c:if test="${page.pageNum != 1}"><li></c:if>--%>
<%--                <a href="${pageContext.request.contextPath}/question/findAllQuestion.do?page=${page.prePage}&questionName=${condition.questionName[0]}"--%>
<%--                   aria-label="Previous"> <span aria-hidden="true">&laquo;</span>--%>
<%--                </a>--%>
<%--            </li>--%>
<%--                <c:forEach begin="1" end="${page.pages}" var="i">--%>
<%--                    <c:if test="${page.pageNum == i}">--%>
<%--                        <li class="active">--%>
<%--                            <a href="${pageContext.request.contextPath}/question/findAllQuestion.do?page=${i}&questionName=${condition.questionName[0]}">${i}</a>--%>
<%--                        </li>--%>
<%--                    </c:if>--%>
<%--                    <c:if test="${page.pageNum != i}">--%>
<%--                        <li>--%>
<%--                            <a href="${pageContext.request.contextPath}/question/findAllQuestion.do?page=${i}&questionName=${condition.questionName[0]}">${i}</a>--%>
<%--                        </li>--%>
<%--                    </c:if>--%>
<%--                </c:forEach>--%>
<%--                <c:if test="${page.pageNum == page.pages}"><li class="disabled"></c:if>--%>
<%--                <c:if test="${page.pageNum != page.pages}"><li></c:if>--%>
<%--                <a href="${pageContext.request.contextPath}/question/findAllQuestion.do?page=${page.nextPage}&questionName=${condition.questionName[0]}"--%>
<%--                   aria-label="Next"> <span aria-hidden="true">&raquo;</span>--%>
<%--                </a>--%>
<%--            </li>--%>
<%--                <span style="font-size: 25px; margin-left: 5px;">--%>
<%--						共${page.total}条记录，共${page.pages}页 </span>--%>
<%--            </ul>--%>
<%--        </nav>--%>
<%--    </div>--%>
</div>
</body>
</html>
