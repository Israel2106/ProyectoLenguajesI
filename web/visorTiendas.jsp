<%-- 
    Document   : visorTiendas
    Created on : 25-may-2017, 18:29:27
    Author     : Israel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE html>
<link rel= "stylesheet" href="css/estilo_tiendas.css"/>
<link rel= "stylesheet" href="css/hoja_de_estilos_1.css"/>
<html>
    <head
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tiendas</title>
    </head>
    <body>
        <header id="main-header">
            
            <a id="logo-header" >
                <span class="site-name">ShopyMarket</span>
		<span class="site-desc">Tu Mercado Cerquitica</span>
            </a> 
            
             <nav>
		<ul>
                    <li><a href="./registrarCliente.jsp">Registrar tienda</a></li>
                    <li><a href="log_in.html">Log in</a></li>
                    
		</ul>
            </nav>

        </header>
        
        <section id="main-content">
            <ul class="galeria">
                <logic:iterate id="item" name="supermercados">
                    <li class="galeria_item">
                        <img src="img/no-image.svg">                                          
                        <label>  * <bean:write name="item" property="nombreEmpresa"/></label></br>
                        <label>  * <bean:write name="item" property="telefono"/></label></br>
                        <label>  <a href="#">Comprar aquí</a></label></br>
                    </li>
                </logic:iterate>
             </ul> 
            
	</section>
    </body>
</html>
