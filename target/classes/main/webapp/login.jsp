<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!doctype html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>登录界面</title>
    <!-- Bootstrap -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="css/style.css">
    <script src="css.page.js"></script>
</head>
<body>
<div class="container">
    <div class="form row" style="height: 300px;">
        <form action="<%= request.getContextPath()%>/account?method=login" method="POST" class="form-horizontal col-md-offset-4" id="login_form">
            <h3 class="form-title">用户登录</h3>
            <div class="col-md-8">
                <div class="form-group">
                    <i class="fa fa-user fa-lg"></i>
                    <span style="color: red;font-size: 13px; margin-left: -1px;">${usernameError}</span>
                    <input class="form-control required" required placeholder="请输入用户名" type="text" name="username"/>
                </div>
                <div class="form-group">
                    <i class="fa fa-user fa-lg"></i>
                    <span style="color: red;font-size: 13px; margin-left: -1px;">${passwordError}</span>
                    <input class="form-control required" required placeholder="请输入密码" type="password" name="password"/>
                </div>
                <div class="form-group">
                    <label class="radio-inline">
                        <input type="radio" name="type" checked value="systemAdmin" class="radio-inline">系统管理员
                    </label>
                    <label class="radio-inline">
                        <input type="radio" name="type" checked value="dormiAdmin" class="radio-inline">宿舍管理员
                    </label>
                </div>
                <div class="form-group col-md-offset-9">
                    <button type="submit" class="btn btn-success pull-left" name="submit">登录</button>
                    <button type="reset" class="btn btn-success pull-right" name="submit">重置</button>
                </div>
            </div>
        </form>
    </div>

</div>
</body>
</html>