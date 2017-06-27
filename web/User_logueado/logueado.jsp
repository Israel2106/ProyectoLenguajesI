<%-- 
    Document   : logueado
    Created on : 24-abr-2017, 22:10:30
    Author     : EmmanuelJs
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>
<%@taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel= "stylesheet" href="css/global_css.css"/>
        <script src="js/jquery.min.js" type="text/javascript"></script>
        
       <script src="/socket.io/socket.io.js"></script>
        <script src="User_logueado/main.js"></script>

        <script>
        $(document).ready(function(){
           $("#enlaceajax").click(function(evento){
              evento.preventDefault();
              $("#destino").load("configuracionusuario.jsp");
           });
        })
        </script>
        <title>sigin</title>

    </head>
    <body>
        <header id="main-header">
            <a id="logo-header" href="#">
                <img src="./img/logo3.png"  width="50" height="50"/>
                <span class="site-name">ShopyMarket</span>
		<span class="site-desc">Tu Mercado Cerquitica</span>
            </a> <!-- / #logo-header -->
            
             <%
                       HttpSession sesion = request.getSession(); 
                       
                          
                       if(sesion.getAttribute("user_name")!= null && sesion.getAttribute("pass")!= null && sesion.getAttribute("email") != null && sesion.getAttribute("id")!=null &&sesion.getAttribute("direccion")!=null ){
       
                            String nombre= ""+sesion.getAttribute("user_name");
                            String pass = ""+sesion.getAttribute("pass").toString();
                            String email = ""+sesion.getAttribute("email").toString();
                            int id = (int) sesion.getAttribute("id");
                            String direccion = ""+sesion.getAttribute("direccion").toString();
                            
                       }else{
                          
                            out.print("<script>location.replace('./log_in.jsp');</script>");
                           
                           }
                       %>
            
             <nav>
                 <ul class="nav">
                    
                    
                    <li><a href="#">Bienvenido  <%=sesion.getAttribute("user_name")%></a></li>      
                    <li><a href="./usuarios.do?metodo=configuracionUs&email=<%=sesion.getAttribute("email")%>&user_name=<%=sesion.getAttribute("user_name")%>&pass=<%=sesion.getAttribute("pass")%>&id=<%=sesion.getAttribute("id")%>&direccion=<%=sesion.getAttribute("direccion")%>" id="enlaceajax">Configuracion</a></li>
                    <li><a href="./log_in.jsp?cerrar=true">Cerrar Sesion</a></li>
                                     
                    
		</ul>
            </nav><!-- / nav -->
        </header>
                    
                    <div id="messages">
                     
                    </div>
                    
        <div id="destino">
        <section id="main-content">
		<article>
                    <header>
                            <ul class="galeria">
                            <logic:iterate id="item" name="supermercados">
                                <li class="galeria_item">
                                    <img class="foto" src="img/no-image.svg" style=" width:25%">                                          
                                    <div class="lb">  * <bean:write name="item" property="nombreEmpresa"/></div>
                                    <div class="lb"> * <bean:write name="item" property="telefono"/></div>
                                    <div class="lb">  <a href="./productos.do?metodo=verProductos">Comprar aquí</a></div></br>
                                </li>
                            </logic:iterate>
                            </ul> 
                    </header>
                       
		</article> <!-- /article -->
	</section> <!-- / #main-content -->
      
        </div>

        <footer id="main-footer">
		<p>&copy; 2017 <a href="#">ShopyMarket.com</a></p>
                              
	</footer> <!-- / #main-footer -->
                
                
            
    </body>
</html>
