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

<title>Registrar Usuario</title>
</head>
<body>
		<style type="text/css">


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
	    <form action="/carro/agregar" method="POST">
			  <div class="form-row">
			    <div class="form-grup col-md-2">
			            <input  type="text" id="name" name="name" placeholder="Cart Name" class="form-control ">
				        <input class="btn btn-success" type="submit" value="Crear">
			    </div>
			    <div class="form-grup col-md-8">
			    		  <center><h2><b>LISTADO DE COMPRAS</b></h2></center>
			    </div>
			  </div>
		</form>
	    
		<table class="table table-striped ">
	             <thead class="table-dark">
    				<tr>
		              	  <th scope="col">Id</th>
		                  <th scope="col">Nombre</th>
		                  <th scope="col">Nombre</th>
		                  <th scope="col">Productos</th>
		                  
		           </tr>
		         </thead>
	             <tbody> 
	              <tr>
	              		<c:forEach var="carro" items="${listCarro}" >
	              		<td> <c:out value = "${carro.getId()}"></c:out>  </td>
	              		<td> <c:out value = "${carro.getName()}"></c:out>  </td>
	              		<td> <c:out value = "${carro.usuario.toString()}"></c:out>  </td>
						<td> <c:if test="${carro.usuario.getId()!=null}">  
							  <form action="/carro/agregarProd" modelAttribute="producto" method="POST"> 
								<input type="hidden" value="${carro.getId()}" name="carro_id">
								  <div class="input-group">	
									<select multiple class="custom-select form-group col-md-5 form-control-lg" name="carro_id">
										<c:forEach var="producto" items="${listProd}">
											<option value="<c:out value="${producto.id}"></c:out>"><c:out value="${prod.name} -- > $"> </c:out><c:out value="${prod.price}"></c:out> </option>
										</c:forEach>
									 </select>
								  <div class="input-group-append">
								 <button type="submit" class="btn btn-success"> Añadir</button>
								 </div>
								</div>
								</form> <br>
						</c:if></td>
						</tr>	
						</c:forEach> 
						
				 
				</tbody>
			</table>
	
	
	
	
</body>
</html>