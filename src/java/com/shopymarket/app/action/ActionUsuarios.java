/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopymarket.app.action;

import com.shopymarket.app.bussiness.BussinessUsuarios;
import com.shopymarket.app.dominio.Usuarios;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
       Usuarios usua = new Usuarios(email, user, pass, 0, direccion);
       BussinessUsuarios bu = new BussinessUsuarios();
       
        
        bu.insertarU(usua);//email, user, pass, id, direccion
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
       
        
        Usuarios usua = new Usuarios(email, user, pass, id, direccion);
        
        BussinessUsuarios bu = new BussinessUsuarios();
        bu.actualizarU(id, usua);
        
        request.setAttribute("id", id);
              request.setAttribute("email", email);
              request.setAttribute("direccion", direccion);
              request.setAttribute("user_name", user);
              request.setAttribute("pass", pass);
        
        return mapping.findForward("entro");
    }
    
     public ActionForward userLogIn(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
         
         
        String userName = request.getParameter("user_name");
        String pass= request.getParameter("pass");
       
        request.setAttribute(userName, "user_name");
        
        
        BussinessUsuarios bus = new BussinessUsuarios();
        
      String email= bus.userValidar(userName, pass).getEmail();
      int id=bus.userValidar(userName, pass).getId();
      String direccion=bus.userValidar(userName, pass).getDireccion();
        
        if(userName.equals(bus.userValidar(userName, pass).getUserName()) && bus.userValidar(userName, pass).getUserName() != "" && pass.equals(bus.userValidar(userName, pass).getContrasena()) && bus.userValidar(userName, pass).getContrasena() != ""){
              request.setAttribute("id", id);
              request.setAttribute("email", email);
              request.setAttribute("direccion", direccion);
              request.setAttribute("user_name", userName);
              request.setAttribute("pass", pass);
               return mapping.findForward("entro");
          
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
}
