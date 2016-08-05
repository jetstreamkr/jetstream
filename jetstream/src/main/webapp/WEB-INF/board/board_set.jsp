<%@ page language="java" contentType="text/html; charset=euc-kr"
	pageEncoding="euc-kr" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script>
	// ���� ���������� Ȯ��
	<c:forEach var="boardMember" items="${boardMemberList}">
		<c:if test="${boardMember.member_id eq member.member_id}">
			<c:if test="${boardMember.member_permit eq 'A'}">
				<c:set var="admin" value="A" />
			</c:if>
		</c:if>
	</c:forEach>

	$(document).ready(function() {
		
		
		var board_permit_val = "${board.board_permit}";
		if(board_permit_val == "O") {
			$("#board_permit_label_O").addClass("active");
			$("#board_permit_O").attr("checked", true);
			
		} else {
			$("#board_permit_label_C").addClass("active");
			$("#board_permit_C").attr("checked", true);
	
		}
		
		var member_permit_val = "${admin}";
		if(member_permit_val != 'A') {
			$("#btn-set, #btn-close, #btn-permit").addClass("disabled");
		}
		
		
		// ��¥���� �� ���̱�
		$(".datepicker1, .datepicker2").datepicker({
			dateFormat : 'yy-mm-dd'
		});
		
	
	});

	// Ŭ������� ����
	function copyToClipboard(element) {
		var $temp = $("<input>");
	  	$("body").append($temp);
	  	$temp.val($(element).val()).select();
	  	document.execCommand("copy");
	  	alert('Ŭ������� ����Ǿ����ϴ�');
	  	$temp.remove();
	}

	//������ �߿��ϴ� POST�� �ѱ�� ��ũ��Ʈ
	function del(board_id) {
	    if (confirm("�����Ͻðڽ��ϱ�?") == true) {
		    var delform = document.createElement("form");
		    delform.setAttribute("method", "POST");
		    delform.setAttribute("action", "/jetstream/board/board_close.do");
	        var field = document.createElement("input");
			field.setAttribute("type", "hidden");
			field.setAttribute("name", "board_id");
			field.setAttribute("value", board_id);
	        delform.appendChild(field);
		    document.body.appendChild(delform);
		    delform.submit();
	    } else {
	        alert('��ҵǾ����ϴ�.');
	    }
	}
	
	
	// ����˻���
	function memberSearchList() {
		$.ajax({
			"url":"/jetstream/board/board_member_search.do",
			"type":"GET",
			"data":"keyword=" + encodeURI(encodeURIComponent($("#memberSearchForm").val())),
			"success":function(data) {
				var html = $.parseHTML(data);
				var list = $(html).find('#search-list');
				$("#search-list").html(list);
			}				
		});
		
	}
	
	// ����߰�
	function addMember(member_id) {
		$.ajax({
			"url":"/jetstream/board/board_member_add.do",
			"type":"POST",
			"data":"member_id=" + member_id + "&board_id=${board.board_id}",
			"success":function(data) {
				var html = $.parseHTML(data);
				var list = $(html).find('#member-list-view');
				$("#member-list-view").html(list);
			}				
		});
	}

	// ��� ���� ����
	function setMemberPermit(member_permit, member_id) {
		$.ajax({
			"url":"/jetstream/board/board_member_set.do",
			"type":"POST",
			"data":"member_id=" + member_id + "&member_permit=" + member_permit + "&board_id=${board.board_id}",
			"success":function(data) {
				var html = $.parseHTML(data);
				var list = $(html).find('#member-list-view');
				$("#member-list-view").html(list);
			}				
		});
	}
	
	// ��� ����
	function closeMember(member_id) {
	    if (confirm("�����ðڽ��ϱ�?") == true) {
			$.ajax({
				"url":"/jetstream/board/board_member_set.do",
				"type":"POST",
				"data":"member_id=" + member_id + "&member_permit=C&board_id=${board.board_id}",
				"success":function(data) {
					var html = $.parseHTML(data);
					var list = $(html).find('#member-list-view');
					$("#member-list-view").html(list);
				}
			});
	    } else {
	        alert('��ҵǾ����ϴ�.');
	    }
	}
	
</script>

