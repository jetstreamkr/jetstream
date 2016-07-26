<%@ page language="java" contentType="text/html; charset=euc-kr" pageEncoding="euc-kr" session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

	<div class="section">
		<div class="container">
			<div class="row">
				<div class="col-md-8">
				
					<!-- ���ã�� �ڽ� ���� -->
					<div class="panel panel-primary">
						<div class="panel-heading">
							<h3 class="panel-title text-info"><span class="fa fa-star fa-fw"></span>���ã��</h3>
						</div>
						<div class="panel-body">
						
							<!-- ���ã�� �ݺ� ���� -->
							<div class="col-md-12 panel panel-warning">
								<h3>JetStream Project 
									<small> 
										<span class="label label-default">(��������)</span>
										<span class="label label-default">(��������)</span>
										<div class="btn-group btn-group-xs">
											<a href="#" class="btn btn-warning"><span class="fa fa-fw fa-star"></span></a>
											<a href="#" class="btn btn-success"><span class="fa fa-fw fa-cog"></span></a>
											<a href="#" class="btn btn-danger"><span class="fa fa-fw fa-close"></span></a>
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
							<h3 class="panel-title"><span class="fa fa-fw fa-clipboard"></span>�� ����</h3>
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
								<h3>${board.boardName}
									<small> 
										<span class="label label-default">(��������)</span>
										<span class="label label-default">(��������)</span>
										<div class="btn-group btn-group-xs">
											<a href="#" class="btn btn-default"><span class="fa fa-fw fa-star-o"></span></a>
											<a href="#" class="btn btn-success"><span class="fa fa-fw fa-cog"></span></a>
											<a href="#" class="btn btn-danger"><span class="fa fa-fw fa-close"></span></a>
										</div>
									</small>
								</h3>
								<div class="progress progress-striped">
									<div class="progress-bar progress-bar-info" role="progressbar" style="width: 60%;">60% Complete</div>
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
						<img src="https://pbs.twimg.com/profile_images/553572195390091265/IeHWVVMX.png"
							class="center-block img-circle img-responsive" width="100" height="100">
						<h4 class="text-center">${member.name}</h4>
						<p class="text-center text-muted">${member.email}</p>
						<a class="btn btn-block btn-warning" href="#">��������</a>
					</div>
					<!-- ������ �ڽ� �� -->
					<button class="btn btn-block btn-lg btn-primary" data-toggle="modal" data-target="#createBoard">
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
	<div class="modal fade" id="createBoard" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header bg-primary">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">��</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">�������</h4>
				</div>
				<div class="modal-body">
					<form role="form" action="board/boardCreate.do" method="POST">
						<div class="form-group">
							<label class="control-label" for="boardName">������� �Է��ϼ���</label>
							<input class="form-control input-lg" id="boardName" name="boardName" placeholder="���� 3~20�� �̳�" type="text">
			
							<input type="hidden" id="boardID" name="boardID" value="" />
							
							<input type="hidden" id="boardPermission" name="boardPermission" value="public" />
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

</html>