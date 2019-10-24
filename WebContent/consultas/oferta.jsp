<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<jsp:directive.include file="/WEB-INF/includefiles.jspf" />
<title>Oferta</title>
</head>
<body>
<div id="container">
		<div id="header"></div>
		<div id="menu">
		</div>
		<div class="formulario">
		
			 <form action="${pageContext.request.contextPath}/Controller">
			 	<fieldset>
			 		<legend><img src="${pageContext.request.contextPath}/resources/img/logo.gif" width="20px"> Busqueda sencilla</legend>
        					
        					<select name="instituto" onchange="cambiar()" >
        					
	        					<option id="default" value="default">Seleccione un instituto</option>
	        						<c:forEach var="instituto" items="${lista}">
	                					<option value="${instituto.getIdIes()}"  > ${instituto.getNombre()}</option>
	                				</c:forEach>	
       						
       						</select>
       						
       						<input name="operacion" type="hidden" value="mostrarOfertas">
							<input type="submit" value="Mostrar">
        		</fieldset>
      		</form>
      
      		</div>
      		<section class="OfertaEducativa">
        	<c:if test="${(not empty listado)}">
        		<table>
        			<tr>
        				<th>Ciclo</th>
        				<th>Turno</th>
        				<th>Plazas</th>
        				<th>Operaciones</th>
        			</tr>
        			<c:forEach var="oe" items="${listado}">
        			<tr>
        				<td>${oe.nombreCiclo}</td>
        				<td>${oe.nombreTurno}</td>
        				<td>${oe.plazas}</td>
        			</tr>
        			</c:forEach>
        		</table>
        	</c:if>
        	</section>
        	</div>
  	</body>
</html>