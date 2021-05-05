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

<title>Tabla Usuarios</title>
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
				    <a class="navbar-brand" href="/">Registrar Usuario</a>
				    <a class="navbar-brand" href="/usuario/tabla_usuarios">Tabla Usuarios</a>
				    <a class="navbar-brand" href="/producto">Registrar Producto</a>
				    <a class="navbar-brand" href="/producto/tabla_productos">Tabla Productos</a>
				    <a class="navbar-brand" href="/carro">Carro</a>
			</div>
	</nav>
	
	<center><h2><b>TABLA DE USUARIOS</b></h2></center>
		<table class="table table-striped table-hover">
	             <thead class="table-dark">
    				<tr>
		              	  <th scope="col">Id</th>
		                  <th scope="col">Nombre</th>
		                  <th scope="col">Apellido</th>
		                  <th scope="col">Rut</th>
		                  <th scope="col">Email</th>
		                  <th scope="col">Opciones</th>
		                  <th scope="col">Carro</th>
		             </tr>
		         </thead>
	             <tbody> 
	              <tr> 
	              	<c:forEach var="user" items="${userTable}" >
	              		<tr>
	    					<th> <c:out value = "${user.getId()}"></c:out>  </th> 
	   						<th> <c:out value = "${user.getName()}"> </c:out></th>
	   						<th> <c:out value = "${user.getLastname()}"> </c:out></th>
	   						<th> <c:out value = "${user.getRut()}"></c:out></th>
	   						<th> <c:out value = "${user.getMail()}"> </c:out></th>
	   						<td> <button type="button" class="btn btn-warning"><a href="/usuario/editar/${user.getId()}" style="text-decoration:none";>Edit</a></button>
							<button type="button" class="btn btn-danger"><a href="/usuario/eliminar/${user.getId()}" style="text-decoration:none";>Delete</a></button></td>
							<td><form action="/carro/agregarUser" method="POST" modelAttribute="carro"> 
							<select>
								<option value="0">-Eliga Carro-</option>
								<c:forEach var="carro" items="${listCarro}">
									<option value="<c:out value="${carro.id}"></c:out>"><c:out value="${carro.name}"></c:out> </option><br>
									
								</select>	
								<button type="button" class="btn btn-success"><a href="/carro/agregarUser/${user.getId()}/${carro.id}/" style="text-decoration:none";>Añadir</a></button>	
								</c:forEach>
							
							
							</form></td>
	   					</tr>
	   			   	</c:forEach>
				 </tr>
				</tbody>
			</table>	
			
	
</body>
</html>