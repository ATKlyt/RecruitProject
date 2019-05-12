<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: linlt
  Date: 2019/5/9
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>添加选择题</title>
    <%-- 导入bootstrap --%>
    <script src="../../js/jquery-3.4.0.min.js"></script>
    <script src="../../js/jquery.form.js"></script>
    <link href="../../css/bootstrap.min.css" rel="stylesheet">
    <script src="../../js/bootstrap.min.js"></script>
</head>
<body>
<div class="container" style="width: 400px;">
    <h3 style="text-align: center;">选择题</h3>
<form id="addQuestionForm" method="post" action="${pageContext.request.contextPath}/question/addChoiceQuestion.do">
    <div class="form-group">
        <label for="newQuestionName">题目：</label>
        <input type="text" name="newQuestionName" class="form-control" id="newQuestionName" placeholder="题目"/>
    </div>
    <div class="form-group">
        <label for="optionA">选项A：</label>
        <input type="text" name="optionA" class="form-control" id="optionA" placeholder="选项A"/>
        <input type="radio" name="optionAType" value="1" checked="checked" />正确答案
        <input type="radio" name="optionAType" value="0" />错误答案
    </div>
    <div class="form-group">
        <label for="optionB">选项B：</label>
        <input type="text" name="optionB" class="form-control" id="optionB" placeholder="选项B"/>
        <input type="radio" name="optionBType" value="1" checked="checked" />正确答案
        <input type="radio" name="optionBType" value="0" />错误答案
    </div>
    <div class="form-group">
        <label for="optionC">选项C：</label>
        <input type="text" name="optionC" class="form-control" id="optionC" placeholder="选项C"/>
        <input type="radio" name="optionCType" value="1" checked="checked" />正确答案
        <input type="radio" name="optionCType" value="0" />错误答案
    </div>

    <div class="form-group">
        <label for="optionD">选项D：</label>
        <input type="text" name="optionD" class="form-control" id="optionD" placeholder="选项D"/>
        <input type="radio" name="optionDType" value="1" checked="checked" />正确答案
        <input type="radio" name="optionDType" value="0" />错误答案
    </div>


    <hr/>
    <div class="form-group" style="text-align: center;">
        <input class="btn btn btn-primary" type="submit" value="添加">
    </div>
</form>
</div>
</body>
</html>
