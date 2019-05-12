<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: linlt
  Date: 2019/5/10
  Time: 12:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>添加试题</title>
    <%-- 导入bootstrap --%>
    <script src="../../js/jquery-3.4.0.min.js"></script>
    <script src="../../js/jquery.form.js"></script>
    <link href="../../css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <h3 style="text-align: center">题目列表</h3>

    <form id="updateQuestionForm" method="post" action="${pageContext.request.contextPath}/testPaper/addSubject.do">
        <table border="1" class="table table-bordered table-hover">
            <tr class="success">
                <th>选中</th>
                <th>编号</th>
                <th>题目类型</th>
                <th>题目</th>
                <th>选项A</th>
                <th>选项B</th>
                <th>选项C</th>
                <th>选项D</th>
                <th>正确答案</th>
            </tr>
            <c:forEach items="${subjects}" var="subject" varStatus="s">
                <tr>
                    <td><input type="checkbox" name="${subject.questionId}" value="${subject.questionId}"></td>
                    <td>${s.count}</td>
                    <td><c:if test="${subject.type == '1'}">选择题</c:if><c:if test="${subject.type == '0'}">填空题</c:if></td>
                    <td>${subject.questionName}</td>
                    <c:forEach items="${subject.options}" var="option" varStatus="i">
                        <td>${option}</td>
                    </c:forEach>
                    <td><c:forEach items="${subject.rightOptions}" var="rightOption" >
                        ${rightOption}&nbsp;
                    </c:forEach></td>
                </tr>
            </c:forEach>
            <div class="form-group" style="text-align: center;">
                <input class="btn btn btn-primary" type="submit" value="确定">
            </div>
        </table>
    </form>
</div>
</body>
</html>
