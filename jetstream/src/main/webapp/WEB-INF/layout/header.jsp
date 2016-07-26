<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR" session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<div class="navbar navbar-default navbar-inverse navbar-static-top navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="/jetstream/dashboard.do"><span>JetStream</span></a>
			</div>
			<div class="collapse navbar-collapse" id="navbar-ex-collapse">
				<c:if test="${sessionScope.member.email != null}">
					<form class="navbar-form navbar-left" role="search" action="">
						<div class="form-group">
							<div class="input-group">
								<input type="search" class="form-control" placeholder="Search">
								<span class="input-group-btn"> <a class="btn btn-success" type="submit"><span class="fa fa-fw fa-search"></span>Search</a>
								</span>
							</div>
						</div>
					</form>
				</c:if>
				<ul class="nav navbar-nav navbar-right">
					<c:choose>
						<c:when test="${sessionScope.member.email != null}">
							<li class="active"><a href="#"><b>${member.member_nm}(${member.email})님 <span class="fa fa-fw fa-heart text-danger"></span></b></a></li>
							<li><a href="/jetstream/logout.do">로그아웃</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="/jetstream/signin.do">회원가입</a></li>
							<li><a href="/jetstream/login.do">로그인</a></li>
						</c:otherwise>
					</c:choose>
				</ul>
			</div>
		</div>
	</div>