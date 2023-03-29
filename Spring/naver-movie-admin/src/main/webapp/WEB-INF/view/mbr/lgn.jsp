<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 로그인</title>
<link rel="stylesheet" href="${context}/css/common.css" />
<script type="text/javascript" src="${context}/js/jquery-3.6.4.min.js"></script>
<script type="text/javascript">
	$().ready(function() {
		$("#login_btn").click(function() {
			var data = {
					mbrId: $("#mbrId").val();
					pwd: $("#pwd").val();
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
		<div class="login_group">
			<h1>KT DS Movie System</h1>
			<div>
				<label for="mbrId">아이디</label>
				<input type="text" id="mbrId" name="mbrId" placeholder="아이디">
			</div>
			<div>
				<label for="pwd">비밀번호</label>
				<input type="password" id="pwd" name="pwd" placeholder="비밀번호">
			</div>
			<div class="align-right">
				<button class="btn_primary" id="login_btn">로그인</button>
			</div>
		</div>
	</div>
</body>
</html>