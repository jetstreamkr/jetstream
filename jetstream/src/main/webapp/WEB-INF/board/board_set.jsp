<%@ page language="java" contentType="text/html; charset=euc-kr"
	pageEncoding="euc-kr" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script>

	$(document).ready(function() {
	var board_permit_val = "${board.board_permit}";
	if(board_permit_val == "O") {
		$("#board_permit_label_O").addClass("active");
		$("#board_permit_O").attr("checked", true);
		
	} else {
		$("#board_permit_label_C").addClass("active");
		$("#board_permit_C").attr("checked", true);

	}
	
	// 날짜선택 폼 붙이기
	$(".datepicker1, .datepicker2").datepicker({
		dateFormat : 'yy-mm-dd'
	});
	
	
	});

	// 클립보드로 복사
	function copyToClipboard(element) {
		var $temp = $("<input>");
	  	$("body").append($temp);
	  	$temp.val($(element).val()).select();
	  	document.execCommand("copy");
	  	alert('클립보드로 복사되었습니다');
	  	$temp.remove();
	}
</script>

<div class="col-md-11">
	<!-- 보드정보 시작 -->
	<div class="col-md-12">
		<h1>${board.board_nm}</h1>
		<hr>
		<h3></h3>
	</div>
	<!-- 보드정보 끝 -->

	<!-- set 왼쪽 시작 -->
	<div class="col-md-4">
		<div class="panel panel-default">
			<div class="panel-heading">
				<span class="panel-title">보드 설정</span>
			</div>
			<div class="panel-body">
				<form role="form">
					<div class="form-group col-md-12">
						<label class="control-label" for="board_nm">보드이름</label>
						<input class="form-control" id="board_nm" name="board_nm" placeholder="보드 이름(영문 30자, 한글 20자 이내)" type="text" value="${board.board_nm}">
					</div>
					<div class="form-group col-md-12">
						<label class="control-label" for="board_uri">보드 URI</label>
						<div class="input-group">
							<input class="form-control" id="board_uri" name="board_uri" placeholder="보드 URI" type="text" value="${board.board_uri}" disabled>
							<span class="input-group-btn"> <a class="btn btn-info" type="button" href="javascript:copyToClipboard('#board_uri')"><span class="fa fa-fw fa-clipboard"></span>클립보드로 복사</a></span>
						</div>
					</div>
					<div class="form-group col-md-12">
						<label class="control-label">보드 권한</label>
						<div class="input-group">
							<div class="btn-group btn-group-justified" data-toggle="buttons">
								<label id="board_permit_label_O" class="btn btn-default">
			    					<input type="radio" name="board_permit" id="board_permit_O" value="O" autocomplete="off"><span class="fa fa-fw fa-unlock"></span>보드 공개
								</label>
								<label id="board_permit_label_C" class="btn btn-default">
			    					<input type="radio" name="board_permit" id="board_permit_C" value="C" autocomplete="off"><span class="fa fa-fw fa-lock"></span>보드 비공개
								</label>
							</div>
						</div>
					</div>
					<fmt:parseDate var="boardStart" value="${board.board_start}" pattern="yyyy-MM-dd HH:mm:ss" />
					<fmt:parseDate var="boardDue" value="${board.board_due}" pattern="yyyy-MM-dd HH:mm:ss" />
					<fmt:formatDate var="boardStartDate" value="${boardStart}" type="date" pattern="yyyy-MM-dd" />
					<fmt:formatDate var="boardDueDate" value="${boardDue}" type="date" pattern="yyyy-MM-dd" />
			
					<div class="form-group col-md-6">
						<label class="control-label" for="board_start">시작일</label>
						<input class="form-control datepicker1" id="board_start" name="board_start" type="text" value="${boardStartDate}" placeholder="시작일 지정">
					</div>
					<div class="form-group col-md-6">
						<label class="control-label" for="board_due">종료일</label>
						<input class="form-control datepicker2" id="board_due" name="board_due" type="text" value="${boardDueDate}" placeholder="종료일 지정">
					</div>
					<div class="form-group col-md-12">
						<button type="submit" class="btn btn-block btn-success btn-lg">수정하기</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- set 왼쪽 끝 -->
	
	<!-- set 멤버 시작 -->
	<div class="col-md-4">
		<div class="panel panel-default">
			<div class="panel-heading">
				<span class="panel-title">멤버 설정</span>
			</div>
			<div class="panel-body">
				<div class="form-group col-md-12">
					<label class="control-label">멤버 목록 : ${fn:length(boardMemberList)}명</label>
					<ul class="media-list">
						<c:forEach var="boardMember" items="${boardMemberList}">
							<li class="media">
								<a class="pull-left" href="#"><img class="img-circle media-object" src="/jetstream/resources/images/${boardMember.photo}" height="50" width="50"></a>
								<div class="media-body">
									<div class="col-md-8">
										<h4 class="media-heading">${boardMember.member_nm}</h4>
										<p class="text-muted">${boardMember.email}</p>
									</div>
									<div class="col-md-4">
										<p>${boardMember.member_permit}</p>
									</div>
								</div>
							</li>
						</c:forEach>
					</ul>
				</div>
				<div class="form-group has-success col-md-12">
					<div class="input-group">
						<input class="form-control" id="board_uri" name="board_uri" placeholder="멤버 검색(이름, E-Mail)" type="text">
						<span class="input-group-btn">
							<a class="btn btn-success" type="button" href="javascript:copyToClipboard('#board_uri')"><span class="fa fa-fw fa-search"></span>멤버 검색</a>
						</span>
					</div>
				</div>
			</div>
		</div>		
	</div>
	<!-- set 멤버 끝 -->	

	<!-- set 라벨 시작 -->
	<div class="col-md-4">
		<div class="panel panel-default">
			<div class="panel-heading">
				<span class="panel-title">라벨 설정</span>
			</div>
			<div class="panel-body">
			</div>
		</div>		
	</div>
	<!-- set 멤버 끝 -->	

</div>