<div class="col-md-11">
	<!-- �������� ���� -->
	<div class="col-md-12">
		<h1>${board.board_nm}</h1>
		<hr>
		<h3></h3>
	</div>
	<!-- �������� �� -->

	<!-- ���弳�� ���� -->
	<div class="col-md-4">
		<div class="panel panel-default">
			<div class="panel-heading">
				<span class="panel-title">���� ����</span>
			</div>
			<div class="panel-body">
				<form role="form" action="/jetstream/board/board_set.do" method="POST">
					<div class="form-group col-md-12">
						<label class="control-label" for="board_nm">�����̸�</label>
						<input class="form-control" id="board_nm" name="board_nm" placeholder="���� �̸�(���� 30��, �ѱ� 20�� �̳�)" type="text" value="${board.board_nm}">
					</div>
					<div class="form-group col-md-12">
						<label class="control-label" for="board_uri">���� URI</label>
						<div class="input-group">
							<input class="form-control" id="board_uri" name="board_uri" placeholder="���� URI" type="text" value="${board.board_uri}" disabled>
							<span class="input-group-btn"> <a class="btn btn-info" type="button" href="javascript:copyToClipboard('#board_uri')"><span class="fa fa-fw fa-clipboard"></span>Ŭ������� ����</a></span>
						</div>
					</div>
					<div class="form-group col-md-12">
						<label class="control-label">���� ����</label>
						<div class="input-group">
							<div class="btn-group btn-group-justified" data-toggle="buttons">
								<label id="board_permit_label_O" class="btn btn-default">
			    					<input type="radio" name="board_permit" id="board_permit_O" value="O" autocomplete="off"><span class="fa fa-fw fa-unlock"></span>���� ����
								</label>
								<label id="board_permit_label_C" class="btn btn-default">
			    					<input type="radio" name="board_permit" id="board_permit_C" value="C" autocomplete="off"><span class="fa fa-fw fa-lock"></span>���� �����
								</label>
							</div>
						</div>
					</div>
					<fmt:parseDate var="boardStart" value="${board.board_start}" pattern="yyyy-MM-dd HH:mm:ss" />
					<fmt:parseDate var="boardDue" value="${board.board_due}" pattern="yyyy-MM-dd HH:mm:ss" />
					<fmt:formatDate var="boardStartDate" value="${boardStart}" type="date" pattern="yyyy-MM-dd" />
					<fmt:formatDate var="boardDueDate" value="${boardDue}" type="date" pattern="yyyy-MM-dd" />
			
					<div class="form-group col-md-6">
						<label class="control-label" for="board_start">������</label>
						<input class="form-control datepicker1" id="board_start" name="board_start" type="text" value="${boardStartDate}" placeholder="������ ����">
					</div>
					<div class="form-group col-md-6">
						<label class="control-label" for="board_due">������</label>
						<input class="form-control datepicker2" id="board_due" name="board_due" type="text" value="${boardDueDate}" placeholder="������ ����">
					</div>
					<div class="form-group col-md-12">
						<input type="hidden" id="board_id" name="board_id" value="${board.board_id}">
						<button type="submit" id="btn-set" class="btn btn-block btn-warning btn-lg">�����ϱ�</button>
						<a id="btn-close" href="javascript:del('${board.board_id}')" class="btn btn-block btn-danger btn-lg">�����ϱ�</a>
						
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- ���� ���� �� -->
	
	<!-- set ��� ���� -->
	<div class="col-md-4">
		<div class="panel panel-default">
			<div class="panel-heading">
				<span class="panel-title">��� ����</span>
			</div>
			<div id="member-list-view">
			<div class="panel-body">
				<div class="form-group col-md-12">
					<label class="control-label">��� ��� : ${fn:length(boardMemberList)}��</label>
					<ul class="media-list">
						<c:forEach var="boardMember" items="${boardMemberList}">
							<li class="media">
								<a class="pull-left" href="#"><img class="img-circle media-object" src="/jetstream/resources/images/${boardMember.photo}" height="50" width="50"></a>
								<div class="media-body">
									<div class="col-md-8">
										<h4 class="media-heading">${boardMember.member_nm}</h4>
										<p class="text-muted">${boardMember.email}</p>
									</div>
									<div class="col-md-4">
										<div class="btn-group">
										<c:choose>
										<c:when test="${boardMember.member_permit eq 'A'}">
											<a href="javascript:setMemberPermit('O', '${boardMember.member_id}')" id="btn-permit" class="btn btn-warning btn-xs"><span class="fa fa-fw fa-key"></span></a>
										</c:when>
										<c:otherwise>
											<a href="javascript:setMemberPermit('A', '${boardMember.member_id}')" id="btn-permit" class="btn btn-default btn-xs"><span class="fa fa-fw fa-child"></span></a>
										</c:otherwise>
										</c:choose>
										<c:if test="${admin eq 'A' || member.member_id eq boardMember.member_id}">
											<a href="javascript:closeMember('${boardMember.member_id}')" class="btn btn-danger btn-xs"><span class="fa fa-fw fa-close"></span></a>
										</c:if>
										</div>
									</div>
								</div>
							</li>
						</c:forEach>
					</ul>
				</div>
				<div class="form-group has-success col-md-12">
					<div class="input-group dropdown">
						<input class="form-control" id="memberSearchForm" name="keyword" onkeyup="memberSearchList()" placeholder="��� �˻�(�̸�, E-Mail)" type="text"
							data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
						<span class="input-group-btn">
							<a class="btn btn-success" type="button" href="javascript:memberSearchList()"><span class="fa fa-fw fa-search"></span>��� �˻�</a>
						</span>
						<ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
							<li class="dropdown-header">�˻� ���</li>
							<div id="search-list">
							</div>
						</ul>
					</div>
				</div>
			</div>
			</div>
		</div>		
	</div>
	<!-- set ��� �� -->	
</div>
