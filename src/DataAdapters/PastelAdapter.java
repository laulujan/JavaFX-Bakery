/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAdapters;

import Beans.Pastel;
import Beans.Tamano;
import Persistence.JDBCMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Proyectos
 */
public class PastelAdapter {
    
    
    //Declaracion de variables
    private int idTamano;
    private int precio;
    private String idPastel;
    private String descripcion;
    List<Pastel> rsCake = new ArrayList<Pastel>();
    //Crea conexion con la base de datos
    JDBCMySQL con = new JDBCMySQL();
    Connection c = con.connect();
    

    //metodo que cara en una lista los datos obtenidos del query 
    public List<Pastel> Select() {
        try {
            rsCake.clear();
            PreparedStatement verificarStmt
                    = c.prepareStatement("SELECT  "
                            + "    descripcion"
                            + " FROM pastel where idTamano = ?");
            verificarStmt.setInt(1, idTamano);
            ResultSet rs = verificarStmt.executeQuery();
            while (rs.next()) {
//                Divisa divisa = new Divisa(rs.getString("nombre"), rs.getDouble("valor"));
                Pastel cake = new Pastel(rs.getString("descripcion"));
                rsCake.add(cake);
            }
            return rsCake;

        } catch (SQLException e) {
            Logger.getLogger(PastelAdapter.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            con.desconectar();
        }

        return null;
    }
    
    //Metodo que obtiene el precio y Id del pastel por medio de la descripcion y el idTamano
    public boolean obtenerPorIdTamanoDescripcion() {
        boolean success = false;
        try {
            if (c != null) {
                PreparedStatement verificarStmt
                        = c.prepareStatement("SELECT "
                                + " id,  precio "
                                + " FROM pastel where descripcion = ? and idTamano = ?");
                verificarStmt.setString(1, descripcion);
                verificarStmt.setInt(2, idTamano);
                ResultSet rs = verificarStmt.executeQuery();
                if (rs.next()) {
                    precio = rs.getInt("precio");
                    idPastel = rs.getString("id");
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
    
    
    //Metodos GETTER y SETTER de las variables
    public int getIdTamano() {
        return idTamano;
    }

    public void setIdTamano(int idTamano) {
        this.idTamano = idTamano;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getIdPastel() {
        return idPastel;
    }

    public void setIdPastel(String idPastel) {
        this.idPastel = idPastel;
    }
}
