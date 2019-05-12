<%--
  Created by IntelliJ IDEA.
  User: linlt
  Date: 2019/5/10
  Time: 11:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>添加试卷</title>
    <%-- 导入bootstrap --%>
    <script src="../../js/jquery-3.4.0.min.js"></script>
    <script src="../../js/jquery.form.js"></script>
    <link href="../../css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container" style="width: 400px;">
    <h3 style="text-align: center;">新增试卷</h3>
    <form id="form" action="${pageContext.request.contextPath}/testPaper/addTestPaper.do" method="post">
        <div class="form-group">
            <label for="paperName">用户名：</label>
            <input type="text" name="paperName" class="form-control" id="paperName" placeholder="请输入试卷名称"/>
        </div>
        <div class="form-group">
            <label for="paperScore">密码：</label>
            <input type="text" name="paperScore" class="form-control" id="paperScore" placeholder="请输入试卷分数"/>
        </div>
        <hr/>
        <div class="form-group" style="text-align: center;">
            <input class="btn btn btn-primary" type="submit" value="开始组卷">
        </div>
    </form>
</div>
</body>
</html>
