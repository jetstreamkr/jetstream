<%@ page language="java" contentType="text/html; charset=euc-kr"
	pageEncoding="euc-kr" session="true" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script type="text/javascript">


	$(document).ready(function() {
		// 로그인 사용자가 보드 멤버임을 확인
		<c:forEach var="boardMember" items="${boardMemberList}">
			<c:if test="${member.member_id eq boardMember.member_id}">
				<c:set var="membered" value="1" />
			</c:if>
		</c:forEach>
		var membered = "${membered}"
		
		// 로그인 사용자가 아닐 경우 form disabled
		<c:if test="${membered ne '1'}">
			$("#card-start, #card-due, #card-nm").attr("disabled", true);
			$("#card-txt-btn").hide();
		</c:if>
		
		// 카드 제목 수정 폼 호출용
		$("#card-nm-form").hide();
		$("#card-nm-value").click(function() {
			<c:if test="${membered eq '1'}">
				$("#modal-card-label").hide();
				$("#card-nm-form").show();
			</c:if>
		});

		
		//
		<c:forEach var="assignMember" items="${assignList}">
				var assignVal = "<li><a href=\"javascript:closeAssign(\'${assignMember.member_id}\')\">"
			  + "<img class=\"img-circle\" src=\"/jetstream/resources/images/${assignMember.photo}\" height=\"24\" width=\"24\"/>"
			  + "&nbsp;${assignMember.member_nm}&nbsp;<span class=\"fa fa-fw fa-check text-success\"></span></a></span>";
			
				$("#card-assign-add-${assignMember.member_id}").html(assignVal);
		</c:forEach>
		
		// 날짜선택 폼 붙이기
		$("#card-start, #card-due").datepicker({
			dateFormat : 'yy-mm-dd'
		});
		
		// 시작일 설정하면 종료일 제한
		$('#card-start').datepicker();
		$('#card-start').datepicker("option", "maxDate", $("#card-due").val());
		$('#card-start').datepicker("option", "onClose", function ( selectedDate ) {
			$("#card-due").datepicker( "option", "minDate", selectedDate );
			$.ajax({
				"url":"/jetstream/board/card_set.do",
				"type":"POST",
				"data":"card_start=" + selectedDate + "&card_id="+ "${card.card_id}" + "&option=start",
				"success":function(data) {
					var html = $.parseHTML(data);
					var list = $(html).find('#card-start');
					$("#card-start").html(list);
				}
			});	
	    });
	 
		// 종료일 설정하면 시작일 제한
	    $('#card-due').datepicker();
	    $('#card-due').datepicker("option", "minDate", $("#card-start").val());
	    $('#card-due').datepicker("option", "onClose", function ( selectedDate ) {
	        $("#card-start").datepicker( "option", "maxDate", selectedDate );
			$.ajax({
				"url":"/jetstream/board/card_set.do",
				"type":"POST",
				"data":"card_due=" + selectedDate + "&card_id="+ "${card.card_id}" + "&option=due",
				"success":function(data) {
					var html = $.parseHTML(data);
					var list = $(html).find('#card-due');
					$("#card-due").html(list);
				}
			});	
	    });
	});

	
	// 오더 수정
	function setOrder(card_order) {
		$.ajax({
			"url":"/jetstream/board/card_set.do",
			"type":"POST",
			"data":"card_order=" + card_order + "&card_id="+ "${card.card_id}" + "&option=order",
			"success":function(data) {
				var html = $.parseHTML(data);
				var list = $(html).find('#modal-card-label');
				$("#modal-card-label").html(list);
			}
		});	
	}
	
	// 카드제목 수정
	function setCardNm(option) {
		if(option == 'update') {
			$.ajax({
				"url":"/jetstream/board/card_set.do",
				"type":"POST",
				"data":"card_nm=" + $("#card-nm").val() + "&card_id="+ "${card.card_id}" + "&option=nm",
				"success":function(data) {
					var html = $.parseHTML(data);
					var list = $(html).find('#modal-card-label');
					$("#modal-card-label").html(list);
					$("#modal-card-label").show();
					$("#card-nm-form").hide();
				}
			});	
		} else if(option == 'cancel') {
			$("#modal-card-label").show();
			$("#card-nm-form").hide();
		}
	}
	
	
	// 담당자 추가버튼
	function viewBoardMember() {
		$(".dropdown-toggle").dropdown();
	}
	
	// 담당자 추가
	function addAssign(member_id) {
		$.ajax({
			"url":"/jetstream/board/assign_add.do",
			"type":"POST",
			"data":"member_id=" + member_id + "&card_id="+ "${card.card_id}",
			//"datatype":"html",
			"success":function(data) {
				var html = $.parseHTML(data);
				var list = $(html).find('#card-assign');
				$("#card-assign").html(list);
			}
		});
	}
	
	// 담당자 삭제
	function closeAssign(member_id) {
		$.ajax({
			"url":"/jetstream/board/assign_close.do",
			"type":"POST",
			"data":"member_id=" + member_id + "&card_id="+ "${card.card_id}",
			//"datatype":"html",
			"success":function(data) {
				var html = $.parseHTML(data);
				var list = $(html).find('#card-assign');
				$("#card-assign").html(list);
			}
		});
	}
	
	// 담당자 체크
	function chkAssign(member_id) {
		$.ajax({
			"url":"/jetstream/board/assign_chk.do",
			"type":"POST",
			"data":"member_id=" + member_id + "&card_id="+ "${card.card_id}",
			//"datatype":"html",
			"success":function(data) {
				var html = $.parseHTML(data);
				var list = $(html).find('#card-assign');
				$("#card-assign").html(list);
			}
		});
	}	

	
	// 카드내용 수정
	function setTxt(option) {
		var txtVal = '';
		if(option != 'del') {
			txtVal = $("#card-txt-form").val();
		}
		$.ajax({
			"url":"/jetstream/board/card_set.do",
			"type":"POST",
			"data":"card_txt=" + txtVal + "&card_id="+ "${card.card_id}" + "&option=txt",
			"success":function(data) {
				var html = $.parseHTML(data);
				var list = $(html).find('#card-txt');
				$("#card-txt").html(list);
			}
		});
		if(option == 'add') {
			alert('작성되었습니다.');
		} else if(option == 'set') {
			alert('수정되었습니다.');
		} else if(option == 'del') {
			alert('삭제되었습니다.');
		}
	}

	// 삭제는 중요하니 POST로 넘기는 스크립트
	function cardClose(card_id) {
		if (confirm("삭제하시겠습니까?") == true) {
			var delform = document.createElement("form");
			delform.setAttribute("method", "POST");
			delform.setAttribute("action", "/jetstream/board/card_close.do");
			var field = document.createElement("input");
			field.setAttribute("type", "hidden");
			field.setAttribute("name", "card_id");
			field.setAttribute("value", card_id);
			delform.appendChild(field);
			var field2 = document.createElement("input");
			field2.setAttribute("type", "hidden");
			field2.setAttribute("name", "board_id");
			field2.setAttribute("value", "${card.board_id}");
			delform.appendChild(field2);
			document.body.appendChild(delform);
			delform.submit();
		} else {
			alert('취소되었습니다.');
		}
	}
	
	
	// 댓글 전송 전 체크
	function addComment() {
		// 제목, 내용 사이즈 체크하는 정규식(아스키코드는 1, 유니코드는 3으로 계산)
		var commentSize = commentCreateForm.comment_txt.value.replace(
				/[\0-\x7f]|([0-\u07ff]|(.))/g, "$&$1$2").length;

		if (commentSize <= 0) {
			alert("내용을 입력해 주세요.");
			commentCreateForm.comment_txt.focus();
			return false;
		} else if (commentSize > 300) {
			alert("댓글은 한글 100자, 영문 300자 이내로 작성해주세요.");
			commentCreateForm.comment_txt.focus();
			return false;
		} else {
			if (confirm("전송하시겠습니까?") == true) {
				$.ajax({
					"url":"/jetstream/board/comment_create.do",
					"type":"POST",
					"data":"board_id=${card.board_id}&list_id=${card.list_id}&card_id=${card.card_id}&member_id=${member.member_id}&comment_txt=" + $("#comment_txt").val(),
					"success":function(data) {
						var html = $.parseHTML(data);
						var list = $(html).find('#card-comment');
						$("#card-comment").html(list);
					}				
				});
			} else {
				alert('취소되었습니다.');
				return false;
			}
		}
	}

	// 댓글 삭제
	function closeComment(comment_id) {
		if (confirm("삭제하시겠습니까?") == true) {
			$.ajax({
				"url":"/jetstream/board/comment_close.do",
				"type":"POST",
				"data":"card_id=${card.card_id}&comment_id=" + comment_id,
				"success":function(data) {
					var html = $.parseHTML(data);
					var list = $(html).find('#card-comment');
					$("#card-comment").html(list);
				}				
			});
		} else {
			alert('취소되었습니다.');
		}
	}
	
	// replaceAll 구현해주는 함수
	function replaceAll(str, searchStr, replaceStr) {
		return str.split(searchStr).join(replaceStr);
	}
	
	// 댓글 수정
	function setComment(comment_id) {
		$("#setCommentForm .form-group").remove();
		$("#comment-txt-set").show();
		var reply = $("#comment-" + comment_id + " p").html();
		reply = replaceAll(reply, "'", "′");
		reply = replaceAll(reply, "&nbsp;", "\u0020");
		reply = replaceAll(reply, "<br>", "\r\n");

		$("#comment-" + comment_id + " .comment-txt-set").hide();
		$("#comment-" + comment_id)
				.append(
						"<div class=\"form-group\"><div class=\"col-md-9\">"
								+ "<textarea class=\"form-control\" style=\"resize:none;\" rows=\"4\" name=\"comment_txt\" id=\"commentTxtSetForm\">"
								+ reply
								+ "</textarea>"
								+ "</div><div class=\"col-md-3\">"
								+ "<a href=\"javascript:commentSetCheck(\'" + comment_id + "\')\" class=\"btn btn-block btn-lg btn-warning\">"
								+ "<span class=\"fa fa-fw fa-pencil-square-o\"></span> 수정</button></div></div>");
	}

	// 댓글 수정 전송 전 체크
	function commentSetCheck(comment_id) {
		// 제목, 내용 사이즈 체크하는 정규식(아스키코드는 1, 유니코드는 3으로 계산)
		var commentSize = commentSetForm.commentTxtSetForm.value.replace(
				/[\0-\x7f]|([0-\u07ff]|(.))/g, "$&$1$2").length;

		if (commentSize <= 0) {
			alert("내용을 입력해 주세요.");
			commentSetForm.commentTxtSetForm.focus();
			return false;
		} else if (commentSize > 2000) {
			alert("댓글은 한글 100자, 영문 300자 이내로 작성해주세요.");
			commentSetForm.commentTxtSetForm.focus();
			return false;
		} else {
			if (confirm("수정하시겠습니까?") == true) {
				alert('${card.card_id}');

				$.ajax({
					"url":"/jetstream/board/comment_set.do",
					"type":"POST",
					"data":"comment_id=" + comment_id + "&comment_txt=" + $("#commentTxtSetForm").val() + "&card_id=${card.card_id}",
					"success":function(data) {
						var html = $.parseHTML(data);
						var list = $(html).find('#card-comment');
						$("#card-comment").html(list);
					}				
				});
			} else {
				alert('취소되었습니다.');
				return false;
			}
		}
	}
