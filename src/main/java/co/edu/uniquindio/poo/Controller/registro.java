package co.edu.uniquindio.poo.Controller;

import java.io.IOException;

import co.edu.uniquindio.poo.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;

public class registro {

    @FXML
    private TextField cedularegistrotf, contrasenaregistrotf,direccionregistrotf, emailregistrotf,nombreregistrotf, telefonoregistrotf ;

  
    @FXML
    void registrarregsitroevent(ActionEvent event) {
         try {
            ModelFactoryController.getInstance().registrarNuevoCliente(cedularegistrotf.getText(), contrasenaregistrotf.getText(),direccionregistrotf.getText(), emailregistrotf.getText(),nombreregistrotf.getText(), telefonoregistrotf.getText());
            new Alert(AlertType.CONFIRMATION, "Se ha registrado con exito,ahora inicie sesión");
            
        } catch (Exception e) {
            e.printStackTrace();
            new Alert(AlertType.WARNING, "ALERTA NO SE PUEDE REGISTRAR").show();
        }
    }



    
    @FXML
    void regresarregsitroevent(ActionEvent event) {
          try {
            // Cambia la vista a la ventana de registro
            App.setRoot("inicioSesionB");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}