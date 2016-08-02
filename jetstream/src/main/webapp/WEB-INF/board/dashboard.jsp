<%@ page language="java" contentType="text/html; charset=euc-kr" pageEncoding="euc-kr" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script type="text/javascript">
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
	
	// ���ã��
	
	var x

function fav(board_id){
	$.ajax({
		"url":"/jetstream/board/board_fav.do",
		"type":"POST",
		"data":"board_id="+board_id,
		//"datatype":"html",
		"success":function(data) {
			//console.log(data)
			var html = $.parseHTML(data);
			var list = $(html).find('#ajax-board1')
			var list2 = $(html).find('#ajax-board2')
			$("#favBoardList").html(list)
			$("#boardList").html(list2)
            
		}
			
	});
}
	
	
</script>


<head>
	<style type="text/css">
		#initial{
			color : white;
			position: absolute;
			top: 15px;
			right: 160px;
		}	
	</style>
</head>
<body>
<div class="section">
	<div class="container">
		<div class="row">
			<div class="col-md-8">

				<!-- ���ã�� �ڽ� ���� -->
				<div class="panel panel-primary">
					<div class="panel-heading">
						<h3 class="panel-title text-info">
							<span class="fa fa-star fa-fw"></span>���ã��
						</h3>
					</div>
					<div class="panel-body" id="favBoardList">

						<%-- ���尡 ���� ��� --%>
						<c:choose>
							<c:when test="${fn:length(favBoardList) eq 0}">
								<p>���ã�Ⱑ �����ϴ�.</p>
							</c:when>
							<c:otherwise>
								<!-- ���帮��Ʈ �ݺ� ���� -->
								<c:forEach var="board" items="${favBoardList}">
									<fmt:parseDate var="boardStart" value="${board.board_start}" pattern="yyyy-MM-dd HH:mm:ss" />
									<fmt:parseDate var="boardDue" value="${board.board_due}" pattern="yyyy-MM-dd HH:mm:ss" />
									<fmt:formatDate var="boardStartDate" value="${boardStart}" type="date" pattern="yyyy-MM-dd" />
									<fmt:formatDate var="boardDueDate" value="${boardDue}" type="date" pattern="yyyy-MM-dd" />
									<div class="col-md-12 panel panel-default">
										<h3>
											<a href="board/board_main.do?board_id=${board.board_id}">${board.board_nm}</a>
											<small> <span class="label label-default">${boardStartDate}</span>
												<span class="label label-default">${boardDueDate}</span>
												<div class="btn-group btn-group-xs">
													<c:choose>
														<c:when test="${board.board_fav eq 'Y'}">
															<a id="fav" class="btn btn-warning" onClick="fav('${board.board_id}');"><span class="fa fa-fw fa-star"></span></a>
														</c:when>
														<c:otherwise>
															<a id="fav" class="btn btn-default" onClick="fva('${board.board_id}');"><span class="fa fa-fw fa-star-o"></span></a>
														</c:otherwise>
													</c:choose>
													<a href="/jetstream/board/board_set.do?board_id=${board.board_id}" class="btn btn-success">
														<span class="fa fa-fw fa-cog"></span>
													</a>
													<a href="javascript:del('${board.board_id}')" class="btn btn-danger">
														<span class="fa fa-fw fa-close"></span>
													</a>
												</div>
											</small>
										</h3>
										<div class="progress progress-striped">
											<c:choose>
												<c:when test="${board.board_prog eq null}">
													<c:set var="board_prog_value" value="0" />
												</c:when>
												<c:otherwise>
													<c:set var="board_prog_value" value="${board.board_prog}" />
												</c:otherwise>
											</c:choose>
											<div class="progress-bar progress-bar-info"
												role="progressbar" style="width: ${board_prog_value}%;">${board_prog_value}% Complete</div>

										</div>
									</div>
								</c:forEach>
							</c:otherwise>
						</c:choose>
						<!-- ���帮��Ʈ �ݺ� �� -->

					</div>
				</div>
				<!-- ���ã�� �ڽ� �� -->

				<!-- �� ���� �ڽ� ���� -->
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">
							<span class="fa fa-fw fa-clipboard"></span>�� ����
						</h3>
					</div>
					<div class="panel-body" id="boardList">

						<%-- ���尡 ���� ��� --%>
						<c:choose>
							<c:when test="${fn:length(boardList) eq 0}">
								<p>���尡 �����ϴ�.</p>
							</c:when>
							<c:otherwise>
								<!-- ���帮��Ʈ �ݺ� ���� -->
								<c:forEach var="board" items="${boardList}">
									<fmt:parseDate var="boardStart" value="${board.board_start}" pattern="yyyy-MM-dd HH:mm:ss" />
									<fmt:parseDate var="boardDue" value="${board.board_due}" pattern="yyyy-MM-dd HH:mm:ss" />
									<fmt:formatDate var="boardStartDate" value="${boardStart}" type="date" pattern="yyyy-MM-dd" />
									<fmt:formatDate var="boardDueDate" value="${boardDue}" type="date" pattern="yyyy-MM-dd" />
									<div class="col-md-12 panel panel-default">
										<h3>
											<a href="board/board_main.do?board_id=${board.board_id}">${board.board_nm}</a>
											<small> <span class="label label-default">${boardStartDate}</span>
												<span class="label label-default">${boardDueDate}</span>
												<div class="btn-group btn-group-xs">
													<c:choose>
														<c:when test="${board.board_fav eq 'Y'}">
															<a id="fav" class="btn btn-warning" onClick="fav('${board.board_id}');"><span class="fa fa-fw fa-star"></span></a>
														</c:when>
														<c:otherwise>
															<a id="fav" class="btn btn-default" onClick="fva('${board.board_id}');"><span class="fa fa-fw fa-star-o"></span></a>
														</c:otherwise>
													</c:choose>
													<a href="/jetstream/board/board_set.do?board_id=${board.board_id}" class="btn btn-success">
														<span class="fa fa-fw fa-cog"></span>
													</a>
													<a href="javascript:del('${board.board_id}')" class="btn btn-danger">
														<span class="fa fa-fw fa-close"></span>
													</a>
												</div>
											</small>
										</h3>
										<div class="progress progress-striped">
											<c:choose>
												<c:when test="${board.board_prog eq null}">
													<c:set var="board_prog_value" value="0" />
												</c:when>
												<c:otherwise>
													<c:set var="board_prog_value" value="${board.board_prog}" />
												</c:otherwise>
											</c:choose>
											<div class="progress-bar progress-bar-info"
												role="progressbar" style="width: ${board_prog_value}%;">${board_prog_value}% Complete</div>

										</div>
									</div>
								</c:forEach>
							</c:otherwise>
						</c:choose>
						<!-- ���帮��Ʈ �ݺ� �� -->

					</div>
				</div>
				<!-- �� ���� �ڽ� �� -->

			</div>


			<div class="col-md-4">
				<!-- ������ �ڽ� ���� -->
				<div class="col-md-12 well well-sm">
					<img src="/jetstream/resources/images/${member.photo}"
						class="center-block img-circle img-responsive" width="100"
						height="100">
					<c:set var="photo" value="${member.photo}" />
					<c:if test="${photo eq 'default.png'}">
						<h1 id="initial" class="text-center text-muted">${initial}</h1>
					</c:if>
					<h4 class="text-center">${member.member_nm}</h4>
					<p class="text-center text-muted">${member.email}</p>
					<a class="btn btn-block btn-warning" href="memberupdate.do">��������</a>
				</div>
				<!-- ������ �ڽ� �� -->
				<button class="btn btn-block btn-lg btn-primary" data-toggle="modal"
					data-target="#createBoard">
					<span class="-square -square-o fa fa-fw fa-plus"></span>�������
				</button>
				<br>
				<!-- ��Ƽ��Ƽ �ڽ� ���� -->
				<div class="col-md-12 well well-sm">
					<ul>
						<!-- ��Ƽ��Ƽ �ݺ� ���� -->
						<li>��Ƽ��Ƽ</li>
						<!-- ��Ƽ��Ƽ �ݺ� �� -->
					</ul>
				</div>
				<!-- ��Ƽ��Ƽ �ڽ� �� -->
			</div>
		</div>
	</div>
</div>
<!-- ������� ��� ���� -->
<div class="modal fade" id="createBoard" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header bg-primary">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">��</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">�������</h4>
			</div>
			<div class="modal-body">
				<form role="form" action="board/board_create.do" method="POST">
					<div class="form-group">
						<label class="control-label" for="board_nm">������� �Է��ϼ���</label> <input
							class="form-control input-lg" id="board_nm" name="board_nm"
							placeholder="���� 3~20�� �̳�" type="text"> <input
							type="hidden" id="member_id" name="member_id"
							value="${member.member_id}" />
					</div>
					<div class="form-group">
						<button type="submit" class="btn btn-lg btn-block btn-info">�����!</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
<!-- ���� ���� ��� �� -->
</body>