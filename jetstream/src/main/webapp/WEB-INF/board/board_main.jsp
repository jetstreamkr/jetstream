<%@ page language="java" contentType="text/html; charset=euc-kr"
	pageEncoding="euc-kr" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="col-md-11">
	<!-- 보드정보 시작 -->
	<div class="col-md-12">
		<h1>${board.board_nm}</h1>
		<ol class="list-inline lead">
		<fmt:parseDate var="boardStart" value="${board.board_start}" pattern="yyyy-MM-dd HH:mm:ss" />
		<fmt:formatDate var="boardStartDate" value="${boardStart}" type="date" pattern="yyyy-MM-dd" />
		<fmt:parseDate var="boardDue" value="${board.board_due}" pattern="yyyy-MM-dd HH:mm:ss" />
		<fmt:formatDate var="boardDueDate" value="${boardDue}" type="date" pattern="yyyy-MM-dd" />
              <li>시작일 : ${boardStartDate}</li>
              <li>종료일 : ${boardDueDate}</li>
            </ol>
            <c:set var="sum" value="0"/>
           	<c:forEach var="prog" items="${progressList}">
           		<c:set var="sum" value="${sum + prog.total}"/>
           	</c:forEach>
		<div class="progress">
			<c:forEach var="prog" items="${progressList}" varStatus="i">
				<c:choose>
					<c:when test="${i.index eq '1'}">
						<c:set var="color" value="success" />
					</c:when>
					<c:when test="${i.index eq '2'}">
						<c:set var="color" value="primary" />
					</c:when>
					<c:when test="${i.index eq '3'}">
						<c:set var="color" value="info" />
					</c:when>
					<c:when test="${i.index eq '4'}">
						<c:set var="color" value="warning" />
					</c:when>
					<c:when test="${i.index eq '5'}">
						<c:set var="color" value="danger" />
					</c:when>
				</c:choose>
					<fmt:formatNumber var="per" value="${prog.done / sum * 100}" pattern=".00"/>
				<div class="progress-bar progress-bar-${color}" role="progressbar" style="width: ${per}%">${prog.list_nm} : ${per}%</div>
			</c:forEach>
		</div>
		<hr/>
	</div>
	<!-- 보드정보 끝 -->

	<!-- 내 카드 목록 시작 -->
	<div class="col-md-6">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">
					<span class="fa fa-fw fa-clipboard"></span>당장 눈 앞에 닥친 카드 목록
				</h3>
			</div>
			<table class="table table-condensed table-striped">
				<thead>
					<tr>
						<td>#</td>
						<td>완료일</td>
						<td>리스트명</td>
						<td>카드명</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="card" items="${cardList}">
						<tr>
							<td class="col-md-1"><c:choose>
									<c:when test="${card.card_order eq '1'}">
										<span class="fa fa-fa fa-arrow-up square text-danger"></span>
									</c:when>
									<c:when test="${card.card_order eq '3' }">
										<span class="fa fa-fa fa-arrow-down square text-muted"></span>
									</c:when>
									<c:otherwise>
										<span class="fa fa-fa fa-arrow-right square text-success"></span>
									</c:otherwise>
								</c:choose></td>
							<td class="col-md-3"><fmt:parseDate var="cardDue" value="${card.card_due}"
									pattern="yyyy-MM-dd HH:mm:ss" /> <fmt:formatDate
									var="cardDueDate" value="${cardDue}" type="date"
									pattern="yyyy-MM-dd" /> ${cardDueDate}</td>
							<td class="col-md-4">${card.list_nm}</td>
							<td class="col-md-4"><a href="/jetstream/board/board_list.do?board_id=${board.board_id}&card_id=${card.card_id}">
								${card.card_nm}</a>
							</td>
						</tr>
					</c:forEach>
					<!-- 카드반복 끝 -->
				</tbody>
			</table>
		</div>
	</div>
	<!-- 카드 목록 끝 -->
	<!-- 리스트 목록 시작 -->
	<div class="col-md-6">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">리스트 목록</h3>
			</div>
			<div class="panel-body">
				<c:forEach var="prog" items="${progressList}">
					<h3>${prog.list_nm}</h3>
					<div class="progress">
						<div class="progress-bar progress-bar-warning" role="progressbar" style="width: ${prog.done / prog.total * 100}%">${prog.done / prog.total * 100} %</div>
					</div>
				</c:forEach>
			
			</div>
		</div>
	</div>
	<!-- 카드 디테일 끝 -->

</div>