</script>

<!-- 카드 뷰 모달 시작 -->
<div class="modal fade" id="modal-card" tabindex="-1" role="dialog" aria-labelledby="modal-card-label" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<div class="container-fluid">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					
					<!-- 제목 시작 -->
					<div class="col-md-10 dropdown">
						<h4 class="modal-title" id="modal-card-label">
						<!-- 오더 시작 -->
						<c:if test="${membered eq '1'}">
							<a href="#" id="card-order-btn" data-target="#" data-toggle="dropdown" aria-haspopup="true" role="button" aria-expanded="false">
						</c:if>
								<c:choose>
									<c:when test="${card.card_order eq '1'}">
										<span id="card-order" class="modal-title fa fa-fa fa-arrow-up square text-danger"></span>
									</c:when>
									<c:when test="${card.card_order eq '3'}">
										<span id="card-order" class="modal-title fa fa-fa fa-arrow-down square text-muted"></span>
									</c:when>
									<c:otherwise>
											<span id="card-order" class="modal-title fa fa-fa fa-arrow-right square text-success"></span>
									</c:otherwise>
								</c:choose>
						<c:if test="${membered eq '1'}">
							</a>
						</c:if>
								
							<!-- 오더 드롭다운 시작 -->
							<ul class="dropdown-menu" role="menu" aria-labelledby="card-order-btn">
								<li><a href="javascript:setOrder('1')"><span id="card-order" class="modal-title fa fa-fa fa-arrow-up square text-danger"></span> 높음</a></li>
								<li><a href="javascript:setOrder('2')"><span id="card-order" class="modal-title fa fa-fa fa-arrow-right square text-success"></span> 보통</a></li>
								<li><a href="javascript:setOrder('3')"><span id="card-order" class="modal-title fa fa-fa fa-arrow-down square text-muted"></span> 낮음</a></li>
							</ul>
							
							<!-- 오더 드롭다운 끝 -->
						<!-- 오더 끝 -->
						<span id="card-nm-value">${card.card_nm}</span></h4>

						<div class="input-group" id="card-nm-form">
							<input type="text" class="form-control" id="card-nm" name="card_nm" value="${card.card_nm}">
							<span class="input-group-btn"><a class="btn btn-warning" href="javascript:setCardNm('update')">수정</a>
							<a class="btn btn-default" href="javascript:setCardNm('cancel')">취소</a></span>
						</div>
					</div>
			
					<!-- 제목 끝 -->
				</div>
			</div>
			<div class="modal-body" id="modal-card-body">
				<div class="container-fluid">
					<fmt:parseDate var="cardStart" value="${card.card_start}" pattern="yyyy-MM-dd HH:mm:ss" />
					<fmt:parseDate var="cardDue" value="${card.card_due}" pattern="yyyy-MM-dd HH:mm:ss" />
					<fmt:formatDate var="cardStartDate" value="${cardStart}" type="date" pattern="yyyy-MM-dd" />
					<fmt:formatDate var="cardDueDate" value="${cardDue}" type="date" pattern="yyyy-MM-dd" />

					<!-- 담당자 시작 -->
					<div class="form-group col-md-6">
						<label class="control-label" for="card-assign">담당자</label>
						<div class="dropdown" id="card-assign">
							<c:forEach var="assign" items="${assignList}">
							<div class="btn-group">
								<a href="javascript:chkAssign('${assign.member_id}')" id="assign-member-${assign.member_id}" data-target="#" data-toggle="dropdown" aria-haspopup="true" role="button" aria-expanded="false">
									<img class="img-circle" src="/jetstream/resources/images/${assign.photo}" height="24" width="24" alt="${assign.member_nm}"/>
									<c:if test="${assign.assign_chk eq 'C'}">
										<span class="fa fa-fw fa-check"></span>
									</c:if>
									
								</a>
								<ul class="dropdown-menu" role="menu" aria-labelledby="assign-member-${assign.member_id}">
									<li class="disabled"><a>${assign.member_nm}<br>
									<small>${assign.email}</small></a></li>
									<li class="divider"></li>
									<c:if test="${assign.member_id eq member.member_id}">
										<li><a href="javascript:chkAssign('${assign.member_id}')">체크!</a></li>
									</c:if>
									<c:forEach var="boardMember" items="${boardMemberList}">
										<c:if test="${boardMember.member_id eq member.member_id}">
											<li><a href="javascript:closeAssign('${assign.member_id}')">삭제</a></li>	
										</c:if>
									</c:forEach>
								</ul>
							</div>
							</c:forEach>
								<!-- 보드멤버일 경우에만 추가 버튼 표시 -->
								
								<c:if test="${membered eq '1'}">
									<!-- 담당자 추가버튼 -->
									&nbsp;
									<div class="btn-group">
									<a class="btn btn-default btn-xs" id="dLabel" data-target="#" href="javascript:viewBoardMember()" data-toggle="dropdown" aria-haspopup="true" role="button" aria-expanded="false">
										<span class="fa fa-plus"></span>
									</a>
									<!-- 담당자 추가 드롭다운 -->
									<ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
									<!-- 담당자가 추가되어 있을 경우 체크 -->
										<c:forEach var="boardMember" items="${boardMemberList}">
											<li id="card-assign-add-${boardMember.member_id}">
												<a href="javascript:addAssign('${boardMember.member_id}')">
													<img class="img-circle" src="/jetstream/resources/images/${boardMember.photo}" height="24" width="24" alt="${boardMember.member_nm}"/>
													&nbsp;${boardMember.member_nm}
												</a>
											</li>
										</c:forEach>
										</ul>
									</div>
							</c:if>
						</div>
					</div>
					<!-- 담당자 끝 -->

					<!-- 시작일 시작 -->
					<div class="form-group col-md-3">
						<label class="control-label" for="card-start">시작일</label>
						<input class="form-control" id="card-start" name="card_start" type="text" value="${cardStartDate}" placeholder="시작일 지정">
					</div>
					<!-- 시작일 끝 -->
					
					<!-- 종료일 시작 -->
					<div class="form-group col-md-3">
						<label class="control-label" for="card-due">종료일</label>
						<input class="form-control" id="card-due" name="card_due" type="text" value="${cardDueDate}" placeholder="종료일 지정">
					</div>
					<!-- 종료일 끝 -->
					
					<!-- 카드 내용 시작 -->
					<div class="form-group col-md-12">
						<div id="card-txt">
							<label class="control-label" for="card-txt-form">Description
								<span id="card-txt-btn">
									<c:choose>
										<c:when test="${card.card_txt eq null}">
											<a id="card-txt-btn-add" class="btn btn-primary btn-xs" href="javascript:setTxt('add')">작성</a>
										</c:when>
										<c:otherwise>
											<a id="card-txt-btn-set" class="btn btn-warning btn-xs" href="javascript:setTxt('set')">수정</a>
											<a id="card-txt-btn-del" class="btn btn-danger btn-xs" href="javascript:setTxt('del')">삭제</a>
										</c:otherwise>
									</c:choose>
								</span>
							</label>
							<textarea class="form-control" id="card-txt-form" name="card_txt" rows="7">${card.card_txt}</textarea>
						</div>
					</div>
					<!-- 카드 내용 끝 -->
					
					<!-- 첨부파일 시작 -->
					<div class="form-group col-md-12">
						<label class="control-label" for="card-attach-${card.card_id}">File
							Attachment</label>
						<ul id="card-attach-${card.card_id}">
							<li><a href="#">파일명</a></li>
							<li><a href="#">파일명</a></li>
						</ul>
					</div>
					<!-- 첨부파일 끝 -->
					
					<!-- 체크리스트 시작 -->
					<div class="form-group col-md-12">
						<label class="control-label" for="checklist-${card.card_id}">Check
							List : 33%</label>
						<div id="checklist-${card.card_id}" class="progress"
							style="height: 5px;">
							<div class="progress-bar" role="progressbar"
								style="width: 33%; height: 5px;"></div>
						</div>
					</div>
					<!-- 체크리스트 끝 -->
					
					<!-- 댓글 시작 -->
					<div class="form-group col-md-12">
						<label class="control-label" for="comment_view">Comment</label>
						<div id="card-comment">
						<div class="panel panel-default" id="comment_view">
							<div class="panel-body">
								<form class="form-horizontal" role="form" id="commentSetForm" name="commentSetForm">
									<!-- 댓글 반복 시작 -->
									<c:if test="${fn:length(commentList) ne 0}">
										<c:forEach var="comment" items="${commentList}">
											<p>
												<img class="img-circle" src="/jetstream/resources/images/${comment.photo}" height="24" width="24" />&nbsp;&nbsp;
												<span class="text-primary">${comment.member_nm}</span>&nbsp;&nbsp;
												<span class="fa fa-fw fa-clock-o"></span> <span class="text-primary"> 
													<fmt:parseDate var="commentDt" value="${comment.comment_dt}" pattern="yyyy-MM-dd HH:mm:ss" />
													<fmt:formatDate var="commentDate" value="${commentDt}" type="both" pattern="yyyy-MM-dd HH:mm:ss" />
													${commentDate}
												</span>
												
												<!-- 로그인한 사람이 쓴 댓글이면 수정/삭제 표시 -->
												<c:if test="${member.member_id eq comment.member_id}">
													<span class="text-muted">&nbsp;&nbsp;
														<a class="btn btn-warning btn-xs" href="javascript:setComment('${comment.comment_id}')">수정</a>&nbsp;&nbsp;
														<a class="btn btn-danger btn-xs" href="javascript:closeComment('${comment.comment_id}')">삭제</a>
													</span>
												</c:if>
											</p>
											<div id="comment-${comment.comment_id}">
												<!-- 내용 금칙문자 처리 -->
												<c:set var="commentTxt" value="${comment.comment_txt}" />
												<c:set var="commentTxt" value="${fn:replace(commentTxt, \"′\", \"'\")}" />
												<c:set var="commentTxt" value="${fn:replace(commentTxt, u0020, \"&nbsp;\")}" />
												<c:set var="commentTxt" value="${fn:replace(commentTxt, \">\", \"&gt;\")}" />
												<c:set var="commentTxt" value="${fn:replace(commentTxt, \"<\", \"&lt;\")}" />
												<c:set var="commentTxt" value="${fn:replace(commentTxt, crlf, \"<br>\")}" />
												<p>${commentTxt}</p>
											</div>
										</c:forEach>
									</c:if>
								</form>
							</div>
							<!-- 목록 표시 끝 / 입력 시작 -->
							<c:if test="${member.member_id ne null}">
								<div class="panel-footer">
									<form class="form-horizontal" role="form" name="commentCreateForm">
										<div class="form-group">
											<div class="col-md-9">
												<input type="hidden" name="board_id" value="${card.board_id}" />
												<input type="hidden" name="list_id" value="${card.list_id}" />
												<input type="hidden" name="card_id" value="${card.card_id}" />
												<input type="hidden" name="member_id" value="${member.member_id}" />
												<textarea class="form-control" style="resize: none;" rows="3" name="comment_txt" id="comment_txt"></textarea>
											</div>
											<div class="col-md-3">
												<a href="javascript:addComment()" class="btn btn-block btn-success">
													<span class="fa fa-fw fa-pencil-square-o"></span> 쓰기
												</a>
											</div>
										</div>
									</form>
								</div>
							</c:if>
						</div>
					</div>
					<!-- 댓글 끝 -->
				</div>
			</div>

		</div>
				<div class="panel-footer">
					<a href="javascript:cardClose('${card.card_id}')" class="btn btn-block btn-danger"><span class="fa fa-fw fa-close"></span>카드삭제</a>
				</div>

	</div>
</div>
<!-- 카드뷰 모달 끝 -->