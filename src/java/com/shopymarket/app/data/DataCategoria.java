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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author usuario
 */
public class DataCategoria extends HibernateUtil{
    
   
    
    public void insert(Object o){
    
        Transaction transaction = null;
        Session session = this.getSessionFactory().openSession();
        
        try{
        
            transaction = session.beginTransaction();
            session.save(o);
            transaction.commit();
        }catch(HibernateException he){
        
            if(transaction!= null){
                transaction.rollback();
            }
            he.printStackTrace();
        }finally{
            session.close();
        }
    }
    
     public ArrayList<Categoria> getEstudiantes(){
    
        ArrayList<Categoria> categorias = new ArrayList();
        Transaction transaction = null;
        Session session = this.getSessionFactory().openSession();
        
        try{
        
            transaction = session.beginTransaction();
            categorias = (ArrayList<Categoria>) session.createQuery("FROM Categoria").list();
            for(Categoria c: categorias){
                System.out.println(c.getIdCategoria());
            }
            transaction.commit();
        }catch(HibernateException he){
        
            if(transaction!= null){
                transaction.rollback();
            }
            he.printStackTrace();
        }finally{
            session.close();
        }
        return categorias;
    }
    public static void main(String args []){
        DataCategoria dcat= new DataCategoria();
        Categoria categoria = new Categoria("Licores");
        
        dcat.insert(categoria);
        dcat.getEstudiantes();
    }
    
    
//     public int consultar(String categoria){
//    
//        Producto producto;
//        int idCategoria=0;
//        producto= new Producto("",0,"",0,"",0);
//         try {
//             String consulta = "SELECT idCategoria from producto p inner join categoria c on p.idCategoria = c.idCategoria"
//                + "where c.nombre = ?";
//             
//             con = this.getConection();
//             
//             PreparedStatement statement = con.prepareStatement(consulta);
//             statement.setString(1,categoria);
//             statement.setInt(2, 1);
//             ResultSet res = statement.executeQuery();
//                  
//             while(res.next()){
//                idCategoria= res.getInt("idCategoria");
//                 
//             }
//         } catch (SQLException ex) {
//             Logger.getLogger(DataProducto.class.getName()).log(Level.SEVERE, null, ex);
//         }
//         return idCategoria;       
//    } 
   
      
    
}
