<%-- 
    Document   : mostrar_productos
    Created on : 13/04/2017, 10:38:05 PM
    Author     : Yessica Zuñiga
--%>

<%@page import="java.util.LinkedList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <link rel= "stylesheet" href="css/global_css.css"/>
       
        <script src="js/jquery-3.2.1.min.js"type="text/javascript"></script>
       
    </head>
    <body>
        <header >            
            <a id="logo-header" href="./Inicio.html">
                <span class="site-name">ShopyMarket</span>
		<span class="site-desc">Tu Mercado Cerquitica</span>
            </a> <!-- / #logo-header -->
            
             <nav class="hprod">
		<ul>
                    <li><a href="./registrarCliente.jsp">Registrar tienda</a></li>
                    <li><a href="#">Inicio</a></li>
                    <li><a href="ver_producto.jsp">Opciones</a></li>
                    
		</ul>
            </nav><!-- / nav -->
        </header>
        <form method="get" action="./productos.do">
            <input type="hidden" value=""/>
            <input type="hidden" name="idCliente"  value="{{producto.idCliente}}"/>
            <input type="hidden" name="idProducto" value="{{producto.idProducto}}"/>
        <ul class="galeria">
            
            <logic:iterate id="producto" name="lista">
                <li class="galeria_item">
                    <img class="foto" src="img/no-image.svg" style=" width: 95%" class="galeria_img" alt="<bean:write name="producto" property="imagen" />"/>                                          
                    <div class="lb">  Nombre:  <bean:write name="producto" property="nombre" /></div>
                    <div class="lb">  Marca: <bean:write name="producto" property="marca" /></div>
                    <div class="lb">  Precio:₡ <bean:write name="producto" property="precio" /></div></br>
                    <input type="submit" value="Comprar"/>  
                </li> 
                
            </logic:iterate>                                              
        
        </ul> 
         </form>    
      
    </body>
</html>
