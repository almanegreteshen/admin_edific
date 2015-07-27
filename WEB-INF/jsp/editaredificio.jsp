<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

	<link rel="stylesheet" type="text/css" href="css/admin.css">
	<script type="text/javascript" src="/buildingAdmin/js/jquery-1.7.1.min.js"></script>
	<script type="text/javascript" src="/buildingAdmin/js/Admin/editaredificio.js"></script>
	
<title>Hello World</title>
</head>
<body>
<jsp:directive.include file="headeradmin.jsp" />

	<h3 align="center">Editar Edificio:</h3>

	<s:form>
		<table align="center" id="TablaNuevoCliente" width="40%">
		<tr style="background: #E0E0E0">
			<td width="20%">Id Edificio</td>
			<td width="*%"><s:textfield id="idEdificio" name="idEdificio" theme="simple" readonly="true" cssStyle="width:97%;background-color:#E0E0E0;"/></td>
		</tr>
		<tr style="background: #CCFFFF">
			<td>Nombre</td>
			<td><s:textfield id="nombreEdif" name="nombreEdif" theme="simple" cssStyle="width:97%;"/></td>
		</tr>
		<tr style="background: #CCFFFF">
			<td>Dirección</td><td>
			<s:textfield id="direccion" name="direccion" theme="simple" cssStyle="width:97%;"/></td>
		</tr>
		<tr style="background: #CCFFFF">
			<td>Ciudad</td>
			<td><s:textfield id="ciudad" name="ciudad" theme="simple" cssStyle="width:97%;"/></td>
		</tr>
		<tr style="background: #CCFFFF">
			<td>Region</td>
			<td><s:textfield id="region" name="region" theme="simple" cssStyle="width:97%;"/></td>
		</tr>
		<tr style="background: #CCFFFF">
			<td></td><td align="right">
			<s:submit id="btnAceptar" value="Aceptar" theme="simple" />
			</td>
		</tr>		
		</table>
	</s:form>
	
<jsp:directive.include file="footer.jsp" />
</body>
</html>