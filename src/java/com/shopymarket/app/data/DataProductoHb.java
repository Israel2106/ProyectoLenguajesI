/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopymarket.app.data;

import com.shopymarket.app.dominio.Direccion;
import com.shopymarket.app.dominio.Usuarios;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Hector Zuñiga
 */
public class DataProductoHb extends HibernateUtil{
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
     
     public static void main(String args []){
        DataUsuariosH de= new DataUsuariosH();
        
        Direccion direccion = new Direccion("Guapilandia");
        Usuarios user = new Usuarios("yess@hotmail.com", "Robinson", "123","Comprador");
//        de.insert(direccion);
        de.insert(user);
    }
}
