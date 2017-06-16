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
    
    public void insertarVendedor(String nombre,String email, String telefono,String pass){
       String sql= "CALL pa_insertarVendedor('"+nombre+"','"+email+"','"+telefono+"','"+pass+"');";
       
        try {
            con = this.getConection();
            CallableStatement proc= (CallableStatement) con.prepareCall(sql);
            proc.execute();
            con.close();
        } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }
    
    
    
    public boolean eliminarVendedor(String id){
    
        boolean eliminar = true;    
        String sql= "CALL pa_eliminarVendedor("+id+")";
       
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
    
    
    
    public boolean editarVendedor(Cliente c, String id){
        JOptionPane.showMessageDialog(null, id);
        boolean actualizar = true;    
        String sql= "call pa_actualizarVendedor('"+c.getNombreEmpresa()+"','"+c.getEmail()+"','"+c.getTelefono()+"',"+id+")";
       
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
    
    public void insertarUbicacionVendedor(String idEmpresa,String provincia,String canton, String distrito,String ubicacionE){
       String sql= "CALL pa_agregarUbicacionVendedor("+idEmpresa+","
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
    
    public LinkedList<Cliente> obtenerTodosVendedores(){ 
        LinkedList<Cliente> lc= new LinkedList<>();
        String sql= "CALL pa_obtener_Vendedores";
        ResultSet r= null;
        try {
            con = this.getConection();
            CallableStatement proc = (CallableStatement) con.prepareCall(sql);
            r=proc.executeQuery();
            while(r.next()){
                Cliente c= new Cliente(r.getString("nombre"), r.getString("email"), r.getString("telefono"));
                c.setId(r.getInt("idUsuario"));
                lc.add(c);
            }
            con.close();
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return lc;
    }
    
    public LinkedList<Cliente> obtenerVendedoresPorUbicacion(String prov, String cant, String dist){ 
        LinkedList<Cliente> lc= new LinkedList<>();
        String sql= "CALL pa_obtener_Vendedores_por_ubicacion('"+prov+"','"+cant+"','"+dist+"')";
        ResultSet r= null;
        try {
            con = this.getConection();
            CallableStatement proc = (CallableStatement) con.prepareCall(sql);
            r=proc.executeQuery();
            while(r.next()){
                Cliente c= new Cliente(r.getString("nombre"), r.getString("email"), r.getString("telefono"));
                c.setId(r.getInt("idUsuario"));
                c.setProvincia(r.getString("provincia"));
                c.setCanton(r.getString("canton"));
                c.setDistrito(r.getString("distrito"));
                c.setEspecificacion(r.getString("ubicacionEspecifica"));
                lc.add(c);
            }
            con.close();
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return lc;
    }
    
    public LinkedList<String> obtenerCantones(){
        LinkedList<String> lc= new LinkedList<>();
        String sql= "CALL pa_obtener_Cantones";
        ResultSet r= null;
        try {
            con = this.getConection();
            CallableStatement proc = (CallableStatement) con.prepareCall(sql);
            r=proc.executeQuery();
            while(r.next()){
                lc.add(r.getString("canton"));
            }
            con.close();
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return lc;
    
    }
    
    public LinkedList<String> obtenerDistritos(){
        LinkedList<String> lc= new LinkedList<>();
        String sql= "CALL pa_obtener_distritos";
        ResultSet r= null;
        try {
            con = this.getConection();
            CallableStatement proc = (CallableStatement) con.prepareCall(sql);
            r=proc.executeQuery();
            while(r.next()){
                lc.add(r.getString("distrito"));
            }
            con.close();
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return lc;
    
    }
    
    
       public int getNextID(){
            String idQuery="select AUTO_INCREMENT from information_schema.TABLES where TABLE_SCHEMA='shopyMarketDB' and TABLE_NAME='usuarios';";
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
