<%@ page language="java" contentType="text/html; charset=euc-kr"
	pageEncoding="euc-kr" session="true" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<style>
.sortable li {
	padding: 0.4em;
}

.sortable {
	padding: 1px;
}

.cardph { 
	height: 3em; line-height: 1.4em; margin:5px;
}

  .portlet-placeholder {
    border: 1px dotted black;
    margin: 0 1em 1em 0;
    height: 50px;
  }

</style>

<script type="text/javascript">

	$(document).ready(function() {
		$("#add-pack-form").hide();
		$(".add-card-form").hide();
		
		// 카드번호가 get으로 넘어왔을 경우 자동으로 해당 카드를 띄움
		if("${card_id}" != "" && "${card_id}" != "none") {
			ajaxCard("${card_id}")
		}
		
	});
	
	// ajax 모달 호출
	function ajaxCard(card_id){
		$.ajax({
			"url":"/jetstream/board/card_view.do",
			"type":"get",
			"data":"card_id=" + card_id,
			"success":function(data) {
				
				// card_view.jsp 삽입
				$("#modal-card-view").html(data);
				
				$("#modal-card").modal();
			}
		});
	}

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

	// 카드 순서 위치 변경
	$( function() {
	    $( ".sortable" ).sortable({
	      connectWith: ".connectedSortable",
    	  placeholder: "panel panel-warning cardph"
	    });

	    $( ".sortable" ).disableSelection();
	    
	  } );
	
	$( function() {
	
	    $( ".column" ).sortable({
	        connectWith: ".column",
	        placeholder: "portlet-placeholder ui-corner-all"
	      });
	  	  });	
</script>

<!-- 카드 뷰 모달 시작 -->
<div id="modal-card-view">
	<!-- card/card_view.jsp ajax 호출 -->
</div>
<!-- 카드뷰 모달 끝 -->

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
			<div class="panel panel-default">
				<div class="panel-heading portlet-header">
					<button type="button" class="close">
						<span class="fa fa-fw fa-gear"></span>
					</button>
					<span class="panel-title">${pack.list_nm}</span>
				</div>

				<div class="panel-body panel-group">

					<!-- 카드 반복 시작 -->
					<ul class="sortable list-unstyled connectedSortable">
						<c:forEach var="card" items="${cardList}">
							<!-- 리스트에 속한 카드만 뿌리기 -->
							<c:if test="${card.list_id eq pack.list_id}">
								<li>
									<div class="panel panel-default" id="${card.card_id}"
										onclick="javascript:ajaxCard('${card.card_id}')">
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
							</c:if>
						</c:forEach>
						<!-- card loop end -->
					</ul>
				</div>

				<!-- 카드생성 시작 -->
				<div class="panel-footer">
					<a id="add-card-btn-${pack.list_id}" class="add-card-btn" href="javascript:addCard('${pack.list_id}')">카드 생성</a>
					<form role="form" action="/jetstream/board/card_create.do" method="POST">
						<div id="add-card-form-${pack.list_id}" class="input-group add-card-form">
							<input type="text" id="card_nm" name="card_nm" class="form-control" placeholder="input">
							<input type="hidden" id="board_id" name="board_id" value="${board.board_id}">
							<input type="hidden" id="list_id" name="list_id" value="${pack.list_id}">
							<input type="hidden" id="member_id" name="member_id" value="${member.member_id}">
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
				<form role="form" action="/jetstream/board/pack_create.do" method="POST">
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
				<div id="add-pack-btn" class="panel-body btn-info text-center" onclick="javascript:addPack()">
					<span class="fa fa-fw fa-lg fa-plus"></span>
				</div>
		</div>
	</div>
	<!-- add pack end -->

</div>