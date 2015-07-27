<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

	<link rel="stylesheet" type="text/css" href="css/estilos.css">
	<script type="text/javascript" src="/buildingAdmin/js/jquery-1.7.1.min.js"></script>
	
<title>Hello World</title>
</head>
<body>
<jsp:directive.include file="header.jsp" />

<div class="top_left">
	<li><a href='#'><span>Agregar nuevo cliente</span></a></li>
	<li><a href='#'><span>Pagos</span></a></li>
	<li><a href='#'><span>Clientes morosos</span></a></li>
	<li><a href='#'><span>Otros</span></a></li>
</div> 

	<h3 align="center">Editar Cliente:</h3>

	<s:form>
		<table align="center" id="TablaNuevoCliente" width="40%">
		<tr style="background: #E0E0E0">
			<td width="20%">Rut</td>
			<td width="*%"><s:textfield id="rut" name="rut" theme="simple" readonly="true" cssStyle="width:97%;background-color:#E0E0E0;"/></td>
		</tr>
		<tr style="background: #CCFFFF">
			<td>Categoria</td>
			<td><s:textfield id="categoria" name="categoria" theme="simple" cssStyle="width:97%;"/></td>
		</tr>
		<tr style="background: #CCFFFF">
			<td>Nombre</td><td>
			<s:textfield id="nombre" name="nombre" theme="simple" cssStyle="width:97%;"/></td>
		</tr>
		<tr style="background: #CCFFFF">
			<td>Password</td>
			<td><s:textfield id="password" name="password" theme="simple" cssStyle="width:97%;"/></td>
		</tr>
		<tr style="background: #CCFFFF">
			<td>Dirección</td>
			<td><s:textfield id="direccion" name="direccion" theme="simple" cssStyle="width:97%;"/></td>
		</tr>
		<tr style="background: #CCFFFF">
			<td></td><td align="right"><s:submit id="btnAceptar" value="Aceptar" onclick="javascript:AceptarEditarCliente()" theme="simple" /></td>
		</tr>		
		</table>
	</s:form>
	
	<div align="center">
	<s:form action="AuthenticationActionBack">
    	<s:submit value="Volver"/>
    </s:form>	
	</div>
	
<jsp:directive.include file="footer.jsp" />
</body>
</html>