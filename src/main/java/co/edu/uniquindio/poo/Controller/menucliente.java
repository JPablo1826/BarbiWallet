package co.edu.uniquindio.poo.Controller;
import co.edu.uniquindio.poo.App;
import java.io.IOException;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;

import co.edu.uniquindio.poo.exceptions.ClienteNoEncontradoException;
import co.edu.uniquindio.poo.model.Categoria;
import co.edu.uniquindio.poo.model.Cliente;
import co.edu.uniquindio.poo.model.Presupuesto;
import co.edu.uniquindio.poo.model.TipoCategoria;
import co.edu.uniquindio.poo.model.TipoTransaccion;
import co.edu.uniquindio.poo.model.Transaccion;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.SVGPath;

public class menucliente implements Initializable {

    @FXML
    private TabPane tabpane;

    // Perfil

    @FXML
    private TextField telefonoperfiltf, nombreperfiltf, IDperfiltf1, emailperfiltf, direccionperfiltf;

    @FXML
    private Button regresarPerfilbt, modificarPerfilbutt;

    // Estadisticas
    @FXML
    private TableView<Transaccion> tablaestadisticasclientetb;

    @FXML
    private TableColumn<Categoria, String> categoriaclienteestadisticacol;

    @FXML
    private ComboBox<String> categoriaestadisticascb;

    @FXML
    private TableColumn<Transaccion, String> descripcionclienteestadisticacol;

    @FXML
    private TableColumn<Transaccion, String> destinoclienteestadisticacol;

    @FXML
    private TableColumn<Transaccion, String> tipoclienteestadisticacol;

    @FXML
    private TableColumn<Transaccion, String> fechaclienteestadisticacol;

    @FXML
    private Button estadoDeTransaccionesEstadisticabt;

    @FXML
    private TableColumn<Transaccion, String> idclienteestadisticacol;

    @FXML
    private TableColumn<Transaccion, String> montoclienteestadisticacol;

    @FXML
    private ComboBox<TipoTransaccion> tipotransaccionclientecb;

    // Presupuesto

    @FXML
    private TableView<Presupuesto> tablapresupuestoclientetb;

    @FXML
    private ComboBox<String> categoriaclientepresupuestocb;

    @FXML
    private Button crearPresupuestobt, eliminarbt, modificarPresupuestobt;

    @FXML
    private TableColumn<Cliente, String> idpresupuestoclientecol;

    @FXML
    private TableColumn<Presupuesto, String> idpresupuestoccol;

    @FXML
    private TableColumn<Categoria, String> categproaopresupuestoclientecol;

    @FXML
    private TextField saldodisponiblepresupuestoclientetf;

    @FXML
    private TextField idpresupuestotf1;
    @FXML
    private TextField nombrepresupuestotf;

    @FXML
    private TableColumn<Presupuesto, String> presupuestopresupuestoclientecol;

    @FXML
    private TextField limitepresupuestotf;

    // Transacciones
    @FXML
    private DatePicker fechatransaccionclientedp;

    @FXML
    private Button eliminarTransaccionbt;

    @FXML
    private TextArea descripciontransaccionta;

    @FXML
    private TextField destinotransaccionclientetf, idtransaccionclientetf, montotransaccionclientetf,
            presupuestoasignadoclientetf;;

    @FXML
    private Button crearTransaccionbt, modificarTransaccionbt;;

    @FXML
    private ComboBox<TipoCategoria> categoriatransaccionclientecb;
    @FXML
    private TextField origentransaccionclientetf1;
    // Categorias

    @FXML
    private TableView<Cliente> tablacategoriaclientetb;

    @FXML
    private Button actualizarcategoriabt, eliminarcategoriabt, crearCategoriabt;;

    @FXML
    private TableColumn<Cliente, String> idcategoriacol;

    @FXML
    private TextField nuevacategoriaclentetf;

    @FXML
    private TableColumn<Cliente, String> nombrecategoriacleintecol;

    @FXML
    private TableColumn<Cliente, String> descripcioncategoriaclientecol;

    // AsistenteVirtual
    @FXML
    private Button asistent4bt, asistente1bt, asistente2bt, asistente3bt;

    // Servicios

    @FXML
    private SVGPath estrella1, estrella11, estrella2, estrella21, estrella3, estrella31, estrella4, estrella5;

    @FXML
    private TextArea descripcionserviciota;
    @FXML
    private Button guardarserviciobt;

    // Reportes

    @FXML
    private DatePicker fechaMaximareportedp;
    @FXML
    private DatePicker fechaminimareportedt;

    @FXML
    private Button generarReportebt;

    @FXML
    void actualizarcategoriaclienteevent(ActionEvent event) {

    }

    @FXML
    void comoeliminarcuentaevent(ActionEvent event) {

    }

    @FXML
    void comomandarplataevent(ActionEvent event) {

    }

