<nav class="navbar sticky-top navbar-expand-lg bg-body-tertiary">
	<div class="container-fluid">
		<a class="navbar-brand" href="accueil">Pharma<span
			class="text-success fw-bold">java</span></a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="accueil">Acceuil</a></li>

				<li class="nav-item"><a class="nav-link" href="https://wa.link/x8piof">Contacter-nous</a>
				</li>

				<li class="nav-item"><a class="nav-link" href="https://github.com/mahdibough6/pharmajava">A propos</a>
				</li>

			</ul>

			<% if (session.getAttribute("user") != null) { %>
			<a class="btn btn-danger" href="deconnexion">deconnexion</a>
			<% } else { %>
			<a class="btn btn-outline-primary me-2" href="login">se connecter</a>
			<a class="btn btn-primary" href="inscription">s'inscrire</a>
			<% } %>
		</div>
	</div>
</nav>