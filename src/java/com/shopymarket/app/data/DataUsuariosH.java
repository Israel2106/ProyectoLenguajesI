/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopymarket.app.data;

import com.shopymarket.app.dominio.Direccion;
import com.shopymarket.app.dominio.Usuarios;
import java.util.ArrayList;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author EmmanuelJs
 */
public class DataUsuariosH extends HibernateUtil{
    
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
    public ArrayList<Usuarios> getLista(){
    
        ArrayList<Usuarios> categorias = new ArrayList();
        Transaction transaction = null;
        Session session = this.getSessionFactory().openSession();
        
        try{
        
            transaction = session.beginTransaction();
            categorias = (ArrayList<Usuarios>) session.createQuery("FROM Usuarios").list();
            for(Usuarios c: categorias){
                System.out.println(c.getDireccion()+" Nombre "+ c.getUserName());
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

     
    /* public static void main(String args []){
        DataUsuariosH de= new DataUsuariosH();
        
        Direccion direccion = new Direccion("Guapilandia");
        Usuarios user = new Usuarios("yess@hotmail.com", "Israel", "123","Comprador");
//        de.insert(direccion);
//        ProductoHb p = new ProductoHb(1,13, "leche condensada", 550,"leopardo", 1);
        
        
        de.insert(user);
        de.getLista();
    }*/
    
}

