
<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="GB2312"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>博客登录</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/static/css/login.css">
    <script src="<%=request.getContextPath()%>/static/js/jquery-1.12.0.min.js"></script>
</head>
<body>
<div class="header">
    <div class="logo"  >

    </div>
</div>
<div class="content">
    <form method="post" action=<%=request.getContextPath()%>+"/admin/doLogin">
        <div class="loginForm">
            <div class="buttonClass">
                <input type="text" name="username" required="required" id = "username" class="textContent" placeholder="YOUR USERNAME:">
            </div>
            <div class="buttonClass">
                <input type="password" name="password" required="required" id = "password" class="textContent"  placeholder="YOUR PASSWORD:">
            </div>
            <div class="buttonClass" id="test2">

                <input type="button" value="SUBMIT" class="textButton" id="textButton" />
            </div>

            <div class="text-other">
                <span class="forgetPass"><a href="#" >忘记密码 </a></span>
                <span class="freeRegister"><a href="#">免费注册</a></span>
            </div>
        </div>
    </form>
</div>
<div class="footer">
    <p>关于博客合作伙伴营销中心廉正举报联系客服开放平台诚征英才联系我们网站地图法律声明? 2017 Taobao.com 版权所有</p>
    <p>
        网络文化经营许可证：文网文[2010]040号|增值电信业务经营许可证：浙B2-20080224-1|信息网络传播视听节目许可证：1109364号
    </p>

</div>
<script>
    $(document).ready(function(){
        $("#textButton").click(function () {
            var url="<%=request.getContextPath()%>/admin/doLogin";
            var  username = $("#username").val();
            var password = $("#password").val();
            jQuery.ajax({
                type:"post",
                url:url,
                dataType:'json',
                data:{username:username ,password:password},
                success:function(json){
                    if(json.code ==200){
                        window.location.href = "<%=request.getContextPath()%>/admin/index";

                    }else{
                        $("#test2").html(" <div class=\"buttonClass\"> <span>用户名或密码错误！</span><input type=\"button\" value=\"SUBMIT\" class=\"textButton\" " +
                            "id=\"textButton\" /> </div>");
                    }
                }

            });

        });

    });

</script>
</body>
</html>