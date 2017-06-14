/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopymarket.app.action;

import com.shopymarket.app.bussiness.BussinessCliente;
import com.shopymarket.app.dominio.Cliente;
import java.sql.ResultSet;
import java.util.LinkedList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import org.apache.struts.actions.DispatchAction;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;

/**
 *
 * @author Israel
 */
public class ClienteAction extends DispatchAction {

    /**
     * This is the Struts action method called on
     * http://.../actionPath?method=myAction1, where "method" is the value
     * specified in <action> element : ( <action parameter="method" .../> )
     */
    public ActionForward setCliente(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
     
//        String n=request.getParameter("nombre");
//        String em=request.getParameter("email");
//        String tel=request.getParameter("telefono");
//        String pass=request.getParameter("pass");
//        Cliente c = new Cliente(n, em, tel);
//        BussinessCliente bc = new BussinessCliente("root", "");
//        c.setId(bc.getNextID());
//        bc.insertarVendedor(n, em, tel,pass);
//        request.setAttribute("cliente",c);

            Cliente c = new Cliente("Nom","Mail","77888");
            c.setId(Integer.parseInt("33"));
            request.setAttribute("cliente",c);
        return mapping.findForward("moduloCliente");
    }

    /**
     * This is the Struts action method called on
     * http://.../actionPath?method=myAction2, where "method" is the value
     * specified in <action> element : ( <action parameter="method" .../> )
     */
    public ActionForward actualizarCliente(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
            String id= request.getParameter("idEmpresa");
            String n=request.getParameter("nombre");
            String em=request.getParameter("email");
            String tel=request.getParameter("telefono");
            Cliente c= new Cliente(n, em, tel);
            c.setId(Integer.parseInt(id));
            BussinessCliente bc= new  BussinessCliente("root", "");
            bc.editarVendedor(c, id);
           
            request.setAttribute("cliente",c);
        
        return mapping.findForward("moduloCliente");
    }
    
    public ActionForward eliminarCliente(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
            String id= request.getParameter("idEmpresa");
            BussinessCliente bc= new  BussinessCliente("root", "");
            bc.eliminarVendedor(id);
        
        return mapping.findForward("inicio");
    }
    
    
        public ActionForward mostrarClientes(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
            BussinessCliente bc= new BussinessCliente("root", "");
            LinkedList<Cliente> supermercados= bc.obtenerTodosVendedores();
            request.setAttribute("supermercados", supermercados);
            
            
        return mapping.findForward("tiendas");
    }
}
