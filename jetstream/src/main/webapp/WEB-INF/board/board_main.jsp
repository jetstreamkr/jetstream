<%@ page language="java" contentType="text/html; charset=euc-kr"
	pageEncoding="euc-kr" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="col-md-11">
	<!-- �������� ���� -->
	<div class="col-md-12">
		<h1>${board.board_nm}</h1>
		<ol class="list-inline lead">
              <li>������ : ${board.board_start}</li>
              <li>������ : ${board.board_due}</li>
              <li>Three</li>
            </ol>
		<div class="progress">
			<div class="progress-bar progress-bar-success" role="progressbar"
				style="width: 40%">Free Space</div>
			<div class="progress-bar progress-bar-warning" role="progressbar"
				style="width: 10%">Warning</div>
			<div class="progress-bar progress-bar-danger" role="progressbar"
				style="width: 20%">Danger</div>
		</div>
		<hr/>
	</div>
	<!-- �������� �� -->

	<!-- �� ī�� ��� ���� -->
	<div class="col-md-6">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">
					<span class="fa fa-fw fa-clipboard"></span>���� �� �տ� ��ģ ī�� ���
				</h3>
			</div>
			<table class="table table-condensed">
				<tbody>
					<c:forEach var="card" items="${cardList}">
						<tr>
							<td><c:choose>
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
							<td><fmt:parseDate var="cardDue" value="${card.card_due}"
									pattern="yyyy-MM-dd HH:mm:ss" /> <fmt:formatDate
									var="cardDueDate" value="${cardDue}" type="date"
									pattern="yyyy-MM-dd" /> ${cardDueDate}</td>
							<td>${card.list_nm}</td>
							<td>${card.card_nm}</td>
						</tr>
					</c:forEach>
					<!-- ī��ݺ� �� -->
				</tbody>
			</table>
		</div>
	</div>
	<!-- ī�� ��� �� -->
	<!-- ����Ʈ ��� ���� -->
	<div class="col-md-6">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">����Ʈ ���</h3>
			</div>
			<div id="test" class="panel-body">ī�峻��</div>
		</div>
	</div>
	<!-- ī�� ������ �� -->

</div>
