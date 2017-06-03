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
        <link rel="stylesheet" href="miestilo.css">
        <link rel="stylesheet" href="css/form.css" >
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
                    <li><a href="log_in.html">Log in</a></li>
                    
		</ul>
            </nav><!-- / nav -->

        </header>
        <form id="formulario" method="get" action="./cliente.do" onsubmit="return validarFormCliente();">
            <input type="hidden" value="setCliente" name="metodo">
           Nombre de la empresa:<br>
           <input id="nombre" type="text" name="nombre" required><br>
           Número telefónico:<br>
           <input id="telefono" type="text" name="telefono" required><br>
           Email:<br>
           <input id="email" type="email" name="email" required><br>
           Contraseña:<br>
           <input id="pass" type="password" name="pass" required><br>
           Comprobar contraseña:<br>
           <input id="vPass" type="password" name="vPass" required>
           <input type="submit" value="inscribir" ><br>
       </form>
    </body>
</html>
