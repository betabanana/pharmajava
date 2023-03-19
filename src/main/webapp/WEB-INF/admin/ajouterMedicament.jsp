<div class="ajouterM" >
 <label for="AjoueterMed" class="close"><i class="fa-solid fa-xmark"></i></label>
        <fieldset>
            <legend><h1> ajouter les médicaments</h1> </legend>
    <form method="post" action="ServletAjouterMed">
        <label><h4>Addresse de l'image  :</h4> </label><input type="text" name="image" size=20 placeholder="Adresse image " required><br>
        <label><h4>Titre médicament     :</h4></label><input type="text" name="nom" size=20 placeholder=" nom " required><br>
        <label><h4>description</h4></label>: <br>
         <TEXTAREA class="TEXTAREA" name="desc" rows=3 cols=94 placeholder=" description " required></TEXTAREA><br>
        <%-- <input type="text" name="desc" size=20 placeholder=" description ">--%>
        <label><h4>prix                 :</h4></label><input type="number" name="prix" size=20 placeholder="prix " required><br>
        <h4>l'ordonnance : </h4>
        <div class="radio">
            <input type="radio" name="ordo" value="false">   non <br>
            <input type="radio" name="ordo" value="true" >    oui
        </div>
       <br> <input type="submit" name="ok"  value="ajouter les médicaments">
    </form>
    </fieldset>
      </div>