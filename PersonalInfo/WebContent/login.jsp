<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>登陆界面</title> 
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="js/jquery-1.9.0.min.js"></script>
<script type="text/javascript" src="js/login.js"></script>
<link href="css/login.css" rel="stylesheet" type="text/css" />
<link rel="icon" href="favicon.ico"  type="image/x-icon">
<script type="text/javascript">  
    function refresh() {  
        //IE存在缓存,需要new Date()实现更换路径的作用  
        document.getElementById("image").src="Securityimage.jsp?"+new Date();  
    }  
</script>  
</head>
<body>
<h1>个人信息管理系统<sup></sup></h1>

<div class="login" style="margin-top:50px;">
    
    <div class="header">
        <div class="switch" id="switch"><a class="switch_btn_focus" id="switch_qlogin" href="javascript:void(0);" tabindex="7">登录界面</a>
			<a class="switch_btn" id="switch_login" href="javascript:void(0);" tabindex="8">注册界面</a><div class="switch_bottom" id="switch_bottom" style="position: absolute; width: 64px; left: 0px;"></div>
        </div>
    </div>    
  
    
    <div class="web_qr_login" id="web_qr_login" style="display: block; height: 245px;">    

            <!--登录-->
            <div class="web_login" id="web_login">
               
               
               <div class="login-box">
    
            
			<div class="login_form">
				<form action="validate.jsp" accept-charset="utf-8" method="post">
                <div class="uinArea" id="uinArea">
                <label class="input-tips" for="u">帐号：</label>
                <div class="inputOuter" id="uArea">  

                    <input type="text" name="username" class="inputstyle" />
                </div>
                </div>
                <div class="pwdArea" id="pwdArea">
               <label class="input-tips" for="p">密码：</label> 
               <div class="inputOuter" id="pArea">
                    
                    <input type="password" name="password" class="inputstyle" />
                </div>           
                </div>
               
                <div style="padding-left:70px;margin-top:20px;">
                <input type="submit" value="登 录" style="width:150px;" class="button_blue"/>
                </div>
              </form>
           </div>
           
            	</div>
               
            </div>
            <!--登录end-->
  </div>

  <!--注册-->
    <div class="qlogin" id="qlogin" style="display: none; ">
   
    <div class="web_login">
    <form name="form2" id="regUser" accept-charset="utf-8"  action="/PersonalInfo/user" method="post">
        <ul class="reg_form" id="reg-ul">
        		<div id="userCue" class="cue">快速注册请注意格式</div>
                <li>
                	
                    <label for="user"  class="input-tips2">用户名：</label>
                    <div class="inputOuter2">
                        <input type="text" id="user" name="username" maxlength="16" class="inputstyle2"/>
                    </div>
                    
                </li>
                
                <li>
                <label for="passwd" class="input-tips2">密码：<input  type="hidden" id="action" name="action" value="add" ></label>
                    <div class="inputOuter2">
                        <input type="password" id="passwd"  name="password" maxlength="16" class="inputstyle2"/>
                    </div>
                    
                </li>
                <li>
                <label for="passwd2" class="input-tips2">确认密码：</label>
                    <div class="inputOuter2">
                        <input type="password" id="passwd2" name="" maxlength="16" class="inputstyle2" />
                    </div>
                    
                </li>
                
                <li>
                 <label for="email" class="input-tips2">Email：</label>
                    <div class="inputOuter2">
                       
                        <input type="text" id="email" name="email"  class="inputstyle2"/>
                    </div>
                   
                </li>


                <li>
                 <label for="email" class="input-tips2">验证码：</label>
                    <div class="inputOuter3">
                       
                    <input type="text" name="code" maxlength="4" class="inputstyle3"/>
                    <img id="image" border="0"  onclick="refresh()" src="Securityimage.jsp" title="点击更换图片">
                    </div>
                   
                </li>
                
                <li>
                    <div class="inputArea">
                        <input type="button" id="reg"  style="margin-top:10px;margin-left:105px;" class="button_blue" value="确认并注册"/></a>
                    </div>
                    
                </li><div class="cl"></div>
            </ul></form>
           
    
    </div>
   
    
    </div>
    <!--注册end-->
</div>
<div class="jianyi"><p>&copy;2016 All Rights Reserved &nbsp;&&nbsp; Design by <a href="https://github.com/Lrtwjhs">Lrtwjhs</a>.</p></div>
</body></html>