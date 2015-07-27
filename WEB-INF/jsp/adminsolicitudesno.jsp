<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

	<link rel="stylesheet" type="text/css" href="css/admin.css">
	<script type="text/javascript" src="/buildingAdmin/js/jquery-1.7.1.min.js"></script>
	
<title>Hello World</title>
</head>
<body>
<jsp:directive.include file="headeradmin.jsp" />

<div>
	<h3 align="center">Solicitudes actuales:</h3>
	
	<s:iterator value="listaSolicitudes" status="elemsStatus">
	
	<table align="center" width="80%" id="TablaClientes" border="1">
	<s:if test="%{#elemsStatus.index == 0}">
	<tr style="background: #E0E0E0">
		<td width="8%" align="center">Ticket</td>		
		<td width="8%" align="center">Id Usuario</td>
		<td width="10%" align="center">Asunto</td>
		<td width="*%" align="center">Detalle</td>
		<td width="10%" align="center">Fecha Solicitud</td>
		<td width="8%" align="center">Acción</td>
	</tr>	
	<tr>
	    <td width="8%"><s:text name="%{ticket}"/></td>
	    <td width="8%"><s:text name="%{idusuario}"/></td>
	    <td width="10%"><s:text name="%{asunto}"/></td>	    
	    <td width="*%"><s:text name="%{detalle}"/></td>
	    <td width="10%"><s:text name="%{fechaSolicitud}"/></td>
	    <td width="8%" align="center">
	    	<s:form action="EditarEdificio">
	    		<s:hidden key="idusuario" name="idusuario" theme="simple" />
		    	<s:hidden key="idEdificio" name="idEdificio" value="%{idedificio}" theme="simple" />
			    <s:submit value="Responder" theme="simple"/>
		    </s:form>
	    </td>      
	</tr>		
	</s:if>
	<s:else>
	<tr>
	    <td width="8%"><s:text name="%{ticket}"/></td>
	    <td width="8%"><s:text name="%{idusuario}"/></td>
	    <td width="10%"><s:text name="%{asunto}"/></td>	    
	    <td width="*%"><s:text name="%{detalle}"/></td>
	    <td width="10%"><s:text name="%{fechaSolicitud}"/></td>
	    <td width="8%" align="center">
	    	<s:form action="EditarEdificio">
	    		<s:hidden key="idusuario" name="idusuario" theme="simple" />
		    	<s:hidden key="idEdificio" name="idEdificio" value="%{idedificio}" theme="simple" />
			    <s:submit value="Responder" theme="simple"/>
		    </s:form>
	    </td>      
	</tr>	
	</s:else>
	</table>	
	
	</s:iterator>
</div>

<jsp:directive.include file="footer.jsp" />
</body>
</html>