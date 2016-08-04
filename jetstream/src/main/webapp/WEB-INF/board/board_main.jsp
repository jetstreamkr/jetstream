<%@ page language="java" contentType="text/html; charset=euc-kr" pageEncoding="euc-kr" session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
		<div class="col-md-11">
			<!-- 보드정보 시작 -->
			<div class="col-md-12">
				<h1>${board.board_nm}</h1>
				<hr>
				<h3></h3>
			</div>
			<!-- 보드정보 끝 -->

			<!-- 내 카드 목록 시작 -->
			<div class="col-md-8">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title"><span class="fa fa-fw fa-clipboard"></span>당장 눈 앞에 닥친 카드 목록
						</h3>
					</div>
					<table class="table table-condensed">
						<tbody>
							<c:forEach var="card" items="${cardList}">
							<tr>
								<td>
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
								</td>
								<td>
									<fmt:parseDate var="cardDue" value="${card.card_due}" pattern="yyyy-MM-dd HH:mm:ss"/>
									<fmt:formatDate var="cardDueDate" value="${cardDue}" type="date" pattern="yyyy-MM-dd"/>
									${cardDueDate}
								</td>
								<td>${card.list_nm}</td>
								<td>${card.card_nm}</td>
							</tr>
							</c:forEach>
							<!-- 카드반복 끝 -->
						</tbody>
					</table>
				</div>
			</div>
			<!-- 카드 목록 끝 -->
			<!-- 옆에서 클릭한 카드 디테일 시작 -->
			<div class="col-md-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">카드제목</h3>
					</div>
					<div id="test" class="panel-body">
						카드내용
					</div>
				</div>
			</div>
			<!-- 카드 디테일 끝 -->

		</div>
