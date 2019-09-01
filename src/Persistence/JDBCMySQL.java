/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * Connection Method
 * @author Benjamin
 */
public class JDBCMySQL {
    
    Connection conn = null;
    
    public Connection connect(){
        try {
              Class.forName("com.mysql.jdbc.Driver");
              conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pasteleria", "root", "12345");
//            String ruta = "jdbc:mysql://localhost:3306/pasteleria";
//            String servidor = "localhost" + "3306";
//            Class.forName("com.mysql.jdbc.Driver");
//            conn = DriverManager.getConnection(ruta.concat(servidor).concat("pasteleria").concat("?autoReconnect=true&useSSL=false"), "root", "12345"); 
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JDBCMySQL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            return conn;
        }
    }
     public void desconectar() {
        conn = null;
    }
}
