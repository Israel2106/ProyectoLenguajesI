/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopymarket.app.bussiness;

import com.shopymarket.app.data.DataBase;
import com.shopymarket.app.data.DataProducto;
import com.shopymarket.app.dominio.Producto;
import java.io.File;
import java.net.MalformedURLException;
import java.sql.Connection;
import java.util.LinkedList;

/**
 *
 * @author Yessica Zuñiga
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.LinkedList;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Yessica Zuñiga
 */
public class BussinesProducto {
    
    private DataProducto dProducto;
    DataBase base;
    Connection conn;
    
    public BussinesProducto (){
    
    dProducto = new DataProducto("root","");
    }
    
    public Producto mostrarProducto(String n, int idCliente){
    return dProducto.mostrarProducto(n, idCliente);
    }
    
    public boolean actualizar(int idProducto,int idCliente,Producto producto){
    return dProducto.modificar(idProducto, idCliente, producto);
    }
    public LinkedList<String> mostrarDatos(String tabla){
    return  dProducto.mostrarDatos(tabla);
    }
    
    public boolean insertar(Producto producto){
    return dProducto.insertar(producto);
    }

    public void eliminar(int codigo){
    
    dProducto.eliminar(codigo);
    }
    public LinkedList<Producto> getListaProductos(int id)  {
        System.out.println("El bussines ");
        return dProducto.getProductos(id);        
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public String seleccionarImagenes() {
    String direccion="";
    String d="";
    JFileChooser selector=new JFileChooser();
    FileNameExtensionFilter filtroImagen=new FileNameExtensionFilter("JPG, PNG & GIF","jpg","png","gif");
    selector.setFileFilter(filtroImagen);
    int r=selector.showOpenDialog(null);
    if(r==JFileChooser.APPROVE_OPTION){
     try {
      File f=selector.getSelectedFile();
      
      direccion= (f.getName());
      //ImageIcon img=new ImageIcon(selector.getSelectedFile().toURL());
      d= ""+selector.getSelectedFile().toURL();
      direccion = d.substring(6);
      System.out.println(direccion);
     } catch (MalformedURLException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
     }
    }
direccion = "file:///C:/Users/usuario/Pictures/9.jpg";
    return direccion;
}
    
    
}

