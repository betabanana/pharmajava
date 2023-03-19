 <div class="Med">
      <form method="post" action="AdminMedcamnet">
<input type="hidden" name="id_med" value="0">
 <input type="hidden" name="gere" value="0">
<button class="close_inst"><i class="fa-solid fa-xmark"></i></button>
 </form>                
             <div class="img">
                <img src="<c:out value="${Modifer.getImage_med()}"/>" alt="">
             </div>
             <div class="prixtitre"><p><c:out value="${Modifer.getTitre_med()}"/></p>   <p><c:out value="${Modifer.getPrix_med()}"/>DH</p></div>
            <div class="desc">
         <p ><c:out value="${Modifer.getDesc_med()}"/></p>
             </div>             
                  
        </div>