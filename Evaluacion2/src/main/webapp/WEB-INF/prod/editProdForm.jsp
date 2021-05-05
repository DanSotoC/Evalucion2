<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- CSS only -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
    <!-- JavaScript Bundle with Popper -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/js/bootstrap.bundle.min.js" integrity="sha384-JEW9xMcG8R+pH31jmWH6WWP0WintQrMb4s7ZOdauHnUtxwoG2vI5DkLtS3qm9Ekf" crossorigin="anonymous"></script>
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	
	<!-- Optional theme -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
	
	<!-- Latest compiled and minified JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

<title>Edicion Productos</title>
</head>
<body>
		<style type="text/css">
		
	    body{
	        margin: 0;
	        padding:0;
        
	        background: linear-gradient(rgba(0,0,0,0.7),rgba(0,0,0,0)), url('https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRloIzpO7aQ3BF_nDFxJZno9ONAxhwgnnbtSg&usqp=CAU');
	        
	       color: white; 
	       height: 100vh;
	                -webkit-background-size:cover;
	                background-size: cover;
	                background-position: center center;
	                position: relative;
	    }
		div{
		  background-color: grey;
		}

	</style>
	<nav class="navbar navbar-dark bg-dark">
  	<!-- Navbar content -->
		  	 <div class="container-fluid">
				    <a class="navbar-brand" href="/">Registrar Usuario</a>
				    <a class="navbar-brand" href="/usuario/tabla_usuarios">Tabla Usuarios</a>
				    <a class="navbar-brand" href="/producto">Registrar Producto</a>
				    <a class="navbar-brand" href="/producto/tabla_productos">Tabla Productos</a>
				    <a class="navbar-brand" href="/carro">Carro</a>
			</div>
	</nav>
	<br>
	
	<div class="container" style="background-color=blue;">
				<form:form class="well form-horizontal" action="/producto/update" modelAttribute="producto" method="POST">
				<fieldset>
		
				<!-- Form Name -->
				<legend><center><h2><b>EDICION DE PRODUCTOS</b></h2></center></legend><br>
				
				<!-- Text input-->
				<form:hidden path="id"/>
				<div class="form-group">
				  <form:label class="col-md-4 control-label" path="name">Nombre </form:label>
				  <div class="col-md-4 inputGroupContainer">
				  	<div class="input-group">
				  		<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
				 		 <form:input path="name" class="form-control"/>
				    </div>
				  </div>
				</div>
				
			   <!-- Text input-->
				  <div class="form-group">
				  <form:label class="col-md-4 control-label" path="description">Descripcion </form:label>
				  <div class="col-md-4 inputGroupContainer">
				  	<div class="input-group">
				  		<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
				 		 <form:input path="description" class="form-control"/>
				    </div>
				  </div>
				</div>
				<!-- Text input-->
				  <div class="form-group">
				  <form:label class="col-md-4 control-label" path="price">Precio </form:label>
				  <div class="col-md-4 inputGroupContainer">
				  	<div class="input-group">
				  		<span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
				 		 <form:input path="price" class="form-control"/>
				    </div>
				  </div>
				</div>
			  <br>
			  <input class="btn btn-success" type="submit" value="Update">
			  </form:form> <br><br>  
			</div>
		</div>
	
	
	
</body>
</html>