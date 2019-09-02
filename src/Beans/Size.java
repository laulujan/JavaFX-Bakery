/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Benjamin
 */
public class Size {

    private final StringProperty descripcion;
    private int id;
//    private DoubleProperty valor;

    //Constructor con propiedades
    public Size(int id, String descripcion) {
        this.descripcion = new SimpleStringProperty(descripcion);
        this.id = id;
    }

    public void setDescripcion(String Descripcion) {
        this.descripcion.set(Descripcion);
    }

    public String getDescripcion() {
        return descripcion.get();
    }
    
    public int getId() {
        return id;
    }

    public void getId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return descripcion.get();
    }

}
