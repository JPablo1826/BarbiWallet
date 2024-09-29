package co.edu.uniquindio.poo.model;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum TipoTransaccion {
    DEPOSITO("Deposito"),RETIRO("Retiro"), TRANSFERENCIA("Transferencia");

    @Getter
    
    
            private String nombre;
    
        public static String[] stringValues() {  
            TipoTransaccion[] tipos = TipoTransaccion.values();
            String[] nombres = new String[tipos.length];
            for (int i = 0; i < tipos.length; i++) {
                nombres[i] = tipos[i].nombre;
            }
            return nombres;
        }
        public static TipoTransaccion geTipoTransaccion(String nombre) {
            for (TipoTransaccion tipoTransaccion : TipoTransaccion.values()) {
                if (tipoTransaccion.getNombre().equals(nombre)) {
                    return tipoTransaccion;
                }
            }
            return null;
    
        }

    }
    
        