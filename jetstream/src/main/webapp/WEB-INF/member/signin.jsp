<%@ page language="java" contentType="text/html; charset=euc-kr" pageEncoding="euc-kr"%>

		<div class="section">
			<div class="container">
				<div class="row">
					<div class="col-md-offset-3 col-md-6 col-md-offset-3">
						<h1>ȸ������</h1>
						<hr>
						<form class="form-horizontal" role="form" id="signInForm" method="post" action="signin.do">
							<div class="form-group">
								<div class="col-sm-4 text-right">
									<label for="name" class="control-label" contenteditable="true">Name</label>
								</div>
								<div class="col-sm-8">
									<input type="text" class="form-control" id="name" name="name" placeholder="Name">
								</div>
							</div>
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
								<div class="col-sm-4 text-right">
									<label for="passwordConfirm" class="control-label">Password Confirm</label>
								</div>
								<div class="col-sm-8">
									<input type="password" class="form-control" id="passwordConfirm" name="passwordConfirm" placeholder="Password Confirm">
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-offset-4 col-sm-8">
									<button type="submit" class="btn btn-block btn-success">Sign in</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>