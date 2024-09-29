package co.edu.uniquindio.poo.model;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;
import lombok.Setter;

@Data
@Setter
@Builder
public class Presupuesto implements Serializable {
    private String idPresupuesto;
    private String nombre;
    private double montoTotal;
    private double montoGastado;
    private double limite;
    Categoria categoria;

    public double getMontoActual() {
        return montoTotal - montoGastado;
    }

    public void disminuirMontoActual(Double monto) {
        montoGastado += monto;
    }

    public void aumentarMonto(double monto) {
        montoTotal += monto;
    }
}
