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

<h2>Liste des étudiants : </h2>
<table border ="3">

<tr>
    <th> <h2> id_etudiant </h2> </th>
    <th> <h2> nom </h2> </th>
    <th> <h2> prenom </h2> </th>
     <th> <h2> age </h2> </th>
      <th> <h2> departement </h2> </th>
</tr>
<% int i = 0; %>

<c:forEach items="${etudiants}" var="l">


<tr id="ligne<%=i%>">
    <td> <h2> ${l.id_etudiant} </h2> </td>
    <td> <h2> ${l.nom} </h2> </td>
    <td> <h2> ${l.prenom} </h2> </td>
     <td> <h2> ${l.age} </h2> </td>
      <td> <h2> ${l.departement.libelle} </h2> </td>
</tr>
<% i++; %>


</c:forEach>

</table>
</div>


<br><br>
<fieldset>
<legend>Ajouter etudiant</legend>
<form action="ajouterEtu" method="POST">
<input type="text" name="id_etudiant" placeholder="id_etudiant"/>
<input type="text" name="nom" placeholder="nom"/>
<input type="text" name="prenom" placeholder="prenom"/>
<input type="text" name="age" placeholder="age"/>
<select name="id_departement">
     <c:forEach items="${departements}" var="d">
       <option value="${d.id_Departement}">${d.libelle}</option>
     </c:forEach>
</select>
<input type="submit" name="ajouter" value="ajouter"/>
</form>
</fieldset>

<br><br>
<fieldset>
<legend>modifier etudiant etudiant</legend>
<form action="modifierEtu" method="POST">
<input type="text" name="id_etudiant" placeholder="id_etudiant"/>
<input type="text" name="nom" placeholder="nom"/>
<input type="text" name="prenom" placeholder="prenom"/>
<input type="text" name="age" placeholder="age"/>
<select name="id_departement">

<c:forEach items="${departements}" var="d">
       <option value="${d.id_Departement}">${d.libelle}</option>
</c:forEach>

      <!-- <option value="1">ISI</option>
        <option value="2">MANAGEMENT</option> -->      
</select>
<input type="submit" name="modifier" value="modifier"/>
</form>
</fieldset>

<br><br>
<fieldset>
<legend>supprimer etudiant </legend>
<form action="supprimerEtu" method="POST">
<input type="text" name="id_etudiant" placeholder="id_etudiant"/>
<input type="submit" name="supprimer" value="supprimer"/>
</form>
</fieldset>

<br><br>
<fieldset>
<legend>rechercher etudiant </legend>
<form action="RechercherEtu" method="POST">
<input type="text" name="id_etudiant" placeholder="id_etudiant"/>
<input type="submit" name="rechercher" value="rechercher"/>
</form>
</fieldset>



</body>
</html>