    @FXML
    void crearTransaccionbt(ActionEvent event) {
        try {

            ModelFactoryController.getInstance().crearTransaccionTemporal(idtransaccionclientetf.getText(),
                    fechatransaccionclientedp.getValue(), tipotransaccionclientecb.getValue(),
                    Double.parseDouble(montotransaccionclientetf.getText()), descripcionserviciota.getText(),
                    origentransaccionclientetf1.getText(), destinotransaccionclientetf.getText(),
                    categoriatransaccionclientecb.getValue());

            tablaestadisticasclientetb.setItems(
                    FXCollections.observableArrayList(ModelFactoryController.getInstance().listarTransacciones()));
            tablaestadisticasclientetb.refresh();
            new Alert(AlertType.INFORMATION, "Transaccion creada con exito").show();

            // Actualización de la tabla
            ArrayList<Transaccion> transacciones = ModelFactoryController.getInstance().listarTransacciones();
            System.out.println("Actualizando tabla con " + transacciones.size() + " transacciones.");
            tablaestadisticasclientetb.setItems(FXCollections.observableArrayList(transacciones));
            tablaestadisticasclientetb.refresh();
            new Alert(AlertType.INFORMATION, "Transacción creada con éxito").show();
        } catch (Exception e) {
            new Alert(AlertType.ERROR, "Error al crear la transacción: " + e.getMessage()).show();
        }
    }

    @FXML
    void crearcategoriaclienteevent(ActionEvent event) {

    }

    @FXML
    void crearpresupuestoevent(ActionEvent event) throws Exception {
        try {
            ModelFactoryController.getInstance().crearPresupuesto(idpresupuestoclientecol.getText(),
                    nombrepresupuestotf.getText(), Double.parseDouble(saldodisponiblepresupuestoclientetf.getText()),
                    Double.parseDouble(limitepresupuestotf.getText()),
                    Double.parseDouble(presupuestoasignadoclientetf.getText()),
                    categoriaclientepresupuestocb.getValue());
            new Alert(AlertType.INFORMATION, "Presupuesto creado con exito").show();

        } catch (Exception e) {
            new Alert(AlertType.ERROR, "Error al crear el presupuesto: " + e.getMessage()).show();
        }
    }

    @FXML
    void cuantopuedosacarevent(ActionEvent event) {

    }

    @FXML
    void eliminarTransaccionesenaevent(ActionEvent event) {
        // hfhfhff
    }

    @FXML
    void eliminarcategoriaclienteevent(ActionEvent event) {

    }

    @FXML
    void eliminarpresupuestoevent(ActionEvent event) {

    }

    @FXML
    void estadoDeTransaccionesevent(ActionEvent event) {

    }

    @FXML
    void estrella1click(MouseEvent event) {

    }

    @FXML
    void estrella2click(MouseEvent event) {

    }

    @FXML
    void estrella3click(MouseEvent event) {

    }

    @FXML
    void estrella4click(MouseEvent event) {

    }

    @FXML
    void estrella5click(MouseEvent event) {

    }

    @FXML
    void generarReporteEvent(ActionEvent event) {

    }

    @FXML
    void guardarservicioevent(ActionEvent event) {

    }

    @FXML
    void modficarTransaccionevent(ActionEvent event) {
        // jhbujhbik
    }

    @FXML
    void modificarperfilevent(ActionEvent event) {

    }

    @FXML
    void modificarpresupuestoevent(ActionEvent event) {

    }

    @FXML
    void nosepudosacarplataevent(ActionEvent event) {

    }

    @FXML
    void regresarclienteevent(ActionEvent event) {
        try {
            // Cambia la vista a la ventana de registro
            App.setRoot("inicioSesionB");
        } catch (IOException e) {
            e.printStackTrace();
        }

    
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Cliente cliente = (Cliente)
        // DatosguardadosController.getInstance().getUsuarioActual().getValue();

        

        tablaestadisticasclientetb.setItems(
                FXCollections.observableArrayList(ModelFactoryController.getInstance().listarTransacciones()));
        fechaclienteestadisticacol.setCellValueFactory(celda -> new ReadOnlyStringWrapper(
                celda.getValue().getFecha().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
        tipoclienteestadisticacol
                .setCellValueFactory(celda -> new ReadOnlyStringWrapper(celda.getValue().getTipoTransaccion().name()));
        montoclienteestadisticacol
                .setCellValueFactory(celda -> new ReadOnlyStringWrapper(String.valueOf(celda.getValue().getMonto())));
        descripcionclienteestadisticacol
                .setCellValueFactory(celda -> new ReadOnlyStringWrapper(celda.getValue().getDescripcion()));
        destinoclienteestadisticacol
                .setCellValueFactory(celda -> new ReadOnlyStringWrapper(celda.getValue().getDescripcion()));
        categoriaclienteestadisticacol
                .setCellValueFactory((cellData -> new ReadOnlyStringWrapper(cellData.getValue().getNombre())));
                tipotransaccionclientecb.setItems(FXCollections.observableArrayList(TipoTransaccion.values()));
        categoriatransaccionclientecb.setItems(FXCollections.observableArrayList(TipoCategoria.values()));

        tablaestadisticasclientetb.refresh();

    }
}
