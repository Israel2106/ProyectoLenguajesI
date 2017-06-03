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
         <link rel= "stylesheet" href="css/estilos_productos.css"/>
       
        <script src="js/jquery-3.2.1.min.js"type="text/javascript"></script>
       
    </head>
    <body>
        <header>            
            <a id="logo-header" href="./Inicio.html">
                <span class="site-name">ShopyMarket</span>
		<span class="site-desc">Tu Mercado Cerquitica</span>
            </a> <!-- / #logo-header -->
            
             <nav>
		<ul>
                    <li><a href="./registrarCliente.jsp">Registrar tienda</a></li>
                    <li><a href="#">Inicio</a></li>
                    <li><a href="ver_producto.jsp">Opciones</a></li>
                    
		</ul>
            </nav><!-- / nav -->
        </header>
        
        <ul class="galeria">
            
            <logic:iterate id="producto" name="lista">
                <li class="galeria_item">
                    <img src="<bean:write name="producto" property="imagen" />" style=" width: 100%" class="galeria_img" alt="<bean:write name="producto" property="nombre" />">                                          
                    <label>  * <bean:write name="producto" property="nombre" /></label></br>
                      <label>  * <bean:write name="producto" property="marca" /></label></br>
                       <label>  * <bean:write name="producto" property="precio" /></label></br>
                </li> 
                
            </logic:iterate>
                                                
        
        </ul> 
        
       
       <script src="js/modal.js"></script>
       
       
      
    </body>
</html>
