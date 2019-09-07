/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAdapters;

import Beans.Cliente;
import Persistence.JDBCMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Benjamin
 */
public class ClienteAdapter {

    //Declaracion de variables 
    private int idCliente;
    private String nombreCliente;
    
    //Crea conexion con la base de datos
    JDBCMySQL con = new JDBCMySQL();
    Connection c = con.connect();

    //Method que busca si existes un cliente
    public boolean findIdExistingClient() {
        boolean success = false;
        try {
            if (c != null) {
                PreparedStatement verificarStmt
                        = c.prepareStatement("SELECT "
                                + "   idCliente, nombreCliente "
                                + " FROM cliente where nombreCliente = ?");
                verificarStmt.setString(1, nombreCliente);
                ResultSet rs = verificarStmt.executeQuery();
                if (rs.next()) {
                    idCliente = rs.getInt("idCliente");
                    success = true;
                }
            }
        } catch (SQLException e) {
            Logger.getLogger(TamanoAdapter.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            con.desconectar();
        }
        return success;
    }
    
    //Metodo que añade a un nuevo cliente

    public boolean addClient() {
        boolean success = false;

        try {
            if (c != null) {
                PreparedStatement verificarStmt
                        = c.prepareStatement("INSERT INTO cliente "
                                + "(idCliente, nombreCliente)"
                                + "VALUES (NULL, ?)");
                verificarStmt.setString(1, nombreCliente);
                verificarStmt.executeUpdate();
                success = true;
            }
        } catch (SQLException e) {
            Logger.getLogger(TamanoAdapter.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            con.desconectar();
        }
        return success;
    }

    
    //Metodos GETTER y SETTER de las variables
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }
}
