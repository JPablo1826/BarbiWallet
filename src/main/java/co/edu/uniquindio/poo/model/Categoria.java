package co.edu.uniquindio.poo.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Categoria implements Serializable {
    public String idCategoria;
    public String nombre;
    public String descripcion;

}
