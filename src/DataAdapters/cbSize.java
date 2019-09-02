/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAdapters;

import Beans.Cake;
import Beans.Size;
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
public class cbSize {
    
    JDBCMySQL con = new JDBCMySQL();
    Connection c = con.connect();
    List<Size> rsSize = new ArrayList<Size>();

    public List<Size> Select() {

        try {
            System.out.println(c);
            PreparedStatement verificarStmt
                    = c.prepareStatement("SELECT "
                            + "   id, descripcion"
                            + " FROM tamano ");

            ResultSet rs = verificarStmt.executeQuery();
            while (rs.next()) {
//                Divisa divisa = new Divisa(rs.getString("nombre"), rs.getDouble("valor"));
                Size size = new Size(rs.getInt("id"),rs.getString("descripcion"));
                rsSize.add(size);
            }
            return rsSize;

        } catch (SQLException e) {
            Logger.getLogger(cbSize.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            con.desconectar();
        }
        return null;
    }
}