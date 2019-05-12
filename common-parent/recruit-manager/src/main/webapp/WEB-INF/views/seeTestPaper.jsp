<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: linlt
  Date: 2019/5/10
  Time: 11:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>试卷详情</title>
    <%-- 导入bootstrap --%>
    <script src="../../js/jquery-3.4.0.min.js"></script>
    <script src="../../js/jquery.form.js"></script>
    <link href="../../css/bootstrap.min.css" rel="stylesheet">
    <script src="../../js/bootstrap.min.js"></script>
</head>
<body>
<div class="container" style="margin-top: 20px;">
    <!-- 试题 -->
    <div style="width: 60%; height: 100%; float: left;">
        <div style="width: 100%; height: 80%;">
            <p><span>试卷名称：${testPaper.paperName}</span></p>
            <div>
                <span>一、选择题（不定项）</span>
                <c:forEach items="${subjects}" var="subject" varStatus="s">
                    <c:if test="${subject.type == '1'}">
                        <br/>
                        ${s.count}、<span>${subject.questionName}</span>
                        <a class="btn btn-danger" href="${pageContext.request.contextPath}/testPaper/deleteSubject.do?questionId=${subject.questionId}&testPaperId=${testPaper.id}">删除</a>
                        <br/>
                        <c:forEach items="${subject.options}" var="option" varStatus="o">
                            ${option}<br/>
                        </c:forEach>
                    </c:if>
                </c:forEach>
                <span>二、填空题</span>
                <c:forEach items="${subjects}" var="subject" varStatus="s">
                    <c:if test="${subject.type == '0'}">
                        <br/>
                        ${s.count}、<span>${subject.questionName}</span>
                        <a class="btn btn-danger" href="${pageContext.request.contextPath}/exam/checkAnswer.do?questionId=${subject.questionId}&testPaperId=${testPaper.id}">删除</a>
                        <br/>
                    </c:if>
                </c:forEach>
                <hr/>
            </div>
        </div>
    </div>

</div>
</body>
</html>
