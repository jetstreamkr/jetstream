<%@ page language="java" contentType="text/html; charset=euc-kr" pageEncoding="euc-kr" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script type="text/javascript">
	//삭제는 중요하니 POST로 넘기는 스크립트
	function del(board_id) {
	    if (confirm("삭제하시겠습니까?") == true) {
		    var delform = document.createElement("form");
		    delform.setAttribute("method", "POST");
		    delform.setAttribute("action", "/jetstream/board/board_close.do");
	        var field = document.createElement("input");
			field.setAttribute("type", "hidden");
			field.setAttribute("name", "board_id");
			field.setAttribute("value", board_id);
	        delform.appendChild(field);
		    document.body.appendChild(delform);
		    delform.submit();
	    } else {
	        alert('취소되었습니다.');
	    }
	}
	
	// 즐겨찾기
	
	var x

function fav(board_id){
	$.ajax({
		"url":"/jetstream/board/board_fav.do",
		"type":"POST",
		"data":"board_id="+board_id,
		//"datatype":"html",
		"success":function(data) {
			//console.log(data)
			var html = $.parseHTML(data);
			var list = $(html).find('#ajax-board1')
			var list2 = $(html).find('#ajax-board2')
			$("#favBoardList").html(list)
			$("#boardList").html(list2)
            
		}
			
	});
}
	
	
</script>


<head>
	<style type="text/css">
		#initial{
			color : white;
			position: absolute;
			top: 15px;
			right: 160px;
		}	
	</style>
