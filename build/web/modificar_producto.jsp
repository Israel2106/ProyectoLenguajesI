<%-- 
    Document   : modificar_producto
    Created on : 17/05/2017, 06:25:49 PM
    Author     : usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<!DOCTYPE html>
<html  ng-app="app">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel= "stylesheet" href="css/global_css.css"/>
         <script src="js/jquery-3.2.1.min.js" type="text/javascript"></script>
         <script src="http://cdnjs.cloudflare.com/ajax/libs/angular.js/1.2.1/angular.min.js"></script>
         <script type="text/javascript" src="javascript/paginacion_angular.js"></script>
        <title>JSP Page</title>
        
        
    </head>
    <body >
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
        
        <form method="get" action="./productos.do" ng-controller="control">
            <center> Buscar: <input class="buscador" ng-model="buscar" type="text"/></center>
        <ul class="galeria" >
            
           
                <li class="galeria_item" ng-repeat="producto in productos  | filter:buscar" >
                        <input type="hidden" name="metodo" value="modificar"/>
                        <input type="hidden" name="idCliente"  value="{{producto.idCliente}}"/>
                        <input type="hidden" name="id" value="{{producto.idProducto}}"/>
                        <input type="hidden" name="n" value="{{producto.nombre}}"/>
                        <img class="foto" src="img/no-image.svg" style=" width: 95%" class="galeria_img" alt="{{producto.imagen}}"/>
                        <div class="lb"> Nombre: </div>
                    <center><div class="lb"><input class="lbe" type="text" name="nombre" value="{{producto.nombre}}"/></div></center>
                        <div class="lb">  Marca  </div>
                        <center> <div class="lb"><input  type="text" name="marca" value="{{producto.marca}}"/></div></center>
                        <div class="lb">  Cantidad  </div>
                         <center><div class="lb"><input type="text" name="cantidad" value="{{producto.cantidad}}"/></div></center>
                         <div class="lb">  Precio  </div>
                         <center><div class="lb"><input type="text" name="precio" value="{{producto.idProducto}}"/></div></center>
                        <input type="submit"  value="Modificar"/>
                    </li> 
               
                   
        
        </ul> 
          </form>
       
                 
    </body>
</html>
