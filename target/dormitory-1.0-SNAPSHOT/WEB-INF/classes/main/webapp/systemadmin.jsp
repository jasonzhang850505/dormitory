<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <!-- 引入 Bootstrap -->
    <script src="https://cdn.bootcss.com/jquery/2.2.4/jquery.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- 引入 font-awesome -->

    <link href="https://cdn.bootcss.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="application/javascript">
        <%--  change方法动态修改路径      --%>
        function change(url, index) {
            $(".list-group-item").removeClass("active");
            $(".list-group-item").eq(index).addClass("active");
            $("iframe").attr("src", url);
        }
    </script>
    <style>
        nav.navba-inverse {
            /*background-color: rgba(0, 0, 0,0.5);*/
            background-color: black;
        }
    </style>
    <script src="js/page.js"></script>
    <link href="css/page.css" rel="stylesheet">
</head>
<body>
<body>
<nav class="navbar navba-inverse" role="navigation">
    <div class="container-fluid">
        <ul class="nav navbar-nav navbar-left">
            <li>
                <a style="color: azure;font-size: 26px;">DORMS宿舍管理系统-系统管理员</a>
            </li>
        </ul>
        <span style="color: #000000; font-size 26px; position: relative; top: 5px;"></span>
        <ul class="nav navbar-nav navbar-right">
            <li>
                <a style="color: azure">欢迎你, ${systemAdmin.name}</a>
            </li>
            <li>
                <a href="/login.jsp">安全退出</a>
            </li>
        </ul>
    </div>
</nav>
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-2">

            <a href="javascript:void(0)" class="list-group-item active" onclick="change('/dormitoryAdmin?method=list',0)">
						<span class="" aria-hidden="true">
							<i class="fa fa-user-circle-o fa-fw"></i>
						</span>宿管管理
            </a>
            <a href="javascript:void(0)" class="list-group-item" onclick="change('/student?method=list',1)">
						<span class="" aria-hidden="true">
							<i class="fa fa-user-circle fa-fw"></i>
						</span>学生管理
            </a>
            <a href="javascript:void(0)" class="list-group-item" onclick="change('building/list',2)">
						<span class="" aria-hidden="true">
							<i class="fa fa-home fa-fw"></i>
						</span>楼宇管理
            </a>
            <a href="javascript:void(0)" class="list-group-item" onclick="change('dormitory/list',3)">
						<span class="" aria-hidden="true">
							<i class="fa fa-bed fa-fw"></i>
						</span>宿舍管理
            </a>
            <a href="javascript:void(0)" class="list-group-item" onclick="change('moveout/list',4)">
						<span class="" aria-hidden="true">
							<i class="fa fa-address-card-o fa-fw"></i>
						</span>学生迁出登记
            </a>
            <a href="javascript:void(0)" class="list-group-item" onclick="change('moveout/record',5)">
						<span class="" aria-hidden="true">
							<i class="fa fa-bookmark fa-fw"></i>
						</span>学生迁出记录
            </a>
            <a href="javascript:void(0)" class="list-group-item" onclick="change('absent/list',6)">
						<span class="" aria-hidden="true">
							<i class="fa fa-bookmark-o fa-fw"></i>
						</span>学生缺寝记录
            </a>

        </div>
        <!--右边内容-->
        <%--        <iframe style="width: 81%; height: 1200px; border: 0px;" src="/dormitoryAdmin/list"></iframe>--%>
        <iframe style="width: 81%; height: 1200px; border: 0px;" src="/dormitoryAdmin?method=list"></iframe>
    </div>
</div>



<div class="footer">
    <p class="text-center">
        2022 © DORMS
    </p>
</div>
</body>
</html>
