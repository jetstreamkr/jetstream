<%@ page language="java" contentType="text/html; charset=euc-kr"
	pageEncoding="euc-kr" session="true" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<style>
.ready {
   font-size: 1.5em;
}

.ui-progressbar-value {
   background: lightblue;
}

.progressbar-container {
   position: relative;
   width: 350px;
}

.progressbar-bar {
   height: 25px;
   margin: 10px 0;
   border-radius: 7px;
}

.progressbar-label {
   position: relative;
   top: 2px;
   left: 0%;
   z-index: 2;
}

.label-xs {
	float: left;
	height: 8px;
	margin: 0px 3px 15px 0px;
	padding: 0;
	width: 75px;
	line-height: 30pt;
	overflow: hidden;
}
</style>


<script type="text/javascript">
	// 삭제는 중요하니 POST로 넘기는 스크립트
	function cardClose(board_id) {
		if (confirm("삭제하시겠습니까?") == true) {
			var delform = document.createElement("form");
			delform.setAttribute("method", "POST");
			delform.setAttribute("action", "/jetstream/board/card_close.do");
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
	// 댓글 전송 전 체크
	function commentCreateCheck() {
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
				return true;
			} else {
				alert('취소되었습니다.');
				return false;
			}
		}
	}

	// 댓글 삭제 POST로 넘기는 스크립트
	function commentClose(comment_id) {
		if (confirm("삭제하시겠습니까?") == true) {
			var replydelform = document.createElement("form");
			replydelform.setAttribute("method", "POST");
			replydelform.setAttribute("action",
					"/jetstream/board/comment_close.do");
			var field = document.createElement("input");
			field.setAttribute("type", "hidden");
			field.setAttribute("name", "comment_id");
			field.setAttribute("value", comment_id);
			replydelform.appendChild(field);
			document.body.appendChild(replydelform);
			replydelform.submit();
		} else {
			alert('취소되었습니다.');
		}
	}
<%-- replaceAll 구현해주는 함수 --%>
	function replaceAll(str, searchStr, replaceStr) {
		return str.split(searchStr).join(replaceStr);
	}
