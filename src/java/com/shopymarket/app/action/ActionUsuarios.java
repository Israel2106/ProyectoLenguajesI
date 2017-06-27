/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopymarket.app.action;

import com.shopymarket.app.bussiness.BussinessCliente;
import com.shopymarket.app.bussiness.BussinessUsuarios;
import com.shopymarket.app.data.DataClientes;
import com.shopymarket.app.data.DataUsuarios;
import com.shopymarket.app.data.DataUsuariosH;
import com.shopymarket.app.dominio.Cliente;
import com.shopymarket.app.dominio.Direccion;
import com.shopymarket.app.dominio.Usuarios;
import com.shopymarket.app.dominio.UsuariosB;
import java.util.LinkedList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import org.apache.struts.actions.DispatchAction;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward; 

/**
 *
 * @author EmmanuelJs
 */
public class ActionUsuarios extends DispatchAction {

    /* forward name="success" path="" */
    private final static String SUCCESS = "success";

    /**
     * This is the Struts action method called on
     * http://.../actionPath?method=myAction1, where "method" is the value
     * specified in <action> element : ( <action parameter="method" .../> )
     */
    public ActionForward insertarUsuarios(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
       String email = request.getParameter("email");
        String user = request.getParameter("user");
        String pass = request.getParameter("pass");
        //int id = Integer.parseInt(request.getParameter("id"));
        String direccion = request.getParameter("direccion");
        
       UsuariosB usua = new UsuariosB(email, user, pass, 0, direccion, "");
       BussinessUsuarios bu = new BussinessUsuarios();
       
       DataUsuariosH de= new DataUsuariosH();
       de.insert(usua);
       
        bu.enviarMensaje(email, "");//email= receptor del mensaje
  
       /* if(de.insert(usua)){
            
            return mapping.findForward("error_log_in");
            
        }else{
            
            JOptionPane.showMessageDialog(null, "El correo ya existe intente con otro");
            return mapping.findForward("insertar_usuario.html");
            }*/
       return mapping.findForward("error_log_in");
    }

    /**
     * This is the Struts action method called on
     * http://.../actionPath?method=myAction2, where "method" is the value
     * specified in <action> element : ( <action parameter="method" .../> )
     */
    public ActionForward eliminarUsuarios(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
       int id = Integer.parseInt(request.getParameter("id"));
        BussinessUsuarios bu = new BussinessUsuarios();
        bu.eliminarU(id);
        
        return mapping.findForward("error_log_in");
    }
    
    public ActionForward actualizarUsuarios(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        
        String email = request.getParameter("email");
        String user = request.getParameter("user_name");
        String pass = request.getParameter("pass");
        int id = Integer.parseInt(request.getParameter("id"));
        String direccion = request.getParameter("direccion");
       
        
        UsuariosB usua = new UsuariosB(email, user, pass, id, direccion,"");
        
        BussinessUsuarios bu = new BussinessUsuarios();
        bu.actualizarU(id, usua);
        
        HttpSession sesion = request.getSession(true);// inicio la sesion
 
            sesion.setAttribute("id", id);
            sesion.setAttribute("user_name", user);
            sesion.setAttribute("email", email);
            sesion.setAttribute("direccion", direccion);
            sesion.setAttribute("pass", pass);
        
         BussinessCliente bc= new BussinessCliente("root", "");
         LinkedList<Cliente> supermercados= bc.obtenerTodosVendedores();
         request.setAttribute("supermercados", supermercados);
        
        return mapping.findForward("comprador");
    }
    
     public ActionForward userLogIn(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response)
            throws Exception {
          
      String userName = request.getParameter("user_name");
      String pass= request.getParameter("pass");
      
      BussinessUsuarios bus = new BussinessUsuarios();
      DataUsuarios du = new DataUsuarios("root", "");
   
      if(bus.verUsuario(userName, pass)){
          HttpSession sesion = request.getSession(true);// inicio la sesion
          
          if(du.getUsuario(userName, pass).getTipoU().equals("Comprador")){
          
            userName = bus.userValidar(userName, pass).getUserName();
            pass =   bus.userValidar(userName, pass).getContrasena();
            String   email= bus.userValidar(userName, pass).getEmail();
            int id = bus.userValidar(userName, pass).getId();
            String direccion = bus.userValidar(userName, pass).getDireccion();
            
            sesion.setAttribute("id", id);//seteo en la sesion y el el jsp los obtengo con sesion.getAttribute
            sesion.setAttribute("user_name", userName);
            sesion.setAttribute("email", email);
            sesion.setAttribute("direccion", direccion);
            sesion.setAttribute("pass", pass);
            
            
            BussinessCliente bc= new BussinessCliente("root", "");
            LinkedList<Cliente> supermercados= bc.obtenerTodosVendedores();
            request.setAttribute("supermercados", supermercados);//con esto le paso las tiendas 
            
            return mapping.findForward("comprador");
            
          }else if(du.getUsuario(userName, pass).getTipoU().equals("Vendedor")){
                    DataClientes dc = new DataClientes("root", "");
                    Cliente cli =dc.obtenerVendedor(userName, pass);
                    request.setAttribute("cliente",cli);
                    return mapping.findForward("moduloCliente");
          }else{
              
                return mapping.findForward("error_log_in");
          }
  
      }else{
            return mapping.findForward("error_log_in");
      }
     }
     
      public ActionForward configuracionUs(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
           String email=request.getParameter("email");
           String user=request.getParameter("user_name");
           String pass=request.getParameter("pass");           
            int id = Integer.parseInt(request.getParameter("id"));
            String direccion=request.getParameter("direccion");
            
            
            request.setAttribute("email", email);
            request.setAttribute("user_name", user);
            request.setAttribute("pass", pass);
            request.setAttribute("id", id);
            request.setAttribute("direccion", direccion);

        return mapping.findForward("configuracion");
    }
      
      public ActionForward recuperaContrasena(ActionMapping mapping, ActionForm form,HttpServletRequest request, HttpServletResponse response)
  throws Exception {
        
        String email = request.getParameter("email");
        BussinessUsuarios bu = new BussinessUsuarios();
        
        
        if(bu.recuperarContrasena(email).equals("")){
            return mapping.findForward("error_correo");
            
        }else{

            
            bu.enviarMensaje(email, bu.recuperarContrasena(email));
            JOptionPane.showMessageDialog(null, "Revise su Correo");
            return mapping.findForward("error_log_in");
            
        }//else
    }
}