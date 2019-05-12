<%--
  Created by IntelliJ IDEA.
  User: linlt
  Date: 2019/5/3
  Time: 16:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>我的笔试</title>
    <%-- 导入bootstrap --%>
    <script src="../../js/jquery-3.4.0.min.js"></script>
    <link href="../../css/bootstrap.min.css" rel="stylesheet">
    <script src="../../js/bootstrap.min.js"></script>
    <script>
        //new Date出来的时间快14小时
        var nowDate = new Date().getTime()+50400000;
        //考试开始时间
        var beginDate = new Date("${time.beginTime}").getTime();
        var differ = nowDate - beginDate;
        document.cookie="differ="+differ;
    </script>
</head>
<c:if test="${entryForm.dateId == null}">
    你尚未选择笔试时间
</c:if>

<c:if test="${entryForm.dateId != null}">
<c:if test="${cookie.differ.value < 0}">
<body>
<div style="text-align: center; padding:11% 0;">
    现在还不是考试时间！
</div>
</c:if>
<c:if test="${cookie.differ.value >= 0}">
<body>
    <%--没有总成绩只有选择题成绩--%>
<c:if test="${allResult.writeResult == null && allResult.choiceResult != null}">
<div style="text-align: center; padding:11% 0;">
    测试完成，您选择题部分的得分为：${allResult.choiceResult}，填空题部分正紧张统计中，请稍后查询<br/>
</div>
</c:if>
<c:if test="${allResult.writeResult != null}">
<div style="text-align: center; padding:11% 0;">
    测试完成，您选择题部分的得分为：${allResult.choiceResult}，填空题部分的得分为：${allResult.blankResult}<br/>
    <c:if test="${allResult.writeResult >= exam.paperCore*0.6}">
        恭喜您通过了灵魂IT公司的笔试阶段
    </c:if>
    <c:if test="${allResult.writeResult < exam.paperCore*0.6}">
        很遗憾您没有通过灵魂IT公司的笔试阶段
    </c:if>

</div>
</c:if>

<c:if test="${allResult.choiceResult == null}">
<body onload = "countTime()">
<div style="text-align: center; padding:11% 0; color: crimson">
    <span id="_d">00</span>
    <span id="_h">00</span>
    <span id="_m">00</span>
    <span id="_s">00</span>
</div>

<div class="container" style="margin-top: 150px;">
    <!-- 试题 -->
    <div style="width: 60%; height: 100%; float: left;">
        <div style="width: 100%; height: 80%;">
            <p><span>试卷名称：${exam.paperName}</span></p>
            <p><span>考生：${user.name}</span></p>
            <form class="form-horizontal" id="examForm" action="${pageContext.request.contextPath}/exam/checkAnswer.do" method="post">
                <input type="hidden" name="userId" value="${user.id}">
                <span>一、选择题（不定项）</span>
                <c:forEach items="${exam.subjects}" var="subject" varStatus="s">
                    <c:if test="${subject.type == '1'}">
                        ${s.count}、<span>${subject.questionName}</span>
                        <br/>
                        <c:forEach items="${subject.options}" var="option" varStatus="o">
                            <input type="checkbox" name="${subject.questionName}" value="${option}" />${option}<br/>
                        </c:forEach>
                        <br/>
                    </c:if>
                </c:forEach>
                <span>二、填空题</span>
                <c:forEach items="${exam.subjects}" var="subject" varStatus="s">
                    <c:if test="${subject.type == '0'}">
                        <br/>
                        ${s.count}、<span>${subject.questionName}</span>
                        <br/>
                        <input type="text" name="${subject.questionName}" />
                        <br/>
                    </c:if>
                </c:forEach>
                <hr/>
                <div class="form-group" style="text-align: center;">
                    <input class="btn btn btn-primary" type="submit" value="交卷">
                </div>
            </form>
        </div>
    </div>

</div>





<script type="text/javascript">

    //倒计时
    function countTime() {
        //获取当前时间
        var date = new Date();
        var now = date.getTime()+50400000;
        //设置截止时间
        var endDate = new Date("${time.endTime}");
        var end = endDate.getTime();
        //时间差
        var leftTime = end-now;
        //定义变量 d,h,m,s保存倒计时的时间
        var d,h,m,s;
        if (leftTime>=0) {
            d = Math.floor(leftTime/1000/60/60/24);
            h = Math.floor(leftTime/1000/60/60%24);
            m = Math.floor(leftTime/1000/60%60);
            s = Math.floor(leftTime/1000%60);
        }
        //将倒计时赋值到div中
        document.getElementById("_d").innerHTML = d+"天";
        document.getElementById("_h").innerHTML = h+"时";
        document.getElementById("_m").innerHTML = m+"分";
        document.getElementById("_s").innerHTML = s+"秒";
        //递归每秒调用countTime方法，显示动态时间效果
        setTimeout(countTime,1000);
    }


    //自动提交表单
    //获取当前时间
    var date = new Date();
    var now = date.getTime()+50400000;
    //设置截止时间
    var endDate = new Date("${time.endTime}");
    var end = endDate.getTime();
    //时间差
    var leftTime = end-now;
    var timer=setInterval("submitForm()", leftTime);
    function submitForm()
    {
        clearInterval(timer);
        alert("时间到");
        //表单提交
        document.getElementById("examForm").submit();
        location.reload();
    }
</script>
</c:if>
</c:if>
</c:if>




    <div style="text-align: center; padding:11% 0;">
        <p ><a href="${pageContext.request.contextPath}/user/home.do" style="font-size: 20px; font-weight: 300; color: #3c28ed;">返回主页</a></p>
    </div>
</body>




</html>
