/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopymarket.app.data;

import com.shopymarket.app.dominio.Producto;
import java.io.File;
import java.net.MalformedURLException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

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
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Yessica Zuñiga
 */
public class DataProducto extends DataBase {
    
     Connection con;
     com.mysql.jdbc.PreparedStatement ps;
     
    public DataProducto(String user, String pass){
        super(user,pass);
    }
    
    
   
    
    public LinkedList<String> mostrarDatos(String tabla){
        LinkedList<String> lista= new LinkedList<>();
     try {
            // Obtener datos de la tabla
           String sql = "select * from "+tabla+"";
           con= this.getConection();
           
                PreparedStatement statement = con.prepareStatement(sql); 
                ResultSet re = statement.executeQuery();  
                //statement.executeUpdate();
               
          
            if(re!= null){
            while(re.next() == true) {
                lista.add(re.getString("nombre"));                                
            }
           }
            
        } catch (Exception e) {
            System.out.println("Error de lectura de BD\n\n");
            
            e.printStackTrace();
        } 
     return lista;
    }
    
    public boolean insertar(Producto producto){
        boolean inserto = true;    
        String sql= "INSERT INTO producto(idCategoria,idVendedor,nombre,marca,precio,cantidad,imagen) "
                + "VALUES (?,?,?,?,?,?,?)";
       
        
        try {
            con = this.getConection();
            try (PreparedStatement statement = con.prepareStatement(sql)) {
                statement.setInt(1, 1);
                statement.setInt(2, 1);
                statement.setString(3, producto.getNombre());
                statement.setString(4, producto.getMarca());
                statement.setInt(5, producto.getPrecio());
                statement.setInt(6, producto.getCantidad());
                statement.setString(7, producto.getImagen());
                statement.executeUpdate();
                JOptionPane.showMessageDialog(null, "Inserta en BD");
            }
            con.close();
        } catch (SQLException ex) {
            inserto = false;
            Logger.getLogger(DataProducto.class.getName()).log(Level.SEVERE, null, ex);
             JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        

        return inserto;
    }
    
    public boolean eliminar(int codigo){
    
        boolean borrar = true;    
        String sql= "DELETE FROM producto where idProducto = "+ codigo+"";
       
        System.out.println("Borra");
        try {
            con = this.getConection();
            PreparedStatement statement = con.prepareStatement(sql);
            statement.executeUpdate();
            statement.close();
            con.close();
        } catch (SQLException ex) {
            borrar = false;
            Logger.getLogger(DataProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        return borrar;
    }
    
    public boolean modificar(int idProducto,int idCliente,Producto p){
        boolean actualiza= true;
        
        String sql= "UPDATE producto set "
                + " nombre='"+p.getNombre()+"',marca='"+p.getMarca()+"',"
                + "precio="+p.getPrecio()+", cantidad="+p.getCantidad()+" "
                + "where idProducto= "+idProducto+" and idVendedor = "+idCliente+"";
        
        try{
        
            con = this.getConection();
            PreparedStatement statement= con.prepareStatement(sql);
//            statement.setInt(1,idProducto);
//            statement.setInt(2, idCliente);
            statement.execute();
            
            
            
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return actualiza;
    
    }
    
    public Producto mostrarProducto(String nombre, int idC){
        
        Producto producto;
        producto= new Producto("",0,"",0,"",0);
         try {
             String sql ="SELECT * FROM producto where nombre = ? and idVendedor = ?";
             
             con = this.getConection();
             
             PreparedStatement statement = con.prepareStatement(sql);
             statement.setString(1,nombre);
             statement.setInt(2, 1);
             ResultSet res = statement.executeQuery();
             
             
             while(res.next()){
                
                 producto.setIdCategoria(res.getString("idCategoria"));
                 producto.setCantidad(res.getInt("cantidad"));
                 producto.setNombre(res.getString("nombre"));
                 producto.setPrecio(res.getInt("precio"));
                 producto.setMarca(res.getString("marca"));
                 producto.setIdCliente(res.getInt("idVendedor"));
                 producto.setImagen(res.getString("imagen"));
             }
         } catch (SQLException ex) {
             Logger.getLogger(DataProducto.class.getName()).log(Level.SEVERE, null, ex);
         }
         return producto;
    }
    
    public LinkedList<Producto> getProductos(int idCliente){
    
        LinkedList<Producto> productos = new LinkedList();
        String sql = "CALL ver_productos("+idCliente+")";
        ResultSet result= null;
        
        try {
            con = this.getConection();       
            CallableStatement proc = con.prepareCall(sql);
            //proc.setInt("idEmpresa", idCliente);
            
            result = proc.executeQuery();
            
        while(result.next()){
        
            Producto prod = new Producto("",0,"",0,"",0);
            prod.setIdCategoria(result.getString("nombre_cat"));
            prod.setIdProducto(result.getInt("idProducto"));
            prod.setNombre(result.getString("nombre"));
            prod.setMarca(result.getString("marca"));
            prod.setPrecio(result.getInt("precio"));
            prod.setIdCliente(result.getInt("idVendedor"));
            prod.setCantidad(result.getInt("cantidad"));
            prod.setImagen(result.getString("imagen"));
           
            productos.add(prod);
        }
            proc.close();
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,ex.getMessage());
            Logger.getLogger(DataProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return productos;
    }
    
    public static void main(String args[]){
        DataProducto d = new DataProducto("root","");
        
             
         
        d.mostrarDatos("producto");
    
    }
    
    


    
    
}

