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
        <link rel="stylesheet" href="css/global_css.css">
        <script src="js/jquery.min.js" type="text/javascript"></script>
         <script src="js/jquery-3.2.1.min.js"type="text/javascript"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript">
            function abrirVentanaUbicaciones(){
                $("#ventanaUbicaciones").slideDown("fast");
            }
            
            function cerrarVentanaUbicaciones(){
                $("#ventanaUbicaciones").slideUp("fast");
            }
            
            function abrirVentanaEliminarCuenta(){
                $("#ventanaEliminarCuenta").slideDown("fast");
            }
            
            function cerrarVentanaEliminarCuenta(){
                $("#ventanaEliminarCuenta").slideUp("fast");
            }
            
            function abrirVentanaEditarInformacion(){
                $("#ventanaEditarInfo").slideDown("fast");
            }
            
            function cerrarVentanaEditarInformacion(){
                $("#ventanaEditarInfo").slideUp("fast");
            }
            $(document).keyup(function (a) {
    if(a.wich === 27){
        $('.ventana').slideUp("fast");
    }
    
});
           
        </script>
        <title>Bienvenido</title>
        <header id="main-header">
             <a id="logo-header" href="Inicio.html" >
                <span class="site-name">ShopyMarket</span>
		<span class="site-desc">Tu Mercado Cerquitica</span>
            </a>
        
             <nav>
		<ul>
                    <li><a href="./productos.do?metodo=mostrar">Aqui debe ir perfil, para desloguearse, sesion</a></li>
                    
		</ul>
            </nav>
            
        </header>
    
        
    </head>
    <body>
    <center><h1>Le damos la bienvenida a <bean:write name="cliente" property="nombreEmpresa"/>
            a nuestra plataforma
        </h1></center>
            
            
             <ul class="grupo_botones">
                    
                 <a href="./productos.do?metodo=mostrar">
                    <li class="btones" href="./productos.do?metodo=mostrar">                                                                 
                        <div class="botones_cli"> </br></br>Agregar Productos </div>
                    </li>
                </a>
                   <a href="javascript:abrirVentanaEditarInformacion();">
                    <li class="btones" href="./productos.do?metodo=mostrar" background-color="red">                                                                 
                        <div class="botones_cli"></br></br>Editar mi Información</div>
                    </li>
                </a>
                 <a href="javascript:abrirVentanaUbicaciones();">
                    <li class="btones" href="./productos.do?metodo=mostrar">
                                                                 
                        <div class="botones_cli">
                            </br></br>Ubicaciones 
                        </div>
                    </li>
                </a>
                   <a href="javascript:abrirVentanaEliminarCuenta()">
                    <li class="btones" href="./productos.do?metodo=mostrar">                                                                 
                        <div class="botones_cli"> </br></br>Eliminar Cuenta</div>
                    </li>
                </a>
            </ul> 
            
            <div class="ventana" id="ventanaUbicaciones">
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
        
            <div class="ventana" id="ventanaEliminarCuenta">
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
                
                       
        
        <div class="ventana" id="ventanaEditarInfo">
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
        
        <script src="javascript/validar.js"></script>
        
    </body>
</html>
