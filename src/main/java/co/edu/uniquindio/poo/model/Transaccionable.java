package co.edu.uniquindio.poo.model;

import co.edu.uniquindio.poo.exceptions.DatosErroneosException;

public interface Transaccionable {
    void realizarMovimiento(
            Cliente usuarioOrigen,
            String idCuentaOrigen,
            String idCuentaDestino,
            Cliente usuarioDestino,
            Double monto,
            String idPresupuesto,
            String descripcion,
            Categoria categoria) throws DatosErroneosException;
}
