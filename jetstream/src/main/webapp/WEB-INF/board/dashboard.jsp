<%@ page language="java" contentType="text/html; charset=euc-kr" pageEncoding="euc-kr" session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<head>
	<style type="text/css">
		#imagebox{
			position: relative;
			width: 300px;
			height: 100px;
			margin-left: auto;
			margin-right: auto;
		}
		#initial{
			color : white;
			position: absolute;
			top: 45px;
			left: 145px;
			z-index: 2;

		}
		#image{
			z-index: 1;
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
					<div class="panel-body">

						<!-- ���ã�� �ݺ� ���� -->
						<div class="col-md-12 panel panel-warning">
							<h3>JetStream Project 
								<small>
									<span class="label label-default">(��������)</span>
									<span class="label label-default">(��������)</span>
									<div class="btn-group btn-group-xs">
										<a href="#" class="btn btn-warning">
											<span class="fa fa-fw fa-star"></span>
										</a>
										<a href="#" class="btn btn-success">
											<span class="fa fa-fw fa-cog"></span>
										</a>
										<a href="#" class="btn btn-danger">
											<span class="fa fa-fw fa-close"></span>
										</a>
									</div>
								</small>
							</h3>
							<div class="progress progress-striped">
								<div class="progress-bar progress-bar-info" role="progressbar" style="width: 60%;">60% Complete</div>
							</div>
						</div>
						<!-- ���ã�� ����Ʈ �� -->

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
					<div class="panel-body">

						<%-- ���尡 ���� ��� --%>
						<c:choose>
							<c:when test="${fn:length(boardList) eq 0}">
								<p>���尡 �����ϴ�.</p>
							</c:when>
							<c:otherwise>
								<!-- ���帮��Ʈ �ݺ� ���� -->
								<c:forEach var="board" items="${boardList}">
									<div class="col-md-12 panel panel-default">
										<h3>
											<a href="board/board_main.do?board_id=${board.board_id}">${board.board_nm}</a>
											<small> <span class="label label-default">(��������)</span>
												<span class="label label-default">(��������)</span>
												<div class="btn-group btn-group-xs">
													<a href="#" class="btn btn-default"><span
														class="fa fa-fw fa-star-o"></span></a> 
													<a href="#"
														class="btn btn-success"><span class="fa fa-fw fa-cog"></span></a>
													<a href="board/board_close.do?board_id=${board.board_id}"
														class="btn btn-danger"><span class="fa fa-fw fa-close"></span></a>
												</div>
											</small>
										</h3>
										<div class="progress progress-striped">
											<div class="progress-bar progress-bar-info"
												role="progressbar" style="width: 60%;">60% Complete</div>
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
					<div id="imagebox">
						<img id="image" src="/jetstream/resources/images/${member.photo}"
							class="center-block img-circle img-responsive" width="100"
							height="100">
						<c:set var="photo" value="${member.photo}" />
						<c:if test="${photo eq 'default.png'}">
							<span id="initial" class="text-center text-muted">${member.member_init}</span>
						</c:if>
					</div>
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