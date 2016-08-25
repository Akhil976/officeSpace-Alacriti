//Home Button
$(document.body).on("click","#homeButton",function(){
	window.location.href = "/OfficeSpace/html/index.html";
});

function onSignIn(googleUser) {
	  $(document.body).on("click",".g-signin2",function(){
		  var id_token = googleUser.getAuthResponse().id_token;
		  var profile = googleUser.getBasicProfile();
		  console.log('ID: ' + profile.getId()); // Do not send to your backend! Use an ID token instead.
	/*	  console.log('Name: ' + profile.getName());
		  console.log('Image URL: ' + profile.getImageUrl());*/
		  console.log('Email: ' + profile.getEmail());
		  
		  console.log(id_token);
		  
		  var jsonObject =  {
				  "id_token" : id_token,
			  };
			 $.ajax({
				type : 'POST',
				contentType : 'application/json',
				data : JSON.stringify(jsonObject),
				url : '/OfficeSpace/web/login/google',
				success : function(response){
					document.write(response);
				}
		 });
		  
		  
	  });

	}

function signOut() {
  var auth2 = gapi.auth2.getAuthInstance();
  auth2.signOut().then(function () {
    console.log('User signed out.');
  });
}

//User Registration
$("#getStarted").click(function(){
	event.preventDefault();
	if(validateForm()){
		$("#form").submit();
	}
});

function validateForm(){
		var first_name = $("#first_name").val();
		var last_name = $("#last_name").val();
		var email_id = $("#email_id").val();
		var contact_number = $("#contact_number").val();
		var pass_word = $("#pass_word").val();
		var confirm_pass_word = $("#confirm_pass_word").val();
		var user_role = $("#user_role").val();
		var flag=1;
		//First Name validation
		if( (first_name == "" || first_name == null)){
			$("#first_name").css("box-shadow","0px 0px 10px red");
			flag=0;
		}
		else if(/\d/.test(first_name)){
			$("#first_name").css("box-shadow","0px 0px 10px red");
			flag=0;
		}
		else{
		}
		//Last Name validation
		if(last_name == "" || last_name == null){
			$("#last_name").css("box-shadow","0px 0px 10px red");
			flag=0;
		}
		else if(/\d/.test(last_name)){
			$("#last_name").css("box-shadow","0px 0px 10px red");
			flag=0;
		}
		else{

		}
		//email validation
		if(email_id == "" || email_id == null){
			$("#email_id").css("box-shadow","0px 0px 10px red");
			flag=0;
		}
		else{

		}	
/*		//contact Number validation
		if(contact_number == "" || contact_number == null){
			$("#contact_number").css("box-shadow","0px 0px 10px red");
			console.log("a");
			flag=0;
		}
		else if(contact_number.length<6 && contact_number.length<15){
			$("#contact_number").css("box-shadow","0px 0px 10px red");
			console.log("b");
			flag=0;
		}
		else if(contact_number.contains("[a-zA-Z]+") == true){
			$("#contact_number").css("box-shadow","0px 0px 10px red");
			console.log("c");
			flag=0;
		}
		else{

		}  */
		//Password validation
		if(confirm_pass_word == "" || confirm_pass_word == null){
			$("#confirm_pass_word").css("box-shadow","0px 0px 10px red");
			flag=0;
		}
		if(pass_word == "" || pass_word == null){
			$("#pass_word").css("box-shadow","0px 0px 10px red");
			flag=0;
		}
		else if(confirm_pass_word == "" || confirm_pass_word == null){
			$("#confirm_pass_word").css("box-shadow","0px 0px 10px red");
			flag=0;
		}
		else if(pass_word!=confirm_pass_word){
			$("#pass_word").css("box-shadow","0px 0px 10px red");
			$("#confirm_pass_word").css("box-shadow","0px 0px 10px red");
			flag=0;
		}
		else{
		}

		if(flag==1){
		/* var userInfo = {
					"first_name" : first_name,
					"last_name" : last_name,
					"email_id" : email_id,
					"contact_number" : contact_number,
					"pass_word" : pass_word,
					"user_role" : user_role
			};
			$.ajax({
				type : 'POST',••
				contentType : 'application/json',
				url : '/OfficeSpace/web/getStarted',
				data : JSON.stringify(userInfo),
				success : function(){
					alert("Successfully uploaded.");
				}
			});*/
			return true;
		}
		else{
			return false;
		}		
}



//Sign in
$(document.body).on("click","#loginButton",function(){
	event.preventDefault();
	$("#loginForm").submit();
});

//ForgotPassword
/*$(document.body).on("click","#fpEmailButton",function(){
	alert("clicked");
	event.preventDefault();
	 $.ajax({
			type : 'POST',
			contentType : 'application/json',
			url : 'http://localhost:8080/OfficeSpace/web/forgotPassword/email',
			success : function(response){
				alert(response);
			}
	 });
});

$(document.body).on("click","#reset",function(){
	event.preventDefault();
//	if(validatePassword()==1)
	//{
		 $.ajax({
				type : 'POST',
				contentType : 'application/json',
				url : 'http://localhost:8080/OfficeSpace/web/forgotPassword/changePassword',
				success : function(response){
					alert(response);
				}
		 });
//	}
});
*/
function validatePassword(){
	var flag=1;
	//Password validation
	var pass_word = $("#newPasswordConfirm").val();
	var confirm_pass_word = $("#newPasswordConfirm").val();
	if(confirm_pass_word == "" || confirm_pass_word == null){
		$("#newPasswordConfirm").css("box-shadow","0px 0px 10px red");
		flag=0;
	}
	if(pass_word == "" || pass_word == null){
		$("#newPassword").css("box-shadow","0px 0px 10px red");
		flag=0;
	}
	else if(confirm_pass_word == "" || confirm_pass_word == null){
		$("#newPasswordConfirm").css("box-shadow","0px 0px 10px red");
		flag=0;
	}
	else if(pass_word!=confirm_pass_word){
		$("#newPassword").css("box-shadow","0px 0px 10px red");
		$("#newPasswordConfirm").css("box-shadow","0px 0px 10px red");
		flag=0;
	}
	else{
	}
	return flag;
}
