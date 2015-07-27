<%@ taglib prefix="s" uri="/struts-tags" %>


<div id='adminmenu'>
<ul>
	<li><a >Admin: &#160; <s:text name="nombre"/> &#160;<s:text name="apepat"/> </a></li>
   	<li><a href='#'><span>Home</span></a></li>
   	<li class='active has-sub'><a href='#'><span>Usuarios</span></a>
      <ul>
         <li class='last'><a href='#'><span>Listar</span></a>

         </li>
         <li class='last'><a href='#'><span>Nuevo</span></a>

         </li>
         <li class='last'><a href='#'><span>Morosos</span></a>

         </li>
      </ul>
   </li>
   <li class='active has-sub'><a href='#'><span>Edificios</span></a>
      <ul>
         <li class='last'><a href='#'>
	    	<s:form action="ListarEdificios">
	    		<s:hidden key="idusuario" name="idusuario" theme="simple" />
			    <s:submit value="Listar" theme="simple"/>
		    </s:form>         
         </a>
         </li>
         <li class='last'><a href='#'>
	    	<s:form action="NuevoEdificio">
	    		<s:hidden key="idusuario" name="idusuario" theme="simple" />
			    <s:submit value="Nuevo" theme="simple"/>
		    </s:form>             
         </a>
         </li>     
      </ul>
   </li>
   <li class='active has-sub'><a href='#'><span>Solicitudes</span></a>
      <ul>
         <li class='last'><a href='#'>
	    	<s:form action="ListarSolicitudesOk">
	    		<s:hidden key="idusuario" name="idusuario" theme="simple" />
			    <s:submit value="Resueltos" theme="simple"/>
		    </s:form>     
         </a>
         </li>
         <li class='last'><a href='#'>
	    	<s:form action="ListarSolicitudesNo">
	    		<s:hidden key="idusuario" name="idusuario" theme="simple" />
			    <s:submit value="Sin Resolver" theme="simple"/>
		    </s:form>             
         </a>
         </li>     
      </ul>
   </li>  
   <li class='last'><a href='#'><span>Balance</span></a></li>
   <li class='last'><a href='#'><span>Salir</span></a></li>
</ul>
</div>


   
   


