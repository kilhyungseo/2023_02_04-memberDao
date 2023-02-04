<%@page import="com.hyungseo.exe.MemberDto"%>
<%@page import="com.hyungseo.exe.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정완료화면</title>
</head>
<body>
	
			<h2>수정된 회원정보</h2>
			<hr>
			아이디 : ${memberDto.id }<br>
			비밀번호 : ${memberDto.password }<br>
			이름 : ${memberDto.name }<br>
			이메일 : ${memberDto.email }<br>
			가입일 : ${memberDto.jointime }<br>

		<br><br>	
		
		<a href="login.do">로그인화면으로가기</a>
</body>
</html>