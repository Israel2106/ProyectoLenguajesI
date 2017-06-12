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
<link rel= "stylesheet" href="css/global_css.css"/>
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
                    <li><a href="log_in.html">Inicio de Sesion</a></li>
                    
		</ul>
            </nav>

        </header>
        
        <section id="main-content">
            <ul class="galeria">
                <logic:iterate id="item" name="supermercados">
                    <li class="galeria_item">
                        <img class="foto" src="img/no-image.svg" style=" width: 95%">                                          
                         <div class="lb">  * <bean:write name="item" property="nombreEmpresa"/></div>
                         <div class="lb"> * <bean:write name="item" property="telefono"/></div>
                         <div class="lb">  <a href="./productos.do?metodo=verProductos">Comprar aquí</a></div></br>
                    </li>
                </logic:iterate>
             </ul> 
            
	</section>
    </body>
</html>
