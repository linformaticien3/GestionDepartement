<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
   <head>
   <meta charset="utf-8">
        <style>
                body{
                color: white;
                background-color: black;
                size: 30px; 
                }
                table{
                border : 3px solid white;
                padding : 8px;
                color : white;
                size : 30px;
                }
                td{
                padding : 20px;}
                #ligne0 {
                text-decoration: underline yellow;
                }

                tr:hover {
                cursor : pointer;
                
                color : green;
                /*font-size : 25px;*/
                
                }

                th{
                cursor : default;
                 padding : 20px;
                color : red;
                font-size: 40px;
                }
                a{
                color : white;
                margin : 0 0 2% 2%;
                }
        </style>
   </head>
<body>

 
<div align="center"> 
<div align="left" ><h1> <a href="index">HOME</a> </h1></div>

<h2>Liste des professeurs : </h2>
<table border ="3">

<tr>
    <th> <h2> id_professeur </h2> </th>
    <th> <h2> nom </h2> </th>
    <th> <h2> prenom </h2> </th>
    <th> <h2> Modules </h2> </th>
</tr>
<% int i = 0; %>
<c:forEach items="${profs}" var="l">
<tr id="ligne<%=i%>">
    <td> <h2> ${l.id_prof} </h2> </td>
    <td> <h2> ${l.nom} </h2> </td>
    <td> <h2> ${l.prenom} </h2> </td>
    <td> <h2> <form action="RechercherModuleByProf" method="POST">
                <input type="hidden" name="id_prof" value="${l.id_prof}"/>
              <input type="submit" name="Afficher" value="Afficher ses modules"/>
              </form> 
              </h2> 
     </td>
</tr>
<% i++; %>
</c:forEach>
</table>
</div>

<br><br>
<fieldset>
<legend>Ajouter professeur</legend>
<form action="ajouterProf" method="POST">
<input type="text" name="id_prof" placeholder="id_professeur"/>
<input type="text" name="nom" placeholder="nom"/>
<input type="text" name="prenom" placeholder="prenom"/>

<input type="submit" name="ajouter" value="ajouter"/>
</form>
</fieldset>

<br><br>
<fieldset>
<legend>modifier professeur</legend>
<form action="modifierProf" method="POST">
<input type="text" name="id_prof" placeholder="id_professeur"/>
<input type="text" name="nom" placeholder="nom"/>
<input type="text" name="prenom" placeholder="prenom"/>
<input type="submit" name="modifier" value="modifier"/>
</form>
</fieldset>

<br><br>
<fieldset>
<legend>supprimer professeur </legend>
<form action="supprimerProf" method="POST">
<input type="text" name="id_prof" placeholder="id_professeur"/>
<input type="submit" name="supprimer" value="supprimer" onClick="return confirm('tout les modules afféctés à ce professeur vont étre supprimés.')"/>
</form>
</fieldset>

<br><br>
<fieldset>
<legend>rechercher professeur </legend>
<form action="RechercherProf" method="POST">
<input type="text" name="id_prof" placeholder="id_professeur"/>
<input type="submit" name="rechercher" value="rechercher"/>
</form>
</fieldset>

</body>
</html>