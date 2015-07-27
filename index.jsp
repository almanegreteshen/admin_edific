<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<link rel="stylesheet" type="text/css" href="css/index.css">
	<link rel="stylesheet" type="text/css" href="css/loginform.css">
	<link rel="stylesheet" type="text/css" href="css/bjqs.css">
	<link rel="stylesheet" type="text/css" href="css/demo.css">
	<link rel='stylesheet prefetch' href='http://fonts.googleapis.com/css?family=Roboto:400,100,400italic,700italic,700'>
	
	<script type="text/javascript" src="/buildingAdmin/js/jquery-1.7.1.min.js"></script>
	<script type="text/javascript" src="/buildingAdmin/js/index/index.js"></script>
	<script type="text/javascript" src="/buildingAdmin/js/bjqs-1.3.min.js"></script>
	
	<title>Ingreso</title>
</head>
<body>
<s:set name="isDatosOk" value="datosOk"/>
<div id="loginContainer">
<div class='form'>
  <div>
	<s:if test="%{#isDatosOk =='error'}">
		<h2>Datos incorrectos</h2>
	</s:if>
	<s:else>
    	<h2>Ingrese sus datos</h2>
	</s:else>
	
    <s:form action="Login">
    	<s:textfield id="txtIdLogin" name="idusuario" theme="simple" placeholder='Username' />
    	<s:textfield id="txtPassLogin" name="passwordusuario" theme="simple" type='password' placeholder='Password'/>
      	<s:submit id="btnLogin" value="Aceptar"/>
    </s:form>
  </div>
  <footer>
    <a href=''>Forgot Password?</a>
  </footer>
</div>
</div>

<div id="slidercontainer">
	<div id="banner-slide">
	  <ul class="bjqs">
	    <li><a href=""><img src="images/banner01.jpg" title="Automatically generated caption"></a></li>
	    <li><img src="images/banner02.jpg" title="Automatically generated caption"></li>
	    <li><img src="images/banner03.jpg" title="Automatically generated caption"></li>
	  </ul>
	</div>
</div>
<jsp:directive.include file="WEB-INF/jsp/footer.jsp" />
</body>
</html>