package co.edu.uniquindio.poo.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class Cliente extends Usuario {

    private String contrasena;
    private String direccion;
    private int saldoTotal;
    private List<String> transacciones;
    private Map<String, Cuenta> cuentas; // Mapa para almacenar múltiples cuentas

    public Cliente(String iD, String nombre, String correo, String telefono, String contrasena, String direccion) {
        super(iD, nombre, correo, telefono);
        this.contrasena = contrasena;
        this.direccion = direccion;
        this.saldoTotal = saldoTotal;
        this.transacciones = transacciones;
        this.cuentas = cuentas;
    }

    public void agregarCuenta(Cuenta cuenta) {
        cuentas.put(cuenta.getIdUsuario(), cuenta);
    }

    public Cuenta buscarCuentaPorId(String idCuenta) {
        return cuentas.get(idCuenta);
    }

    @Override
    public void displayUserInfo() {

    }

    public double getSaldoTotal() {
        return calcularSaldoRecursivo(new ArrayList<>(cuentas.values()), 0);
    }

    private double calcularSaldoRecursivo(List<Cuenta> listaCuentas, int index) {
        // Caso base: Si hemos recorrido todas las cuentas, retornamos 0
        if (index >= listaCuentas.size()) {
            return 0;
        }

        // Caso recursivo: Sumar el saldo total de la cuenta actual e ir a la siguiente
        return listaCuentas.get(index).getSaldoTotal() + calcularSaldoRecursivo(listaCuentas, index + 1);
    }

    public void agregarTransaccion(String idTransaccion) {
        transacciones.add(idTransaccion);
    }


   
}


