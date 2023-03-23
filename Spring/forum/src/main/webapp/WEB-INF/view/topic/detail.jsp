<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h1>${topic.subject}</h1>
	<div>
		${topic.memberVO.name} (${topic.memberVO.email})
	</div>
	<div>
		작성일: ${topic.crtDt}
		/ 수정일: ${topic.mdfyDt}
	</div>
	<div>
		첨부파일: ${topic.originFileName}
	</div>
	<div>
		${topic.content}
	</div>
	<hr/>
	<form action="/forum/topic/reply/create" method="post">
		<input type="text" name="topicId" value="${topic.id}" />
		<input type="text" name="prntReplyId" value="0"/>
		
		<div>
			<label for="email">작성자 이메일</label>
			<input type="email" name="email" id="email" />
		</div>
		<div>
			<label for="reply">댓글 내용</label>
			<textarea type="text" name="reply" id="reply"></textarea>		
		</div>
		<div>
			<input type="submit" value="댓글등록" />
		</div>
	</form>
	
	<hr/>
	<ul>
		<c:forEach items="${topic.replyList}" var="reply">
			<li style="margin-left: ${reply.depth * 30}px;">${reply.reply} | ${reply.memberVO.name} | ${reply.crtDt}</li>
		</c:forEach>
	</ul>
	<hr/>
	<a href="/forum/topics">목록</a>
	<a href="/forum/topic/update/${topic.id}">수정</a>
	<a href="/forum/topic/delete/${topic.id}">삭제</a>
	
</body>
</html>