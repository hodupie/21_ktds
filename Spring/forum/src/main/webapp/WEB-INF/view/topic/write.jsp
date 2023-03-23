<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/forum/topic/write" method="post">
		<div>
			<label for="subject">제목</label>
			<input type="text" name="subject" id="subject" placeholder="제목입력" />
		</div>
		<div>
			<label for="email">이메일</label>
			<input type="email" name="email" id="email" placeholder="이메일" />
		</div>
		<div>
			<label for="content">내용</label>
			<textarea name="content" id="content" placeholder="내용"></textarea>
		</div>
		<div>
			<input type="submit" value="등록" />
		</div>
	</form>
</body>
</html>