<%-- 댓글 수정 --%>
	function replyMod(seq) {
		$("#replyModForm .form-group").remove();
		$(".reply").show();
		var reply = $("#reply-" + seq + " p").html();
		reply = replaceAll(reply, "'", "′");
		reply = replaceAll(reply, "&nbsp;", "\u0020");
		reply = replaceAll(reply, "<br>", "\r\n");

		$("#reply-" + seq + " .reply").hide();
		$("#reply-" + seq).append(
				"<input type=\"hidden\" name=\"seq\" value=\"" + seq + "\"/>");
		$("#reply-" + seq)
				.append(
						"<div class=\"form-group\"><div class=\"col-md-10\">"
								+ "<textarea class=\"form-control\" style=\"resize:none;\" rows=\"4\" name=\"reply\" id=\"reply\">"
								+ reply
								+ "</textarea>"
								+ "</div><div class=\"col-md-2\">"
								+ "<button type=\"submit\" class=\"btn btn-block btn-lg btn-warning\" style=\"height:93px\" style=\"height:93px\">"
								+ "<i class=\"fa fa-fw fa-pencil-square-o\"></i> 수정</button></div></div>");
	}

	// 댓글 수정 전송 전 체크
	function replyModCheck() {
		// 제목, 내용 사이즈 체크하는 정규식(아스키코드는 1, 유니코드는 3으로 계산)
		var replySize = replyModForm.reply.value.replace(
				/[\0-\x7f]|([0-\u07ff]|(.))/g, "$&$1$2").length;

		if (replySize <= 0) {
			alert("내용을 입력해 주세요.");
			replyModForm.reply.focus();
			return false;
		} else if (replySize > 2000) {
			alert("댓글은 한글 666자, 영문 2000자 이내로 작성해주세요.");
			replyModForm.reply.focus();
			return false;
		} else {
			if (confirm("수정하시겠습니까?") == true) {
				return true;
			} else {
				alert('취소되었습니다.');
				return false;
			}
		}
	}

	// 라벨 추가
	function setLabel(card_id, board_id, label_id, label_nm, label_color,
			label_order) {

		var param = {
			"card_id" : card_id,
			"board_id" : board_id,
			"label_id" : label_id,
			"label_nm" : label_nm,
			"label_color" : label_color,
			"label_order" : label_order
		};

		$.ajax({
			"url" : "../label/SetLabel.do",
			"type" : "POST",
			"data" : param,
			//"datatype":"html",
			"success" : function(data) {
				var html = $.parseHTML(data)
				var la = $(html).find('#addedLabel')
				$("#addedLabel").html(la)
			}

		});
	}

	// 파일업로드 ajax

	/* $("#upload").click(function() {
		var formData = new FormData();
		formData.append("file", $("input[name=file]")[0].files[0]);
		formData.append("card_id", $("input[name=card_id]").val());
		formData.append("board_id", $("input[name=board_id]").val());

		$.ajax({
			url : '/jetstream/attach/attach.do',
			data : formData,
			processData : false,
			contentType : false,
			type : 'POST',
			success : function(data) {
				var html = $.parseHTML(data);
				var list = $(html).find('#fileupload1')
				alert(list)
				$("#fileupload1").html(list)
			}
		});
	}); */
	
	
	/*  체크리스트 */
	
	   
   //체크리스트 추가
   function checklistadd(myform, board_id, list_id, card_id) {
      //, board_id, list_id, card_id
      chklist_txt = myform.checkName.value
      alert(chklist_txt)
      if (chklist_txt != "") {
         $.ajax({
            type : 'POST',
            data : "chklist_txt=" + chklist_txt + "&board_id=" + board_id
                  + "&list_id=" + list_id + "&card_id=" + card_id,
            dataType : 'text',
            url : 'checkcreate.do',
            success : function(msg) {
               $("#listshow").html(msg);
               $('input:checkbox[name="chkbox"]').on("change",function() {

                  arr = $(this).val().split(',')
                  card_id = 'chkbox-' + arr[0]
                  chk_id = 'chkbox-' + arr[1]
                  
                  //체크됐을 때         
                     if (this.checked == true){
                        checked = $('.'+ card_id+ ':checked').length
                        sum = $('.'+ card_id).length
                        percent = parseInt((checked * 100)/ sum)
                        $("#percent-"+ $(this).val()).html(percent+ ' %')
                        $("#progressbar-bar-"+ $(this).val()).progressbar({
                           value : percent
                        });
                        $.ajax({
                           type : 'POST',
                           data : "card_id="+ arr[0]+ "&chklist_id="+ arr[1]+ "&state=1",
                           dataType : 'text',
                           url : 'checkstate.do',
                           success : function(msg) {

                           },
                           error : function(xhr,status,e) {
                              alert(e);
                           }
                        });
                     }else{
                        //check 해제됐을 때
                        checked = $('.'+ card_id+ ':checked').length
                        sum = $('.'+ card_id).length
                        percent = parseInt((checked * 100)/ sum)
                        $("#percent-"+ $(this).val()).html(percent + ' %')
                        $("#progressbar-bar-"+ $(this).val()).progressbar({
                           value : percent
                        });
                        $.ajax({
                           type : 'POST',
                           data : "card_id="+ arr[0]+ "&chklist_id="+ arr[1]+ "&state=0",
                           dataType : 'text',
                           url : 'checkstate.do',
                           success : function(msg) {

                           },
                           error : function(xhr,status,e) {
                              alert(e);
                           }
                        });
                     }
               });
            },
            error : function(xhr, status, e) {
               alert(e);
            }
         });

      } else {
         alert("아이디를 입력해주세요.");

      }

   }
   //체크리스트 삭제
   function deleteCheck(card_id, chklist_id){
	 
      $.ajax({
         type : 'GET',
         data : "card_id="+card_id+"&chklist_id="+ chklist_id,
         dataType : 'text',
         url : 'checkdelete.do',
         success : function(msg) {
            $("#listshow").html(msg);
            $('input:checkbox[name="chkbox"]').on("change",function() {

               arr = $(this).val().split(',')
               card_id = 'chkbox-' + arr[0]
               chk_id = 'chkbox-' + arr[1]
               
               //체크됐을 때         
                  if (this.checked == true){
                     checked = $('.'+ card_id+ ':checked').length
                     sum = $('.'+ card_id).length
                     percent = parseInt((checked * 100)/ sum)
                     $("#percent-"+ $(this).val()).html(percent+ ' %')
                     $("#progressbar-bar-"+ $(this).val()).progressbar({
                        value : percent
                     });
                     $.ajax({
                        type : 'POST',
                        data : "card_id="+ arr[0]+ "&chklist_id="+ arr[1]+ "&state=1",
                        dataType : 'text',
                        url : 'checkstate.do',
                        success : function(msg) {

                        },
                        error : function(xhr,status,e) {
                           alert(e);
                        }
                     });
                  }else{
                     //check 해제됐을 때
                     checked = $('.'+ card_id+ ':checked').length
                     sum = $('.'+ card_id).length
                     percent = parseInt((checked * 100)/ sum)
                     $("#percent-"+ $(this).val()).html(percent + ' %')
                     $("#progressbar-bar-"+ $(this).val()).progressbar({
                        value : percent
                     });
                     $.ajax({
                        type : 'POST',
                        data : "card_id="+ arr[0]+ "&chklist_id="+ arr[1]+ "&state=0",
                        dataType : 'text',
                        url : 'checkstate.do',
                        success : function(msg) {

                        },
                        error : function(xhr,status,e) {
                           alert(e);
                        }
                     });
                  }
            });
         },
         error : function(xhr,status,e) {
            alert(e);
         }
      });
   }
   //check
   $(document).ready(function() {
      
      $('input:checkbox[name="chkbox"]').on("change",function() {

         arr = $(this).val().split(',')
         card_id = 'chkbox-' + arr[0]
         chk_id = 'chkbox-' + arr[1]
         
         //체크됐을 때         
            if (this.checked == true){
               checked = $('.'+ card_id+ ':checked').length
               sum = $('.'+ card_id).length
               percent = parseInt((checked * 100)/ sum)
               $("#percent-"+ $(this).val()).html(percent+ ' %')
               $("#progressbar-bar-"+ $(this).val()).progressbar({
                  value : percent
               });
               $.ajax({
                  type : 'POST',
                  data : "card_id="+ arr[0]+ "&chklist_id="+ arr[1]+ "&state=1",
                  dataType : 'text',
                  url : 'checkstate.do',
                  success : function(msg) {

                  },
                  error : function(xhr,status,e) {
                     alert(e);
                  }
               });
            }else{
               //check 해제됐을 때
               checked = $('.'+ card_id+ ':checked').length
               sum = $('.'+ card_id).length
               percent = parseInt((checked * 100)/ sum)
               $("#percent-"+ $(this).val()).html(percent + ' %')
               $("#progressbar-bar-"+ $(this).val()).progressbar({
                  value : percent
               });
               $.ajax({
                  type : 'POST',
                  data : "card_id="+ arr[0]+ "&chklist_id="+ arr[1]+ "&state=0",
                  dataType : 'text',
                  url : 'checkstate.do',
                  success : function(msg) {

                  },
                  error : function(xhr,status,e) {
                     alert(e);
                  }
               });
            }
      });
   });
	
