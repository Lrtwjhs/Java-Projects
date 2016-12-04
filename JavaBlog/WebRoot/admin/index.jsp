<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="favicon.ico" mce_href="favicon.ico" type="image/x-icon"> 
    <title>Login</title>
    <!-- Bootstrap core CSS -->
    <link href="style/bootstrap.min.css" rel="stylesheet">
    <!-- Custom styles for this template -->
    <link href="style/signin.css" rel="stylesheet">
    <link href="../css/bootstrap.css" rel="stylesheet" type="text/css"/>
<link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="../css/bootstrap-theme.css" rel="stylesheet" type="text/css"/>
<link href="../css/bootstrap-theme.min.css" rel="stylesheet" type="text/css"/>
<link href="../css/theme.css" rel="stylesheet" type="text/css"/>
<link href="../css/theme-light.css" rel="stylesheet" type="text/css"/>

<script src="../js/bootstrap.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/jquery.min.js"></script>
<script src="../js/jquery.tagcloud.js"></script>
<script src="../js/npm.js"></script>

<link rel="icon" href="favicon.ico" type="image/x-icon"> 
    <!-- Just for debugging purposes. Don't actually copy this line! -->
    <!--[if lt IE 9]><script src="assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

  </head>
  <body>
    <div class="abc"></div>
     <%@include file="nav.jsp"%>

    <div class="container">
	       <h2 class="form-signin-heading">Admin Signin</h2>
         <p></p>
         <p></p>
         <p></p>
         <p></p>
     
        <div class="cow">
        <div class="col-md-4 col-md-offset-4 login-container">
        <div class="login-panel">
        <form class="signin-form" method="poster" action="validate.jsp">       
        <input name="userid" type="text"  class="form-control" placeholder="Username" >
        <input name="passwd" type="password" class="form-control" placeholder="Password" >
        <button class="button btn btn-primary btn-block" type="submit">Login</button>
         </form>
         </div>
         </div>
         </div>
 </div> 
       
   

<%@include file="../bottom.jsp" %>  

  </body>
</html>

