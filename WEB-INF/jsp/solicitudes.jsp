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
  	<div class="divsolider">
  		<h2>Estas son tus solicitudes:</h2>
   	</div>
  	<div class="divsoliizq">
		   <s:form action="nuevasolicitud">
		   		Nueva solicitud
		   		<s:hidden key="idusuario" name="idusuario" value="%{idusuario}" theme="simple" />
		      	<s:submit type="image" src="images/add.png" width="50px" height="50px" theme="simple"/>
		   </s:form>	
   	</div>
	<div>	
	<s:iterator value="listaSolicitudes" status="elemsStatus">
	
	<table align="center" width="100%" id="TablaClientes" border="1">
	<s:if test="%{#elemsStatus.index == 0}">
	<tr style="background: #E0E0E0">
		<td width="10%" align="center">Ticket</td>
		<td width="10%" align="center">Asunto</td>
		<td width="*" align="center">Detalle</td>
		<td width="15%" align="center">Fecha solicitud</td>
		<td width="15%" align="center">Fecha resuelto</td>
		<td width="10%" align="center">Respuesta</td>
	</tr>	
	<tr>
	    <td width="10%"><s:text name="%{ticket}"/></td>
	    <td width="10%"><s:text name="%{asunto}"/></td>	    
	    <td width="*%"><s:text name="%{detalle}"/></td>
	    <td width="15%"><s:text name="%{fechaSolicitud}"/></td>
	    <td width="15%"><s:text name="%{fechaResolucion}"/></td>
	    <td width="10%"><s:text name="%{Respuesta}"/></td>      
	</tr>		
	</s:if>
	<s:else>
	<tr>
	    <td width="10%"><s:text name="%{ticket}"/></td>
	    <td width="10%"><s:text name="%{asunto}"/></td>
	    <td width="*%"><s:text name="%{detalle}"/></td>
	    <td width="15%"><s:text name="%{fechaSolicitud}"/></td>
	    <td width="15%"><s:text name="%{fechaResolucion}"/></td>
	    <td width="10%"><s:text name="%{Respuesta}"/></td>
	</tr>	
	</s:else>
	</table>	
	
	</s:iterator>	
    </div>   	
</div>

<jsp:directive.include file="footer.jsp" />
</body>
</html>