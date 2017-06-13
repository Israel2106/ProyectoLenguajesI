<%-- 
    Document   : log_in.jsp
    Created on : 12-jun-2017, 21:04:34
    Author     : EmmanuelJs
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Log In</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel= "stylesheet" href="css/inicio.css"/>
    </head>
    <body>
        
         <header id="main-header">
            
            <a id="logo-header" href="Inicio.html">
                <img src="./img/logo3.png"  width="50" height="50"/>
                <span class="site-name">ShopyMarket</span>
		<span class="site-desc">Tu Mercado Cerquitica</span>
                
            </a> <!-- / #logo-header -->
            
            

        </header>
        
         <%
         HttpSession sesion = request.getSession(); 
         if(request.getParameter("cerrar") != null){
             sesion.invalidate();
             
          }
        %>
        
        <div class="container">
            <img src="img/man.png"/>
            
            <form method="POST" action="./usuarios.do">
                <input type="hidden" name="metodo" value="userLogIn"/>
                
                <div class="form-input">
                    <input type="text" required="required" placeholder="Nombre Usuario o Correo" name="user_name">
                </div>
                <div class="form-input">
                    <input type="password" required="required" placeholder="Contraseña" name="pass">
                </div>
                
               
                <div> <input type="submit" name="log_in" value="Iniciar Sesion"/></div>
                
            </form>
            
            <a href="./insertar_usuario.html">CREAR CUENTA</a>
            </br>
            <a href="./recuperarcontrasena.jsp">Olvidé mi contraseña</a>
        </div>
    </body>
</html>

