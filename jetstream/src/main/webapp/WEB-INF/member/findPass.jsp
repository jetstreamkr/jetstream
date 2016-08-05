<%@ page language="java" contentType="text/html; charset=euc-kr" pageEncoding="euc-kr"%>
		<div class="section">
			<div class="container">
				<div class="row">
					<div class="col-md-offset-3 col-md-6 col-md-offset-3">
						<h1>비밀번호 찾기</h1>
						<hr>
						<form class="form-horizontal" role="form" id="signInForm" action="sendPassEmail.do" method="post">
							<div class="form-group">
								<div class="col-sm-4 text-right">
									<label for="email" class="control-label">Email</label>
								</div>
								<div class="col-sm-8">
									<input type="email" class="form-control" id="email" name="email" placeholder="가입하신 이메일">
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-offset-4 col-sm-8">
									<button type="submit" class="btn btn-block btn-primary">보내기</button>
								</div>
							</div>
						</form>
						<div class="col-sm-offset-4 col-sm-8">
							<ul style="list-style: none;">
								<li>가입하신 이메일을 통해 비밀번호를 안내해드립니다.</li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
