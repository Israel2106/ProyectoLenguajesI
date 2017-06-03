/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopymarket.app.data;

import com.mysql.jdbc.CallableStatement;
import com.mysql.jdbc.Statement;
import com.shopymarket.app.dominio.Usuarios;
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
 * @author EmmanuelJs
 */
public class DataUsuarios extends DataBase{
    
    
    
    Connection con;

    public DataUsuarios(String user, String pass) {
        super(user, pass);
    }
    
    
     public boolean insertarUsuario(Usuarios user){
        boolean inserto = true;
        String sql ="CALL insertar_usuario('"+user.getEmail()+"', '"+user.getUserName()+"', '"+user.getContrasena()+"', '"+user.getDireccion()+"')";

        ResultSet r=null;
        try {
            con = this.getConection();
            CallableStatement proc = (CallableStatement) con.prepareCall(sql);
            r = proc.executeQuery();
            if(r.next()){
                JOptionPane.showMessageDialog(null, r.getString("resultado"));
                if(r.getString("resultado").equals("correo ya existe")){
                    inserto =false;    
                }
            }
     
            proc.close();
        } catch (SQLException ex) {
            inserto = false;
            Logger.getLogger(DataUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return inserto;
    }

        public boolean eliminarUsuario(int id_user){
    
        boolean eliminar = true;    
        String sql= "DELETE FROM usuarios where id= '"+id_user+"'";
       
        try {
            con = this.getConection();
            PreparedStatement statement = con.prepareStatement(sql);
            statement.executeUpdate();
            statement.close();
            con.close();
        } catch (SQLException ex) {
            eliminar = false;
            Logger.getLogger(DataUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return eliminar;
    }
        
        public boolean actualizarUsuario(int id_user, Usuarios user){
    
        boolean actualizar = true;    
        String sql= "UPDATE usuarios SET email='"+user.getEmail()+"',"+"user_name='"+user.getUserName()+"',"+"pass='"+user.getContrasena()+"',"+"direccion='"+user.getDireccion()+"'"+" WHERE id = "+id_user+"";
       
        try {
           con = this.getConection();
            PreparedStatement statement = con.prepareStatement(sql);
            statement.executeUpdate();
            statement.close();
            con.close();
        } catch (SQLException ex) {
            actualizar = false;
            Logger.getLogger(DataUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return actualizar;
    }
        
     public Usuarios validarUser(String user, String pass){
         
          String sql= "SELECT * FROM usuarios WHERE user_name='"+user+"'AND pass='"+pass+"'";
         Usuarios usuario;
         usuario = new Usuarios("", "", "", 0, "");
        try {
            con = this.getConection();
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs=st.executeQuery();
         
            while(rs.next()){
                usuario.setEmail(rs.getString("email"));
                usuario.setUserName(rs.getString("user_name"));
                usuario.setContrasena(rs.getString("pass"));
                usuario.setId(rs.getInt("id"));
                usuario.setDireccion(rs.getString("direccion"));
           
            }
       
            st.close();
            con.close();
 
        } catch (SQLException ex) {
          
            Logger.getLogger(DataUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return usuario;
     
     }
     
     
      public Usuarios getUsuario(int id){
        
        
        String sql ="SELECT * FROM usuarios WHERE id='"+id+";";
        
        Usuarios usuarios;
        usuarios = new Usuarios("", "", "", 0, "");
     
        try {
            con=this.getConection();
            
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            
            while (result.next()) {
                usuarios.setEmail(result.getString("email"));
                usuarios.setUserName(result.getString("user_name"));
                usuarios.setContrasena(result.getString("pass"));
                usuarios.setId(result.getInt("id"));
                usuarios.setDireccion(result.getString("direccion"));
                

            }
            statement.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuarios;
    }//metodo getEditorial
}
