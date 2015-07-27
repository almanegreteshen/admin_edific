$(document).ready(function(){

    $("#btnAceptar").click(function(){
    	
    	var canEdit = 0;
    	
    	//validar que los campos sean correctos
    	if(	$("#nombreEdif").val() == "" ||
    		$("#direccion").val() == "" ||
    		$("#ciudad").val() == "" ||
    		$("#region").val() == ""){
    		canEdit = 1;
    		alert("favor completar la información necesaria");
    	}
    	
    	if(canEdit == 0){
	    	var r = confirm("Esta seguro de agregar un nuevo edificio?");
	
	    	var nombre = $("#nombreEdif").val();
	    	var direccion = $("#direccion").val();
	    	var ciudad = $("#ciudad").val();
	    	var region = $("#region").val();    	
	    	
	    	var parametros = {
	    			'nombreEdif':nombre,
	    			'direccion':direccion,
	    			'ciudad':ciudad,
	    			'region':region
	    	};	
	    		
    		if (r == true) {
    			$.ajax({
    	            type: 'POST',
    	            url:'AceptaNuevoEdificio',
    	            data:  parametros,
    	            dataType: 'json',
    	            complete : function() {
    	            	alert("Cliente agregado correctamente");
    	            }
    	        });
    		}
    	}
    });
    
});
