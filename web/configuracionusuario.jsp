<%-- 
    Document   : configuracionusuario
    Created on : 26-abr-2017, 22:19:24
    Author     : EmmanuelJs
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <script src="js/jquery.min.js" type="text/javascript"></script><!--importar para usar librerias de Jquery-->
         
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="css/login.css">
        
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
     
        <header id="main-header">
            
            <a id="logo-header" href="Inicio.html">
                <img src="./img/logo3.png"  width="50" height="50"/>
                <span class="site-name">ShopyMarket</span>
		<span class="site-desc">Tu Mercado Cerquitica</span>
                
            </a> <!-- / #logo-header -->
            
            
        </header>
        
      
       
        
         <section id="main-content">
             
             
	
		<article>
                     <div id="principal">
                        <h1>Editar:</h1>
                        <form method="post" class="usuario" method="get" action="./usuarios.do">
                            <input type="hidden" name="metodo" value="actualizarUsuarios"/>
                      
                            
                            <label><strong>Correo:</strong></label>
                            <div class="form-input"> <input type="text" name="email" value="<%= request.getAttribute("email") %>"/></div>

                            
                            <label><strong>Nombre Usuario:</strong></label>
                            <div class="form-input"><input type="text" name="user_name" value="<%= request.getAttribute("user_name") %>"/></div>
                              
                          
                            <label><strong>Contraseña:</strong></label>
                            <div class="form-input"><input type="text" name="pass" value="<%= request.getAttribute("pass") %>"/></div>

                           
                            <label><strong>Direccion:</strong></label>
                            <div class="form-input"><input type="text" name="direccion" value="<%= request.getAttribute("direccion") %>"/></div>

                            <label><strong>Eliminar Cuenta??</strong></label>
                            
                            <input type="hidden" name="id" value="<%= request.getAttribute("id") %>"/>
                            
                            
                            <div id="capa"><a href="./usuarios.do?metodo=eliminarUsuarios&id=<%= request.getAttribute("id")%>">Eliminar</a></div>
                                
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
                        
        <footer id="main-footer">
	<p>&copy; 2017 <a href="#">ShopyMarket.com</a></p>
	</footer> 
        
        
    </body>
</html>
