<%--
  Created by IntelliJ IDEA.
  User: linlt
  Date: 2019/5/2
  Time: 18:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>个人详情</title>
    <%-- 导入bootstrap --%>
    <script src="../../js/jquery-3.4.0.min.js"></script>
    <link href="../../css/bootstrap.min.css" rel="stylesheet">
    <script src="../../js/bootstrap.min.js"></script>
</head>
<body>
<div class="container panel panel-primary" style="width: 800px;">
    <div class="row">
        <div class="col-md-3">姓名</div>
        <div class="col-md-6">${studentInfo.name}</div>
        <div class="col-md-3">身份证</div>
        <div class="col-md-6">${studentInfo.identityCard}</div>
    </div>
    <div class="row panel panel-primary">
        <div class="col-md-3">电话</div>
        <div class="col-md-3">${studentInfo.telephone}</div>
        <div class="col-md-3">生日</div>
        <div class="col-md-3">${studentInfo.birthday}</div>
        <div class="col-md-3">性别</div>
        <div class="col-md-3">${studentInfo.gender}</div>
    </div>
    <div class="row panel panel-primary">
        <div class="col-md-3">学校</div>
        <div class="col-md-3">${studentInfo.school}</div>
        <div class="col-md-3">学号</div>
        <div class="col-md-3">${studentInfo.number}</div>
        <div class="col-md-3">年级</div>
        <div class="col-md-3">${studentInfo.grade}</div>
    </div>
    <div class="row panel panel-primary">
        <div class="col-md-3">邮箱</div>
        <div class="col-md-9">${studentInfo.email}</div>
    </div>
    <div class="row panel panel-primary">
        <div class="col-md-3">家庭住址</div>
        <div class="col-md-9">${studentInfo.address}</div>
    </div>
</div>
</body>
</html>
