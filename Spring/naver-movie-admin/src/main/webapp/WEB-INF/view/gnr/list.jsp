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
<title>장르 관리 페이지</title>
<jsp:include page="../include/stylescript.jsp" />
<script type="text/javascript">
	$().ready(function() {
		
		$(".grid > table > tbody > tr").click(function() {
			$("#isModify").val("true"); // 수정모드
			var data = $(this).data();
			$("#gnrId").val(data.gnrid);
			$("#gnrNm").val(data.gnrnm);
			$("#crtDt").val(data.crtdt);
			$("#crtr").val(data.crtr);
			$("#mdfyDt").val(data.mdfydt);
			$("#mdfyr").val(data.mdfyr);
			
			$("#useYn").prop("checked", data.useyn == "Y");
			
			console.log(data);
		});
		
		$("#new-btn").click(function() {
			$("#isModify").val("false"); // 등록모드
			
			$("#gnrId").val("");
			$("#gnrNm").val("");
			$("#crtDt").val("");
			$("#crtr").val("");
			$("#mdfyDt").val("");
			$("#mdfyr").val("");
			
			$("#useYn").prop("checked", false);
		});
		
		$("#save-btn").click(function() {
			
			if ($("#isModify").val() == "false") {
				// 신규등록
				$.post("${context}/api/gnr/create", {gnrNm: $("#gnrNm").val(), useYn: $("#useYn:checked").val()}, function(response) {
					if (response.status == "200 OK") {
						location.reload(); // 새로고침
					}
					else {
						alert(response.errorCode + "/" + response.message);
					}
				});
			}
			else {
				// 수정
				$.post("${context}/api/gnr/update", {gnrNm: $("#gnrNm").val(), useYn: $("#useYn:checked").val()}, function(response) {
					if (response.status == "200 OK") {
						location.reload(); // 새로고침
					}
					else {
						alert(response.errorCode + "/" + response.message);
					}
				});				
			}
		});
		
		$("#delete-btn").click(function() {
			var gnrId = $("#gnrId").val();
			if(gnrId == "") {
				alert("선택된 장르가 없습니다.");
				return
			}
			
			if(!confirm("정말 삭제하시겠습니까?")) {
				return;
			}
			
			$.get("${context}/api/gnr/delete/" + gnrId, function(response) {
				if (response.status == "200 OK") {
					location.reload(); // 새로고침
				}
				else {
					alert(response.errorCode + "/" + response.message);
				}
			});
		});
		
	});
	
</script>
</head>
<body>
	<div class="main-layout">
		<jsp:include page="../include/header.jsp" />
		<div>
			<jsp:include page="../include/sysMgmtSidemenu.jsp" />
			<jsp:include page="../include/content.jsp" />		
				<div class="path">영화 > 장르관리</div>
				<div class="grid">
					<div class="grid-count align-right">
						총 ${gnrList.size()}건
					</div>
					<table>
							<thead>
									<tr>
										<th><input type="checkbox" id="all_check" /></th>
										<th>순번</th>
										<th>장르ID</th>
										<th>장르명</th>
										<th>사용 여부</th>
										<th>등록일</th>
										<th>등록자</th>
										<th>수정일</th>
										<th>수정자</th>
									</tr>
							</thead>
							<tbody>
								<c:choose>
									<c:when test="${not empty gnrList}">
										<c:forEach items="${gnrList}"
													var="gnr"
													varStatus="index">
											<tr data-gnrid="${gnr.gnrId}"
												data-gnrnm="${gnr.gnrNm}"
												data-useyn="${gnr.useYn}"
												data-crtdt="${gnr.crtDt}"
												data-crtr="${gnr.crtr}"
												data-mdfydt="${gnr.mdfyDt}"
												data-mdfyr="${gnr.mdfyr}" >
												<td>
													<input type="checkbox" class="check-idx" value="${gnr.gnrId}" />
												</td>
												<td>${index.index}</td>
												<td>${gnr.gnrId}</td>
												<td>${gnr.gnrNm}</td>
												<td>${gnr.useYn}</td>
												<td>${gnr.crtDt}</td>
												<td>${gnr.crtr}</td>
												<td>${gnr.mdfyDt}</td>
												<td>${gnr.mdfyr}</td>
											</tr>
										</c:forEach>
									</c:when>
									<c:otherwise>
										<tr>
											<td colspan="9" class="no-items">
												등록된 장르가 없습니다.
											</td>
										</tr>
									</c:otherwise>
								</c:choose>
							</tbody>
					</table>
				</div>
				<div class="grid-detail">
					<form id="detail-form">
						<!-- 
						isModify == true ==> 수정(update)
						isModify == false ==> 등록(insert)
						-->
						<input type="hidden" id="isModify" value="false" />
						<div class="input-group inline"> 
							<label for="gnrId" style="width: 180px;">장르ID</label><input type="text" id="gnrId" name="gnrId" readonly value=""/>
						</div>
						<div class="input-group inline">
							<label for="gnrNm" style="width: 180px;">장르명</label><input type="text" id="gnrNm" name="gnrNm" value=""/>
						</div>
						<div class="input-group inline">
							<label for="useYn" style="width: 180px;">사용 여부</label><input type="checkbox" id="useYn" name="useYn" value="Y"/>
						</div>
						<div class="input-group inline">
							<label for="crtDt" style="width: 180px;">등록일</label><input type="text" id="crtDt" name="crtDt" value=""/>
						</div>
						<div class="input-group inline">
							<label for="crtr" style="width: 180px;">등록자</label><input type="text" id="crtr" name="crtr" value=""/>
						</div>
						<div class="input-group inline">
							<label for="mdfyDt" style="width: 180px;">수정일</label><input type="text" id="mdfyDt" name="mdfyDt" value=""/>
						</div>
						<div class="input-group inline">
							<label for="mdfyr" style="width: 180px;">수정자</label><input type="text" id="mdfyr" name="mdfyr" value=""/>
						</div>
					</form>
				</div>
				<div class="align-right">
					<button id="new-btn" class="btn-primary">신규</button>
					<button id="save-btn" class="btn-primary">저장</button>
					<button id="delete-btn" class="btn-delete">삭제</button>
				</div>
			<jsp:include page="../include/footer.jsp" />			
		</div>
	</div>
</body>
</html>