/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shopymarket.app.data;

/**
 *
 * @author Yessica Zuñiga
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yessica Zuñiga
 */
public class DataBase {
    
     private String user;
    private String pass;
    private Connection con;

    public DataBase( String user, String pass) {
        this.user = user;
        this.pass = pass;
        this.con= null;
    }
    
    public Connection getConection() throws SQLException{
    
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
     return   con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopyMarketDB",user,pass);
    }
    
}

