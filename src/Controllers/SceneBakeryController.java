/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Beans.Cliente;
import Beans.Pastel;
import Beans.Tamano;
import DataAdapters.ClienteAdapter;
import DataAdapters.PastelAdapter;
import DataAdapters.PedidoAdapter;
import DataAdapters.TamanoAdapter;
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

    PastelAdapter pasteladapter = new PastelAdapter(); //Crea nuevo objecto de PastelAdapter
    TamanoAdapter tamanoadapter = new TamanoAdapter(); //Crea nuevo objecto de TamanoAdapter
    ClienteAdapter clienteadapter = new ClienteAdapter(); //Crea nuevo objecto de ClienteAdapter
    PedidoAdapter pedidoadapter = new PedidoAdapter(); //Crea un nuevo constructor de PedidoAdaper
    private int precio; //Variables privadas globales utilizadas en el metodo finalizarPedido
    private String idPastel; //Variables pribadas globales utilizadas en el metodo finalizrPedido

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtName;

    @FXML
    private Button btnSend;

    @FXML
    private ComboBox<Pastel> cmbCake;

    @FXML
    private ComboBox<Tamano> cmbSize;

    @FXML
    private Spinner<Integer> spnQuantity;

    @FXML
    void btnSend_ActionPerfomed(ActionEvent event) { //Llama a la funcion de Enviar
        clienteadapter.setNombreCliente(txtName.getText()); //Toma el valor de Texto escrito en la TextBox y lo manda al DataAdapter de Cliente
        if (!clienteadapter.findIdExistingClient()) { //Evalua el metodo finExistingCliente dentro de ClienteAdaprter
            clienteadapter.addClient(); //Llama al metodo addCliente que añade un Cliente
            finalizarPedido(); //Llama al metodo finalizarPedido
        } else {
            finalizarPedido(); //LLama al metodo finalizarPedido
        }
    }

    //Realiza la acción cuando se cambia el indice seleccionado en la ComboBox de Tamaño
    @FXML
    void cmbSize_ActionPerfomed(ActionEvent event) {
        tamanoadapter.setTamanoPastel(cmbSize.getValue().toString()); //llama al metodo setTamanoPastel y lo manda al Adapter de Tamaño
        tamanoadapter.buscarIdSizeByName(); //Llama al metood buscar Id por nombre
        loadCmbCake();//llama la funcion para cargar los datos a la ComboBox
    }

    @FXML
    void initialize() {
        assert txtName != null : "fx:id=\"txtName\" was not injected: check your FXML file 'sceneBakery.fxml'.";
        assert btnSend != null : "fx:id=\"btnSend\" was not injected: check your FXML file 'sceneBakery.fxml'.";
        assert cmbCake != null : "fx:id=\"cmbCake\" was not injected: check your FXML file 'sceneBakery.fxml'.";
        assert cmbSize != null : "fx:id=\"cmbSize\" was not injected: check your FXML file 'sceneBakery.fxml'.";
        assert spnQuantity != null : "fx:id=\"spnQuantity\" was not injected: check your FXML file 'sceneBakery.fxml'.";
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadCmbSize(); //Llama a la función que carga la ComboBox de tamano
        //Llama a la funcion que inicializa el spinner
        inicializarSpinner();
    }

    private void loadCmbCake() { //Metodo que carga la ComboBox de Pastel
        cmbCake.getItems().clear(); //Limpia la combobox de Pasteles
        pasteladapter.setIdTamano(tamanoadapter.getId());//Establece el  Tamano Id al quaery en el metodo en DataAdapters.PastelAdapter 
        ObservableList<Pastel> data = FXCollections.observableArrayList(pasteladapter.Select()); //Crea una observable list del Array creado in DataAdaoter.PastelAdapter
        cmbCake.setItems(data);//Sets the data obtained from the Array and  fills the ComboBox
    }

    private void loadCmbSize() { //Metodo que carga la ComboBox de Tamaño
        cmbSize.getItems().clear(); //Limpia la combobox de Tamaño
        ObservableList<Tamano> data = FXCollections.observableArrayList(tamanoadapter.Select()); //Crea una observable list del Array creado en DataAdapter.TamnoAdapter
        cmbSize.setItems(data); //Estable la informacion obtenida del Attay y rellena la ComboBox
    }

    private void finalizarPedido() { //Metodo que finaliza el pedido dentro de la base de datos
        clienteadapter.setNombreCliente(txtName.getText()); // estable la variable nombre de cliente en ClienteAdapter, obteniendo la informacion de la TextBox 
        clienteadapter.findIdExistingClient(); // Llama a la función de encontrar al cliente por id
        pedidoadapter.setClientes_idCliente(clienteadapter.getIdCliente()); //Establece la variable de id de cliente a pedidoadapter obtenida de ClienteAdapter, metodo getIdCliente
        tamanoadapter.setTamanoPastel(cmbSize.getValue().toString());//Establece la variable de tamano de pastel a tamno adapter obtenido del indice seleccionado en la ComboBox
        tamanoadapter.buscarIdSizeByName(); //Llama al metodo dentro de TamanoAdapter que busca los tamaaños por Id
        pasteladapter.setDescripcion(cmbCake.getValue().toString()); //Establece el valor de la variable descripcion en el pastel adapter, 
        pasteladapter.setIdTamano(tamanoadapter.getId());//Estable el valor de la variable IdTamno en pasteladaper
        pasteladapter.obtenerPorIdTamanoDescripcion(); //llama a la funcion de pasteladapter que obtion el precio y id del Pastel correspondiente
        precio = pasteladapter.getPrecio(); //asigana a la variable precio el valor obtenido  del query en pastel adapter
        idPastel = pasteladapter.getIdPastel(); //asigna a la variable idPastel el valor obtenido del query en pastel adapter 
        pedidoadapter.setTotal(spnQuantity.getValue() * precio); //establece la variable total en pedido adapter. Esta se obtiene haciendo calculo de la cantidad establecida en el spinner por el precio obtenido en la 
        //consulta de pastel adapter
        pedidoadapter.setIdPastel(idPastel); //establece la variable idPastel en pedido adapter 
        pedidoadapter.setCantidad(spnQuantity.getValue()); //establece la variable cantidad en pedido adapter. Esta se obtiene del numero establecido en el spinner
        pasteladapter.setIdTamano(tamanoadapter.getId()); //estable la variable idTamano en pedido adapter. Esta se  obtiene del numero establecido en el spinner
        pedidoadapter.addPedido(); //llama al metodo addPedido dentro de pedido adapter
    }

    //Metodo que inicializa el Spinner
    private void inicializarSpinner() {
        SpinnerValueFactory<Integer> gradesValueFctory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 1);
        this.spnQuantity.setValueFactory(gradesValueFctory);
    }
}
