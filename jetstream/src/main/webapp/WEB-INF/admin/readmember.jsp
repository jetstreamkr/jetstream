<%@ page language="java" contentType="text/html; charset=euc-kr"
	pageEncoding="euc-kr" session="true" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<title>Insert title here</title>
<!-- 참고 부트스닙 http://bootsnipp.com/snippets/KBNdD -->
</head>
<body>
	<div class="container">

		<div class="row col-md-10 col-md-offset-1 custyle">
			<h3>member Count : ${fn:length(readMember)}</h3>
			<table class="table table-striped custab">
				<thead>
					<a href="add.do" class="btn btn-primary btn-xs pull-right"><b>+</b>
						Add new Member</a>
					<tr>
						<th>ID</th>
						<th>Email</th>
						<th data-hide="phone,tablet">P.W</th>
						<th>Name</th>
						<th data-hide="phone,tablet">Photo</th>
						<th>State</th>
						<th>SignDate</th>
						<th class="text-center">Action</th>
					</tr>
				</thead>
				<c:forEach var="member" items="${readMember}">
					<tr>
						<td><a href="#">${member.member_id}</a></td>
						<td>${member.email}</td>
						<td>${member.password}</td>
						<td>${member.member_nm}</td>
						<td>${member.photo}</td>
						<td>${member.member_st}</td>
						<td>${member.member_dt}</td>
						<td class="text-center"><a class='btn btn-info btn-xs'
							href="/jetstream/admin/update.do?member_id=${member.member_id}"><span
								class="glyphicon glyphicon-edit"></span> Edit</a> <a href="#"
							class="btn btn-danger btn-xs"><span
								class="glyphicon glyphicon-remove"></span> Del</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>