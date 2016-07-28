<%@ page language="java" contentType="text/html; charset=euc-kr" pageEncoding="euc-kr" session="true" import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<link rel="stylesheet" href="//code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" />
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script src="//code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script>
<script type="text/javascript">

	$(document).ready(function() {
		$("#add-pack-form").hide();
		$(".add-card-form").hide();
	});

    $(function() {
        $(".datepicker1, .datepicker2").datepicker({
            dateFormat: 'yy-mm-dd'
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
				<button type="button" class="close"><span class="fa fa-fw fa-gear"></span></button>
				<a class="panel-title" href="/jetstream/board/board_list.do?board_id=${pack.board_id}&list_id=${pack.list_id}">${pack.list_nm} ${pack.list_id}</a>
			</div>
			
			<div class="panel-body panel-group" id="accordion" role="tablist" aria-multiselectable="true">
			
				<!-- Card loop start -->
				<c:forEach var="card" items="${cardList}">
				<c:if test="${card.list_id eq pack.list_id}">
				<div class="panel panel-default">
					<div class="panel-heading" role="tab" id="heading-${card.card_id}" data-toggle="collapse" data-parent="#accordion" href="#card-${card.card_id}" aria-expanded="true" aria-controls="card-${card.card_id}">
						<p class="panel-title" style="clear:both;">
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
							<c:set var="today" value="<%= new java.util.Date() %>"/>
							
							<fmt:parseDate var="cardDue" value="${card.card_due}" pattern="yyyy-MM-dd HH:mm:ss"/>
							<fmt:formatDate var="now" value="${today}" pattern="yyyy-MM-dd" />
							<fmt:formatDate var="cardDueDate" value="${cardDue}" pattern="yyyy-MM-dd" />
 							${now} // ${cardDueDate}
 							
						</p>
					</div>
					<div id="card-${card.card_id}" class="panel-collapse collapse" role="tabpanel" aria-labelledby="heading-${card.card_id}">
						<div class="panel-body">
									<fmt:parseDate var="cardStart" value="${card.card_start}" pattern="yyyy-MM-dd HH:mm:ss"/>
									<fmt:parseDate var="cardDue" value="${card.card_due}" pattern="yyyy-MM-dd HH:mm:ss"/>
									<fmt:formatDate var="cardStartDate" value="${cardStart}" type="date" pattern="yyyy-MM-dd"/>
									<fmt:formatDate var="cardDueDate" value="${cardDue}" type="date" pattern="yyyy-MM-dd"/>

							<div class="form-group col-md-6">
								<label class="control-label" for="card-start-${card.card_id}">Start Date</label>
								<input class="form-control datepicker1" id="card-start-${card.card_id}" name="card_start" type="text" value="${cardStartDate}">
							</div>
							<div class="form-group col-md-6">
								<label class="control-label" for="card-due-${card.card_id}">Due Date</label>
								<input class="form-control datepicker2" id="card-due-${card.card_id}" name="card_due" type="text" value="${cardDueDate}">
							</div>
							<div class="form-group col-md-12">
								<label class="control-label" for="card-txt-${card.card_id}">Description</label>
								<textarea class="form-control" id="card-txt-${card.card_id}" name="card_txt">${card.card_txt}</textarea>
							</div>
							<div class="form-group col-md-12">
								<label class="control-label" for="card-attach-${card.card_id}">File Attachment</label>
								<ul id="card-attach-${card.card_id}">
									<li><a href="#">파일명</a></li>
									<li><a href="#">파일명</a></li>
								</ul>
							</div>
							<div class="form-group col-md-12">
								<label class="control-label" for="checklist-${card.card_id}">Check List : 33%</label>
					           <div id="checklist-${card.card_id}" class="progress" style="height:5px;">
              						<div class="progress-bar" role="progressbar" style="width: 33%; height:5px;"></div>
            					</div>
 								<div class="checkbox">
                    				<label><input type="checkbox">Remember me</label>
               					</div>
							</div>
						</div>
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
				</c:if>
				</c:forEach>
				<!-- card loop end -->
			</div>
			
			<!-- 카드생성 시작 -->
			<div class="panel-footer">
				<a id="add-card-btn-${pack.list_id}" class="add-card-btn" href="javascript:addCard('${pack.list_id}')">카드 생성</a>
				<form role="form" action="/jetstream/board/card_create.do" method="POST">
					<div id="add-card-form-${pack.list_id}" class="input-group add-card-form">
						<input class="form-control" id="card_nm" name="card_nm" placeholder="input" type="text">
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
						<input class="form-control" id="list_nm" name="list_nm" placeholder="input" type="text">
						<input type="hidden" id="board_id" name="board_id" value="${board.board_id}">
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