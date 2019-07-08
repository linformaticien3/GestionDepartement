<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
   <head>
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
               /* font-size : 25px;*/
                
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
<h2>Liste des Départements : </h2>
<table border ="3">

<tr>
    <th> <h2> id_Departement </h2> </th>
    <th> <h2> libelle </h2> </th>
    <th> <h2> capacité </h2> </th>
</tr>
<% int i = 0; %>
<c:forEach items="${departements}" var="l">

<tr id="ligne<%=i%>">
    <td> <h2> ${l.id_Departement} </h2> </td>
    <td> <h2> ${l.libelle} </h2> </td>
    <td> <h2> ${l.capacité} </h2> </td>
</tr>
<% i++; %>

</c:forEach>

</table>
</div>

<br><br>
<fieldset>
<legend>Ajouter departement</legend>
<form action="ajouterDep" method="POST">
<input type="text" name="id_Departement" placeholder="id_Departement"/>
<input type="text" name="libelle" placeholder="libelle"/>
<input type="text" name="capacite" placeholder="capacité"/>
<input type="submit" name="ajouter" value="ajouter"/>
</form>
</fieldset>

<br><br>
<fieldset>
<legend>Modifier departement</legend>
<form action="modifierDep" method="POST">
<input type="text" name="id_Departement" placeholder="id_Departement"/>
<input type="text" name="libelle" placeholder="libelle"/>
<input type="text" name="capacite" placeholder="capacité"/>
<input type="submit" name="modifier" value="modifier"/>
</form>
</fieldset>

<br><br>
<fieldset>
<legend>Supprimer departement</legend>
<form action="supprimerDep" method="POST">
<input type="text" name="id_Departement" placeholder="id_Departement"/>
<input type="submit" name="supprimer" value="supprimer" onClick="return confirm('tous les étudiants qui appartiennent à cette département vont étre supprimés')" />
</form>
</fieldset>

<br><br>
<fieldset>
<legend>Rechercher departement</legend>
<form action="rechercherDep" method="POST">
<input type="text" name="id_departement" placeholder="id_Departement"/>
<input type="submit" name="rechercher" value="rechercher"  />
</form>
</fieldset>

</body>
</html>