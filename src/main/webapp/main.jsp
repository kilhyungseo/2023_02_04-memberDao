<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
</head>
<body>
	<h2>메인페이지입니다.</h2>
	<hr>
		<% 
		
			String sessionId = (String)session.getAttribute("memberId");
					System.out.print(sessionId);
				if(sessionId == null){
					sessionId = "guest";
													}
		%>
	<form action="logout.do">
		<%= sessionId %>님 로그인 중입니다. 감사합니다.
		<input type="submit" value="로그아웃">
		<input type="button" value="정보수정" onclick="javascript:window.location='modifyInfo.do'">
		<input type="button" value="회원탈퇴" onclick="javascript:window.location='delOk.do'">
	</form>
			
		로그인 하시면 정보를 더 제공받을수 있습니다.<br>
		<a href="login.do">로그인 페이지로 이동</a>
		
</body>
</html>