</script>



<!-- 카드 뷰 모달 시작 -->
<div class="modal fade" id="modal-card" tabindex="-1" role="dialog"
	aria-labelledby="modal-card-label" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="modal-card-label">${card.card_nm}</h4>
			</div>
			<div class="modal-body" id="modal-card-body">
				<div class="container-fluid">
					<fmt:parseDate var="cardStart" value="${card.card_start}"
						pattern="yyyy-MM-dd HH:mm:ss" />
					<fmt:parseDate var="cardDue" value="${card.card_due}"
						pattern="yyyy-MM-dd HH:mm:ss" />

					<fmt:formatDate var="cardStartDate" value="${cardStart}"
						type="date" pattern="yyyy-MM-dd" />
					<fmt:formatDate var="cardDueDate" value="${cardDue}" type="date"
						pattern="yyyy-MM-dd" />

					<div class="form-group col-md-6">
						<label class="control-label" for="card--${card.card_id}">담당자</label>

					</div>


					<div class="form-group col-md-3">
						<label class="control-label" for="card-start-${card.card_id}">시작일</label>
						<input class="form-control datepicker1"
							id="card-start-${card.card_id}" name="card_start" type="text"
							value="${cardStartDate}" placeholder="시작일 지정">
					</div>
					<div class="form-group col-md-3">
						<label class="control-label" for="card-due-${card.card_id}">종료일</label>
						<input class="form-control datepicker2"
							id="card-due-${card.card_id}" name="card_due" type="text"
							value="${cardDueDate}" placeholder="종료일 지정">
					</div>

					<!--라벨  -->

					<div class="form-group col-md-12">
						<div class="dropdown col-md-4">
							<button class="btn btn-default dropdown-toggle" type="button"
								id="dropdownMenu1" data-toggle="dropdown" aria-expanded="true">
								Label <span class="caret"></span>
							</button>
							<ul class="dropdown-menu" role="menu"
								aria-labelledby="dropdownMenu1">

								<c:forEach var="label" items="${labelList}">
									<li role="presentation"><a
										onclick="setLabel('${card.card_id}','${label.board_id}','${label.label_id}','${label.label_nm}','${label.label_color}','${label.label_order}');">
											<span class="labal-size label"
											style="background-color: ${label.label_color}">color</span>
									</a></li>
								</c:forEach>

							</ul>
						</div>
					</div>
					<div class="col-md-12">
						<div id="addedLabel">
							<c:forEach var="addedlabel" items="${addedlabelListDTO}">
								<span class="label labal-size label-default label-xs"
									style="background-color: ${addedlabel.label_color}"> <a>${addedlabel.label_color}</a>
								</span>
							</c:forEach>
						</div>
					</div>

					<!-- 라벨 끝 -->

					<!-- Description -->
					<div class="form-group col-md-12">
						<label class="control-label" for="card-txt-${card.card_id}">Description</label>
						<textarea class="form-control" id="card-txt-${card.card_id}"
							name="card_txt">${card.card_txt}</textarea>
					</div>
					<!-- Description 끝 -->

					<!-- 파일 업로드 -->

					<div class="form-group col-md-12">
						<label class="control-label" for="card-attach-${card.card_id}">File
							Attachment</label>
						<ul id="card-attach-${card.card_id}">
							<c:forEach var="file" items="${fileList}">
								<li><a
									href="attachdownload.do?board_id=${card.board_id}&card_id=${card.card_id}&file_path=${file.file_path}">
										${file.file_nm}</a> <a
									href="attachdelete.do?board_id=${card.board_id}&card_id=${card.card_id}&file_path=${file.file_path}">
										x</a></li>
							</c:forEach>
						</ul>
						<form action="/jetstream/attach.do" method="post"
							enctype="multipart/form-data">
							<input type="file" name="file" size="20"> <input
								type="hidden" name="card_id" value="${card.card_id}" size="50">
							<input type="hidden" name="board_id" value="${card.board_id}"
								size="50">
							<button type="submit">업로드</button>
						</form>
					</div>

					<!-- 파일 업로드 끝-->

					<!-- 체크리스트 시작 -->
					<div class="form-group col-md-12">
						<!--프로그래스바-->
						<div class="progressbar-container">
							<label class="control-label" for="card-chklist-${card.card_id}">
								CheckList: <span id="percent-${card.card_id}">${percent}
									%</span>
							</label> <span id="progressbar-label"></span>
							<div id="progressbar-bar-${card.card_id}" class="progressbar-bar"></div>
						</div>
						<!-- 체크리스트 뿌려주는 곳 -->
						<div id="listshow" name="listshow">
							<c:forEach var="chklist" items="${checkList}">
								<c:set var="card_id" value="${card.card_id}" />
								<c:set var="chk_card_id" value="${chklist.card_id}" />
								<c:set var="chk_st" value="${chklist.chklist_st}" />
								<c:if test="${card_id eq chk_card_id}">
									<div id="chklist-${chklist.chklist_id}">
										${chklist.chklist_txt}
										<c:choose>
											<c:when test="${chk_st == 'O'}">
												<input type="checkbox" name="chkbox" id="chkbox"
													class="chkbox-${card.card_id}"
													value="${card.card_id},${chklist.chklist_id}" checked />
											</c:when>
											<c:when test="${chk_st == 'C'}">
												<input type="checkbox" name="chkbox"
													id="chkbox-${chklist.chklist_id}"
													class="chkbox-${card.card_id}"
													value="${card.card_id},${chklist.chklist_id}" />
											</c:when>
											<c:otherwise>
											</c:otherwise>
										</c:choose>
										<input type="button" value="x"
											onclick="deleteCheck('${card.card_id}','${chklist.chklist_id}')">
									</div>
								</c:if>
							</c:forEach>
						</div>
						<!-- 체크리스트 생성 하는 곳-->
						<form>
							<div>
								<input type="text" id="checkName" name="checkName" /> <input
									type="button" value="ok" id="btnSave"
									onclick="checklistadd(this.form,'${card.board_id}','${card.list_id}','${card.card_id}')" />
							</div>
						</form>

					</div>
					<!-- 체크리스트 끝 -->
					<div class="form-group col-md-12">
						<label class="control-label" for="comment_view">Comment</label>
						<!-- 댓글 시작 -->
						<div class="panel panel-default" id="comment_view">
							<div class="panel-body">
								<form class="form-horizontal" role="form" id="commentSetForm"
									name="commentSetForm" action="/jetstream/board/comment_set.do"
									method="POST" onsubmit="return commentSetCheck()">
									<!-- 댓글 반복 시작 -->
									<c:if test="${fn:length(commentList) ne 0}">
										<c:forEach var="comment" items="${commentList}">
											<p>
												<img class="img-circle"
													src="/jetstream/resources/images/${comment.photo}"
													height="24" width="24" />&nbsp;&nbsp; <span
													class="text-primary">${comment.member_nm}</span>&nbsp;&nbsp;
												<span class="fa fa-fw fa-clock-o"></span> <span
													class="text-primary"> <fmt:parseDate var="commentDt"
														value="${comment.comment_dt}"
														pattern="yyyy-MM-dd HH:mm:ss" /> <fmt:formatDate
														var="commentDate" value="${commentDt}" type="both"
														pattern="yyyy-MM-dd HH:mm:ss" /> ${commentDate}
												</span>
												<!-- 로그인한 사람이 쓴 댓글이면 수정/삭제 표시 -->
												<c:if test="${member.member_id eq comment.member_id}">
													<span class="text-muted">&nbsp;&nbsp; <a
														class="btn btn-warning btn-xs"
														href="javascript:commentSet(${comment.comment_id})">수정</a>&nbsp;&nbsp;
														<a class="btn btn-danger btn-xs"
														href="javascript:commentClose(${comment.comment_id});">삭제</a>
													</span>
												</c:if>
											</p>
											<div id="comment_${comment.comment_id}">
												<!-- 내용 금칙문자 처리 -->
												<c:set var="commentTxt" value="${comment.comment_txt}" />
												<c:set var="commentTxt"
													value="${fn:replace(commentTxt, \"′\", \"'\")}" />
												<c:set var="commentTxt"
													value="${fn:replace(commentTxt, u0020, \"&nbsp;\")}" />
												<c:set var="commentTxt"
													value="${fn:replace(commentTxt, \">\", \"&gt;\")}" />
												<c:set var="commentTxt"
													value="${fn:replace(commentTxt, \"<\", \"&lt;\")}" />
												<c:set var="commentTxt"
													value="${fn:replace(commentTxt, crlf, \"<br>\")}" />
												<p>${commentTxt}</p>
											</div>
										</c:forEach>
									</c:if>
								</form>
							</div>
							<!-- 목록 표시 끝 / 입력 시작 -->
							<c:if test="${member.member_id ne null}">
								<div class="panel-footer">
									<form class="form-horizontal" role="form"
										name="commentCreateForm"
										action="/jetstream/board/comment_create.do" method="POST">
										<div class="form-group">
											<div class="col-md-10">
												<input type="hidden" name="board_id"
													value="${card.board_id}" /> <input type="hidden"
													name="list_id" value="${card.list_id}" /> <input
													type="hidden" name="card_id" value="${card.card_id}" /> <input
													type="hidden" name="member_id" value="${member.member_id}" />
												<textarea class="form-control" style="resize: none;"
													rows="3" name="comment_txt" id="comment_txt"></textarea>
											</div>
											<div class="col-md-2">
												<button type="submit" class="btn btn-block btn-success">
													<span class="fa fa-fw fa-pencil-square-o"></span> 쓰기
												</button>
											</div>
										</div>
									</form>
								</div>
							</c:if>
						</div>
						<!-- 댓글 끝 -->
					</div>


				</div>
			</div>
			<div class="modal-footer bg-success">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				<button type="button" class="btn btn-primary">Send message</button>
			</div>
		</div>
	</div>
</div>
<!-- 카드뷰 모달 끝 -->