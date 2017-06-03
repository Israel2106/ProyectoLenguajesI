/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopymarket.app.data;

import com.shopymarket.app.dominio.Categoria;
import com.shopymarket.app.dominio.Producto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
public class DataCategoria extends DataBase{
    
    Connection con;
    PreparedStatement ps;
    public DataCategoria(String user, String pass) {
        super(user, pass);
    }
    
    public boolean insertar(Categoria categoria){
        boolean inserta= true;
        String sql = "insert into categoria(nombre) values (?)";
        try {
            con= this.getConection();
            ps= con.prepareStatement(sql);
            ps.setString(1, categoria.getNombre());
            
        } catch (SQLException ex) {
            Logger.getLogger(DataCategoria.class.getName()).log(Level.SEVERE, null, ex);
            inserta = false;
        }
        
        return inserta;
    }
    
    public int consultar(String categoria){
    
        Producto producto;
        int idCategoria=0;
        producto= new Producto("",0,"",0,"",0);
         try {
             String consulta = "SELECT idCategoria from producto p inner join categoria c on p.idCategoria = c.idCategoria"
                + "where c.nombre = ?";
             
             con = this.getConection();
             
             PreparedStatement statement = con.prepareStatement(consulta);
             statement.setString(1,categoria);
             statement.setInt(2, 1);
             ResultSet res = statement.executeQuery();
                  
             while(res.next()){
                idCategoria= res.getInt("idCategoria");
                 
             }
         } catch (SQLException ex) {
             Logger.getLogger(DataProducto.class.getName()).log(Level.SEVERE, null, ex);
         }
         return idCategoria;       
    }    
    
}
