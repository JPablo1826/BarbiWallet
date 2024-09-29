
package co.edu.uniquindio.poo.Controller;

import java.io.IOException;

import co.edu.uniquindio.poo.App;

import co.edu.uniquindio.poo.exceptions.inicioFallidoException;
import co.edu.uniquindio.poo.model.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class incioSesion {

    @FXML
    private PasswordField contrasenainiciopas;

    @FXML
    private TextField usuarioiniciotf;

    @FXML
    void continuarinicioaction(ActionEvent event) {
        try {
           
            Usuario usuario = ModelFactoryController.getInstance().iniciarSesion(
                    usuarioiniciotf.getText(),
                    contrasenainiciopas.getText());
            
            DatosguardadosController.getInstance().setUsuarioActual(usuario);
    
           
            if (DatosguardadosController.getInstance().verificarIsAdmi()) {
                App.setRoot("menuAdmin");
            } else {
                App.setRoot("menuClientesB");
            }
        } catch (inicioFallidoException e) {
            new Alert(AlertType.ERROR, "Credenciales incorrectas").show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    


    @FXML
    void registrarseinicioaction(ActionEvent event) {
        try {
            // Cambia la vista a la ventana de registro
            App.setRoot("registroB");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    }



    
