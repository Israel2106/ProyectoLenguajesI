<%-- 
    Document   : modificar_producto
    Created on : 17/05/2017, 06:25:49 PM
    Author     : usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel= "stylesheet" href="css/estilos_productos.css"/>
         <script src="js/jquery-3.2.1.min.js" type="text/javascript"></script>
        <title>JSP Page</title>
        
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
    </head>
    <body>
        
        <ul class="galeria">
            
            <logic:iterate id="prod" name="produ">
                <form method="get" action="./productos.do">
                    <li class="galeria_item">
                        <input type="hidden" name="metodo" value="modificar"/>
                        <input type="hidden" name="idCliente"  value="<bean:write name="prod" property="idCliente"/>"/>
                        <input type="hidden" name="idProducto" value="<bean:write name="prod" property="idProducto"/>"/>
                        <input type="text" name="nombre" value="<bean:write name="prod" property="nombre"/>"/></br>
                        <input type="text" name="marca" value="<bean:write name="prod" property="marca"/>"/></br>
                        <input type="text" name="cantidad" value="<bean:write name="prod" property="cantidad"/>"/></br>
                        <input type="text" name="precio" value="<bean:write name="prod" property="precio"/>"/></br>
                        <input type="submit"  value="Modificar"/>
                    </li> 
                </form>
            </logic:iterate>
                                                
        
        </ul> 
         
                 <script src="js/modal.js"></script>
    </body>
</html>
