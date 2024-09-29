package co.edu.uniquindio.poo.model;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Transaccion implements Serializable {
    public String idTransaccion;
    public LocalDate fecha;
    public TipoTransaccion tipoTransaccion;
    public double monto;
    public String descripcion;
    public String cuentaOrigen;
    public String cuentaDestino;
    public TipoCategoria categoria;

}