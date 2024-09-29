package co.edu.uniquindio.poo.Controller;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.App;
import co.edu.uniquindio.poo.model.Cliente;
import co.edu.uniquindio.poo.model.Cuenta;
import co.edu.uniquindio.poo.model.Transaccion;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class menuadmin implements Initializable {

    @FXML
    private TabPane tabpane;
    // PESTAÑA DE USUARIOS
    @FXML
    private TableView<Cliente> tablausuarioadmintb;
    @FXML
    private TableColumn<Cliente, String> idusuarioadmincol;
    @FXML
    private TableColumn<Cliente, String> correousuarioadmincol;

    @FXML
    private TableColumn<Cliente, String> nombreusuarioadmincol;
    @FXML
    private TableColumn<Cliente, String> saldousuarioadmincol1;

    @FXML
    private TableColumn<Cliente, String> telefonousuarioadmincol;

    @FXML
    private Button Modificarbt, eliminarbt, regresarbt, crearUsuariobt;

    @FXML
    private TextField idusuarioadmintf, nombreusuarioadmintf, correousuarioadmintf, telefonousuarioadmintf,
            contrasñeasuarioadmintf1, direccionuarioadmintf11;


            
    @FXML
    private Button crearPresupuestobt;

    // PESTAÑA CUENTA
    @FXML

    private TableView<Cuenta> tablaadmincuentastb;

    @FXML
    private TableColumn<Cuenta, String> bancocuentasadmincol;

    @FXML
    private TableColumn<Cuenta, String> idcuentasadmincol;

    @FXML
    private TableColumn<Cuenta, String> numcuentasadmincol;

    @FXML
    private TableColumn<Cuenta, String> tipocuentacuentasadmincol;

    @FXML
    private TextField bancoadmintf1;

    @FXML
    private ComboBox<String> tipocuentaadmincb;
    @FXML
    private Button agregarCuentabt, eliminarCuentabt, modificarCuentabt;

    @FXML
    private TextField numcuentacuentasadmintf, idcuentasadmintf;

    // Pestaña de transaccion

    @FXML
    private TableView<Transaccion> tablatransaccionadmintb;

    @FXML
    private TableColumn<Transaccion, String> tipotransaccionadmincol;
    @FXML
    private TableColumn<Transaccion, String> categoriatransaccionadmincol;

    @FXML
    private TableColumn<Transaccion, String> descripciontransaccionadmincol;

    @FXML
    private TableColumn<Transaccion, String> origentransaccionadmincol;
    @FXML
    private TableColumn<Transaccion, String> montotransaccionadmincol;
    @FXML
    private TableColumn<Transaccion, String> fechatransaccionadmincol;
    @FXML
    private TableColumn<Transaccion, String> idtransaccionadmincol;

    @FXML
    private TableColumn<Transaccion, String> destinotransaccionadmincol;

    @FXML
    private ComboBox<String> tpotransaccionadmincb;

    @FXML
    private ComboBox<String> categoriatransaccionadmincb;

    @FXML
    private Button crearTransaccionbt, consultarTransaccionbt1;

    @FXML
    private TextField destinotransaccionadmintf, montotransaccionadmintf, origentransaccionadmintf,
            idtransaccionadmintf;

    @FXML
    private DatePicker fechatransaccionadmindp;

    @FXML
    private TextArea descripciontransaccionadminta;

    // Pestaña de estadisticas

    @FXML
    private Button usuariomayortransaccionesbt, saldoPromediobt, gastosComunesbt;

    @FXML
    private TableColumn<Transaccion, String> montoestadisticasadmincol;

    @FXML
    private TableColumn<Transaccion, String> descripcionestadisticasadmincol;

    @FXML
    private TableColumn<Transaccion, String> idestadisticasadmincol;

    @FXML
    private TableColumn<Transaccion, String> categoriaestadisticasadmincol;

    @FXML
    private TableColumn<Transaccion, String> origenestadisticasadmincol;
    @FXML
    private TableColumn<Transaccion, String> destinoestadisticasadmincol;

    @FXML
    private TableColumn<Transaccion, String> tipoestadisticasadmincol;

    @FXML
    private TableColumn<Transaccion, String> fechaestadisticasadmincol;

    @FXML
    private ComboBox<String> categoriaestadisticasadmincb;

    @FXML
    private AreaChart<?, ?> estadisticasadminac;

    @FXML
    void agregarcuentaadminevent(ActionEvent event) {

        
        
    }

    @FXML
    void creartransaccionadminevent(ActionEvent event) {
         
            
           
            
            
          
    }


















    

    @FXML
    void crearusuarioadminevent(ActionEvent event) {
        try {
            ModelFactoryController.getInstance().registrarNuevoCliente(idusuarioadmintf.getText(),
                    nombreusuarioadmintf.getText(), correousuarioadmintf.getText(), telefonousuarioadmintf.getText(),
                    contrasñeasuarioadmintf1.getText(), direccionuarioadmintf11.getText());
            new Alert(AlertType.CONFIRMATION, "Se ha registrado con exito, ahora inicie sesion");
        } catch (Exception e) {
            new Alert(AlertType.ERROR, "Error al crear el usuario: " + e.getMessage()).show();
        }

    }

    @FXML
    void eliminarcuentaadminevent(ActionEvent event) {

    }

    @FXML
    void eliminarusuarioadminevent(ActionEvent event) {
        Cliente cliente = tablausuarioadmintb.getSelectionModel().getSelectedItem();
        if (cliente == null) {
            new Alert(AlertType.ERROR, "Debe seleccionar un evento").show();
            return;
        }
        if (ModelFactoryController.getInstance().eliminarCliente(cliente.getID()) == true) {
            new Alert(AlertType.INFORMATION, "El evento se eliminó correctamente").show();
            tablausuarioadmintb.getItems().remove(cliente);
            tablausuarioadmintb.refresh();
        } else {
            new Alert(AlertType.ERROR, "No se pudo eliminar el evento").show();
        }

    }

    @FXML
    void gastosmascomunesadminevent(ActionEvent event) {

    }

    @FXML
    void modificarcuentaadminevent(ActionEvent event) {

    }

    @FXML
    void modificarusuarioadminevent(ActionEvent event) throws Exception {
        Cliente cliente = tablausuarioadmintb.getSelectionModel().getSelectedItem();
        if (cliente == null) {
            new Alert(AlertType.ERROR, "Debe seleccionar un cliente").show();
            return;
        }
        try {
            ModelFactoryController.getInstance().modificarPerfilClientePorId(cliente.getID(),
                    nombreusuarioadmintf.getText(), correousuarioadmintf.getText(), telefonousuarioadmintf.getText(),
                    contrasñeasuarioadmintf1.getText(), direccionuarioadmintf11.getText());
            new Alert(AlertType.INFORMATION, "Cliente modificado con exito").show();
        } catch (Exception e) {
            new Alert(AlertType.ERROR, e.getMessage()).show();
        }

    }

    @FXML
    void regresaradminevent(ActionEvent event) {
        try {

            App.setRoot("inicioSesionB");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void saldopromedioadminevent(ActionEvent event) {

    }

    @FXML
    void usuariomayortransaccionadminevent(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tablausuarioadmintb
                .setItems(FXCollections.observableArrayList(ModelFactoryController.getInstance().listarClientes()));
        idusuarioadmincol.setCellValueFactory((cellData -> new ReadOnlyStringWrapper(cellData.getValue().getID())));
        nombreusuarioadmincol
                .setCellValueFactory((cellData -> new ReadOnlyStringWrapper(cellData.getValue().getNombre())));
        correousuarioadmincol
                .setCellValueFactory((cellData -> new ReadOnlyStringWrapper(cellData.getValue().getCorreo())));
        telefonousuarioadmincol
                .setCellValueFactory((cellData -> new ReadOnlyStringWrapper(cellData.getValue().getTelefono())));

        tablausuarioadmintb.refresh();

        // Transaccion
       
        categoriatransaccionadmincb.setItems(FXCollections.observableArrayList(ModelFactoryController.getInstance().obtenerCategorias()));
        tpotransaccionadmincb.setItems(FXCollections.observableArrayList(Arrays.asList("Transferencia", "Deposito", "Retiro")));
        fechatransaccionadmincol.setCellValueFactory((cellData -> new ReadOnlyStringWrapper(cellData.getValue().getFecha().toString())));
        idtransaccionadmincol.setCellValueFactory((cellData -> new ReadOnlyStringWrapper(cellData.getValue().getIdTransaccion())));
        montotransaccionadmincol.setCellValueFactory((cellData -> new ReadOnlyStringWrapper(String.valueOf(cellData.getValue().getMonto()))));
        
        
        //Cuentas



        
 



    }

}


