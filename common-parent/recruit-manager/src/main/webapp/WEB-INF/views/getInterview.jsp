<%--
  Created by IntelliJ IDEA.
  User: linlt
  Date: 2019/5/11
  Time: 22:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>面试成绩</title>
    <%-- 导入bootstrap --%>
    <script src="../../js/jquery-3.4.0.min.js"></script>
    <script src="../../js/jquery.form.js"></script>
    <link href="../../css/bootstrap.min.css" rel="stylesheet">
    <script src="../../js/bootstrap.min.js"></script>
</head>
<body>
<div style="text-align: center; padding:11% 0;">
    <p style="font-size: 20px; font-weight: 300; color: #999;">你的面试成绩为：${allResult.interviewResult}</p>
</div>
</body>
</html>
