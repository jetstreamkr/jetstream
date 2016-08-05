<%@ page language="java" contentType="text/html; charset=euc-kr"
	pageEncoding="euc-kr"%>

	<script>
	var state;		
	function test() {
		$.ajax({
			"url":"check_id.do",
			"type":"post",
			"data":{"email":$("#email").val()},
			"dataType":"text",
			"success":success_run,
			"error":err_run
		});
	}
	
	function success_run(txt){				
		var obj = JSON.parse(txt);		
		state = obj.state;
		$("#checkId").html(obj.result);		
	}
	
	function err_run(obj,msg,statusMsg){
		alert("오류발생"+obj+msg+statusMsg);
	}
	
	function run(){
		if(!state){
			signInForm.submit();
		}else{
			alert("이미 사용중인 이메일입니다.")
		}
	}
	</script>

	<div class="section">
		<div class="container">
			<div class="row">
				<div class="col-md-offset-3 col-md-6 col-md-offset-3">
					<h1>회원가입</h1>
					<hr>
					<form class="form-horizontal" role="form" id="signInForm" name="signInForm"
						method="post" action="signin.do">
						<div class="form-group">
							<div class="col-sm-4 text-right">
								<label for="member_nm" class="control-label"
									contenteditable="true">Name</label>
							</div>
							<div class="col-sm-8">
								<input type="text" class="form-control" id="member_nm"
									name="member_nm" placeholder="Name">
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-4 text-right">
								<label for="email" class="control-label">Email</label>
							</div>
							<div class="col-sm-8">
								<input type="email" class="form-control" id="email" name="email" onkeyup="test()"
									placeholder="Email">
							</div>
							

						</div>
						<div class="form-group">
							<div class="col-sm-4 text-right">
							</div> 
							<div class="col-sm-8">
								<span id="checkId"></span>
							</div> 
						</div>

						<div class="form-group">
							<div class="col-sm-4 text-right">
								<label for="password" class="control-label">Password</label>
							</div>
							<div class="col-sm-8">
								<input type="password" class="form-control" id="password"
									name="password" placeholder="Password">
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-4 text-right">
								<label for="passwordConfirm" class="control-label">Password
									Confirm</label>
							</div>
							<div class="col-sm-8">
								<input type="password" class="form-control" id="passwordConfirm"
									name="passwordConfirm" placeholder="Password Confirm">
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-4 col-sm-8">
								<button type="submit" class="btn btn-block btn-success">Sign
									in</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>