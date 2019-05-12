<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: linlt
  Date: 2019/5/8
  Time: 0:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>用户详情</title>
    <%-- 导入bootstrap --%>
    <script src="../../js/jquery-3.4.0.min.js"></script>
    <script src="../../js/jquery.form.js"></script>
    <link href="../../css/bootstrap.min.css" rel="stylesheet">
    <script src="../../js/bootstrap.min.js"></script>
</head>
<body>

<div style="text-align: center; padding:3% 0;">
    <div style="font-size: 20px; font-weight: 100; color: #999;">
        用户信息<hr/>
        <img src="${findUser.avatar}"  width="100px" height="100px"><br/>
        用户名：${findUser.username}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;昵称：${findUser.nickname}<br/>
        姓名：${findUser.name}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;角色：${findUser.role}<br/><br/><hr/>
        <c:if test="${findStudentInfo != null}">
            个人信息<br/>
            毕业院校：${findStudentInfo.school}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;学号：${findStudentInfo.number}<br/>
            年级：${findStudentInfo.grade}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;性别：${findStudentInfo.gender}<br/>
            家庭住址：${findStudentInfo.address}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;出生年月：${findStudentInfo.birthday}<br/>
            邮箱：${findStudentInfo.email}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;手机号码：${findStudentInfo.telephone}<br/>
            身份证：${findStudentInfo.identityCard}<br/><br/>
        </c:if>
        <c:if test="${findEntryForm != null}">
            报名信息<hr/>
            年龄：${findEntryForm.age}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;专业：${findEntryForm.major}
        </c:if>
    </div>
</div>



</body>
</html>
