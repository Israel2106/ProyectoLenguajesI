/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopymarket.app.dominio;


/**
 *
 * @author EmmanuelJs
 */
public class Usuarios {
    
    private String email;
    private String userName;
    private String contrasena;
    private int id;
    private String tipoU; 
    private Direccion direccion;

    public Usuarios(){
    }
    public Usuarios(String email, String userName, String contrasena, String tipoU) {
        this.email = email;
        this.userName = userName;
        this.contrasena = contrasena;
        
        this.tipoU= tipoU;
      

    }
    

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }    

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipoU() {
        return tipoU;
    }

    public void setTipoU(String tipoU) {
        this.tipoU = tipoU;
    }
    
    

   
    
    
    
}