</head>
<body>
<div class="section">
	<div class="container">
		<div class="row">
			<div class="col-md-8">

				<!-- 즐겨찾기 박스 시작 -->
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title text-info">
							<span class="fa fa-star fa-fw"></span>즐겨찾기
						</h3>
					</div>
					<div class="panel-body" id="favBoardList">

						<%-- 보드가 없을 경우 --%>
						<c:choose>
							<c:when test="${fn:length(favBoardList) eq 0}">
								<p>즐겨찾기가 없습니다.</p>
							</c:when>
							<c:otherwise>
								<!-- 보드리스트 반복 시작 -->
								<c:forEach var="board" items="${favBoardList}">
									<fmt:parseDate var="boardStart" value="${board.board_start}" pattern="yyyy-MM-dd HH:mm:ss" />
									<fmt:parseDate var="boardDue" value="${board.board_due}" pattern="yyyy-MM-dd HH:mm:ss" />
									<fmt:formatDate var="boardStartDate" value="${boardStart}" type="date" pattern="yyyy-MM-dd" />
									<fmt:formatDate var="boardDueDate" value="${boardDue}" type="date" pattern="yyyy-MM-dd" />
									<div class="col-md-12 panel panel-default">
										<h3>
											<a href="board/board_main.do?board_id=${board.board_id}">${board.board_nm}</a>
											<small> <span class="label label-default">${boardStartDate}</span>
												<span class="label label-default">${boardDueDate}</span>
												<div class="btn-group btn-group-xs">
													<c:choose>
														<c:when test="${board.board_fav eq 'Y'}">
															<a id="fav" class="btn btn-warning" onClick="fav('${board.board_id}');"><span class="fa fa-fw fa-star"></span></a>
														</c:when>
														<c:otherwise>
															<a id="fav" class="btn btn-default" onClick="fva('${board.board_id}');"><span class="fa fa-fw fa-star-o"></span></a>
														</c:otherwise>
													</c:choose>
													<a href="/jetstream/board/board_set.do?board_id=${board.board_id}" class="btn btn-success">
														<span class="fa fa-fw fa-cog"></span>
													</a>
													<a href="javascript:del('${board.board_id}')" class="btn btn-danger">
														<span class="fa fa-fw fa-close"></span>
													</a>
												</div>
											</small>
										</h3>
										<div class="progress progress-striped">
											<c:choose>
												<c:when test="${board.board_prog eq null}">
													<c:set var="board_prog_value" value="0" />
												</c:when>
												<c:otherwise>
													<c:set var="board_prog_value" value="${board.board_prog}" />
												</c:otherwise>
											</c:choose>
											<div class="progress-bar progress-bar-info"
												role="progressbar" style="width: ${board_prog_value}%;">${board_prog_value}% Complete</div>

										</div>
									</div>
								</c:forEach>
							</c:otherwise>
						</c:choose>
						<!-- 보드리스트 반복 끝 -->

					</div>
				</div>
				<!-- 즐겨찾기 박스 끝 -->

				<!-- 내 보드 박스 시작 -->
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">
							<span class="fa fa-fw fa-clipboard"></span>내 보드
						</h3>
					</div>
					<div class="panel-body" id="boardList">

						<%-- 보드가 없을 경우 --%>
						<c:choose>
							<c:when test="${fn:length(boardList) eq 0}">
								<p>보드가 없습니다.</p>
							</c:when>
							<c:otherwise>
								<!-- 보드리스트 반복 시작 -->
								<c:forEach var="board" items="${boardList}">
									<fmt:parseDate var="boardStart" value="${board.board_start}" pattern="yyyy-MM-dd HH:mm:ss" />
									<fmt:parseDate var="boardDue" value="${board.board_due}" pattern="yyyy-MM-dd HH:mm:ss" />
									<fmt:formatDate var="boardStartDate" value="${boardStart}" type="date" pattern="yyyy-MM-dd" />
									<fmt:formatDate var="boardDueDate" value="${boardDue}" type="date" pattern="yyyy-MM-dd" />
									<div class="col-md-12 panel panel-default">
										<h3>
											<a href="board/board_main.do?board_id=${board.board_id}">${board.board_nm}</a>
											<small> <span class="label label-default">${boardStartDate}</span>
												<span class="label label-default">${boardDueDate}</span>
												<div class="btn-group btn-group-xs">
													<c:choose>
														<c:when test="${board.board_fav eq 'Y'}">
															<a id="fav" class="btn btn-warning" onClick="fav('${board.board_id}');"><span class="fa fa-fw fa-star"></span></a>
														</c:when>
														<c:otherwise>
															<a id="fav" class="btn btn-default" onClick="fva('${board.board_id}');"><span class="fa fa-fw fa-star-o"></span></a>
														</c:otherwise>
													</c:choose>
													<a href="/jetstream/board/board_set.do?board_id=${board.board_id}" class="btn btn-success">
														<span class="fa fa-fw fa-cog"></span>
													</a>
													<a href="javascript:del('${board.board_id}')" class="btn btn-danger">
														<span class="fa fa-fw fa-close"></span>
													</a>
												</div>
											</small>
										</h3>
										<div class="progress progress-striped">
											<c:choose>
												<c:when test="${board.board_prog eq null}">
													<c:set var="board_prog_value" value="0" />
												</c:when>
												<c:otherwise>
													<c:set var="board_prog_value" value="${board.board_prog}" />
												</c:otherwise>
											</c:choose>
											<div class="progress-bar progress-bar-info"
												role="progressbar" style="width: ${board_prog_value}%;">${board_prog_value}% Complete</div>

										</div>
									</div>
								</c:forEach>
							</c:otherwise>
						</c:choose>
						<!-- 보드리스트 반복 끝 -->

					</div>
				</div>
				<!-- 내 보드 박스 끝 -->

			</div>


			<div class="col-md-4">
				<!-- 프로필 박스 시작 -->
				<div class="col-md-12 well well-sm">
					<img src="/jetstream/resources/images/${member.photo}"
						class="center-block img-circle img-responsive" width="100"
						height="100">
					<c:set var="photo" value="${member.photo}" />
					<c:if test="${photo eq 'default.png'}">
						<h1 id="initial" class="text-center text-muted">${initial}</h1>
					</c:if>
					<h4 class="text-center">${member.member_nm}</h4>
					<p class="text-center text-muted">${member.email}</p>
					<a class="btn btn-block btn-warning" href="memberupdate.do">정보수정</a>
				</div>
				<!-- 프로필 박스 끝 -->
				<button class="btn btn-block btn-lg btn-primary" data-toggle="modal"
					data-target="#createBoard">
					<span class="-square -square-o fa fa-fw fa-plus"></span>보드생성
				</button>
				<br>
				<!-- 액티비티 박스 시작 -->
				<div class="col-md-12 well well-sm">
					<ul>
						<!-- 액티비티 반복 시작 -->
						<li>액티비티</li>
						<!-- 액티비티 반복 끝 -->
					</ul>
				</div>
				<!-- 액티비티 박스 끝 -->
			</div>
		</div>
	</div>
</div>
<!-- 보드생성 모달 시작 -->
<div class="modal fade" id="createBoard" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header bg-primary">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">×</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">보드생성</h4>
			</div>
			<div class="modal-body">
				<form role="form" action="board/board_create.do" method="POST">
					<div class="form-group">
						<label class="control-label" for="board_nm">보드명을 입력하세요</label> <input
							class="form-control input-lg" id="board_nm" name="board_nm"
							placeholder="영문 3~20자 이내" type="text"> <input
							type="hidden" id="member_id" name="member_id"
							value="${member.member_id}" />
					</div>
					<div class="form-group">
						<button type="submit" class="btn btn-lg btn-block btn-info">만들기!</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
<!-- 보드 생성 모달 끝 -->
</body>