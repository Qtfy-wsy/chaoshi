<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="frame/layui/css/layui.css">
<link rel="stylesheet" href="frame/static/css/style.css">
<title>超市营销管理系统</title>
</head>
<body class="login-body body">
<style>
    body{
        background-size: 100%;
        background-image: url("${pageContext.request.contextPath}/static/background1.png");
        background-repeat:no-repeat;
    }
</style>

<div class="login-box">
    <form class="layui-form layui-form-pane" method="post" action="login">
        <div class="layui-form-item">
            <h3>超市营销管理系统</h3>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">账号：</label>

            <div class="layui-input-inline">
                <input type="text" name="userName" class="layui-input" lay-verify="account" placeholder="账号"
                       autocomplete="on" maxlength="20"/>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">密码：</label>

            <div class="layui-input-inline">
                <input type="password" name="password" class="layui-input" lay-verify="password" placeholder="密码"
                       maxlength="20"/>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">用户组：</label>

            <div class="layui-input-inline">
                <select name="loginType">
					<option value="admin">管理员</option>
					<option value="user">员工</option>
				</select>
            </div>
        </div>
        <div class="layui-form-item">
            <button style="width:100%" type="submit" class="layui-btn btn-submit" lay-submit="" lay-filter="sub">立即登录</button>
        </div>
        <div style="padding:10px;"><font color="red">${error }</font></div>
    </form>
</div>

<script type="text/javascript" src="frame/layui/layui.js"></script>
<script type="text/javascript">
    layui.use(['form', 'layer'], function () {

        // 操作对象
        var form = layui.form
                , layer = layui.layer
                , $ = layui.jquery;

        // 验证
        form.verify({
            account: function (value) {
                if (value == "") {
                    return "请输入用户名";
                }
            },
            password: function (value) {
                if (value == "") {
                    return "请输入密码";
                }
            }
        });
    })

</script>
</body>
</html>