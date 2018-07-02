$(document).ready(function(){
	$('.expediente').hide();
	$('#form-h-it').keyup(function(){
		  var input, filter, table, tr, td, i;
		  input = document.getElementById('form-h-it');
		  filter = input.value.toUpperCase();
		  table = document.getElementById('myTable');
		  tr = table.getElementsByTagName('tr');

		  // Loop through all table rows, and hide those who don't match the search query
		  for (i = 0; i < tr.length; i++) {
		    td = tr[i].getElementsByTagName('td')[2];
		    if (td) {
		      if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
		        tr[i].style.display = "";
		      } else {
		        tr[i].style.display = "none";
		      }
		    } 
		  }
	});
	
});
function eliminar(id){	
	$('input[id=id_elimina]').val(id);
	$('#idFormElimina').submit();
}
function revisar(id){	
	$('input[id="id_rev"]').val(id);
	$('#idFormRev').submit();
}
function ConsulExpe(id){	
	$('input[id="idExpe"]').val(id);
	$('#idFormCons').submit();
}

function registrar(){	
}

function editarExpediente(id,idTra,estado,fchApertura){	
	
	$('input[id=id_ID]').val(id);
	$('select[id=idTra]').val(idTra);
	$('select[id=estadoAct]').val(estado);
	$('input[id=fecha_ingresoAct]').val(fchApertura);
}
function editarDocumento(id,expe,desc,link){	
	
	$('input[id=id_ID]').val(id);
	$('select[id=idExp]').val(expe);
	$('input[id=desc]').val(desc);
	$('input[id=lnk]').val(link);
}
function editarEntidad(id,poder,sector,ruc,nombre, direccion ){	
	
	$('input[id=id_ID]').val(id);
	$('input[id=poder_est]').val(poder);
	$('input[id=sector]').val(sector);
	$('input[id=ruc]').val(ruc);
	$('input[id=nombre]').val(nombre);
	$('input[id=direccion]').val(direccion);
}
function editarEmpleado(id,nombre,apePat,apeMat,sueldo,idCargo){	
	
	$('input[id=id_ID]').val(id);
	$('input[id=nombre]').val(nombre);
	$('input[id=apePat]').val(apePat);
	$('input[id=apeMat]').val(apeMat);
	$('input[id=sueldo]').val(sueldo);
	$('select[id=cargo]').val(idCargo);
}
function updateClock ( ){
	var currentTime = new Date ( );
	var currentHours = currentTime.getHours ( );
	var currentMinutes = currentTime.getMinutes ( );

	// Compose the string for display
	var currentTimeString = currentHours + ":" + currentMinutes;
	
	
	$("#clock").html(currentTimeString);
	  	
}


$(document).ready(function()
{
setInterval('updateClock()', 1000);
});
