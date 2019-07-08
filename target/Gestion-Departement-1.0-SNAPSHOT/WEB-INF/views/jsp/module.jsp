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

<h2>Liste des Modules : </h2>
<table border ="3">

<tr>
    <th> <h2> id_Module </h2> </th>
    <th> <h2> libelle </h2> </th>
    <th> <h2> Professeur </h2> </th>
</tr>
<% int i = 0; %>

<c:forEach items="${modules}" var="l">


<tr id="ligne<%=i%>">
    <td> <h2> ${l.id_module} </h2> </td>
    <td> <h2> ${l.libelle} </h2> </td>
      <td> <h2> ${l.prof.nom} &nbsp ${l.prof.prenom} </h2> </td>
</tr>
<% i++; %>


</c:forEach>

</table>
</div>


<br><br>
<fieldset>
<legend>Ajouter module</legend>
<form action="ajouterModule" method="POST">
<input type="text" name="id_module" placeholder="id_module"/>
<input type="text" name="libelle" placeholder="libelle"/>
<select name="id_prof">
     <c:forEach items="${profs}" var="d">
       <option value="${d.id_prof}">${d.nom} &nbsp ${d.prenom}</option>
     </c:forEach>
</select>
<input type="submit" name="ajouter" value="ajouter"/>
</form>
</fieldset>

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



</body>
</html>