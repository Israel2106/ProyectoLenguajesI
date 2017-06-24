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
public class Carrito {
    
    private Producto producto;
    private String idPedido;

    public Carrito(Producto producto, String idPedido) {
        this.producto = producto;
        this.idPedido = idPedido;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public String getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }
 
    
}
