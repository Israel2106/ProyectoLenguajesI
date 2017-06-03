/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopymarket.app.bussiness;

import com.shopymarket.app.data.DataUsuarios;
import com.shopymarket.app.dominio.Usuarios;

/**
 *
 * @author EmmanuelJs
 */
public class BussinessUsuarios {
    
      public void insertarU(Usuarios user){//, String email, String user, String pass, int id, String direccion
        
        DataUsuarios du = new DataUsuarios("root","");
        du.insertarUsuario(user);//email, user, pass, id, direccion
    
    }
     
     public void eliminarU(int id_user){
         
          DataUsuarios du = new DataUsuarios("root","");
     du.eliminarUsuario(id_user);
     }
    
     //*************************************************************************
      public void actualizarU(int id_user, Usuarios us){
         
          DataUsuarios du = new DataUsuarios("root","");
          
            du.actualizarUsuario(id_user, us);
     }
      
      public Usuarios userValidar(String user, String pass){
          
          
          DataUsuarios du = new DataUsuarios("root","");
          
          return du.validarUser(user, pass); 
  
          
      }
  
 //**************************************************************************************************************+
      
       public Usuarios verUsuario(int id){
        DataUsuarios datu = new DataUsuarios("root", "");
        return datu.getUsuario(id);
    }
}//class
