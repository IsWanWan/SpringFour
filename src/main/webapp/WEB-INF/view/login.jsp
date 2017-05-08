<%@ page language="java" import="java.util.*"  pageEncoding="GB2312" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>���͵�¼</title>
    <link rel="stylesheet" type="text/css" href="/static/css/login.css">
    <script src="/static/js/jquery-1.12.0.min.js"></script>
</head>
<body>
<div class="header">
    <div class="logo"></div>
</div>
<div class="content">
    <form method="post" action="/admin/doLogin">
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
                <span class="forgetPass"><a href="#" >�������� </a></span>
                <span class="freeRegister"><a href="#">���ע��</a></span>
            </div>
        </div>
    </form>
</div>
<div class="footer">
    <p>���ڲ��ͺ������Ӫ�����������ٱ���ϵ�ͷ�����ƽ̨����Ӣ����ϵ������վ��ͼ��������? 2017 Taobao.com ��Ȩ����</p>
    <p>
        �����Ļ���Ӫ���֤��������[2010]040��|��ֵ����ҵ��Ӫ���֤����B2-20080224-1|��Ϣ���紫��������Ŀ���֤��1109364��
    </p>

</div>
<script>
    $(document).ready(function(){
        $("#textButton").click(function () {
            var url="/admin/doLogin";
            var  username = $("#username").val();
            var password = $("#password").val();
            jQuery.ajax({
                type:"post",
                url:url,
                dataType:'json',
                data:{username:username ,password:password},
                success:function(json){
                    if(json.code ==200){
                        window.location.href = "/admin/index";

                    }else{
                        $("#test2").html(" <div class=\"buttonClass\"> <span>�û������������</span><input type=\"button\" value=\"SUBMIT\" class=\"textButton\" " +
                            "id=\"textButton\" /> </div>");
                    }
                }

            });

        });

    });

</script>
</body>
</html>