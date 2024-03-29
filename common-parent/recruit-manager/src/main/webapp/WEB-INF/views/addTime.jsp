<%--
  Created by IntelliJ IDEA.
  User: linlt
  Date: 2019/5/11
  Time: 3:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>新增时间</title>
    <%-- 导入bootstrap --%>
    <script src="../../js/jquery-3.4.0.min.js"></script>
    <script src="../../js/jquery.form.js"></script>
    <link href="../../css/bootstrap.min.css" rel="stylesheet">
    <link href="../../css/bootstrap-datetimepicker.min.css" rel="stylesheet">
    <script src="../../js/bootstrap.min.js"></script>
    <script src="../../js/bootstrap-datetimepicker.min.js"></script>
    <script src="../../js/locales/bootstrap-datetimepicker.fr.js"></script>
</head>
<body>
<div class="container" style="width: 400px;">
    <h3 style="text-align: center;">用户登录</h3>
    <form id="addTimeForm" action="${pageContext.request.contextPath}/time/toSetTime.do" method="post">
        <input type="hidden" name="type" value="${type}">
        <div class="form-group">
            <label for="beginTime">开始时间：</label>
            <input type="text" name="beginTime" class="form-control" id="beginTime" placeholder="开始时间"/>
        </div>
        <div class="form-group">
            <label for="endTime">结束时间：</label>
            <input type="text" name="endTime" class="form-control" id="endTime" placeholder="结束时间"/>
        </div>
        <div class="form-group">
            <label for="amountLimit">限制人数：</label>
            <input type="text" name="amountLimit" class="form-control" id="amountLimit" placeholder="限制人数"/>
        </div>
        <hr/>
        <div class="form-group" style="text-align: center;">
            <input class="btn btn btn-primary" type="submit" value="增加">
        </div>
    </form>

    <script>
        $.fn.datetimepicker.dates['zh'] = {
            days: ["星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"],
            daysShort: ["日", "一", "二", "三", "四", "五", "六", "日"],
            daysMin: ["日", "一", "二", "三", "四", "五", "六", "日"],
            months: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
            monthsShort: ["一", "二", "三", "四", "五", "六", "七", "八", "九", "十", "十一", "十二"],
            meridiem: ["上午", "下午"],
            //suffix:      ["st", "nd", "rd", "th"],
            today: "今天"
        };
        $("#beginTime,#endTime").datetimepicker({
            language: 'zh',  //用自己设置的时间文字
            //weekStart: 1,  //一周从那天开始，默认为0，从周日开始，可以设为1从周一开始
            // startDate:"2018-5-20", //开始时间，可以写字符串，也可以直接写日期格式new Date(),在这之前的日期不能选择
            //endDate:"2018-6-20",
            //daysOfWeekDisabled: [0,4,6],  //一周的周几不能选
            todayBtn: 1,  //是否显示今天按钮，0为不显示
            autoclose: 1, //选完时间后是否自动关闭
            todayHighlight: 1,  //高亮显示当天日期
            startView: 2, //0从小时视图开始，选分;1	从天视图开始，选小时;2从月视图开始，选天;3从年视图开始，选月;4从十年视图开始，选年
            minView: 0,//最精确时间，默认0；0从小时视图开始，选分；1从天视图开始，选小时；2从月视图开始，选天；3从年视图开始，选月；4从十年视图开始，选年
            //maxView:4,  //默认值：4, ‘decade’
            //keyboardNavigation:true,  //是否可以用键盘方向键选日期，默认true
            forceParse: 0, //强制解析,你输入的可能不正规，但是它胡强制尽量解析成你规定的格式（format）
            format: 'yyyy-mm-dd hh:ii',// 格式,注意ii才是分，mm或MM都是月
            minuteStep:5, //选择分钟时的跨度，默认为5分钟
            //pickerPosition:"top-right",  // ‘bottom-left’，’top-right’，’top-left’’bottom-right’
            showMeridian:0, //在日期和小时选择界面，出现上下午的选项,默认false
            // showSecond: false,
            // showMillisec: true,
            //timeFormat: 'hh:mm:ss:l',
            //bootcssVer: 3,
        });

    </script>
</div>
</body>
</html>
