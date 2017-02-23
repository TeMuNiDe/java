<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
<script type="text/javascript" src="jquery-1.11.3.min.js">
document.ready(function(){
$("#logn").submit(function(){
	$.get("validate",{id:$("#id").val(),pass:$("#pass").val()},function(data,status){
		alert(data+"\n::::____\n"+status);
	});
});	
});
</script>
</head>
<body>
<h1>enter your credentials</h1>
<br><br><br>
<form method="get" id="logn" action="javascript:void(0)">
<input type="text" name="id" id="id"/><br><br>
<input type="password" name="pass" id="pass"/><br><br>
<input type="submit"/></form>
</body>
</html>