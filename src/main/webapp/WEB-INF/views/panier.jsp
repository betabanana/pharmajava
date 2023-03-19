<%@ page import="model.Medicament" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<jsp:include page="/WEB-INF/views/components/cssLoader.jsp" />
<title>panier</title>
<style>
@media (min-width: 1025px) {
.h-custom {
height: 100vh !important;
}
}

.card-registration .select-input.form-control[readonly]:not([disabled]) {
font-size: 1rem;
line-height: 2.15;
padding-left: .75em;
padding-right: .75em;
}

.card-registration .select-arrow {
top: 13px;
}

.bg-grey {
background-color: #eae8e8;
}

@media (min-width: 992px) {
.card-registration-2 .bg-grey {
border-top-right-radius: 16px;
border-bottom-right-radius: 16px;
}
}

@media (max-width: 991px) {
.card-registration-2 .bg-grey {
border-bottom-left-radius: 16px;
border-bottom-right-radius: 16px;
}
}
</style>
</head>
<body >
	<jsp:include page="./components/navbar.jsp" />

	<section class=" h-custom" >
  <div class="container py-5 h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col-12">
        <div class="card card-registration card-registration-2" style="border-radius: 15px;">
          <div class="card-body p-0">
            <div class="row g-0">
              <div class="col-lg-8">
                <div class="p-5">
                  <div class="d-flex justify-content-between align-items-center mb-5">
                    <h1 class="fw-bold mb-0 text-black">Panier</h1>
                  </div>


  <!-- begin card -->

                  <% List<Medicament> lm = (List<Medicament>) request.getAttribute("lm"); %>

                  <% int id_comm = (Integer) request.getAttribute("id_comm"); %>
                  <c:set var="count" scope="page" />
                  <c:forEach items="${lm}" var="mc">
                  <hr class="my-4">

                  <div class="row mb-4 d-flex justify-content-between align-items-center">
                    <div class="col-md-2 col-lg-2 col-xl-2">
                      <img

                        src="${mc.getImage_med()}"
                        class="img-fluid rounded-3" alt="pharmajava image">
                    </div>

                    <div class="col-md-3 col-lg-3 col-xl-3">
                      <h6 class="text-muted">${mc.getTitre_med()}</h6>
                      <h6 class="text-black mb-0">${mc.getTitre_med()}</h6>
                    </div>

                    <div class="col-md-3 col-lg-2 col-xl-2 offset-lg-1">
                      <h6 class="mb-0">${mc.getPrix_med()} MAD</h6>
                    </div>
                    <div class="col-md-1 col-lg-1 col-xl-1 text-end">
                      <a href="#!" class="text-muted"><i class="fas fa-times"></i></a>
                    </div>
                  </div>
                    <c:set var="prix_total" value="${prix_total + mc.getPrix_med()}" scope="page"/>
                    <c:set var="count" value="${count + 1}" scope="page"/>
                  </c:forEach>
<!-- begin card -->
                  <hr class="my-4">




                  <div class="pt-5">
                    <h6 class="mb-0"><a href="acceuil" class="text-body"><i
                          class="fas fa-long-arrow-alt-left me-2"></i>retourner au shop</a></h6>
                  </div>
                </div>
              </div>
              <div class="col-lg-4 rounded" style="background-color:#29906A; color:white;">
                <div class="p-5">
                  <h3 class="fw-bold mb-5 mt-2 pt-1">Summary</h3>
                  <hr class="my-4">

                  <div class="d-flex justify-content-between mb-4">
                    <h5 class="text-uppercase">articles ${lm.size()} </h5>
                    <h5><c:out value="${prix_total}"  />MAD</h5>
                  </div>
                  <h5 class="text-uppercase mb-3">Shipping</h5>

                  <div class="mb-4 pb-2">
                   <em style="font-weight: bold">Livraison gratuite (vous economisez 27.36 Dhs)</em>
                    Livre au plus tard le 14 mars si vous commandez d'ici 2hrs 39mins
                  </div>

                  <h5 class="text-uppercase mb-3">Ordonance</h5>

                  <div class="mb-5">
                    <div class="form-outline">
                      <form action="FileUploadServlet" method="post" enctype="multipart/form-data">
                        <span> deposer votre ordonnance ici:</span> <br><br> <input class="form-control" type="file" name="fileName">
                        <br>
                        <br>
                        <hr class="my-4">
                        <input type="hidden" name="id_comm" value="<%=id_comm%>">
                        <input class="btn btn-primary" id="mb__passer__comm" type="submit" value="passer la commande">
                      </form>
                    </div>
                  </div>


                  <input type="hidden" value="<c:out value="${prix_total}"  />" id="pt">

                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
	<jsp:include page="/WEB-INF/views/components/jsLoader.jsp" />
    <script>
     $("#mb__passer__comm").on("click", function(){
      console.log(<%= id_comm %>) ;
      var pt = $("input#pt").val();

      console.log(pt)
      /* $.post( "commander", { id_comm: <%= id_comm %> } ).done(function (){
         //window.location.href = 'commander'
       });
      */

         $.ajax({
             type: "POST",
             url: "commander",
             data: {id_comm:<%=id_comm%>, prix_comm:pt},
             success: function (){
                 console.log("done")
             },
         });
     });


    </script>
</body>
</html>