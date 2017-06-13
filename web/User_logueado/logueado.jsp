<%-- 
    Document   : logueado
    Created on : 24-abr-2017, 22:10:30
    Author     : EmmanuelJs
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@page session="true" %>

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
                    
                    <li><a href="#">Hola! <%=sesion.getAttribute("user_name")%></a>
				
                        <ul>
                        
                            <li><a href="./usuarios.do?metodo=configuracionUs&email=<%=sesion.getAttribute("email")%>&user_name=<%=sesion.getAttribute("user_name")%>&pass=<%=sesion.getAttribute("pass")%>&id=<%=sesion.getAttribute("id")%>&direccion=<%=sesion.getAttribute("direccion")%>">Configuracion</a></li>
                            <li><a href="./log_in.jsp?cerrar=true">cerrar Sesion</a></li>
					
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
                <p>Configurar Cuenta:<a href="../usuarios.do?metodo=configuracionUs&email=<%= sesion.getAttribute("email")%>&user_name=<%= sesion.getAttribute("user_name")%>&pass=<%= sesion.getAttribute("pass")%>&id=<%= sesion.getAttribute("id")%>&direccion=<%= sesion.getAttribute("direccion")%>"><%=sesion.getAttribute("user_name")%> </a></p>
                
	</footer> <!-- / #main-footer -->
                
                
            
    </body>
</html>
