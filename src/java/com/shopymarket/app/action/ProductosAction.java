/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopymarket.app.action;


import com.google.gson.Gson;
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
import org.json.JSONObject;

/**
 *
 * @author Yessica Zuñiga
 */
public class ProductosAction extends DispatchAction {

    /* forward name="success" path="" */
    private final static String SUCCESS = "success";
    BussinesProducto bProducto = new BussinesProducto();
//    DataCategoria dCategoria = new DataCategoria("root", "");
    String nombre="";
        int precio=0 ;
        String marca="";
        int cantidad=0; 
        String categoria="";
        int id_usuario= 1;  
        String estado="";
    

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
            request.setAttribute("estado", estado);
                  
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
        id_usuario= 2;// cambiar aquí
        String img = request.getParameter("url");
        request.setAttribute("url", "img/no-image.svg");
        Producto producto = new Producto(categoria,cantidad,nombre,precio,marca,id_usuario);
        producto.setImagen(img);
        
        
        if(bProducto.insertar(producto)){
            estado = "Se ha insertado";
            request.setAttribute("estado", estado);
        }else {
             estado = "el nombre ya existe, intente otro";
            request.setAttribute("estado", estado);
        }
       
     
        
        }catch (Exception e){
             JOptionPane.showMessageDialog(null, "Error de algun" + e.getMessage());
        }
        estado= "";
        return mapping.findForward("inicio");
    }
    

    /**
     * This is the Struts action method called on
     * http://.../actionPath?method=myAction2, where "method" is the value
     * specified in <action> element : ( <action parameter="method" .../> )
     */
    public ActionForward verProductos(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        
        int id=  Integer.parseInt(request.getParameter("id"));
        LinkedList<Producto> listaproductos= bProducto.getListaProductos(id);
        request.setAttribute("lista", listaproductos);
        new ProductosAction().escribirJSON(listaproductos);
        
        
        return mapping.findForward("mostrar");
    }
    
     public ActionForward mostrarProducto(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        //Productos por tienda en una lista
        
        LinkedList<Producto> prod= bProducto.getListaProductos(2);       
        LinkedList<String> categorias= bProducto.mostrarDatos("categoria");
        
        new ProductosAction().escribirJSON(prod);
               request.setAttribute("categorias", categorias);
               request.setAttribute("produ", prod);
            
    
          
        return mapping.findForward("modificar_producto");
    }
     public ActionForward modificar(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
         
         int idCliente= Integer.parseInt(request.getParameter("idCliente"));
         int idproducto= Integer.parseInt(request.getParameter("id"));

               System.out.println("idC "+idCliente+" prod " +idproducto+"");  
         Producto p = new Producto (request.getParameter("n"),request.getParameter("marca"),
         Integer.parseInt(request.getParameter("cantidad")),Integer.parseInt(request.getParameter("precio")));
         
         System.out.println("Producto "+request.getParameter("nombre"));  
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
    
      public void escribirJSON(LinkedList<Producto> lista){
        
        Gson gson = new Gson();
        String list = gson.toJson(lista);
         
        try {
           FileWriter fw = new FileWriter("C:\\Users\\Hector Zuñiga\\Documents\\NetBeansProjects\\ProyectoLenguajesI\\web\\json\\productos.json",true);
           BufferedWriter bw = new BufferedWriter(fw);
           bw.write("");
            bw.close();
           FileWriter file = new FileWriter("C:\\Users\\Hector Zuñiga\\Documents\\NetBeansProjects\\ProyectoLenguajesI\\web\\json\\productos.json");
           file.write(list);
            file.flush();
            file.close();
           
        }catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Entra al jason"+list.toString());
    }
}
     
     
    



