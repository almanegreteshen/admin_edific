$(document).ready(function(){

    $("#btnEliminar").click(function(){
    	var r = confirm("Esta seguro de eliminar el Edificio con Id: " + $("#idEdificio").val() + "?");
    	
    	var idedificio = $("#idEdificio").val(); 	
    	
    	var parametros = {
    		'idEdificio':idedificio
    	};	
    		
		if (r == true) {
			$.ajax({
	            type: 'POST',
	            url:'EliminarEdificio',
	            data:  parametros,
	            dataType: 'json',
	            complete : function() {
	            	alert("Cliente eliminado correctamente");
	            }
	        });
		}
    });	
	
    $("#btnAceptar").click(function(){
    	
    	var canEdit = 0;
    	
    	//validar que los campos sean correctos
    	if(	$("#idEdificio").val() == "" ||
    		$("#nombreEdif").val() == "" ||
    		$("#direccion").val() == "" ||
    		$("#ciudad").val() == "" ||
    		$("#region").val() == ""){
    		canEdit = 1;
    		alert("favor completar la información necesaria");
    	}
    	
    	if(canEdit == 0){
	    	var r = confirm("Esta seguro de agregar un nuevo edificio?");
	    	
	    	var idedificio = $("#idEdificio").val();
	    	var nombre = $("#nombreEdif").val();
	    	var direccion = $("#direccion").val();
	    	var ciudad = $("#ciudad").val();
	    	var region = $("#region").val();    	
	    	
	    	var parametros = {
	    			'idEdificio':idedificio,
	    			'nombreEdif':nombre,
	    			'direccion':direccion,
	    			'ciudad':ciudad,
	    			'region':region
	    	};	
	    		
    		if (r == true) {
    			$.ajax({
    	            type: 'POST',
    	            url:'AceptaEditarEdificio',
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

function eliminaEdificio(id){

	var r = confirm("Esta seguro de eliminar el Edificio con Id: " + id + "?");	
	
	var parametros = {
		'idEdificio':id
	};	
		
	if (r == true) {
		$.ajax({
            type: 'POST',
            url:'EliminarEdificio',
            data:  parametros,
            dataType: 'json',
            complete : function() {
            	alert("Cliente eliminado correctamente");
            	location.reload();
            }
        });
	}
	
}


