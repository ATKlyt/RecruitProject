<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: linlt
  Date: 2019/5/10
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>试卷列表</title>
    <%-- 导入bootstrap --%>
    <script src="../../js/jquery-3.4.0.min.js"></script>
    <script src="../../js/jquery.form.js"></script>
    <link href="../../css/bootstrap.min.css" rel="stylesheet">
    <script src="../../js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <h3 style="text-align: center">试卷列表</h3>
    <div style="float: left;">
        <form class="form-inline"
              action="${pageContext.request.contextPath}/testPaper/testPaperList.do"
              method="post">
            <div class="form-group">
                <label for="paperName">试卷名称：</label>
                <input type="text" name="paperName" class="form-control" id="paperName" value="${condition.paperName[0]}">
            </div>
            <button type="submit" class="btn btn-default">查询</button>
        </form>
    </div>

    <div style="float: right; margin: 5px;">
        <a class="btn btn-default" href="${pageContext.request.contextPath}/user/manager.do">返回</a>

        <a class="btn btn-primary" href="${pageContext.request.contextPath}/testPaper/newTestPaper.do">添加试卷</a>
    </div>

    <form id="form" method="post">
        <table border="1" class="table table-bordered table-hover">
            <tr class="success">
                <th>编号</th>
                <th>试卷名称</th>
                <th>试卷分数</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${testPaperList}" var="testPaper" varStatus="s">
                <tr>
                    <td>${s.count}</td>
                    <td>${testPaper.paperName}</td>
                    <td>${testPaper.paperScore}</td>
                    <td><a class="btn btn-default btn-sm"
                           href="${pageContext.request.contextPath}/testPaper/seeTestPaper.do?testPaperId=${testPaper.id}">查看</a>&nbsp;
                        <a class="btn btn-default btn-sm"
                           href="${pageContext.request.contextPath}/testPaper/deleteTestPaper.do?testPaperId=${testPaper.id}">删除</a></td>
                </tr>
            </c:forEach>
        </table>
    </form>

    <div>
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <c:if test="${page.pageNum == 1}"><li class="disabled"></c:if>
                <c:if test="${page.pageNum != 1}"><li></c:if>
                <a href="${pageContext.request.contextPath}/testPaper/testPaperList.do?page=${page.prePage}&paperName=${condition.paperName[0]}"
                   aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
                <c:forEach begin="1" end="${page.pages}" var="i">
                    <c:if test="${page.pageNum == i}">
                        <li class="active">
                            <a href="${pageContext.request.contextPath}/testPaper/testPaperList.do?page=${i}&paperName=${condition.paperName[0]}">${i}</a>
                        </li>
                    </c:if>
                    <c:if test="${page.pageNum != i}">
                        <li>
                            <a href="${pageContext.request.contextPath}/testPaper/testPaperList.do?page=${i}&paperName=${condition.paperName[0]}">${i}</a>
                        </li>
                    </c:if>
                </c:forEach>
                <c:if test="${page.pageNum == page.pages}"><li class="disabled"></c:if>
                <c:if test="${page.pageNum != page.pages}"><li></c:if>
                <a href="${pageContext.request.contextPath}/testPaper/testPaperList.do?page=${page.nextPage}&paperName=${condition.paperName[0]}"
                   aria-label="Next"> <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
                <span style="font-size: 25px; margin-left: 5px;">
						共${page.total}条记录，共${page.pages}页 </span>
            </ul>
        </nav>
    </div>
</div>
</body>
</html>
