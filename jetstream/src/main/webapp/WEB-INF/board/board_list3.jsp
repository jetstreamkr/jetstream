<%@ page language="java" contentType="text/html; charset=euc-kr"
	pageEncoding="euc-kr" session="true" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<style>
.sortable li {
	padding: 0.4em;
}
</style>

<script type="text/javascript">


	$(document).ready(function() {
		$("#add-pack-form").hide();
		$(".add-card-form").hide();
	});

	
	// 모달
	function ajaxCard(card_id){
	$.ajax({
		"url":"/jetstream/board/card_view.do",
		"type":"post",
		"data":"card_id=" + card_id,

		"success":function(data) {
			
			var html = $.parseHTML(data);
			var list = $(html).find('#ajax-board1')
			var list2 = $(html).find('#ajax-board2')
			$("#ajax-board1").html(list)
			$("#ajax-board2").html(list2)
            
		}
			
	});
	}
	
	
	
	
	// 날짜 선택기
	$(function() {
		$(".datepicker1, .datepicker2").datepicker({
			dateFormat : 'yy-mm-dd'
		});
	});

	// 카드 생성
	function addCard(pack_id) {
		$(".add-card-form").hide();
		$(".add-card-btn").show();
		$("#add-card-form-" + pack_id).show();
		$("#add-card-btn-" + pack_id).hide();
	}

	// 패키지 생성
	function addPack() {
		$("#add-pack-form").show();
		$("#add-pack-btn").hide();
	}

	// 모달 오픈
	function openCard(card_id) {
		$("#modal-" + card_id).modal()
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
		<div class="col-md-4 column">
			<div class="panel panel-default portlet">
				<div class="panel-heading portlet-header">
					<button type="button" class="close">
						<span class="fa fa-fw fa-gear"></span>
					</button>
					<span class="panel-title">${pack.list_nm} / ${pack.list_id}</span>
				</div>

				<div class="panel-body panel-group">

					<!-- 카드 반복 시작 -->
					<ul class="sortable list-unstyled connectedSortable">
						<c:forEach var="card" items="${cardList}">
							<!-- 리스트에 속한 카드만 뿌리기 -->
							<c:if test="${card.list_id eq pack.list_id}">
								<li>
									<div class="panel panel-default" id="${card.card_id}"
										onclick="javascript:openCard('${card.card_id}')">
										<div class="panel-heading">
											<p class="panel-title" style="clear: both;">
												<c:choose>
													<c:when test="${card.card_order eq '1'}">
														<span class="fa fa-fa fa-arrow-up square text-danger"></span>
													</c:when>
													<c:when test="${card.card_order eq '3'}">
														<span class="fa fa-fa fa-arrow-down square text-muted"></span>
													</c:when>
													<c:otherwise>
														<span class="fa fa-fa fa-arrow-right square text-success"></span>
													</c:otherwise>
												</c:choose>
												&nbsp;${card.card_nm}
											</p>
										</div>
									</div>
								</li>
								<!-- 카드 뷰 모달 시작 -->
								<div class="modal fade" id="modal-${card.card_id}" tabindex="-1" role="dialog" aria-labelledby="modal-${card.card_id}-label" aria-hidden="true">
									<div class="modal-dialog">
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal"
													aria-label="Close">
													<span aria-hidden="true">&times;</span>
												</button>
												<h4 class="modal-title" id="modal-${card.card_id}-label">${card.card_nm}</h4>
											</div>
											<div class="modal-body" id="modal-${card.card_id}-body">
												<div class="container-fluid">
													<fmt:parseDate var="cardStart" value="${card.card_start}"
														pattern="yyyy-MM-dd HH:mm:ss" />
													<fmt:parseDate var="cardDue" value="${card.card_due}"
														pattern="yyyy-MM-dd HH:mm:ss" />
													<fmt:formatDate var="cardStartDate" value="${cardStart}"
														type="date" pattern="yyyy-MM-dd" />
													<fmt:formatDate var="cardDueDate" value="${cardDue}"
														type="date" pattern="yyyy-MM-dd" />
													<div class="form-group col-md-6">
														<label class="control-label" for="card-start-${card.card_id}">Start Date</label>
														<input class="form-control datepicker1" id="card-start-${card.card_id}" name="card_start" type="text" value="${cardStartDate}">
													</div>
													<div class="form-group col-md-6">
														<label class="control-label" for="card-due-${card.card_id}">Due
															Date</label> <input class="form-control datepicker2"
															id="card-due-${card.card_id}" name="card_due" type="text"
															value="${cardDueDate}">
													</div>
													<div class="form-group col-md-12">
														<label class="control-label" for="card-txt-${card.card_id}">Description</label>
														<textarea class="form-control"
															id="card-txt-${card.card_id}" name="card_txt">${card.card_txt}</textarea>
													</div>
													<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
													<div class="form-group col-md-12">
														<label class="control-label"
															for="card-attach-${card.card_id}">File Attachment</label>
														<ul id="card-attach-${card.card_id}">
															<li><a href="#">파일명</a></li>
															<li><a href="#">파일명</a></li>
														</ul>
													</div>
													<div class="form-group col-md-12">
														<label class="control-label"
															for="checklist-${card.card_id}">Check List : 33%</label>
														<div id="checklist-${card.card_id}" class="progress" style="height: 5px;">
															<div class="progress-bar" role="progressbar" style="width: 33%; height: 5px;">
															</div>
														</div>
													</div>
												</div>
											</div>
											<div class="modal-footer bg-success">
												<button type="button" class="btn btn-default"
													data-dismiss="modal">Close</button>
												<button type="button" class="btn btn-primary">Send
													message</button>
											</div>
										</div>
									</div>
								</div>
								<!-- 카드뷰 모달 끝 -->
							</c:if>
						</c:forEach>
						<!-- card loop end -->
					</ul>
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