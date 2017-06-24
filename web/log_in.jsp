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
        <link rel= "stylesheet" href="css/global_css.css"/>
    </head>
    <body>
        
      <header id="main-header">
            
            <a id="logo-header"  href="./Inicio.html">
                <span class="site-name">ShopyMarket</span>
		<span class="site-desc">Tu Mercado Cerquitica</span>
            </a> <!-- / #logo-header -->
            
             <nav>
		<ul>
                    <li><a href="./Inicio.html">Volver</a></li>
                    <li><a href="log_in.jsp">Inicio Sesion</a></li>
                    
		</ul>
            </nav><!-- / nav -->

        </header>
        
         <%
         HttpSession sesion = request.getSession(); 
         if(request.getParameter("cerrar") != null){
             sesion.invalidate();
             
          }
        %>
             
            <form method="POST" action="./usuarios.do" class="formulario">
                <input type="hidden" name="metodo" value="userLogIn"/>
                <img src="img/man.png" width="50%" height="50%"/>
                <div class="input-group">
                    <input class="f-in" type="text" required="required" placeholder="Nombre Usuario o Correo" name="user_name">
                </div>
                <div class="input-group">
                    <input class="f-in" type="password" required="required" placeholder="Contraseña" name="pass">
                </div>
 
                <div class="input-group"> <input class="f-in" type="submit" name="log_in" value="Iniciar Sesion"/></div>
                <a href="./insertar_usuario.html">CREAR CUENTA</a>
                </br>
                <a href="./recuperarcontrasena.jsp">Olvidé mi contraseña</a>
            </form>
           
    </body>
</html>

