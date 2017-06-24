/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopymarket.app.dominio;

/**
 *
 * @author Hector Zuñiga
 */
public class UsuariosB {
    
     private String email;
    private String userName;
    private String contrasena;
    private int id;
    private String direccion;
    private String tipoU; 

    public UsuariosB(String email, String userName, String contrasena, int id, String direccion, String tipoU){
        this.email = email;
        this.userName = userName;
        this.contrasena = contrasena;
        this.id = id;
        this.direccion = direccion;
        this.tipoU=this.tipoU;

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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTipoU() {
        return tipoU;
    }

    public void setTipoU(String tipoU) {
        this.tipoU = tipoU;
    }
       
}
