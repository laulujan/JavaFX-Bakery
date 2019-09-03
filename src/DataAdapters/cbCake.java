/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAdapters;

import Beans.Cake;
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
public class cbCake {

    private int id;
    private cbSize cbsize;
    JDBCMySQL con = new JDBCMySQL();
    Connection c = con.connect();
    List<Cake> rsCake = new ArrayList<Cake>();

    public List<Cake> Select() {

        try {
            rsCake.clear();
            PreparedStatement verificarStmt
                    = c.prepareStatement("SELECT  "
                            + "    descripcion"
                            + " FROM pasteles where idTamano = ?");
            verificarStmt.setInt(1, id);
            ResultSet rs = verificarStmt.executeQuery();
            while (rs.next()) {
//                Divisa divisa = new Divisa(rs.getString("nombre"), rs.getDouble("valor"));
                Cake cake = new Cake(rs.getString("descripcion"));
                rsCake.add(cake);
            }
            return rsCake;

        } catch (SQLException e) {
            Logger.getLogger(cbCake.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            con.desconectar();
        }
        return null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
