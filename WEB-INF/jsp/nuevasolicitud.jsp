<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

	<link rel="stylesheet" type="text/css" href="css/estilos.css">
	
	<script type="text/javascript" src="/buildingAdmin/js/jquery-1.7.1.min.js"></script>

<title>Inicio</title>
</head>
<body>
<jsp:directive.include file="headeruser.jsp" />

<div class="divtablasolicitudes">
	<s:form action="aceptanuevasolicitud">
	<table align="center">
		<tr>
			<td>Asunto</td>
			<td>
				<s:textfield name="asunto" theme="simple"/>
			</td>
			<td>
			</td>		
		</tr>
		<tr>
			<td>Detalle</td>
			<td rowspan="2">
				<s:textarea name="detalle" cols="40" rows="8" theme="simple"/>
			</td>
			<td></td>
		</tr>
		<tr>
			<td></td>
			<td>
				<s:hidden key="idusuario" name="idusuario" value="%{idusuario}" theme="simple" />
				<s:submit type="image" src="images/ok.png" width="50px" height="50px" theme="simple"/>
			</td>	
		</tr>			
	</table>
	</s:form>
</div>

<jsp:directive.include file="footer.jsp" />
</body>
</html>