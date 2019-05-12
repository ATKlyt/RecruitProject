<%--
  Created by IntelliJ IDEA.
  User: linlt
  Date: 2019/5/9
  Time: 21:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>增加填空题</title>
    <%-- 导入bootstrap --%>
    <script src="../../js/jquery-3.4.0.min.js"></script>
    <script src="../../js/jquery.form.js"></script>
    <link href="../../css/bootstrap.min.css" rel="stylesheet">
    <script src="../../js/bootstrap.min.js"></script>
</head>
<body>
<div class="container" style="width: 400px;">
    <h3 style="text-align: center;">填空题</h3>
    <form id="addQuestionForm" method="post" action="${pageContext.request.contextPath}/question/addBlankQuestion.do">
        <div class="form-group">
            <label for="newQuestionName">题目：</label>
            <input type="text" name="newQuestionName" class="form-control" id="newQuestionName" placeholder="题目"/>
        </div>
        <hr/>
        <div class="form-group" style="text-align: center;">
            <input class="btn btn btn-primary" type="submit" value="添加">
        </div>
    </form>
</div>
</body>
</html>
