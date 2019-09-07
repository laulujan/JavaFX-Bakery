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
public class Cliente {

        
    //Crea constructor Cliente con propiedades
    
    private final StringProperty nombreCliente;
    private int idCliente;

    public Cliente(String nombreCliente) {
        this.nombreCliente = new SimpleStringProperty(nombreCliente);
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente.set(nombreCliente);
    }

    public String getNombreCliente() {
        return nombreCliente.get();
    }

    @Override
    public String toString() {
        return nombreCliente.get();
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
}
