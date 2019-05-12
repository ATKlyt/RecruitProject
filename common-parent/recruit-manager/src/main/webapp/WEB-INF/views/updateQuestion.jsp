<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: linlt
  Date: 2019/5/9
  Time: 19:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>修改题目</title>
    <%-- 导入bootstrap --%>
    <script src="../../js/jquery-3.4.0.min.js"></script>
    <script src="../../js/jquery.form.js"></script>
    <link href="../../css/bootstrap.min.css" rel="stylesheet">
    <script src="../../js/bootstrap.min.js"></script>
</head>
<body>
<div class="container" style="width: 400px;">
    <h3 style="text-align: center;">修改题目</h3>
    <form id="questionForm" action="${pageContext.request.contextPath}/question/updateQuestion.do" method="post">
        <input type="hidden" value="${question.type}" name="questionType">
        <input type="hidden" value="${question.id}" name="questionId">
        <div class="form-group">
            <label for="newQuestionName">题目：</label>
            <input type="text" name="newQuestionName" class="form-control" id="newQuestionName" value="${question.questionName}"/>
        </div>
        <c:forEach items="${answers}" var="answer" varStatus="i">
            <div class="form-group">
                <label for="option${i.count}">选项${i.count}：</label>
                <input type="text" name="option${i.count}" class="form-control" id="option${i.count}" value="${answer.answerName}"/><br/>
                <c:if test="${answer.answerType == '1'}">
                    <input type="radio" name="option${i.count}Type" value="1" id="option${i.count}Type" checked>正确答案&nbsp;
                    <input type="radio" name="option${i.count}Type" value="0" id="option${i.count}Type">错误答案
                </c:if>
                <c:if test="${answer.answerType == '0'}">
                    <input type="radio" name="option${i.count}Type" value="1" id="option${i.count}Type" >正确答案&nbsp;
                    <input type="radio" name="option${i.count}Type" value="0" id="option${i.count}Type" checked>错误答案
                </c:if>
            </div>
        </c:forEach>


        <hr/>
        <div class="form-group" style="text-align: center;">
            <input class="btn btn btn-primary" type="submit" value="修改">
        </div>
    </form>
</div>
</body>
</html>
