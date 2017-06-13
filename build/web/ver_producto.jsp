<%-- 
    Document   : ver_producto
    Created on : 13/05/2017, 03:54:52 PM
    Author     : yessica
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         
         <link rel="stylesheet" href="css/css1.css">
    </head>
    
    <body>
       <header id="main-header">
        <a id="logo-header" href="./Inicio.html">
                <span class="site-name">ShopyMarket</span>
		<span class="site-desc">Tu Mercado Cerquitica</span>
        </a> 
        <nav>
        
        <ul>
                    <li><a href="./registrarCliente.jsp">Registrar tienda</a></li>
                    <li><a href="./Inicio.html">Inicio</a></li>
                    <li><a href="log_in.jsp">Inicio Secion</a></li>
                    <li><a href="ver_producto.jsp">Ver IN</a></li>
                    
        </ul>
            
    </nav>
        </header>
        <section class="descripcion" id="descrip">
            <img src="img/logo3.png" style=" width: 30%" class="galeria_img" id="img" >
                <article>
                <ul class="descripcion" >
            
                
                    <li class="descripcion_producto">
                       Nombre:<bean:write name="producto" property="nombre"/>                         
                    </li> 
                    <li class="descripcion_producto">
                        Precio:<bean:write name="producto" property="precio"/>                         
                    </li> 
                    <li class="descripcion_producto">
                       Marca: <bean:write name="producto" property="marca"/>                         
                    </li> 
                
                                                
        
        </ul> 
                </article>
        </section>        
            
       
    </body>
</html>
