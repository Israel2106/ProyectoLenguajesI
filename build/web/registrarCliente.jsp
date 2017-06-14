<%-- 
    Document   : registrarCliente
    Created on : 15-abr-2017, 10:09:14
    Author     : Israel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/global_css.css">
        
        <title>registro</title>
        <script src="javascript/validar.js"></script>
    </head>
    <body>
        <header id="main-header">
            
            <a id="logo-header" >
                <span class="site-name">ShopyMarket</span>
		<span class="site-desc">Tu Mercado Cerquitica</span>
            </a> <!-- / #logo-header -->
            
             <nav>
		<ul>
                    <li><a href="./Inicio.html">Volver</a></li>
                    <li><a href="log_in.html">Inicio Sesion</a></li>
                    
		</ul>
            </nav><!-- / nav -->

        </header>
        <div id="contFormulario">
        <form class="formulario" method="get" action="./cliente.do" onsubmit="return validarFormCliente();">
            <input class="f-in" type="hidden" value="setCliente" name="metodo">
           Nombre de la empresa:<br>
           <input class="f-in" id="nombre" type="text" name="nombre" required><br>
           Número telefónico:<br>
           <input class="f-in" id="telefono" type="text" name="telefono" required><br>
           Email:<br>
           <input class="f-in" id="email" type="email" name="email" required><br>
           Contraseña:<br>
           <input class="f-in" id="pass" type="password" name="pass" required><br>
           Comprobar contraseña:<br>
           <input class="f-in" id="vPass" type="password" name="vPass" required>
           <input type="submit" value="inscribir" ><br>
       </form>
            </div>
    </body>
    
</html>
