<!DOCTYPE html>
<html id="htmlTag">

<head>
    <meta charset="UTF-8">
    <title>Sign-Up/Login Form</title>
    <link href='http://fonts.googleapis.com/css?family=Titillium+Web:400,300,600' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="/OfficeSpace/files/login/css/normalize.css">
    <link rel="stylesheet" href="/OfficeSpace/files/login/css/style.css">
    <link rel="stylesheet" href="/OfficeSpace/css/login.css">
    <meta name="google-signin-client_id" content="360785064192-idqsajfiss7kivd2gi0uscqm3jrrntr0.apps.googleusercontent.com">
</head>

<body>
<div id="body">


	<div  class="form" style="margin-top:100px;">
			  <ul id="loginPage" class="tab-group" style="margin-left:170px !important;">
			    <li class="tab" ><a href="#login">Log In</a></li>
			  </ul>
	<style>
		p{
			color:gray;
			margin-left:50px;
		}
	</style>
	
	<h1>Alacriti employees only can signin directly with Google Mail.</h1>
	<p>Suggestion: Use Alacriti mail id or register with OfficeSpace</p>
	<div id="header">
		<h1 id="title"> OfficeSpace </h1>
			<div id="homeButton" class="buttonDiv"> <p class="buttonText">Home<p></div>
		<div id="statusBar">
			<p id="headerItem"></p>
		</div>
	</div>   
    
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
