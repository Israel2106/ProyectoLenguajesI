/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopymarket.app.action;


import com.shopymarket.app.bussiness.BussinesProducto;
import com.shopymarket.app.data.DataCategoria;
import com.shopymarket.app.dominio.Producto;
import java.util.LinkedList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import org.apache.struts.actions.DispatchAction;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import java.io.*;

/**
 *
 * @author Yessica Zuñiga
 */
public class ProductosAction extends DispatchAction {

    /* forward name="success" path="" */
    private final static String SUCCESS = "success";
    BussinesProducto bProducto = new BussinesProducto();
    DataCategoria dCategoria = new DataCategoria("root", "");
    String nombre="";
        int precio=0 ;
        String marca="";
        int cantidad=0; 
        String categoria="";
        int id_usuario= 1;   
    

    /**
     * This is the Struts action method called on
     * http://.../actionPath?method=myAction1, where "method" is the value
     * specified in <action> element : ( <action parameter="method" .../> )
     * @throws java.lang.Exception
     */
    public ActionForward mostrar(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        try{     
       
            LinkedList<String> categorias= bProducto.mostrarDatos("categoria");
            Producto producto= new Producto("",0,"",0,"",0);
            request.setAttribute("producto", producto);
            request.setAttribute("categorias", categorias);
            request.setAttribute("url", "img/no-image.svg");
                  
        }catch (Exception e){
             JOptionPane.showMessageDialog(null, "Error de algun numero" + e.getMessage());
        }

        return mapping.findForward("ingresar");
    }
    
    public ActionForward insertarProducto(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        try{
        
        nombre= (String) request.getParameter("nombre");
        precio =Integer.parseInt(request.getParameter("precio"));
        marca= request.getParameter("marca");
        cantidad =Integer.parseInt(request.getParameter("cantidad"));
        categoria= (String)request.getParameter("id_categoria");
        id_usuario= 2;
        String img = request.getParameter("url");
        request.setAttribute("url", "img/man.png");
        Producto producto = new Producto(categoria,cantidad,nombre,precio,marca,id_usuario);
        producto.setImagen(img);
        bProducto.insertar(producto);
        LinkedList<String> categorias= bProducto.mostrarDatos("categoria");
        request.setAttribute("categorias", categorias);
        producto= new Producto("",0,"",0,"",0);
        request.setAttribute("producto", producto);
        
        }catch (Exception e){
             JOptionPane.showMessageDialog(null, "Error de algun" + e.getMessage());
        }

        return mapping.findForward("ingresar");
    }
    

    /**
     * This is the Struts action method called on
     * http://.../actionPath?method=myAction2, where "method" is the value
     * specified in <action> element : ( <action parameter="method" .../> )
     */
    public ActionForward verProductos(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        //int id=  Integer.parseInt(request.getParameter("idCliente"));
        LinkedList<Producto> listaproductos= bProducto.getListaProductos(1);
        request.setAttribute("lista", listaproductos);
        
        return mapping.findForward("mostrar");
    }
    
     public ActionForward mostrarProducto(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        //Productos por tienda en una lista
        
        LinkedList<Producto> prod= bProducto.getListaProductos(2);
        
        System.out.println(prod.getFirst().getIdCategoria());
        LinkedList<String> categorias= bProducto.mostrarDatos("categoria");
         
               request.setAttribute("categorias", categorias);
               request.setAttribute("produ", prod);
            
    
          
        return mapping.findForward("modificar_producto");
    }
     public ActionForward modificar(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
         
         int idCliente= Integer.parseInt(request.getParameter("idCliente"));
         int idproducto= Integer.parseInt(request.getParameter("idProducto"));

                 
         Producto p = new Producto (request.getParameter("nombre"),request.getParameter("marca"),
                 Integer.parseInt(request.getParameter("cantidad")),Integer.parseInt(request.getParameter("precio")));
         
         bProducto.actualizar(idproducto, idCliente, p);

           
            
        return mapping.findForward("mostrarProductos");
    }
     public ActionForward verProducto(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        //eliminar este método lleva a ver_producto.jsp
            Producto producto= new Producto("limpieza",100,"Papas",200,"Del Campo",12);
            request.setAttribute("producto", producto);
          
        return mapping.findForward("ver_producto");
    }
    
     
     
     public ActionForward seleccionarImagen(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
            LinkedList<String> categorias= bProducto.mostrarDatos("categoria");
            Producto producto= new Producto("",0,"",0,"",0);
            request.setAttribute("producto", producto);
            request.setAttribute("categorias", categorias);
            String imagen=  "img/man.png";//bProducto.seleccionarImagenes();
            
            request.setAttribute("url", imagen);
                      
        return mapping.findForward("ingresar");
    }
    
}


