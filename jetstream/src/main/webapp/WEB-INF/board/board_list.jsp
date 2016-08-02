<%@ page language="java" contentType="text/html; charset=euc-kr"
	pageEncoding="euc-kr" session="true" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<link rel="stylesheet"
	href="//code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" />
<script type="text/javascript" charset="utf-8"
	src="//ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="//code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
<style type="text/css">
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
</style>
<script type="text/javascript">
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
				},
				error : function(xhr, status, e) {
					alert(e);
				}
			});

		} else {
			alert("아이디를 입력해주세요.");

		}

	}
	function changeState(card_id, chklist_id){
		alert(chklist_id)
		$.ajax({
			type : 'POST',
			data : "chklist_id=" + chklist_id + "&card_id=" + card_id,
			dataType : 'text',
			url : 'checkstate.do',
			success : function(msg) {

			},
			error : function(xhr, status, e) {
				alert(e);
			}
		});
	}
	
	$(document).ready(function() {
		$("#add-pack-form").hide();
		$(".add-card-form").hide();
		$('input:checkbox[name="chkbox"]').on("change", function() {
			card_id = 'chkbox-' + $(this).val()
			$('.' + card_id + ':checked').each(function() {
				if (this.checked == true) {
					checked = $('.' + card_id + ':checked').length
					sum = $('.' + card_id).length
					percent = (checked * 100) / sum
					$("#percent-"+$(this).val()).html(percent + ' %')
					$("#progressbar-bar-"+$(this).val()).progressbar({
						value : percent
					});
				} else {

				}
			});
		})
	});

	$(function() {
		$(".datepicker1, .datepicker2").datepicker({
			dateFormat : 'yy-mm-dd'
		});
	});

	function addCard(pack_id) {
		$(".add-card-form").hide();
		$(".add-card-btn").show();
		$("#add-card-form-" + pack_id).show();
		$("#add-card-btn-" + pack_id).hide();
	}

	function addPack() {
		$("#add-pack-form").show();
		$("#add-pack-btn").hide();
	}
</script>

