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
        <link rel= "stylesheet" href="css/hoja_de_estilos_1.css"/>
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
        
        
        <div class="contForm">
        <section id="formulario">
           <h1> Insertar un Producto</h1>
           <form method="get"  id="formularioProducto" action="./productos.do" onsubmit="return validarFormProducto();">
            <input type="hidden" name="metodo" value="insertarProducto"/>
             <table id="tproductos"  cellspacing="11" align="left" >
                
                <tr>
                    <td>Nombre de Producto:</td>
                    <td> <input type="text" id="nombre" name="nombre" >
                        <div id="msj1" class="msjerror">Nombre incorrecto</div>
                    </td>
                </tr>
                <tr>
                    <td>Cantidad:</td>
                    <td><input type="text" id="cantidad" name="cantidad" required>
                    <div id="msj2" class="msjerror">Solo números</div></td>
                </tr>
                <tr>
                    <td>Precio</td>
                    <td><input type="text" id="precio" name="precio" >
                    <div id="msj3" class="msjerror">Sólo Números</div></td>
                </tr>
                 <tr>
                    <td>Marca</td>
                    <td><input type="text" id="marca" name="marca" required>
                    <div id="msj4" class="msjerror">Solo letras</div></td>
                </tr>
                
                <tr>
                   <td>     
                       <select id="categoria" name="id_categoria" >
                      <logic:iterate name="categorias" id="i"> 
                        <option value="<bean:write name="i"/>">
                        <bean:write name="i"/>
                        </option>
                    </logic:iterate>
                   </select>
                   </td>
                </tr>
                <tr>
                    <td><a href="./productos.do?metodo=seleccionarImagen">Insertar Imágen</a></td>
                    <td> <img src="<bean:write name="url" />"  alt="imagen"></td>
                </tr>
                
                <tr>
                    <td> <input id="btnEnviarProducto" type="submit" value="Agregar"></td>                         
                </tr>
                
             </table>
            
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
