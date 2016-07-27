<%@ page language="java" contentType="text/html; charset=euc-kr" pageEncoding="euc-kr" session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<script type="text/javascript">

	$(document).ready(function() {
		$("#add-pack-form").hide();
		$(".add-card-form").hide();
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
						<p class="panel-title" style="clear:both;">${card.card_nm}${card.list_id}</p>
					</div>
					<div id="card-${card.card_id}" class="panel-collapse collapse" role="tabpanel" aria-labelledby="heading-${card.card_id}">
						<div class="panel-body">
							Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident. Ad vegan excepteur butcher vice lomo. Leggings occaecat craft beer farm-to-table, raw denim aesthetic synth nesciunt you probably haven't heard of them accusamus labore sustainable VHS.
						</div>
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