/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Beans.Cake;
import Beans.Size;
import DataAdapters.cbCake;
import DataAdapters.cbSize;
import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Benjamin
 */
public class SceneBakeryController implements Initializable {

    cbCake cbcake = new cbCake();
    cbSize cbsize = new cbSize();
    int desc;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtName;

    @FXML
    private Button btnSend;

    @FXML
    private ComboBox<Cake> cmbCake;

    @FXML
    private ComboBox<Size> cmbSize;

    @FXML
    private Spinner<Integer> spnQuantity;

    @FXML
    private Button btnCancel;

    @FXML
    void btnCancel_ActionPerfomed(ActionEvent event) {

    }

    @FXML
    void btnSend_ActionPerfomed(ActionEvent event) {

    }

    @FXML
    void cmbSize_ActionPerfomed(ActionEvent event) {
        cbsize.setDescripcion(cmbSize.getValue().toString());
        cbsize.buscarIdSizeByName();
        loadCmbCake();
    }

    @FXML
    void initialize() {
        assert txtName != null : "fx:id=\"txtName\" was not injected: check your FXML file 'sceneBakery.fxml'.";
        assert btnSend != null : "fx:id=\"btnSend\" was not injected: check your FXML file 'sceneBakery.fxml'.";
        assert cmbCake != null : "fx:id=\"cmbCake\" was not injected: check your FXML file 'sceneBakery.fxml'.";
        assert cmbSize != null : "fx:id=\"cmbSize\" was not injected: check your FXML file 'sceneBakery.fxml'.";
        assert spnQuantity != null : "fx:id=\"spnQuantity\" was not injected: check your FXML file 'sceneBakery.fxml'.";
        assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'sceneBakery.fxml'.";

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loadCmbSize();
        //Configure the spinner
        SpinnerValueFactory<Integer> gradesValueFctory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 1);
        this.spnQuantity.setValueFactory(gradesValueFctory);
    }

    private void loadCmbCake() { //Method that loads the Cake (Flavor) ComboBox
        cmbCake.getItems().clear();
        cbcake.setId(cbsize.getId()); //Sets Size Id to quaery method in DataAdapters.cbCake 
        ObservableList<Cake> data = FXCollections.observableArrayList(cbcake.Select()); //Creates observable list from Array created in DataAdaoter.cbCake
        cmbCake.setItems(data);//Sets the data obtained from the Array and  fills the ComboBox
    }

    private void loadCmbSize() { //Method that loads the Size ComboBox
        cmbSize.getItems().clear();
        ObservableList<Size> data = FXCollections.observableArrayList(cbsize.Select());
        cmbSize.setItems(data);
    }

}
