<%-- 
    Document   : recuperarcontrasena
    Created on : 07-jun-2017, 18:16:44
    Author     : EmmanuelJs
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Recuperar contraseña</title>
        <link rel= "stylesheet" href="css/login.css"/>
    </head>
    <body>
        <a id="logo-header" href="Inicio.html">
                <img src="./img/logo3.png"  width="50" height="50"/>
                <span class="site-name">ShopyMarket</span>
		<span class="site-desc">Tu Mercado Cerquitica</span>
                
            </a> <!-- / #logo-header -->
            
            <div id="principal">
                
                
                <form  method="POST" action="./usuarios.do" name="finsertar">
                            <input type="hidden" name="metodo" value="recuperaContrasena"/>
                            
                            <label>Dijite su Correo </label>
                            <input name="email" required="required" type="email" placeholder="micorreo@mail.com"/>
                            <input type="submit" value="Recuperar Contraseña" />
                                        
                </form>
            </div>
    </body>
</html>
