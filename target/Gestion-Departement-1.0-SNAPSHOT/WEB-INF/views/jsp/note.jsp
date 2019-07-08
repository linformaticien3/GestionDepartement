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

<h2>Liste des Notes : </h2>
<table border ="3">

<tr>
    <th> <h2> Etudiant </h2> </th>
    <th> <h2> Module </h2> </th>
    <th> <h2> Note </h2> </th>
</tr>
<% int i = 0; %>

<c:forEach items="${notes}" var="l">


<tr id="ligne<%=i%>">
    <td> <h2> ${l.etudiant.nom} &nbsp ${l.etudiant.prenom} </h2> </td>
    <td> <h2> ${l.module.libelle} </h2> </td>
      <td> <h2> ${l.note} </h2> </td>
</tr>
<% i++; %>


</c:forEach>

</table>
</div>


<br><br>
<fieldset>
<legend>Ajouter module</legend>
<form action="ajouterNotesRest" method="POST">
<select name="id_etudiant">
     <c:forEach items="${etudiants}" var="d">
       <option value="${d.id_etudiant}">${d.nom} &nbsp ${d.prenom}</option>
     </c:forEach>
</select>
<select name="id_module">
     <c:forEach items="${modules}" var="d">
       <option value="${d.id_module}">${d.libelle}</option>
     </c:forEach>
</select>
<input type="text" name="note" placeholder="note"/>
<input type="submit" name="ajouter" value="ajouter"/>
</form>
</fieldset>

<!--  
<br><br>
<fieldset>
<legend>modifier module</legend>
<form action="modifierModuleRest" method="POST">
<input type="text" name="id_module" placeholder="id_module"/>
<input type="text" name="libelle" placeholder="libelle"/>
<select name="id_prof">
<c:forEach items="${profs}" var="d">
       <option value="${d.id_prof}">${d.nom} &nbsp ${d.prenom}</option>
</c:forEach>

</select>
<input type="submit" name="modifier" value="modifier"/>
</form>
</fieldset>

<br><br>
<fieldset>
<legend>supprimer module </legend>
<form action="supprimerModuleRest" method="POST">
<input type="text" name="id_module" placeholder="id_module"/>
<input type="submit" name="supprimer" value="supprimer"/>
</form>
</fieldset>

<br><br>
<fieldset>
<legend>rechercher module </legend>
<form action="rechercherModuleRest" method="POST">
<input type="text" name="id_module" placeholder="id_module"/>
<input type="submit" name="rechercher" value="rechercher"/>
</form>
</fieldset>

-->

</body>
</html>