<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<jsp:include page="components/cssLoader.jsp"/>
<title>Inscription</title>
</head>
<body>
	<div class="container mx-auto">
		<form class="row g-3 mx-auto" action="inscription" method="post" style="max-width: 700px;margin-top: 80px;">
			<div class="col-md-6">
				<label for="nomUtil" class="form-label">Nom</label> <input
					type="text" name="nomUtil" class="form-control" id="nomUtil">
			</div>
			<div class="col-md-6">
				<label for="prenomUtil" class="form-label">Prenom</label> <input
					type="text" name="prenomUtil" class="form-control" id="prenomUtil">
			</div>
			<div class="col-md-12">
				<label for="emailUtil" class="form-label">Email</label> <input
					type="email" name="emailUtil" class="form-control" id="inputEmail4">
			</div>
			<div class="col-md-12">
				<label for="pwdUtil" class="form-label">Mot de passe</label> <input
					type="password" class="form-control" name="pwdUtil" id="pwdUtil">
			</div>
			<div class="col-12">
				<label for="adresseUtil" class="form-label">Adresse</label> <input
					type="text" class="form-control" name="adresseUtil"
					id="adresseUtil" placeholder="1234 Main St">
			</div>


			<div class="col-md-8">
				<label for="inputCity" class="form-label">telephone</label> <input
					class="form-control" type="tel" id="phone" name="teleUtil"
					pattern="(06|05|07)[0-9]{8}" required> <small>Format:
					06 XX XX XX XX</small>
			</div>
			<div class="col-4">
				<label for="dateNaissUtil" class="form-label">date naissance</label>
				<input type="date" class="form-control" id="dateNaissUtil"
					name="dateNaissUtil" value="2001-05-22" min="1900-01-01"
					max="2007-01-01">
			</div>
			<div class="col-12">
				<div class="form-check">
					<input class="form-check-input" type="checkbox" id="gridCheck">
					<label class="form-check-label" for="gridCheck"> Check me
						out </label>
				</div>
			</div>
			<div class="col-12">
				<button type="submit" class="btn btn-primary">Sign in</button>
			</div>
		</form>
	</div>


	<jsp:include page="components/jsLoader.jsp"/>
</body>
</html>