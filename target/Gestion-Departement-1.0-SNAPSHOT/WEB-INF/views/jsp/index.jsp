<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1256">
<title>Insert title here</title>
<style type="text/css">
.container{
margin : 10% 0;
border : 2px solid green;
text-align : center;
padding : 50px;

}
.dep{

cursor : pointer;
text-align : center;
width : 50%;
/*float:left;*/
border : 2px solid red;
padding : 10px 5% 10px 5%;
margin : 1% 20% 1% 20%;
}
a{text-decoration:none;
width : 100%}
.dep:hover , .etu:hover , .prof:hover  {

background-color: green;
color : white;
}


.etu{

cursor : pointer;
text-align : center;
width : 50%;
/*float:right;*/
border : 2px solid red;
padding : 10px 5% 10px 5%;
margin : 1% 20% 1% 20%;
}

.prof{

cursor : pointer;
text-align : center;
width : 50%;
border : 2px solid red;
padding : 10px 5% 10px 5%;
margin : 1% 20% 1% 20%;

}

</style>
  
</head>
<body>

<div class="container"> 


<a align="center" href="/GestionDep/departement" >
 <div align="center" class="dep" >       Département
</div></a>


<a href="/GestionDep/etudiant" >
<div class="etu" >        Etudiant</div>
</a>



<a href="/GestionDep/professeur"" >
 <div class="prof" >       professeur
</div></a>

<a href="/GestionDep/module"" >
 <div class="prof" >       Module
</div></a>


<a href="/GestionDep/notes" >
 <div class="prof" >       Notes
</div></a>

</div>


<!--  
<div role="main" class="l-main">
<li class="LiclassCat animated zoomInDown" id="cattg">
					<a href="PageService.php?ville='.$ville.'&idCat= '1' &titre='titre'  class="c-img-link-overlay" >
						<span class="c-img-link-overlay__content">

							<span class="c-img-link-overlay__text-large">titre</span>
						</span>
						<img src="image" height="190" width="232" aria-hidden="true">
					</a>
				</li>
		
		</div>
	</div>
-->
</body>
</html>