package co.edu.uniquindio.poo.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public abstract class Usuario implements Serializable {
    public String ID;
    public String nombre;
    public String correo;
    public String telefono;

    public Usuario(String iD, String nombre, String correo, String telefono) {
        ID = iD;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;

    }

    public abstract void displayUserInfo();
}
