<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: linlt
  Date: 2019/5/8
  Time: 23:21
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
<div class="container">
    <h3 style="text-align: center">考生填空答案列表</h3>
    <div>
        <table border="1" class="table table-bordered table-hover">
            <tr class="success">
                <th>题目</th>
                <th>考生答案</th>
                <th>题目分数</th>
            </tr>
            <tr>
                <td>${blankAnswer.questionName}</td>
                <td>${blankAnswer.blankAnswer}</td>
                <td>${blankAnswer.blankScore}</td>
            </tr>
        </table>
    </div>
    <form action="${pageContext.request.contextPath}/blank/scoring.do?userId=${blankAnswer.userId}&questionId=${blankAnswer.questionId}" method="post">
        <c:forEach begin="1" end="${blankAnswer.blankScore}" varStatus="i">
            <input type="radio" name="blankResult" value="${i.count}">${i.count}
        </c:forEach>
        <div class="form-group" style="text-align: center;">
            <input class="btn btn btn-primary" type="submit" value="提交分数">
        </div>
    </form>
</div>
</body>
</html>
