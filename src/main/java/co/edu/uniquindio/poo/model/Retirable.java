package co.edu.uniquindio.poo.model;

import co.edu.uniquindio.poo.exceptions.PresupuestoNoEncontradoException;
import co.edu.uniquindio.poo.exceptions.SaldoInsuficienteException;
import co.edu.uniquindio.poo.exceptions.TransaccionInvalidaException;

public interface Retirable {
    void retirarDinero(double monto) throws TransaccionInvalidaException, SaldoInsuficienteException, PresupuestoNoEncontradoException;
}
