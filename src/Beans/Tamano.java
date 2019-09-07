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
public class Tamano {

    //Crea constructor de Tamano con propiedades descripcion y id
    private final StringProperty descripcion; 
    private int id;

    public Tamano(String descripcion) {
        this.descripcion = new SimpleStringProperty(descripcion);
    }

    public void setDescripcion(String Descripcion) {
        this.descripcion.set(Descripcion);
    }

    public String getDescripcion() {
        return descripcion.get();
    }

    @Override
    public String toString() {
        return descripcion.get();
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
