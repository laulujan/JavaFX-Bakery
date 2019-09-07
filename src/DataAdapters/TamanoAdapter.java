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
 * @author Benjamin
 */
public class TamanoAdapter {

    //Declara las variables del adapter
    private int id;
    private String tamanoPastel;
    List<Tamano> rsSize = new ArrayList<Tamano>();
    
    //Crea conexion con la base de datos
    JDBCMySQL con = new JDBCMySQL();
    Connection c = con.connect();
    
    
    //Metodo que fuarda los tamaños en una lista por medio de una consulta
    public List<Tamano> Select() {
        try {
            PreparedStatement verificarStmt
                    = c.prepareStatement("SELECT "
                            + "   descripcion"
                            + " FROM tamano ");

            ResultSet rs = verificarStmt.executeQuery();
            while (rs.next()) {
//                Divisa divisa = new Divisa(rs.getString("nombre"), rs.getDouble("valor"));
                Tamano size = new Tamano(rs.getString("descripcion"));
                rsSize.add(size);
            }
            return rsSize;

        } catch (SQLException e) {
            Logger.getLogger(TamanoAdapter.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            con.desconectar();
        }
        return null;
    }
    
//Metodo que obtiene el id por el nombre/descripcion del tamaño del pastel
    public boolean buscarIdSizeByName() {
        boolean success = false;
        try {
            if (c != null) {
                PreparedStatement verificarStmt
                        = c.prepareStatement("SELECT "
                                + "   id "
                                + " FROM tamano where descripcion = ?");
                verificarStmt.setString(1, tamanoPastel);
                ResultSet rs = verificarStmt.executeQuery();
                if (rs.next()) {
                    id = rs.getInt("id");
                    System.out.println(getId());
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
    public String getTamanoPastel() {
        return tamanoPastel;
    }

    public void setTamanoPastel(String tamanoPastel) {
        this.tamanoPastel = tamanoPastel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
