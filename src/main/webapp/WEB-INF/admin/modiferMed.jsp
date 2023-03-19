<div class="ModiferMed">
<form method="post" action="">
<input type="hidden" name="id_med" value="0">
 <input type="hidden" name="gere" value="0">
<button class="close_inst"><i class="fa-solid fa-xmark"></i></button>
 </form>
        <fieldset>
            <legend><h1> Modifier les médicaments</h1> </legend>
    <form method="post" action="ServletModifer">
                               <input type="hidden" name="id_med" value="<c:out value="${ide}"/>">
        <label><h4>Addresse de l'image  :</h4> </label><input type="text" name="image" size=20 value="<c:out value="${Modifer.getImage_med()}"/>" required><br>
        <label><h4>Titre médicament     :</h4></label><input type="text" name="nom" size=20 value="<c:out value="${Modifer.getTitre_med()}"/>" required><br>
        <label><h4>description          :</h4> </label><br>
         <TEXTAREA class="TEXTAREA" name="desc" rows=3 cols=94 placeholder=" description " required><c:out value="${Modifer.getDesc_med()}"/></TEXTAREA><br>
        <%-- </label><input type="text" name="desc" size=20 value="<c:out value="${Modifer.getDesc_med()}"/>"><br>--%>
        <label><h4>prix                 :</h4></label><input type="number" name="prix" size=20 value="<c:out value="${Modifer.getPrix_med()}"/>" required><br>
        <h4>l'ordonnance : </h4> 
        <div class="radio">
             <c:choose>
              <c:when test="${Modifer.getStatus_ord_med()==true }" >
              <input type="radio" name="ordo" value="false" >   non <br>
               <input type="radio" name="ordo" value="true" checked>    oui
               </c:when>
                <c:otherwise>
                 <input type="radio" name="ordo" value="false" checked>   non <br>
                 <input type="radio" name="ordo" value="true" >    oui
                </c:otherwise>
             </c:choose>
          
           
        </div>
       <br> <input type="submit" name="ok"  value="Modifer les médicaments">
    </form>
    </fieldset>
      </div>