<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.6.4.min.js"></script>
<script type="text/javascript">
	$().ready(function(){
	});
</script>
</head>
<body>

	<img src="${pageContext.request.contextPath}/img/Instagram-Icon.png" style="width:100px"/>
	
	<h1>${topic.subject}</h1>
	<div>
		${topic.memberVO.name} (${topic.memberVO.email})
	</div>
	<div>
		작성일: ${topic.crtDt}
		/ 수정일: ${topic.mdfyDt}
	</div>
	<div>
		첨부파일: 
		<c:forEach items="${topic.attachFileList}" var="file">
			<a href="${pageContext.request.contextPath}/file/download/${file.topicId}/${file.fileId}">${file.originFileName}</a>
		</c:forEach>
	</div>
	<div>
		${topic.content}
	</div>
	<hr/>
	<form action="${pageContext.request.contextPath}/topic/reply/create" method="post">
		<input type="hidden" name="topicId" value="${topic.id}"/>
		<input type="text" name="prntReplyId" value="0"/>
		<div>
			<label for="reply">댓글 내용</label>
			<textarea name="reply" id="reply"></textarea>		
		</div>
		<div>
			<input type="submit" value="댓글등록" />
		</div>
	</form>
	
	<hr/>
	
	<ul>
		<c:choose>
			<c:when test="${empty topic.replyList.get(0).reply}">
				첫 번째 댓글을 작성해보세요!
			</c:when>
			<c:otherwise>
		<c:forEach items="${topic.replyList}" var="reply">
			<li style="margin-left: ${reply.depth * 30}px;">${reply.replyId} | ${reply.reply} | ${reply.memberVO.name} | ${reply.crtDt}</li>
		</c:forEach>			
			</c:otherwise>
		</c:choose>	
	</ul>
	<hr/>
	<a href="${pageContext.request.contextPath}/topics">목록</a>
	<a href="${pageContext.request.contextPath}/topic/update/${topic.id}">수정</a>
	<a href="${pageContext.request.contextPath}/topic/delete/${topic.id}">삭제</a>
	
</body>
</html>