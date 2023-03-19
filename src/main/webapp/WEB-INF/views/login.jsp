<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<jsp:include page="/WEB-INF/views/components/cssLoader.jsp"></jsp:include>
</head>
<body>
	<div class="container" style="max-width: 400px" />
	<form style="margin-top: 80px" action="login" method="post">

		<h1>
			Pharma<span class="text-success fw-bold ">java</span>
		</h1>
		<div class="mb-3">
			<label for="exampleInputEmail1" class="form-label">Adresse
				Email</label> <input type="email" name="emailUtil" class="form-control"
				id="exampleInputEmail1" aria-describedby="emailHelp">
			<div id="emailHelp" class="form-text">votre informations seront securiser</div>
		</div>
		<div class="mb-3">
			<label for="exampleInputPassword1" class="form-label">Mot de
				passe</label> <input type="password" name="pwdUtil" class="form-control"
				id="exampleInputPassword1">
		</div>
		<div class="mb-3 form-check">
			<input type="checkbox" class="form-check-input" id="exampleCheck1">
			<label class="form-check-label" for="exampleCheck1">Accepter les terms et les conditions</label>
		</div>
		<button type="submit" class="btn btn-primary">Submit</button>
	</form>
	</div>


<jsp:include page="/WEB-INF/views/components/jsLoader.jsp"></jsp:include>
</body>
</html>