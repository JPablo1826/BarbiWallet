module co.edu.uniquindio.poo {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;

    opens co.edu.uniquindio.poo to javafx.fxml; // Asegúrate de que esto esté aquí
    opens co.edu.uniquindio.poo.Controller to javafx.fxml; // Asegúrate de abrir el paquete del controlador
    exports co.edu.uniquindio.poo;
    requires transitive javafx.graphics;
}

