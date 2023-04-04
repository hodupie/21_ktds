<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.Random"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<c:set var="date" value="<%=new Random().nextInt()%>" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화인 관리 페이지</title>
<jsp:include page="../include/stylescript.jsp" />
<script type="text/javascript">
	$().ready(function() {
		
		$(".grid > table > tbody > tr").click(function() {
			$("#isModify").val("true"); // 수정모드
			var data = $(this).data();
			$("#mvPplId").val(data.mvpplid);
			$("#nm").val(data.nm);
			$("#rlNm").val(data.rlnm);
			$("#crtDt").val(data.crtdt);
			$("#crtr").val(data.crtr);
			$("#mdfyDt").val(data.mdfydt);
			$("#mdfyr").val(data.mdfyr);
			
			$("#useYn").prop("checked", data.useyn == "Y");
		});
		
		$("#new-btn").click(function() {
			$("#isModify").val("false"); // 등록모드
			
			$("#mvPplId").val("");
			$("#nm").val("");
			$("#rlNm").val("");
			$("#crtDt").val("");
			$("#crtr").val("");
			$("#mdfyDt").val("");
			$("#mdfyr").val("");
			
			$("#useYn").prop("checked", false);
		});
		
		$("#save-btn").click(function() {
			
			var fm = new FormData();
			fm.append("uploadFile", $('#prflPht')[0].files[0])
			fm.append("nm", $('#nm').val());
			fm.append("rlNm", $('#rlNm').val());
			fm.append("useYn", $('#useYn:checked').val() || "N");
			
			$.ajax({
				type: "POST",
				url: "${context}/api/mvppl/create",
				processData: false,
				contentType: false,
				data: fm,
				success: function(response) {
					console.log(response)
				}
			});
			
			return 
			
			if ($("#isModify").val() == "false") {
				// 신규등록
				$.post("${context}/api/mvppl/create", {nm: $("#nm").val(), useYn: $("#useYn:checked").val()}, function(response) {
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
				$.post("${context}/api/mvppl/update", {mvPplId: $("#mvPplId").val(), nm: $("#nm").val(), useYn: $("#useYn:checked").val()}, function(response) {
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
			var mvPplId = $("#mvPplId").val();
			if(mvPplId == "") {
				alert("선택된 영화인이 없습니다.");
				return
			}
			
			if(!confirm("정말 삭제하시겠습니까?")) {
				return;
			}
			
			$.get("${context}/api/mvPpl/delete/" + mvPplId, function(response) {
				if (response.status == "200 OK") {
					location.reload(); // 새로고침
				}
				else {
					alert(response.errorCode + "/" + response.message);
				}
			});
		});
		
		$("#search-btn").click(function() {
			mavePage(0);
		});
		
		$("#all_check").change(function() {
			$(".check-idx").prop("checked", $(this).prop("checked"));
		});
		
		$(".check-idx").change(function() {
			var count = $(".check-idx").length;
			var checkCount = $(".check-idx:checked").length;
			$("#all_check").prop("checked", count == checkCount);
		});
		
		$("#delete-all-btn").click(function() {
			var checkLen = $(".check-idx:checked").length;
			if (checkLen == 0) {
				alert("삭제할 장르가 없습니다");
				return;
			}
			
			var form = $("<form></form>")
			$(".check-idx:checked").each(function() {
				form.append("<input type='hidden' name='mvPplId' value='" + $(this).val() + "'>");
			});
			
			$.post("${context}/api/mvppl/delete", form.serialize(), function(response) {});
			location.reload(); // 새로고침
			
		});
		
	});
	
		function movePage(pageNo) {
			// 전송
			// 입력 값
			var nm = $("#search-keyword-nm").val();
			// URL 요청
			location.href = "${context}/mvppl/list?nm=" + nm + "&pageNo=" + pageNo;
		}

</script>
</head>
<body>
	<div class="main-layout">
		<jsp:include page="../include/header.jsp" />
		<div>
			<jsp:include page="../include/mvMgmtSidemenu.jsp" />
			<jsp:include page="../include/content.jsp" />		
				<div class="path"> 영화 > 영화인관리</div>
				<div class="search-row-group">
					<div class="search-group">
						<label for="search-keyword-nm">이름</label>
						<input type="text" id="search-keyword-nm" class="search-input" value="${mvPplVO.nm}" />
						<label for="search-keyword-rlnm">본명</label>
						<input type="text" id="search-keyword-rlnm" class="search-input" value="${mvPplVO.rlNm}" />
					</div>
						
						<div class="search-group">
							<label for="search-keyword-startdt">조회기간</label>
							<input type="date" id="search-keyword-startdt" class="search-input" value="${mvPplVO.startDt}" />
							<input type="date" id="search-keyword-enddt" class="search-input" value="${mvPplVO.endDt}" />
							<button class="btn-search" id="search-btn">&#128269</button>					
						</div>
				</div>
				<div class="grid">
					<div class="grid-count align-right">
						총 ${mvPplList.size() > 0 ? mvPplList.get(0).totalCount : 0}건
					</div>
					<table>
							<thead>
									<tr>
										<th><input type="checkbox" id="all_check" /></th>
										<th>영화인ID</th>
										<th>이름</th>
										<th>본명</th>
										<th>등록일</th>
										<th>등록자</th>
										<th>수정일</th>
										<th>수정자</th>
									</tr>
							</thead>
							<tbody>
								<c:choose>
									<c:when test="${not empty mvPplList}">
										<c:forEach items="${mvPplList}"
													var="mvPpl"
													varStatus="index">
											<tr data-mvpplid="${mvPpl.mvPplId}"
												data-prflpht="${mvPpl.prflPht}"
												data-nm="${mvPpl.nm}"
												data-rlnm="${mvPpl.rlNm}"
												data-crtr="${mvPpl.crtr}"
												data-crtdt="${mvPpl.crtDt}"
												data-mdfydt="${mvPpl.mdfyDt}"
												data-mdfyr="${mvPpl.mdfyr}"
												data-useyn="${mvPpl.useYn}"
												data-delyn="${mvPpl.crtrMbrVO.mbrNm}"
												data-delyn="${mvPpl.mdfyMbrVO.mbrNm}" >
												<td>
													<input type="checkbox" class="check-idx" value="${mvPpl.mvPplId}" />
												</td>
												<td>${mvPpl.mvPplId}</td>
												<td>${mvPpl.nm}</td>
												<td>${mvPpl.rlNm}</td>
												<td>${mvPpl.crtDt}</td>
												<td>${mvPpl.crtr}(${mvPpl.crtrMbrVO.mbrNm})</td>
												<td>${mvPpl.mdfyDt}</td>
												<td>${mvPpl.mdfyr}(${mvPpl.mdfyMbrVO.mbrNm})</td>
											</tr>
										</c:forEach>
									</c:when>
									<c:otherwise>
										<tr>
											<td colspan="8" class="no-items">
												등록된 장르가 없습니다.
											</td>
										</tr>
									</c:otherwise>
								</c:choose>
							</tbody>
					</table>
					<div class="align-right mt-10">
						<button id="delete-all-btn" class="btn-delete">선택 삭제</button>
					</div>
					<div class="pagenate">
						<ul>
							<c:set value="${mvPplList.size() > 0 ? mvPplList.get(0).lastPage : 0}" var="lastPage"/>
							<c:set value="${mvPplList.size() > 0 ? mvPplList.get(0).lastGroup : 0}" var="lastGroup" />
							
							<fmt:parseNumber var="nowGroup" value="${Math.floor(mvPplVO.pageNo / 10)}" integerOnly="true" />
							<c:set value="${nowGroup * 10}" var="groupStartPageNo" />
							<c:set value="${groupStartPageNo + 10}" var="groupEndPageNo" />
							<c:set value="${groupEndPageNo > lastPage ? lastPage : groupEndPageNo - 1}" var="groupEndPageNo" />
							
							<c:set value="${(nowGroup - 1) * 10}" var="prevGroupStartPageNo" />
							<c:set value="${(nowGroup + 1) * 10}" var="NextGroupStartPageNo" />
							
							<c:if test="${nowGroup > 0}">
								<li><a href="javascript:movePage(0)">처음</a></li>
								<li><a href="javascript:movePage(${prevGroupStartPageNo})">이전</a></li>
							</c:if>
							
							<c:forEach begin="${groupStartPageNo}" end="${groupEndPageNo}" step="1" var="pageNo">
								<li><a class="${pageNo eq mvPplVO.pageNo ? 'on' : ''}" href="javascript:movePage(${pageNo})" > ${pageNo + 1}</a></li>
							</c:forEach>
							
							<c:if test="${lastGroup > nowGroup}">
								<li><a href="javascript:movePage(${NextGroupStartPageNo})">다음</a></li>
								<li><a href="javascript:movePage(${lastPage})">끝</a></li>
							</c:if>
						</ul>
					</div>
				</div>
				<div class="grid-detail">
					<form id="detail-form" enctype="multipart/form-date">
						<!-- 
						isModify == true ==> 수정(update)
						isModify == false ==> 등록(insert)
						-->
						<input type="hidden" id="isModify" value="false" />
						<div class="input-group inline"> 
							<label for="mvPplId" style="width: 180px;">영화인ID</label><input type="text" id="mvPplId" name="mvPplId" readonly value=""/>
						</div>
						<div class="input-group inline">
							<label for="prflPht" style="width: 180px;">프로필사진</label><input type="file" id="prflPht" name="prflPht" value=""/>
						</div>
						<div class="input-group inline">
							<label for="nm" style="width: 180px;">이름</label><input type="text" id="nm" name="nm" value=""/>
						</div>
						<div class="input-group inline">
							<label for="rlNm" style="width: 180px;">본명</label><input type="text" id="rlNm" name="rlNm" value=""/>
						</div>
						<div class="input-group inline">
							<label for="crtDt" style="width: 180px;">등록일</label><input type="text" id="crtDt" name="crtDt" disabled value=""/>
						</div>
						<div class="input-group inline">
							<label for="crtr" style="width: 180px;">등록자</label><input type="text" id="crtr" name="crtr" disabled value=""/>
						</div>
						<div class="input-group inline">
							<label for="mdfyDt" style="width: 180px;">수정일</label><input type="text" id="mdfyDt" name="mdfyDt" disabled value=""/>
						</div>
						<div class="input-group inline">
							<label for="mdfyr" style="width: 180px;">수정자</label><input type="text" id="mdfyr" name="mdfyr" disabled value=""/>
						</div>
						<div class="input-group inline">
							<label for="useYn" style="width: 180px;">사용여부</label><input type="checkbox" id="useYn" name="useYn" value="Y"/>
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