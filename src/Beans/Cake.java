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
public class Cake {

    private final StringProperty descripcion;
 //   private final StringProperty idCake;
//    private DoubleProperty valor;

    //Constructor con propiedades
    public Cake(String descripcion) {
        this.descripcion = new SimpleStringProperty(descripcion);
  //      this.idCake = new SimpleStringProperty(idCake);
    }

    public void setDescripcion(String Descripcion) {
        this.descripcion.set(Descripcion);
    }

    public String getDescripcion() {
        return descripcion.get();
    }
//    public void setIdCake(String idCake) {
//        this.idCake.set(idCake);
//    }
//
//    public String getIdCake() {
//        return idCake.get();
//    }
    @Override
    public String toString() {
        return descripcion.get();
    }

}
