/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopymarket.app.bussiness;

import Email.EnviarCorreo;
import com.shopymarket.app.data.DataUsuarios;
import com.shopymarket.app.dominio.Usuarios;

/**
 *
 * @author EmmanuelJs
 */
public class BussinessUsuarios {
    
       public boolean insertarU(Usuarios user){
        
        DataUsuarios du = new DataUsuarios("root","");//DataUsuarios("ucrgrupo4","Grupo#4Koee!")
        //du.insertarUsuario(user);//email, user, pass, id, direccion
        
        return du.insertarUsuario(user);
    
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
       
          public void enviarMensaje(String receptor, String pass){
           EnviarCorreo send = new EnviarCorreo();
           
           send.send(receptor, pass);
       
       }
          
          
      public String recuperarContrasena(String email){
        
        DataUsuarios du = new DataUsuarios("root","");//DataUsuarios("ucrgrupo4","Grupo#4Koee!")
        //du.insertarUsuario(user);//email, user, pass, id, direccion
        
        return du.recuperarContrasena(email);
    
    }
}//class
