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
public class ProductoHb {
    
    int categoria;
    int cantidad;
    String nombre;
    int precio;
    String marca;
    int idCliente;
    int idProducto;
    String imagen;

    public ProductoHb(){}
    
    
    public ProductoHb(int categoria, int cantidad, String nombre, int precio, String marca, int idCliente) {
        this.categoria = categoria;
        this.cantidad = cantidad;
        this.nombre = nombre;
        this.precio = precio;
        this.marca = marca;
        this.idCliente= idCliente;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }
    

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    
    

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int idProducto) {
        this.cantidad = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    
}
