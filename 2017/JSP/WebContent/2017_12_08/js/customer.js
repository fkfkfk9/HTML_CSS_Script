$(document).ready(function(){
	$('#logout').click(function(){
		$("#contents").load("Jsp/logOut.jsp");
	});
	
	$('#customer').click(function(){
		$("#contents").load("FormJsp/updateForm.jsp");
	});
});//end 익명함수----------------------------------------------------------------->