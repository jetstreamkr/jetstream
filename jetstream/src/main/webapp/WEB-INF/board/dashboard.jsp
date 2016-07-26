<%@ page language="java" contentType="text/html; charset=euc-kr" pageEncoding="euc-kr" session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

	<div class="section">
		<div class="container">
			<div class="row">
				<div class="col-md-8">
				
					<!-- 즐겨찾기 박스 시작 -->
					<div class="panel panel-primary">
						<div class="panel-heading">
							<h3 class="panel-title text-info"><span class="fa fa-star fa-fw"></span>즐겨찾기</h3>
						</div>
						<div class="panel-body">
						
							<!-- 즐겨찾기 반복 시작 -->
							<div class="col-md-12 panel panel-warning">
								<h3>JetStream Project 
									<small> 
										<span class="label label-default">(시작일자)</span>
										<span class="label label-default">(종료일자)</span>
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
							<!-- 즐겨찾기 리스트 끝 -->
							
						</div>
					</div>
					<!-- 즐겨찾기 박스 끝 -->
					
					<!-- 내 보드 박스 시작 -->	
					<div class="panel panel-default">
						<div class="panel-heading">
							<h3 class="panel-title"><span class="fa fa-fw fa-clipboard"></span>내 보드</h3>
						</div>
						<div class="panel-body">
												
							<%-- 보드가 없을 경우 --%>
							<c:choose>
							<c:when test="${fn:length(boardList) eq 0}">
								<p>보드가 없습니다.</p>
							</c:when>
							<c:otherwise>
							<!-- 보드리스트 반복 시작 -->
							<c:forEach var="board" items="${boardList}">
							<div class="col-md-12 panel panel-default">
								<h3>${board.boardName}
									<small> 
										<span class="label label-default">(시작일자)</span>
										<span class="label label-default">(종료일자)</span>
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
							<!-- 보드리스트 반복 끝 -->
							
						</div>
					</div>
					<!-- 내 보드 박스 끝 -->	
					
				</div>
				
				
				<div class="col-md-4">
					<!-- 프로필 박스 시작 -->
					<div class="col-md-12 well well-sm">
						<img src="https://pbs.twimg.com/profile_images/553572195390091265/IeHWVVMX.png"
							class="center-block img-circle img-responsive" width="100" height="100">
						<h4 class="text-center">${member.name}</h4>
						<p class="text-center text-muted">${member.email}</p>
						<a class="btn btn-block btn-warning" href="#">정보수정</a>
					</div>
					<!-- 프로필 박스 끝 -->
					<button class="btn btn-block btn-lg btn-primary" data-toggle="modal" data-target="#createBoard">
						<span class="-square -square-o fa fa-fw fa-plus"></span>보드생성
					</button>
					<br>
					<!-- 액티비티 박스 시작 -->
					<div class="col-md-12 well well-sm">
						<ul>
							<!-- 액티비티 반복 시작 -->
							<li>액티비티</li>
							<!-- 액티비티 반복 끝 -->
						</ul>
					</div>
					<!-- 액티비티 박스 끝 -->
				</div>
			</div>
		</div>
	</div>
	<!-- 보드생성 모달 시작 -->
	<div class="modal fade" id="createBoard" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header bg-primary">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">×</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">보드생성</h4>
				</div>
				<div class="modal-body">
					<form role="form" action="board/boardCreate.do" method="POST">
						<div class="form-group">
							<label class="control-label" for="boardName">보드명을 입력하세요</label>
							<input class="form-control input-lg" id="boardName" name="boardName" placeholder="영문 3~20자 이내" type="text">
			
							<input type="hidden" id="boardID" name="boardID" value="" />
							
							<input type="hidden" id="boardPermission" name="boardPermission" value="public" />
						</div>
						<div class="form-group">
							<button type="submit" class="btn btn-lg btn-block btn-info">만들기!</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- 보드 생성 모달 끝 -->
</body>

</html>