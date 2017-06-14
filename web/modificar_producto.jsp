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
        <link rel= "stylesheet" href="css/global_css.css"/>
         <script src="js/jquery-3.2.1.min.js" type="text/javascript"></script>
        <title>JSP Page</title>
        
        
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
        <form method="get" action="./productos.do">
        <ul class="galeria">
            
            <logic:iterate id="prod" name="produ">
                
                    <li class="galeria_item">
                        <input type="hidden" name="metodo" value="modificar"/>
                        <input type="hidden" name="idCliente"  value="<bean:write name="prod" property="idCliente"/>"/>
                        <input type="hidden" name="idProducto" value="<bean:write name="prod" property="idProducto"/>"/>
                        <img class="foto" src="img/no-image.svg" style=" width: 95%" class="galeria_img" alt="<bean:write name="prod" property="imagen" />"/>
                        <div class="lb">  Nombre: </div>
                    <center><div class="lb"><input class="input_p" type="text" name="nombre" value="<bean:write name="prod" property="nombre"/>"/></div></center>
                        <div class="lb">  Marca  </div>
                       <center> <div class="lb"><input class="input_p" type="text" name="marca" value="<bean:write name="prod" property="marca"/>"/></div></center>
                        <div class="lb">  Cantidad  </div>
                         <center><div class="lb"><input class="input_p" type="text" name="cantidad" value="<bean:write name="prod" property="cantidad"/>"/></div></center>
                         <div class="lb">  Precio  </div>
                         <center><div class="lb"><input class="input_p" type="text" name="precio" value="<bean:write name="prod" property="precio"/>"/></div></center>
                        <input type="submit"  value="Modificar"/>
                    </li> 
               
            </logic:iterate>            
        
        </ul> 
          </form>
                 
    </body>
</html>
