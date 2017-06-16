<%-- 
    Document   : visorTiendas
    Created on : 25-may-2017, 18:29:27
    Author     : Israel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE html>
<link rel= "stylesheet" href="css/global_css.css"/>
<html>
    <head
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tiendas</title>
    </head>
    <body>
        <header id="main-header">
            
            <a id="logo-header" >
                <span class="site-name">ShopyMarket</span>
		<span class="site-desc">Tu Mercado Cerquitica</span>
            </a> 
            
             <nav>
		<ul>
                    <li><a href="./registrarCliente.jsp">Registrar tienda</a></li>
                    <li><a href="log_in.jsp">Inicio de Sesion</a></li>
                    
		</ul>
            </nav>

        </header>
        <br>
        
        <form method="get" action="./cliente.do">
            <input type="hidden" name="metodo" value="mostrarClientesPorUbicacion" >
            Buscar por Ubicación:<br>
            <select name="provincia" style="width: 20%">
                <option value="choose">Elíge tu Provincia</option>
                <option value="Sanjose">San José</option>
                <option value="Heredia">Heredia</option>
                <option value="Alajuela">Alajuela</option>
                <option value="cartago">Cartago</option>
                <option value="limon">Limon</option>
                <option value="Puntarenas">Puntarenas</option>
                <option value="Guanacaste">Guanacaste</option>
            </select>
            <select name="canton" style="width: 20%">
                <option value="choose">Elíge tu Cantón</option>
                <logic:iterate name="cantones" id="i"> 
                    <option value="<bean:write name="i"/>">
                        <bean:write name="i"/>
                    </option>
                </logic:iterate>
            </select>
            <select name="distrito" style="width: 20%">
                <option value="choose">Elíge tu Distrito</option>
                <logic:iterate name="distritos" id="i"> 
                    <option value="<bean:write name="i"/>">
                        <bean:write name="i"/>
                    </option>
                </logic:iterate>
            </select>
            <input type="submit" value="Buscar">
        </form>
        

        
        <section id="main-content">
            <ul class="galeria">
                <logic:iterate id="item" name="supermercados">
                    <li class="galeria_item">
                        <img class="foto" src="img/no-image.svg" style=" width: 95%">                                          
                         <div class="lb">  * <bean:write name="item" property="nombreEmpresa"/></div>
                         <div class="lb"> * <bean:write name="item" property="telefono"/></div>
                         <div class="lb">  <a href="./productos.do?metodo=verProductos">Comprar aquí</a></div></br>
                    </li>
                </logic:iterate>
             </ul> 
            
	</section>
    </body>
</html>
