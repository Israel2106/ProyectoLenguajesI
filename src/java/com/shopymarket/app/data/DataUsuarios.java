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
        String sql= "CALL pa_EliminarUsuario("+id_user+")";
       
        try {
            con = this.getConection();
            CallableStatement statement = (CallableStatement) con.prepareCall(sql);
            statement.executeUpdate();
            statement.close();
            con.close();
        } catch (SQLException ex) {
            eliminar = false;
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return eliminar;
    }
        
        public boolean actualizarUsuario(int id_user, Usuarios user){
    
        boolean actualizar = true;    
        String sql= "CALL pa_ActualizarUsuario('"+user.getEmail()+"','"+user.getUserName()+"','"+user.getContrasena()+"','"+user.getDireccion()+"',"+id_user+")";
       
        try {
           con = this.getConection();
            CallableStatement statement = (CallableStatement) con.prepareCall(sql);
            statement.executeUpdate();
            statement.close();
            con.close();
        } catch (SQLException ex) {
            actualizar = false;
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return actualizar;
    }
        
     public Usuarios validarUser(String user, String pass){
         
        String sql= "CALL pa_validarUser('"+user+"', '"+pass+"')";
        Usuarios usuario;
        usuario = new Usuarios("", "", "", 0, "", "");
        try {
            con = this.getConection();
            CallableStatement cst = (CallableStatement) con.prepareCall(sql);
            ResultSet rs=cst.executeQuery();
         
            while(rs.next()){
                usuario.setEmail(rs.getString("email"));
                usuario.setUserName(rs.getString("nombre"));
                usuario.setContrasena(rs.getString("pass"));
                usuario.setId(rs.getInt("idUsuario"));
                usuario.setDireccion(rs.getString("direccion"));
                usuario.setTipoU(rs.getString("tipoUsuario"));
            }
       
            cst.close();
            con.close();
 
        } catch (SQLException ex) {
          
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        return usuario;
     
     }
     
     
      public Usuarios getUsuario(int id){
        
        
        String sql ="CALL pa_obtenerUsuario("+id+")";
        
        Usuarios usuarios;
        usuarios = new Usuarios("", "", "", 0, "","");
     
        try {
            con=this.getConection();
            
            CallableStatement statement = (CallableStatement) con.prepareCall(sql);
            ResultSet result = statement.executeQuery();
            
            while (result.next()) {
                usuarios.setEmail(result.getString("email"));
                usuarios.setUserName(result.getString("nombre"));
                usuarios.setContrasena(result.getString("pass"));
                usuarios.setId(result.getInt("idUsuario"));
                usuarios.setDireccion(result.getString("direccion"));
                

            }
            statement.close();
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuarios;
    }//metodo getEditorial
      
  public String recuperarContrasena(String correo){
        
        
        String sql ="CALL recuperar_contrasena('"+correo+"')";
       
        String contrasena="";

        try {
            con=this.getConection();
            
            CallableStatement statement = (CallableStatement) con.prepareCall(sql);
            ResultSet result = statement.executeQuery();
            
            while (result.next()) {
                contrasena = result.getString("pass");
                
            }
            statement.close();
            con.close();
            
      
            
        } catch (SQLException ex) {
            Logger.getLogger(DataUsuarios.class.getName()).log(Level.SEVERE, null, ex);
        }
        return contrasena;
    }//metodo getEditorial
  
  
   //********************************************
     public boolean confirmarUsuario(String user, String pass){
         
        String sql= "CALL pa_validarUser('"+user+"', '"+pass+"')";
        Usuarios usuario;
        usuario = new Usuarios("", "", "", 0, "","");
       
        try {
            con = this.getConection();
            CallableStatement cst = (CallableStatement) con.prepareCall(sql);
            ResultSet rs=cst.executeQuery();
         
            while(rs.next()){
                usuario.setEmail(rs.getString("email"));
                usuario.setUserName(rs.getString("nombre"));
                usuario.setContrasena(rs.getString("pass"));
                usuario.setId(rs.getInt("idUsuario"));
                usuario.setDireccion(rs.getString("direccion"));
           
            }

            cst.close();
            con.close();
           
            if(usuario.getUserName().equals("")){
                return false;
            
            }else{
                return true;
            }
           
 
        } catch (SQLException ex) {
          
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        
        return false;
     
     }
}
