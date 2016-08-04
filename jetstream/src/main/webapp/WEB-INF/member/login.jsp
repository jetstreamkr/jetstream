<%@ page language="java" contentType="text/html; charset=euc-kr" pageEncoding="euc-kr"%>
		<div class="section">
			<div class="container">
				<div class="row">
					<div class="col-md-offset-3 col-md-6 col-md-offset-3">
						<h1>로그인</h1>
						<hr>
						<form class="form-horizontal" role="form" id="signInForm" action="login.do" method="post">
							<div class="form-group">
								<div class="col-sm-4 text-right">
									<label for="email" class="control-label">Email</label>
								</div>
								<div class="col-sm-8">
									<input type="email" class="form-control" id="email" name="email" placeholder="Email">
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-4 text-right">
									<label for="password" class="control-label">Password</label>
								</div>
								<div class="col-sm-8">
									<input type="password" class="form-control" id="password" name="password" placeholder="Password">
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-offset-4 col-sm-8">
									<button type="submit" class="btn btn-block btn-primary">Log in</button>
								</div>
							</div>
						</form>
						<div class="col-sm-offset-4 col-sm-8">
							<ul>
								<li>비밀번호를 잊으셨으면 <a href="/jetstream/find_pass.do">비밀번호 찾기</a></li>
								<li>계정이 없으시다면 <a href="/jetstream/signin.do">회원가입</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
