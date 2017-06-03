<%-- 
    Document   : moduloCliente
    Created on : 25-abr-2017, 20:16:09
    Author     : Israel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="css/css1.css">
        <script src="js/jquery.min.js" type="text/javascript"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript">
            function abrirVentanaUbicaciones(){
                $(".ventanaUbicaciones").slideDown("fast");
            }
            
            function cerrarVentanaUbicaciones(){
                $(".ventanaUbicaciones").slideUp("fast");
            }
            
            function abrirVentanaEliminarCuenta(){
                $(".ventanaEliminarCuenta").slideDown("fast");
            }
            
            function cerrarVentanaEliminarCuenta(){
                $(".ventanaEliminarCuenta").slideUp("fast");
            }
            
            function abrirVentanaEditarInformacion(){
                $(".ventanaEditarInformacion").slideDown("fast");
            }
            
            function cerrarVentanaEditarInformacion(){
                $(".ventanaEditarInformacion").slideUp("fast");
            }
            
        </script>
        <title>Bienvenido</title>
        <header id="main-header">
             <a id="logo-header" >
                <span class="site-name">ShopyMarket</span>
		<span class="site-desc">Tu Mercado Cerquitica</span>
            </a>
        
             <nav>
		<ul>
                    <li><a href="./productos.do?metodo=mostrar">Agregar Producto</a></li>
                    <li><a href="javascript:abrirVentanaUbicaciones();">Agregar Ubicacion</a></li>
                    <li><a href="javascript:abrirVentanaEditarInformacion();">Editar mi Informacion</a></li>
                    <li><a href="javascript:abrirVentanaEliminarCuenta()">Eliminar mi cuenta</a></li>
		</ul>
            </nav>
            
        </header>
    
        <script src="javascript/validar.js"></script>
    </head>
    <body>
        <h1>Le damos la bienvenida a <bean:write name="cliente" property="nombreEmpresa"/>
            a nuestra plataforma
        </h1>
        <div class="ventanaUbicaciones">
            <div class="form">
                <div class="cerrar"><a href="javascript:cerrarVentanaUbicaciones();">X</a></div>
                <h1>Nueva ubicacion</h1>
                <hr>
                <form>
                    Canton:<br>
                    <input type="text" name="canton" ><br>
                    Ubicacion:<br>
                    <input type="text" name="ubicacion" ><br>
                    <input type="submit" value="Agregar" >
                </form>

            </div>
        </div>
        
        <div class="ventanaEliminarCuenta">
            <div class="form">
                <div class="cerrar"><a href="javascript:cerrarVentanaEliminarCuenta();">X</a></div>
                <h1>Eliminar su cuenta?</h1>
                <hr>
                <form method="get" action="./cliente.do">

                <input type="hidden" name="metodo" value="eliminarCliente" >
                <input type="hidden" name="idEmpresa" value="<bean:write name="cliente" property="id"/>" ><br>
                <input type="submit" value="Si" >   
                
                </form>
                <button onclick="javascript:cerrarVentanaEliminarCuenta();">No</button>
            </div>
            
        </div>
        
         <div class="ventanaEditarInformacion">
            <div class="form">
                <div class="cerrar"><a href="javascript:cerrarVentanaEditarInformacion();">X</a></div>
                <h1>Modifique sus datos aqui</h1>
                <hr>
                <form method="get" action="./cliente.do" onsubmit="return validarFormEditarCliente();">
                   
                    <input type="hidden" name="metodo" value="actualizarCliente" >
                    <input type="hidden" name="idEmpresa" value="<bean:write name="cliente" property="id"/>">
               
                    Nombre de la Empresa:<br>
                    <input id="nombre" type="text" name="nombre" value="<bean:write name="cliente" property="nombreEmpresa"/>"><br>
               
                    Email:<br>
                    <input id="email" type="email" name="email" value="<bean:write name="cliente" property="email"/>"><br>
                     
                    Telefono:<br>
                    <input id="telefono" type="text" name="telefono" value="<bean:write name="cliente" property="telefono"/>">
                  
                    <br><br><br><input type="submit" value="Listo" >
                   
                  
                </form>
                <button onclick="javascript:cerrarVentanaEditarInformacion();">cancelar</button>
            </div>
            
        </div>
        
        
        
    </body>
</html>
