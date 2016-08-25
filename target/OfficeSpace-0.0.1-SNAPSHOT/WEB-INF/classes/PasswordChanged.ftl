<!DOCTYPE html>
<html id="htmlTag">

<head>
    <meta charset="UTF-8">
    <title>Sign-Up/Login Form</title>
    <link href='http://fonts.googleapis.com/css?family=Titillium+Web:400,300,600' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="/OfficeSpace/files/login/css/normalize.css">
    <link rel="stylesheet" href="/OfficeSpace/files/login/css/style.css">
</head>

<body>
<div id="body">


	<div  class="form" style="margin-top:100px;">
			  <ul id="loginPage" class="tab-group" style="margin-left:170px !important;">
			    <li class="tab" ><a href="#login">Log In</a></li>
			  </ul>
	<style>
		h1 h2 h5{
			text-aline:center;		
		}
	</style>
	
	<h1>Password Change Successfully</h1>
	<h1>Login to OfficeSpace</h1>

    
 </div>
 <script src="https://apis.google.com/js/platform.js" async defer></script>
 <script type="text/javascript" src="/OfficeSpace/javaScript/login.js"></script>
 
 </body>
 
 

<script type="text/javascript" src="/OfficeSpace/javaScript/jquery-3.0.0.min.js"></script>
<script type="text/javascript" src="/OfficeSpace/files/login/js/forgotPassword.js"></script>
	<script>
		$(document.body).on("click","#loginPage",function(){
			window.location.href = "/OfficeSpace/html/login.html";
		});
	</script>
</html>
