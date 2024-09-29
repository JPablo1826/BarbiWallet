package co.edu.uniquindio.poo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum TipoDeCuenta {
    AHORRO("Ahorro"),
    CORRIENTE("Corriente");

    @Getter
    private String nombre;

    public static String[] stringValues() {
        TipoDeCuenta[] tipos = TipoDeCuenta.values();
        String[] nombres = new String[tipos.length];
        for (int i = 0; i < tipos.length; i++) {
            nombres[i] = tipos[i].nombre;
        }
        return nombres;
    }

    public static TipoDeCuenta getTipoEvento(String nombre) {
        for (TipoDeCuenta tipoEvento : TipoDeCuenta.values()) {
            if (tipoEvento.getNombre().equals(nombre)) {
                return tipoEvento;
            }
        }
        return null;

    }

}
