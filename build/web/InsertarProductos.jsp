<%-- 
    Document   : InsertarProductos
    Created on : 24/04/2017, 07:11:50 PM
    Author     : usuario
--%>

<%@page import="com.shopymarket.app.dominio.Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <link rel= "stylesheet" href="css/global_css.css"/>
        <script src="js/jquery.min.js" type="text/javascript"></script>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    
    <body>
        
        <header>            
            <a id="logo-header" >
                <span class="site-name">ShopyMarket</span>
		<span class="site-desc">Tu Mercado Cerquitica</span>
            </a> <!-- / #logo-header -->
            
             <nav>
		<ul>
                    <li><a href="./registrarCliente.jsp">Registrar tienda</a></li>
                    <li><a href="#">Inicio</a></li>
                    <li><a href="./productos.do?metodo=mostrarProducto">Gestionar Productos</a></li>
                    
		</ul>
            </nav><!-- / nav -->
        </header>
        
        
        
        <h1 class="formulario-titulo"> Insertar un Producto</h1>
           <form method="get"  id="formularioProducto" action="./productos.do"
                 onsubmit="return validarFormProducto();" class="formulario">
               <input class="f-in"type="hidden" name="metodo" value="insertarProducto"/>
               
            <div class="input-group">
                <input class="f-in" type="text" id="nombre" name="nombre" >
                <label for="nombre">Nombre:</label>
            </div>
                
            <div class="input-group">
                <input class="f-in" type="text" id="cantidad" name="cantidad" >
                <label for="cantidad">Cantidad:</label>
            </div>
            <div class="input-group">
                <input class="f-in" type="text" id="precio" name="precio" >
                <label for="precio">Precio:</label>
            </div>
            
            <div class="input-group">
                <input class="f-in" type="text" id="marca" name="marca" >
                <label for="marca">Marca:</label>
            </div>
            <div class="input-group">
                <select id="categoria" name="id_categoria" >
                    <logic:iterate name="categorias" id="i"> 
                       <option value="<bean:write name="i"/>">
                       <bean:write name="i"/>
                       </option>
                    </logic:iterate>
                </select>
            </div>                         
            <div  class="input-group">
                <a href="./productos.do?metodo=seleccionarImagen">Insertar Imágen</a>
                <img src="<bean:write name="url" />"  alt="imagen">
               <input id="btnEnviarProducto" type="submit" value="Agregar">                         
            </div>
        </form>
            <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>  
            <DIV ALIGN=rigth>
                
            <form method="get" action="./productos.do">
                        
                <input type="submit" value="ver Productos" >
                <input type="hidden" name="metodo" value="verProductos">
                
            </form>
            </DIV>
        </section>
        </div>
       
        <script src="javascript/validar_productos.js"></script>
        
        <footer>
        <p>(c) 2017 ShopyMarket
        </footer>
    </body>
</html>
