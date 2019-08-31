/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;


/**
 * FXML Controller class
 *
 * @author Benjamin
 */
public class SceneBakeryController implements Initializable {
     @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtName;

    @FXML
    private Button btnSend;

    @FXML
    private ComboBox<?> cmbCake;

    @FXML
    private Label cmbFlavor;

    @FXML
    private Spinner<?> spnQuantity;

    @FXML
    private Button btnCancel;

    @FXML
    void btnCancel_ActionPerfomed(ActionEvent event) {

    }

    @FXML
    void btnSend_ActionPerfomed(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert txtName != null : "fx:id=\"txtName\" was not injected: check your FXML file 'sceneBakery.fxml'.";
        assert btnSend != null : "fx:id=\"btnSend\" was not injected: check your FXML file 'sceneBakery.fxml'.";
        assert cmbCake != null : "fx:id=\"cmbCake\" was not injected: check your FXML file 'sceneBakery.fxml'.";
        assert cmbFlavor != null : "fx:id=\"cmbFlavor\" was not injected: check your FXML file 'sceneBakery.fxml'.";
        assert spnQuantity != null : "fx:id=\"spnQuantity\" was not injected: check your FXML file 'sceneBakery.fxml'.";
        assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'sceneBakery.fxml'.";

    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
