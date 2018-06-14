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

function registrar(){	
}

function editar(id,idTra,estado,fchApertura){	
	
	$('input[id=id_ID]').val(id);
	$('select[id=idTra]').val(idTra);
	$('select[id=estadoAct]').val(estado);
	$('input[id=fecha_ingresoAct]').val(fchApertura);
}