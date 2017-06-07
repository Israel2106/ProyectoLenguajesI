<%-- 
    Document   : logueado
    Created on : 24-abr-2017, 22:10:30
    Author     : EmmanuelJs
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>sigin</title>
       <link rel="stylesheet" href="css/inicio.css">
       
       
        
    </head>
    <body>
        <header id="main-header">
            
            <a id="logo-header" href="#">
                <img src="./img/logo3.png"  width="50" height="50"/>
                <span class="site-name">ShopyMarket</span>
		<span class="site-desc">Tu Mercado Cerquitica</span>
                
            </a> <!-- / #logo-header -->
            
             <nav>
                 <ul class="nav">
                    <li><a href="#">Acerca de</a></li>
                    <li><a href="#">Contacto</a></li>
                    <%String nombre= ""+request.getParameter("user_name");
                    
                    %>
                    
                    <li><a href="#">Hola! <%=nombre%></a>
				
                        <ul>
                        
                            <li><a href="./usuarios.do?metodo=configuracionUs&email=<%= request.getAttribute("email")%>&user_name=<%= request.getAttribute("user_name")%>&pass=<%= request.getAttribute("pass")%>&id=<%= request.getAttribute("id")%>&direccion=<%= request.getAttribute("direccion")%>">Configuracion</a></li>
                            <li><a href="log_in.html">cerrar Sesion</a></li>
					
			</ul>
                    </li>
   
		</ul>
            </nav><!-- / nav -->

        </header>
                    
        <section id="main-content">
	
		<article>
			<header>
				<h1>Mostrar tiendas con usuario logueado</h1>
			</header>
			
			
                        
                         <div class="content">
                             <p >mostrar tiendas</p>
			 
			</div>
			
			
		</article> <!-- /article -->
               
                
	
	</section> <!-- / #main-content -->
        
        <footer id="main-footer">
		<p>&copy; 2017 <a href="#">ShopyMarket.com</a></p>
                <p>Configurar Cuenta:<a href="./usuarios.do?metodo=configuracionUs&email=<%= request.getAttribute("email")%>&user_name=<%= request.getAttribute("user_name")%>&pass=<%= request.getAttribute("pass")%>&id=<%= request.getAttribute("id")%>&direccion=<%= request.getAttribute("direccion")%>"><%=nombre%> </a></p>
                
	</footer> <!-- / #main-footer -->
                
                
            
    </body>
</html>
