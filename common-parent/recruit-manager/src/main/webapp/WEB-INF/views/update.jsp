<%--
  Created by IntelliJ IDEA.
  User: linlt
  Date: 2019/4/30
  Time: 21:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>修改信息</title>
    <%-- 导入bootstrap --%>
    <script src="../../js/jquery-3.4.0.min.js"></script>
    <link href="../../css/bootstrap.min.css" rel="stylesheet">
    <script src="../../js/bootstrap.min.js"></script>
</head>
<body>
<div class="container" style="width: 400px;">
    <div>
        <h3 style="text-align: center;">
            <p>修改信息</p>
        </h3>
    </div>
    <div class="rg_form_center">
        <form class="form-horizontal" id="updateForm" action="${pageContext.request.contextPath}/studentInfo/toUpdate.do" method="post">
            <input type="hidden" name="id" value="${studentInfo.id}"/>
            <input type="hidden" name="userId" value="${user.id}"/>
            <div class="form-group">
                <label for="name">姓名</label>
                <input type="text" id="name" class="form-control" name="name" value="${studentInfo.name}"
                       readonly="readonly" placeholder="请输入真实姓名"/>
            </div>
            <div class="form-group">
                <label for="school">学校</label>
                <input type="text" id="school" class="form-control" name="school" value="${studentInfo.school}"
                       readonly="readonly" placeholder="请输入您的学校"/>
            </div>
            <div class="form-group">
                <label for="grade">年级</label>
                <input type="text" id="grade" class="form-control" name="grade" value="${studentInfo.grade}"
                       readonly="readonly" placeholder="请输入您的年级"/>
            </div>
            <div class="form-group">
                <label for="number">学号</label>
                <input type="text" id="number" class="form-control" name="number" value="${studentInfo.number}"
                       readonly="readonly" placeholder="请输入您的学号"/>
            </div>

            <div class="form-group">
                <label>性别：</label>
                <input type="radio" name="gender" value="男" checked="checked"/>男
                <input type="radio" name="gender" value="女"/>女
            </div>

            <div class="form-group">
                <label for="email">Email</label>
                <input type="email" id="email" class="form-control" name="email" value="${studentInfo.email}"
                       placeholder="请输入Email"/>
            </div>

            <div class="form-group">
                <label for="telephone">手机号码</label>
                <input type="text" id="telephone" class="form-control" name="telephone" value="${studentInfo.telephone}"
                       placeholder="请输入手机号码"/>
            </div>

            <div class="form-group">
                <label for="identityCard">身份证</label>
                <input type="text" id="identityCard" class="form-control" name="identityCard"
                       value="${studentInfo.identityCard}" placeholder="请输入您的身份证"/>
            </div>
            <div class="form-group">
                <label for="birthday">生日</label>
                <input type="date" id="birthday" name="birthday" value="${studentInfo.birthday}" placeholder="年/月/日">
            </div>
            <div class="form-group">
                <label for="address">家庭住址</label>
                <input type="text" id="address" class="form-control" name="address" value="${studentInfo.address}"
                       placeholder="请输入您的家庭住址"/>
            </div>

            <hr/>
            <div class="form-group" style="text-align: center;">
                <input class="btn btn btn-primary" type="submit" value="修改">
                <input class="btn btn btn-group" type="reset" value="重置">
            </div>

        </form>
    </div>
</div>


<script src="../../js/login.js"></script>
</body>
</html>
