<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.Random"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<c:set var="date" value="<%=new Random().nextInt()%>" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 로그인</title>
<jsp:include page="../include/stylescript.jsp" />
<script type="text/javascript">
	$().ready(function() {
		$("#login-btn").click(function() {
			var data = {
					mbrId: $("#mbrId").val(),
					pwd: $("#pwd").val()
			};
			$.post("${context}/api/mbr/lgn", data, function(response) {
				// Response Spec
			/* 	{
					status: "200 OK",
					message: "",
					errorCode: "",
					redirectURL: ""
				} */
				if (response.status == "200 OK") {
					location.href = "${context}" + response.redirectURL;
				} 
				else if (response.status == "400") {
					// 파라미터를 전달하지 않은 경우
					alert(response.message);
				} 
				else {
					alert(response.errorCode + "/" + response.message);
					if (response.redirectURL) {
						location.href = "${context}" + response.redirectURL;
					}
				}
			});
		})
	});
</script>
</head>
<body>
	<div class="fullscreen item-align-center bg-gray">
		<div class="login-title inline align-left">
			<h1>LOGIN</h1>
		</div>
		<div class="login-input inline">
			<div>
				<input type="text" id="mbrId" name="mbrId" placeholder="아이디">
			</div>
			<div>
				<input type="password" id="pwd" name="pwd" placeholder="비밀번호">
			</div>
				<button class="login-btn" id="login-btn">로그인</button>
		</div>
	</div>
</body>
</html>