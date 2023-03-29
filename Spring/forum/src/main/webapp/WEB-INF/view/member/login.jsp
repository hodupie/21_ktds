<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.4.min.js"></script>
<script type="text/javascript">
	$().ready(function() {
		
		$("#login_btn").click(function(event) {
			event.preventDefault();
				
			var emailValue = $("#email").val();
			var passwordValue = $("#password").val();
			
/* 			if (emailValue == "") {
				alert("이메일을 입력하세요!");	
				return;
			}
			
			if (passwordValue == "") {
				alert("비밀번호를 입력하세요!");
				return;
			} */
			
			// Ajax 요청
			$.post("${pageContext.request.contextPath}/api/member/login",
				{email: emailValue, password: passwordValue},
				function(response) {
					console.log(response);
					if(response.loginResult) {
						// 로그인 성공하면 페이지 이동
						location.href = "${pageContext.request.contextPath}/topics";
					}
					else if (response.errorCode == "NOT_FOUND_USER") {
						alert("아이디 또는 비밀번호가 일치하지 않습니다.");
					}
					else if (response.status == "fail") {
						alert(response.message);
					}
				});
		});
		/* <c:if test="${errorCode eq 'NOT_FOUND_USER'}">
			alert("아이디 또는 비밀번호가 일치하지 않습니다.");
		</c:if>
		
		$("#login_btn").click(function(event) {
			event.preventDefault();
			
			var emailValue = $("#email").val();
			var passwordValue = $("#password").val();
			
			if (emailValue == "") {
				alert("이메일을 입력하세요!");
				return;
			}
			
			if (passwordValue == "") {
				alert("비밀번호를 입력하세요!");
				return;
			}
			
			$("#login_form").attr({
				"action": "${pageContext.request.contextPath}/member/login",
				"method": "post"
			}).submit();
		}) */
	});
</script>
</head>
<body>
	<h1>Login</h1>
	
	<form id="login_form">
		<div>
			<label for="email">로그인 이메일</label>
			<input type="email" id="email" name="email" />
		</div>
		<div>
			<label for="password">로그인 비밀번호</label>
			<input type="password" id="password" name="password" />
		</div>
		<div>
			<button id="login_btn">로그인</button>
		</div>
	</form>
</body>
</html>