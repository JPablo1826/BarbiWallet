package co.edu.uniquindio.poo.model;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor

public enum TipoCategoria {
    UNIVERSIDAD("Universidad"),SALUD("Salud"), ENTRETENIMIENTO("Entretenimiento");

    @Getter
    
    
            private String nombre;
    
        public static String[] stringValues() {  
            TipoCategoria[] tipos = TipoCategoria.values();
            String[] nombres = new String[tipos.length];
            for (int i = 0; i < tipos.length; i++) {
                nombres[i] = tipos[i].nombre;
            }
            return nombres;
        }
        public static TipoCategoria geTipoCategoria(String nombre) {
            for (TipoCategoria tipoCategoria : TipoCategoria.values()) {
                if (tipoCategoria.getNombre().equals(nombre)) {
                    return tipoCategoria;
                }
            }
            return null;
    
        }

    }