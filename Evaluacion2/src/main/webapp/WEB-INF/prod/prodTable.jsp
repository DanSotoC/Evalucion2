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

<title>Tabla Productos</title>
</head>
<body>
		<style type="text/css">
		
		div{
		  background-color: grey;
		}

	</style>
	<nav class="navbar navbar-dark bg-dark">
  	<!-- Navbar content -->
		   <div class="container-fluid">
				    <a class="navbar-brand" href="/usuario/">Registrar Usuario</a>
				    <a class="navbar-brand" href="/usuario/tabla_usuarios">Tabla Usuarios</a>
				    <a class="navbar-brand" href="/producto">Registrar Producto</a>
				    <a class="navbar-brand" href="/producto/tabla_productos">Tabla Productos</a>
				    <a class="navbar-brand" href="/carro">Carro</a>
				    <a  href="/usuario/logout" class="btn btn-danger">LogOut</a>
			</div>
	</nav>
	
	<center><h2><b>TABLA DE PRODUCTOS</b></h2></center>
		<table class="table table-striped table-hover">
	             <thead class="table-dark table-hover">
    				<tr>
		              	  <th scope="col">Id</th>
		                  <th scope="col">Nombre</th>
		                  <th scope="col">Descripcion</th>
		                  <th scope="col">Precio</th>
		                  <th scope="col">Opciones</th>
		                  
		                  
		             </tr>
		         </thead>
	             <tbody> 
	              <tr> 
	              	<c:forEach var="prod" items="${prodTable}" >
	              		<tr>
	    					<th> <c:out value = "${prod.getId()}"></c:out>  </th> 
	   						<th> <c:out value = "${prod.getName()}"> </c:out></th>
	   						<th> <c:out value = "${prod.getDescription()}"> </c:out></th>
	   						<th> <c:out value = "${prod.getPrice()}"></c:out></th>
	   						<td><button type="button" class="btn btn-warning"><a href="/producto/editar/${prod.getId()}" style="text-decoration:none";>Edit</a></button>
							<button type="button" class="btn btn-danger"><a href="/producto/eliminar/${prod.getId()}" style="text-decoration:none";>Delete</a></button></td>
							
							
	   					</tr>
	   			   	</c:forEach>
				 </tr>
				</tbody>
			</table>	
			
	
</body>
</html>