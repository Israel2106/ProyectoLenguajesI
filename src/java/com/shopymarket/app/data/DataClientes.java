/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

    Author: Israel
 */
package com.shopymarket.app.data;

import com.mysql.jdbc.CallableStatement;
import com.shopymarket.app.dominio.Cliente;
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
 * @author Israel
 */
public class DataClientes extends DataBase{

    public DataClientes(String user, String pass) {
        super(user, pass);
    }
    Connection con;
    
    public void insertarCliente(String nombre,String email, String telefono,String pass){
       String sql= "CALL pa_insertarCliente('"+nombre+"','"+email+"','"+telefono+"','"+pass+"');";
       
        try {
            con = this.getConection();
            CallableStatement proc= (CallableStatement) con.prepareCall(sql);
            proc.execute();
            con.close();
        } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    
    
    public boolean eliminarCliente(String id){
    
        boolean eliminar = true;    
        String sql= "CALL pa_eliminarCliente("+id+")";
       
        try {
            con = this.getConection();
            CallableStatement proc = (CallableStatement) con.prepareCall(sql);
            proc.execute();
            con.close();
        } catch (SQLException ex) {
            eliminar = false;
           JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return eliminar;
    }
    
    
    
    public boolean editarCliente(Cliente c, String id){
        
        boolean actualizar = true;    
        String sql= "call pa_actualizarCliente('"+c.getNombreEmpresa()+"','"+c.getEmail()+"','"+c.getTelefono()+"',"+id+")";
       
        try {
            con = this.getConection();
            CallableStatement proc= (CallableStatement) con.prepareCall(sql);
            proc.execute();
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            actualizar = false;
        }
        return actualizar;
    }
    
    public void insertarUbicacionCliente(int idEmpresa,String provincia,String canton, String distrito,String ubicacionE){
       String sql= "CALL pa_agregarUbicacionEmpresa("+idEmpresa+","
               + "'"+provincia+"','"+canton+"','"+distrito+"','"+ubicacionE+"');";
       
        try {
            con = this.getConection();
            CallableStatement proc= (CallableStatement) con.prepareCall(sql);
            proc.execute();
            con.close();
        } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    public LinkedList<Cliente> obtenerClientes(){ 
        LinkedList<Cliente> lc= new LinkedList<>();
        String sql= "CALL pa_obtener_Clientes";
        ResultSet r= null;
        try {
            con = this.getConection();
            CallableStatement proc = (CallableStatement) con.prepareCall(sql);
            r=proc.executeQuery();
            while(r.next()){
                Cliente c= new Cliente(r.getString("nombreEmpresa"), r.getString("email"), r.getString("telefono"));
                c.setId(r.getInt("idEmpresa"));
                lc.add(c);
            }
            con.close();
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return lc;
    }
    
    
       public int getNextID(){
            String idQuery="select AUTO_INCREMENT from information_schema.TABLES where TABLE_SCHEMA='proyecto' and TABLE_NAME='cliente';";
            ResultSet re = null;
            int id=0;
            try {
                con = this.getConection();
                PreparedStatement ps= (PreparedStatement) con.prepareStatement(idQuery);
                re=ps.executeQuery();
                if(re.next()){
                    id=Integer.parseInt(re.getString(1));
                } 
		
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());	
            }		
            return id;
	}
}
