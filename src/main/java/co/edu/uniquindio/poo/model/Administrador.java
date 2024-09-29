package co.edu.uniquindio.poo.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class Administrador extends Usuario {

    private final String ID = "admin";
    private final String contrasena = "admin";
    private static Administrador instancia;

    public Administrador() {
        super("admin", "admin", "telefono", "correo");
    }

    public static Administrador obtenerInstancia() {

        if (instancia == null) {
            instancia = new Administrador();
        }

        return instancia;
    }

    @Override
    public void displayUserInfo() {

    }
}
