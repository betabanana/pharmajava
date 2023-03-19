<%@ page language="java" %>
<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.Medicament"%>
<!DOCTYPE html>
<html>
<head>
<title>${ util.getNom_util()}</title>

<jsp:include page="/WEB-INF/views/components/cssLoader.jsp"></jsp:include>
<style>

#mb__btn__panier{
	width:60px;
	height:60px;
	background-color:#ff8000;
	position:fixed;
	bottom:10px;
	right:10px;
	border-radius:19px;
	padding:0.8em;
}
#mb__btn__panier i{
	font-size:30px;
}
#mb__num__panier{
	color:white;
	position:absolute;
	border-radius:8px;
	z-index:10;
	top:0;
	background-color:red;
	padding:0.1em 0.3em;
	right:0.2em;
	font-weight:bold;

}
.btn-pharma-panier{
	
	background-color:#ff8000;
}
</style>
	
</head>

<body>
	<jsp:include page="/WEB-INF/views/components/navbar.jsp" />
	<div class="container">
		<form class="d-flex py-3" action="ServletAcceuil" method="post">
			<input type="text" name="motCle" class="flex-grow-1 me-2 form-control"
				placeholder="search" />
			<input type="submit" class="btn btn-success" value="search">
		</form>
	</div>
	<div class="container">
		<div
			class="row row-cols row-cols-sm-1 row-cols-md-2 row-cols-lg-3 gy-3 mt-3">
			<% List<Medicament> meds = (List<Medicament>) request.getAttribute("meds"); %>
			<c:forEach items="${meds}" var="med">
				<!-- start card -->
				<div class="col">
					<div class="card w-100" style="width: 18rem;">
						<img src="${med.getImage_med()}" class="card-img-top" alt="...">
						<div class="card-body">
							<h5 class="card-title">${med.getTitre_med()}</h5>
							<p class="card-text">${med.getDesc_med()}</p>
							<div class="row">
								<div class="col">
									<% if (session.getAttribute("user") != null) { %>
									<button class="btn btn-pharma-panier mb__ajouter__panier"
										data-id="${med.getId_med()}">
										<i class="fa-solid fa-cart-plus"></i> ajouter
									</button>
									<% } %>
								</div>
								<div class="col fw-bold px-2">
									${med.getPrix_med()} <span>MAD</span>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- end card -->
			</c:forEach>
		</div>
	</div>


	<!-- panier -->
	<% if (session.getAttribute("user") != null) { %>

<div id="mb__btn__panier" ><span id="mb__num__panier" data-qte="<%= request.getAttribute("qteComm")%>"></span><i class="fa-solid fa-basket-shopping"></i></div>
	<% } %>
<jsp:include page="/WEB-INF/views/components/jsLoader.jsp"></jsp:include>
<% // for specific scripting %>
<script>

	$(function (){

		var count = $("#mb__num__panier").data("qte");
		$("#mb__num__panier").html(count)
	})
$("#mb__btn__panier").on("click", function(event){
	window.location.href = 'panier'
});
$(document).ready($('.mb__ajouter__panier').on("click",function(event){
	var target = $(event.target);
	id_med = target.data("id");
	console.log(id_med);
	var count = $("#mb__num__panier").data("qte");
	count++;
	$("#mb__num__panier").html(count)
	$("#mb__num__panier").data("qte", count) ;
	$.post( "/pharmajava2/panier", { id_med: id_med } ).done(function (){
		//window.location.href = 'acceuil'
		/*
		qte.html(qteVal);

		if(qteVal == 0){
			$("#mb__qte__med").css("display","none");
		}
		*/





	});


}));

</script>
</body>
</html>