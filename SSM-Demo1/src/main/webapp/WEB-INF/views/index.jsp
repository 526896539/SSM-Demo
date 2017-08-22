<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge"> 
<meta name="viewport" content="width=device-width, initial-scale=1"> 
<title>login</title>
<link rel="stylesheet" type="text/css" href="../static/css/normalize.css" />
<link rel="stylesheet" type="text/css" href="../static/css/demo.css" />
<!--必要样式-->
<link rel="stylesheet" type="text/css" href="../static/css/component.css" />
<!--[if IE]>
<script src="js/html5.js"></script>
<![endif]-->
</head>
<body>
        <div class="container demo-1">
            <div class="content">
                <div id="large-header" class="large-header">
                    <canvas id="demo-canvas"></canvas>
                    <div class="logo_box">
                        <h3>欢迎你</h3>
                        <form action="${pageContext.request.contextPath }/mvc/login.action" name="f" method="post">
                            <div class="input_outer">
                                <span class="u_user"></span>
                                <input name="user_name" class="text" style="color: #FFFFFF !important" type="text" placeholder="请输入账户">
                            </div>
                            <div class="input_outer">
                                <span class="us_uer"></span>
                                <input name="password" class="text" style="color: #FFFFFF !important; position:absolute; z-index:100;"value="" type="password" placeholder="请输入密码">
                            </div>
                            <div class="mb2"><input style="color: #FFFFFF;width:327px;" type="submit" value="登录" class="act-but submit"></div>
                        </form>
                    </div>
                </div>
            </div>
        </div><!-- /container -->
        <script src="../static/js/TweenLite.min.js"></script>
        <script src="../static/js/EasePack.min.js"></script>
        <script src="../static/js/rAF.js"></script>
        <script src="../static/js/demo-1.js"></script>
    </body>
</html>