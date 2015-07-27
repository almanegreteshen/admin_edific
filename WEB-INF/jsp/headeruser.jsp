<%@ taglib prefix="s" uri="/struts-tags" %>

<div class="grandparent">
  	<div class="parent">
  		<h2>Tu comunidad en linea</h2>
      	<div class="child">
      		<h3>Bienvenido a tu comunidad en <s:text name="nombreEdificio"/></h3>
      		<p>Usuario(a): <s:text name="nombre"/>&#160;<s:text name="apepat"/>&#160;<s:text name="apemat"/></p>
      		<p><s:text name="departamento"/> - <s:text name="direccion"/></p>
      	</div>
   	</div>
</div>

<div id='cssmenu'>
<table border="1" align="center">
	<tr>
		<td>
		   <s:form action="solicitud">
		   		<s:hidden key="idusuario" name="idusuario" value="%{idusuario}" theme="simple" />
		      	<s:submit type="image" src="images/home.png" width="50px" height="50px" theme="simple"/>
		   </s:form>			
		</td>
		<td>
		   <s:form action="solicitud">
		   		<s:hidden key="idusuario" name="idusuario" value="%{idusuario}" theme="simple" />
		      	<s:submit type="image" src="images/solicitudes.png" width="50px" height="50px" theme="simple"/>
		   </s:form>	
		</td>
		<td>
		   <s:form action="solicitud">
		   		<s:hidden key="idusuario" name="idusuario" value="%{idusuario}" theme="simple" />
		      	<s:submit type="image" src="images/message.png" width="50px" height="50px" theme="simple"/>
		   </s:form>
		</td>
		<td>
		   <s:form action="solicitud">
		   		<s:hidden key="idusuario" name="idusuario" value="%{idusuario}" theme="simple" />
		      	<s:submit type="image" src="images/opciones.png" width="50px" height="50px" theme="simple"/>
		   </s:form>	
		</td>
		<td>		   
		   <s:form action="Login">
		      	<s:submit type="image" src="images/salir.png" width="50px" height="50px" theme="simple"/>
		   </s:form>			   
		</td>		
	</tr>
	<tr>
		<td>
			Home
		</td>
		<td>
			Solicitudes
		</td>
		<td>
			Contacto
		</td>
		<td>
			Settings
		</td>
		<td>
			Salir
		</td>		
	</tr>	
</table>
</div>

   
   


