<%@ page language="java" contentType="text/html; charset=euc-kr"
	pageEncoding="euc-kr" session="true" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

	<!-- ī�� �� ��� ���� -->
	<div class="modal fade" id="modal-card" tabindex="-1" role="dialog" aria-labelledby="modal-card-label" aria-hidden="true">
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
						<fmt:parseDate var="cardStart" value="${card.card_start}" pattern="yyyy-MM-dd HH:mm:ss" />
						<fmt:parseDate var="cardDue" value="${card.card_due}" pattern="yyyy-MM-dd HH:mm:ss" />
						<fmt:formatDate var="cardStartDate" value="${cardStart}" type="date" pattern="yyyy-MM-dd" />
						<fmt:formatDate var="cardDueDate" value="${cardDue}" type="date" pattern="yyyy-MM-dd" />
						
						<div class="form-group col-md-6">
							<label class="control-label" for="card--${card.card_id}">�����</label>
							<input class="form-control datepicker1" id="card-start-${card.card_id}" name="card_start" type="text" value="${cardStartDate}" placeholder="������ ����">
						</div>
						
						
						<div class="form-group col-md-3">
							<label class="control-label" for="card-start-${card.card_id}">������</label>
							<input class="form-control datepicker1" id="card-start-${card.card_id}" name="card_start" type="text" value="${cardStartDate}" placeholder="������ ����">
						</div>
						<div class="form-group col-md-3">
							<label class="control-label" for="card-due-${card.card_id}">������</label>
							<input class="form-control datepicker2" id="card-due-${card.card_id}" name="card_due" type="text" value="${cardDueDate}" placeholder="������ ����">
						</div>
						<div class="form-group col-md-12">
							<label class="control-label" for="card-txt-${card.card_id}">Description</label>
							<textarea class="form-control"
								id="card-txt-${card.card_id}" name="card_txt">${card.card_txt}</textarea>
						</div>
						<div class="form-group col-md-12">
							<label class="control-label"
								for="card-attach-${card.card_id}">File Attachment</label>
							<ul id="card-attach-${card.card_id}">
								<li><a href="#">���ϸ�</a></li>
								<li><a href="#">���ϸ�</a></li>
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
	<!-- ī��� ��� �� -->