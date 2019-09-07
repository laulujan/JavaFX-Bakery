/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAdapters;

import Beans.Cliente;
import Beans.Pastel;
import Persistence.JDBCMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Benjamin
 */
public class PedidoAdapter {

    //Crea conexion con la base de datos
    JDBCMySQL con = new JDBCMySQL();
    Connection c = con.connect();

    //Crea variables del pedido adapter
    private int clientes_idCliente;
    private int total;
    private String idPastel;
    private int cantidad;
    
    
    //Metodo que inserta un nuevo pedido en la bse de datos
    public boolean addPedido() {

        boolean success = false;

        try {
            if (c != null) {
                PreparedStatement verificarStmt
                        = c.prepareStatement("INSERT INTO pedido "
                                + "(idPedido, clientes_idCliente, total, idPastel, cantidad)"
                                + "VALUES (NULL, ?, ?, ?, ?)");
                verificarStmt.setInt(1, clientes_idCliente);
                verificarStmt.setFloat(2, total);
                verificarStmt.setString(3, idPastel);
                verificarStmt.setInt(4, cantidad);
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
    public int getClientes_idCliente() {
        return clientes_idCliente;
    }

    public void setClientes_idCliente(int clientes_idCliente) {
        this.clientes_idCliente = clientes_idCliente;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getIdPastel() {
        return idPastel;
    }

    public void setIdPastel(String idPastel) {
        this.idPastel = idPastel;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
