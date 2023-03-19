<div class="ajouterI" >
<form method="post" action="">
<input type="hidden" name="id_med" value="0">
 <input type="hidden" name="gere" value="0">
<button class="close_inst"><i class="fa-solid fa-xmark"></i></button>
 </form>
             
        <fieldset>
        <center><legend><h1> ajouter Instance</h1> </legend></center>
    <form method="post" action="ServletAjouterInstance">
                         <input type="hidden" name="id_med" value="<c:out value="${ide}"/>">
        <label><h4>Quantiter de stock   : </h4></label><input type="number" name="stock" size=20 placeholder=" nembre de stock" required><br>
        <label><h4>Date de production   : </h4></label><input type="date" name="date_pro" required ><br>
        <label><h4>Date d'expration     : </h4></label><input type="date" name="date_per" required> <br>
       <br> 
       <center><input type="submit" name="ok"  value="ajouter Instance"></center>
    </form>
    </fieldset>
      </div>