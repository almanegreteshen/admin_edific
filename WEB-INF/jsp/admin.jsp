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

<div>
	<h3 align="center">Edificios actuales:</h3>
	
	<s:iterator value="listaEdificios" status="elemsStatus">
	
	<table align="center" width="80%" id="TablaClientes" border="1">
	<s:if test="%{#elemsStatus.index == 0}">
	<tr style="background: #E0E0E0">
		<td width="8%" align="center">Id Edificio</td>		
		<td width="20%" align="center">Nombre</td>
		<td width="*%" align="center">Dirección</td>
		<td width="15%" align="center">Ciudad</td>
		<td width="8%" align="center">Region</td>
		<td width="8%" align="center">Editar</td>
		<td width="8%" align="center">Eliminar</td>
	</tr>	
	<tr>
	    <td width="8%"><s:text name="%{idedificio}"/></td>
	    <td width="20%"><s:text name="%{nombre}"/></td>
	    <td width="*%"><s:text name="%{direccion}"/></td>	    
	    <td width="15%"><s:text name="%{ciudad}"/></td>
	    <td width="10%"><s:text name="%{region}"/></td>
	    <td width="8%" align="center">
	    	<s:form action="EditarEdificio">
	    		<s:hidden key="idusuario" name="idusuario" theme="simple" />
		    	<s:hidden key="idEdificio" name="idEdificio" value="%{idedificio}" theme="simple" />
			    <s:submit value="Edit" theme="simple"/>
		    </s:form>
	    </td>
	    <td width="8%" align="center">
			<s:submit id="btnEliminar" name="%{idedificio}" onclick="eliminaEdificio(this.name)" value="X" theme="simple" />
	    </td>	       
	</tr>		
	</s:if>
	<s:else>
	<tr>
	    <td width="8%"><s:text name="%{idedificio}"/></td>
	    <td width="20%"><s:text name="%{nombre}"/></td>
	    <td width="*%"><s:text name="%{direccion}"/></td>
	    <td width="15%"><s:text name="%{ciudad}"/></td>
	    <td width="10%"><s:text name="%{region}"/></td>
    	<td width="8%" align="center">
    		<s:form action="EditarEdificio">
    			<s:hidden key="idusuario" name="idusuario" theme="simple" />
		    	<s:hidden key="idEdificio" name="idEdificio" value="%{idedificio}" theme="simple" />		
		    	<s:submit value="Edit" theme="simple"/>
		    </s:form>
    	</td>
	    <td width="8%" align="center">
			<s:submit id="btnEliminar" name="%{idedificio}" onclick="eliminaEdificio(this.name)" value="X" theme="simple" />
	    </td>	    	
	</tr>	
	</s:else>
	</table>	
	
	</s:iterator>
</div>

<!--
<div>
	<h3 align="center">Usuarios actuales:</h3>
	
	<s:iterator value="listaUsuarios" status="elemsStatus">
	
	<table align="center" width="80%" id="TablaClientes" border="1">
	<s:if test="%{#elemsStatus.index == 0}">
	<tr style="background: #E0E0E0">
		<td width="8%" align="center">Id Usuario</td>		
		<td width="10%" align="center">Password</td>
		<td width="8%" align="center">Id Edif</td>
		<td width="*%" align="center">Nombre</td>
		<td width="10%" align="center">Ape. Pat</td>
		<td width="10%" align="center">Ape. Mat</td>
		<td width="10%" align="center">Depto</td>
		<td width="10%" align="center">Tipo Usuario</td>
		<td width="8%" align="center">Editar</td>
		<td width="8%" align="center">Eliminar</td>
	</tr>	
	<tr>
	    <td width="8%"><s:text name="%{idusu}"/></td>
	    <td width="10%"><s:text name="%{passwordusu}"/></td>
	    <td width="8%"><s:text name="%{idedificio}"/></td>	    
	    <td width="*%"><s:text name="%{nombre}"/></td>
	    <td width="10%"><s:text name="%{apepat}"/></td>
	    <td width="10%"><s:text name="%{apemat}"/></td>
	    <td width="10%"><s:text name="%{departamento}"/></td>	    
	    <td width="10%"><s:text name="%{tipousu}"/></td>
	    <td width="8%" align="center">
	    	<s:form action="EditarCliente">
		    	<s:hidden key="rut" name="rut" value="%{rut}" theme="simple" />
			    <s:submit value="Edit" theme="simple"/>
		    </s:form>
	    </td>
	    <td width="8%" align="center">
	    	<s:form action="EliminarCliente">
	    		<s:hidden key="rut" name="rut" value="%{rut}" theme="simple" />
			    <s:submit value="X" theme="simple"/>
		    </s:form>
	    </td>	       
	</tr>		
	</s:if>
	<s:else>
	<tr>
	    <td width="8%"><s:text name="%{idusu}"/></td>
	    <td width="10%"><s:text name="%{passwordusu}"/></td>
	    <td width="8%"><s:text name="%{idedificio}"/></td>	    
	    <td width="*"><s:text name="%{nombre}"/></td>
	    <td width="10%"><s:text name="%{apepat}"/></td>
	    <td width="10%"><s:text name="%{apemat}"/></td>	    
	    <td width="10%"><s:text name="%{departamento}"/></td>
	    <td width="10%"><s:text name="%{tipousu}"/></td>
    	<td width="8%" align="center">
    		<s:form action="EditarCliente">
		    	<s:hidden key="rut" name="rut" value="%{rut}" theme="simple" />		
		    	<s:submit value="Edit" theme="simple"/>
		    </s:form>
    	</td>
	    <td width="8%" align="center">
	    	<s:hidden key="rut" name="rut" value="%{rut}" theme="simple" />	    	
		    <s:submit value="X" theme="simple" name="%{rut}" onclick="Eliminar(this.name)" />
	    </td>	    	
	</tr>	
	</s:else>
	</table>	
	
	</s:iterator>
</div>
-->

<jsp:directive.include file="footer.jsp" />
</body>
</html>