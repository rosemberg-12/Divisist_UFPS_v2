$(document).ready(function() {
    
      $('#materias').DataTable( {
             dom: 'Bfrtip',
    buttons: [
        'copy', 'excel', 'pdf'
    ]
} );


    
    
} );
function dibujar(id, dato){
  var request = $.ajax({
  url: "../JSP/servicioHoras.jsp",
  method: "POST",
  data: { id : id },

});
 
request.done(function( msg ) {
    
  
  var resul=msg.split(",");
  var i=0;
  
  if(esValido(resul,dato)){
        for (i=0; i<resul.length; i++)
        {
            var x=$("#"+resul[i]).text();

            if($("#"+resul[i]).html()==dato){
                $("#"+id).html("Previa");
                $("#-"+id).removeClass('selected');
                $("#"+resul[i]).html('.');
                $("#"+resul[i]).css("background", "#FFFFFF");
            }

            else{
                $("#-"+id).addClass('selected');
                $("#"+id).html("Ocultar");
                $("#"+resul[i]).css("background", "#F5A9A9");
                $("#"+resul[i]).html(dato);
            }
        }
  }
   else{
       alert("No se puede previsualizar porque ya hay materias incluidas o previsualizadas en este mismo horario");
    }
  
});
 
request.fail(function( jqXHR, textStatus ) {
  alert( "Request failed: " + textStatus );
});
    
}

function esValido(resul,dato){
    
    var i=0;
    
    for (i=0; i<resul.length; i++)
        {
            var x=$("#"+resul[i]).text();
           
            
            if(x!='.' && $("#"+resul[i]).html()!=dato){
            
                return false;
                
            }
        }
        return true;
}

function incluir(id){
    
      var request = $.ajax({
      url: "../JSP/servicioInclusion.jsp",
      method: "POST",
      data: { id : id },

    });
 
    request.done(function( msg ) {
        
        alert(msg);
            location.reload();

    });

    request.fail(function( jqXHR, textStatus ) {
      alert( "Request failed: " + textStatus );
    });
    
}