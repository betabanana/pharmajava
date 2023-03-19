<div class="ajouterM" style="display: block;   margin-top: 4px;" >
<form method="post" action="">
<input type="hidden" name="id_med" value="0">
 <input type="hidden" name="gere" value="0">
<button class="close_inst"><i class="fa-solid fa-xmark"></i></button>
 </form>
        <fieldset>
            <legend><h1> ajouter les médicaments</h1> </legend>
    <form method="post" action="ServletAjouterMed">
        <label><h4>Addresse de l'image  :</h4> </label><input type="text" name="image" size=20 placeholder="Adresse image "><br>
        <label><h4>Titre médicament     :</h4></label><input type="text" name="nom" size=20 placeholder=" nom "><br>
        <label><h4>description          :</h4></label> <br>
         <TEXTAREA class="TEXTAREA" name="desc" rows=3 cols=94 placeholder=" description " ></TEXTAREA><br>
        <label><h4>prix                 :</h4></label><input type="number" name="prix" size=20 placeholder="prix " required><br>
        <h4>l'ordonnance : </h4>
        <br>
        <br>
        <br>
      
        <div class="radio">
            <input type="radio" name="ordo" value="false">   non <br>
            <input type="radio" name="ordo" value="true" >    oui    <p style="color: red;font-size: 30px;"> ajouter toutes les informations </p>
        </div>
      
       <br>
       <input type="submit" name="ok"  value="ajouter les médicaments" ><br>
    </form>
 
    </fieldset>
     
      </div>