<div class="col-md-11">
	<!-- Strart Board Info -->
	<div class="col-md-12">
		<h1>${board.board_nm}</h1>
		<hr>
	</div>
	<!--  -->

	<!-- Pack loop Start -->
	<c:forEach var="pack" items="${packList}">
		<div class="col-md-4">
			<div class="panel panel-default">
				<div class="panel-heading">
					<button type="button" class="close">
						<span class="fa fa-fw fa-gear"></span>
					</button>
					<a class="panel-title"
						href="/jetstream/board/board_list.do?board_id=${pack.board_id}&list_id=${pack.list_id}">${pack.list_nm}
						${pack.list_id}</a>
				</div>

				<div class="panel-body panel-group" id="accordion" role="tablist"
					aria-multiselectable="true">

					<!-- Card loop start -->
					<c:forEach var="card" items="${cardList}">
						<c:if test="${card.list_id eq pack.list_id}">
							<div class="panel panel-default">
								<div class="panel-heading" role="tab"
									id="heading-${card.card_id}" data-toggle="collapse"
									data-parent="#accordion" href="#card-${card.card_id}"
									aria-expanded="true" aria-controls="card-${card.card_id}">
									<p class="panel-title" style="clear: both;">
										<c:choose>
											<c:when test="${card.card_order eq '1'}">
												<span class="fa fa-fa fa-arrow-up square text-danger"></span>
											</c:when>
											<c:when test="${card.card_order eq '3' }">
												<span class="fa fa-fa fa-arrow-down square text-muted"></span>
											</c:when>
											<c:otherwise>
												<span class="fa fa-fa fa-arrow-right square text-success"></span>
											</c:otherwise>
										</c:choose>

										&nbsp;${card.card_nm}
										<!-- 남은 날짜 아이콘 -->
										<c:set var="today" value="<%=new java.util.Date()%>" />

										<fmt:parseDate var="cardDue" value="${card.card_due}"
											pattern="yyyy-MM-dd HH:mm:ss" />
										<fmt:formatDate var="now" value="${today}"
											pattern="yyyy-MM-dd" />
										<fmt:formatDate var="cardDueDate" value="${cardDue}"
											pattern="yyyy-MM-dd" />
										${now} // ${cardDueDate}

									</p>
								</div>
								<div id="card-${card.card_id}" class="panel-collapse collapse"
									role="tabpanel" aria-labelledby="heading-${card.card_id}">
									<div class="panel-body">
										<fmt:parseDate var="cardStart" value="${card.card_start}"
											pattern="yyyy-MM-dd HH:mm:ss" />
										<fmt:parseDate var="cardDue" value="${card.card_due}"
											pattern="yyyy-MM-dd HH:mm:ss" />
										<fmt:formatDate var="cardStartDate" value="${cardStart}"
											type="date" pattern="yyyy-MM-dd" />
										<fmt:formatDate var="cardDueDate" value="${cardDue}"
											type="date" pattern="yyyy-MM-dd" />

										<div class="form-group col-md-6">
											<label class="control-label" for="card-start-${card.card_id}">Start
												Date</label> <input class="form-control datepicker1"
												id="card-start-${card.card_id}" name="card_start"
												type="text" value="${cardStartDate}">
										</div>
										<div class="form-group col-md-6">
											<label class="control-label" for="card-due-${card.card_id}">Due
												Date</label> <input class="form-control datepicker2"
												id="card-due-${card.card_id}" name="card_due" type="text"
												value="${cardDueDate}">
										</div>
										<div class="form-group col-md-12">
											<label class="control-label" for="card-txt-${card.card_id}">Description</label>
											<textarea class="form-control" id="card-txt-${card.card_id}"
												name="card_txt">${card.card_txt}</textarea>
										</div>
										
										
										<!-- file attachment -->
										<div class="form-group col-md-12">
											<label class="control-label"
												for="card-attach-${card.card_id}">File Attachment</label>
											<ul id="card-attach-${card.card_id}">
												<c:forEach var="file" items="${fileList}">
													<c:set var="card_id" value="${card.card_id}" />
													<c:set var="file_card_id" value="${file.card_id}" />
													<c:if test="${card_id eq file_card_id}">
														<li><a
															href="attachdownload.do?board_id=${card.board_id}&card_id=${card.card_id}&file_path=${file.file_path}">
																${file.file_nm}</a> <a
															href="attachdelete.do?board_id=${card.board_id}&card_id=${card.card_id}&file_path=${file.file_path}">
																x</a></li>
													</c:if>
												</c:forEach>
											</ul>
											<form action="list/attach.do" method="post"
												enctype="multipart/form-data">
												<input type="file" name="file" size="20"> <input
													type="hidden" name="card_id" value="${card.card_id}"
													size="50"> <input type="hidden" name="board_id"
													value="${card.board_id}" size="50">
												<button type="submit">업로드</button>
											</form>
										</div>

										
										<!-- checklist -->

										<div class="form-group col-md-12">
											<div class="progressbar-container">
												<label class="control-label"
													for="card-chklist-${card.card_id}">CheckList: <span
													id="percent-${card.card_id}">0%</span></label> <span id="progressbar-label"></span>
												<div id="progressbar-bar-${card.card_id}" class="progressbar-bar"></div>

											</div>
											<div id="listshow" name="listshow">
												<c:forEach var="chklist" items="${checkList}">
													<c:set var="card_id" value="${card.card_id}" />
													<c:set var="chk_card_id" value="${chklist.card_id}" />
													<c:if test="${card_id eq chk_card_id}">
														<div id="chklist-${chklist.chklist_id}">
															${chklist.chklist_txt}
															<input type="checkbox" name="chkbox" id="chkbox"
																class="chkbox-${card.card_id}" value="${card.card_id}" />
														</div>
													</c:if>
												</c:forEach>
											</div>
											<div>
												<input type="text" id="checkName" name="checkName" /> 
												<input type="button" value="ok" id="btnSave"
													onclick="checklistadd(this.form,'${card.board_id}','${card.list_id}','${card.card_id}')" />
												<input type="button" value="save" id="btnsubmit" onclick="changeState('${card.card_id}','${chklist.chklist_id}')" >
											</div>

										</div>
										<!-- comment -->
										<table class="table table-bordered table-condensed">
											<tbody>
												<tr>
													<td>dddd</td>
													<td>dddd</td>
													<td>dddd</td>
												</tr>
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</c:if>
					</c:forEach>
					<!-- card loop end -->
				</div>

				<!-- 카드생성 시작 -->
				<div class="panel-footer">
					<a id="add-card-btn-${pack.list_id}" class="add-card-btn"
						href="javascript:addCard('${pack.list_id}')">카드 생성</a>
					<form role="form" action="/jetstream/board/card_create.do"
						method="POST">
						<div id="add-card-form-${pack.list_id}"
							class="input-group add-card-form">
							<input class="form-control" id="card_nm" name="card_nm"
								placeholder="input" type="text"> <input type="hidden"
								id="board_id" name="board_id" value="${board.board_id}">
							<input type="hidden" id="list_id" name="list_id"
								value="${pack.list_id}"> <input type="hidden"
								id="member_id" name="member_id" value="${member.member_id}">
							<span class="input-group-btn">
								<button type="submit" class="btn btn-info">만들기</button>
							</span>
						</div>
					</form>
				</div>
				<!-- 카드생성 끝 -->


			</div>
		</div>
	</c:forEach>
	<!-- pack loop end -->

	<!-- add pack -->
	<div id="add-pack" class="col-md-4">
		<div class="panel panel-default">
			<div id="add-pack-form" class="panel-heading">
				<form role="form" action="/jetstream/board/pack_create.do"
					method="POST">
					<div class="input-group">
						<input class="form-control" id="list_nm" name="list_nm"
							placeholder="input" type="text"> <input type="hidden"
							id="board_id" name="board_id" value="${board.board_id}">
						<span class="input-group-btn">
							<button type="submit" class="btn btn-info">만들기</button>
						</span>
					</div>
				</form>
			</div>
			<a href="javascript:addPack()">
				<div id="add-pack-btn" class="panel-body btn-info text-center">
					<span class="fa fa-fw fa-lg fa-plus"></span>
				</div>
			</a>
		</div>
	</div>
	<!-- add pack end -->

</div>
