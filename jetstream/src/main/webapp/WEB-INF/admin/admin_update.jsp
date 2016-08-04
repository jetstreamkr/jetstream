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
						method="post" action="/jetstream/admin/memberupdate.do" enctype="multipart/form-data">
						
						<div class="form-group">
							<div class="col-sm-4 text-right">
								<label for="member_id" class="control-label">member_id</label>
							</div>
							<div class="col-sm-8">
								<input type="text" name="member_id" size="20"
									value="${memberInfo.member_id}" readonly="readonly">
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-4 text-right">
								<label for="member_id" class="control-label">email</label>
							</div>
							<div class="col-sm-8">
								<input type="text" name="email" size="20"
									value="${memberInfo.email}" readonly="readonly">
							</div>
						</div>
						
						<div class="form-group">
							<div class="col-sm-4 text-right">
								<label for="name" class="control-label">name</label>
							</div>
							<div class="col-sm-8">
								<input type="text" name="member_nm" size="20"
									value="${memberInfo.member_nm}" readonly="readonly">
							</div>
						</div>
						
						<div class="form-group">
							<div class="col-sm-4 text-right">
								<label for="password" class="control-label">password</label>
							</div>
							<div class="col-sm-8">
								<input type="text" name="password" size="20"
									value="${memberInfo.password}">
							</div>
						</div>
						
						
						<div class="form-group">
							<div class="col-sm-4 text-right">
								<label for="member_st" class="control-label">member_st</label>
							</div>
							<div class="col-sm-8">
								<input type="text" name="member_st" size="20"
									value="${memberInfo.member_st}">
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