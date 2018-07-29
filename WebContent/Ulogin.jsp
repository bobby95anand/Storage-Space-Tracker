<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="border:solid;border-color:black;height:220px;" bgcolor="silver " >
<form action="Ulogin">
<table style ="border: double;border-color:black;background: teal ;margin-left:300px;margin-top:10px; float:left;  height:200px; width:500px">
<tr><th><font style="font-family:Lucida Handwriting ;align:center;font-size: 24;color:black;text-decoration: underline; ">USERS LOGIN</font></th></tr>
<tr><td><font style="font-family: algerian;color:white ;"> ENTER USERNAME </font></td><td><input type="text" name="uname"></td></tr>
<tr><td><font style="font-family: algerian;color:white ;"> ENTER PASSWORD </font></td><td><input type="password" name="upass"></td></tr>
<tr><th colspan="8"><input type="submit" value="Login"></th></tr>
<tr><th>FORGOT YOUR PASSWORD ? <a href=Find.jsp>Click Here</a></th></tr>
</table>
</form>
<p>
<h4>NOT A REGISTERD USER ?</h4>
<a href=Regis.jsp>CLICK HERE</a>
</body>
</html>