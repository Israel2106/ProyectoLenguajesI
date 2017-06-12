/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


    
    $(document).ready(function(){
        $("#btnEnviarProducto").click(function(){
             var nombre= $('#nombre').val();
             var cantidad= $('#cantidad').val();
             var precio= $("#precio").val();
             var marca= $("#marca").val();
             var categoria= $("#categoria").val();
             var numeros= "1234567890";
             if(nombre === "" ){
                 
                 $('#msj1').html("<div>Hola</div>");
                 return false;
             }else{
                 $("#msj1").fadeOut()();
                 if(marca===""){
                     $("#msj4").fadeIn();
                 }else{
                     $("#msj4").fadeOut();
                     if(precio in numeros){
                         $("#msj3").fadeIn();
                         return false;
                     }
                 }
             }
        });
    });
    



