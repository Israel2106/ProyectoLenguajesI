<%-- 
    Document   : configuracionusuario
    Created on : 26-abr-2017, 22:19:24
    Author     : EmmanuelJs
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
     
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel= "stylesheet" href="css/global_css.css"/>
         <script src="js/jquery.min.js" type="text/javascript"></script>
         <title>Configuracion Usuario</title>
    </head>
    <body>
        
       <%
                       HttpSession sesion = request.getSession(); 
                       
                          
                       if(sesion.getAttribute("user_name")!= null && sesion.getAttribute("pass")!= null && sesion.getAttribute("email") != null && sesion.getAttribute("id")!=null &&sesion.getAttribute("direccion")!=null ){
       
                            String nombre= ""+sesion.getAttribute("user_name");
                            String pass = ""+sesion.getAttribute("pass").toString();
                            String email = ""+sesion.getAttribute("email").toString();
                            int id = (int) sesion.getAttribute("id");
                            String direccion = ""+sesion.getAttribute("direccion").toString();
                            
                       }else{
                          
                           out.print("<script>location.replace('./log_in.jsp');</script>");
                           
                           }
                       %>

         <section id="main-content">
		<article>
                     <div id="principal">
            
                            <form class="formulario" method="post" class="usuario" method="get" action="./usuarios.do">
                            <input type="hidden" name="metodo" value="actualizarUsuarios"/>
                      
                            <h1>Editar:</h1>
                            <label><strong>Correo:</strong></label>
                            <div class="form-input"> <input type="text" name="email" value="<%= sesion.getAttribute("email") %>"/></div>

                            </br>
                            <label><strong>Nombre Usuario:</strong></label>
                            <div class="form-input"><input type="text" name="user_name" value="<%= sesion.getAttribute("user_name") %>"/></div>
                              
                            </br>
                            <label><strong>Contraseña:</strong></label>
                            <div class="form-input"><input type="text" name="pass" value="<%= sesion.getAttribute("pass") %>"/></div>

                           </br>
                            <label><strong>Direccion:</strong></label>
                            <div class="form-input"><input type="text" name="direccion" value="<%= sesion.getAttribute("direccion") %>"/></div>
                            </br>
                            <label><strong>Eliminar Cuenta??</strong></label>
                            
                            <input type="hidden" name="id" value="<%= sesion.getAttribute("id") %>"/>
                           
                      
                            
                            <div id="capa"><a style="margin:0"href="./usuarios.do?metodo=eliminarUsuarios&id=<%= sesion.getAttribute("id")%>">Eliminar</a></div>
                                
                                <div id="mensaje" style="display: none;">Esta opcion no es reversible !!</div>
                                <script>
                                   $("#capa").mouseenter(function(evento){
                                    $("#mensaje").css("display", "block");
                                 });
                                 $("#capa").mouseleave(function(evento){
                                    $("#mensaje").css("display", "none");
                                }); 
                                    
                                </script>
                            
                            
                            <div><input class="btn" type="submit" name="actualizar" value="Guardar Cambios"/></div>
                  
                        </form>
                          
                    </div>

		</article> 

	</section> 
 
    </body>
</html>
