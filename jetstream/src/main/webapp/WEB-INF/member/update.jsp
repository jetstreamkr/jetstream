<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
</head>
<body>
	
	<div class="section">
		<div class="container">
			<div class="row">
				<div class="col-md-offset-3 col-md-6 col-md-offset-3">
					<h1>회원수정</h1>
					<hr>
					<form class="form-horizontal" role="form"
						method="post" action="memberupdate.do" enctype="multipart/form-data">
						<div class="form-group">
							<div class="col-sm-4 text-right">
								<label for="email" class="control-label">email</label>
							</div>
							<div class="col-sm-8">
								<p>${member.email}</p>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-4 text-right">
								<label for="name" class="control-label">name</label>
							</div>
							<div class="col-sm-8">
								<input type="text" name="member_nm" size="20"
									value="${member.member_nm}">
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-4 text-right">
								<label for="prevpassword" class="control-label">prev
									password</label>
							</div>
							<div class="col-sm-8">
								<input type="password" name="prevpass" size="20">
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-4 text-right">
								<label for="password" class="control-label">password</label>
							</div>
							<div class="col-sm-8">
								<input type="password" name="pass" size="20">
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-4 text-right">
								<label for="file" class="control-label">Photo</label>
							</div>
							<div class="col-sm-8">
								<input type="file" id="file" name="file" size="50"
									class="form-control">
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-4 col-sm-8">
								<button type="submit" class="btn btn-block btn-success">수정</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	
</body>
</html>