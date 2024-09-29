package co.edu.uniquindio.poo.Utils;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import co.edu.uniquindio.poo.model.BilleteraVirtual;


public class Serializacion {

    private static final String RUTA = "datos.dat";

    public static void guardarDatos(BilleteraVirtual billeteraVirtual) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(RUTA))) {
            oos.writeObject(billeteraVirtual);
            System.out.println("Guardado exitoso de datos");
        } catch (IOException e) {
            System.out.println("Error al guardar datos: " + e.getMessage());
        }
    }

    public static BilleteraVirtual obternerDatos() {
        BilleteraVirtual billeteraVirtual = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(RUTA))) {
            billeteraVirtual = (BilleteraVirtual) ois.readObject();
            System.out.println("Datos cargados exitosamente");
        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el archivo de datos");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer datos: " + e.getMessage());
        }
        if (billeteraVirtual == null) {
            billeteraVirtual = new BilleteraVirtual();
            guardarDatos(billeteraVirtual); // Si no se encontraron datos, se crea una nueva instancia y se guarda
        }
        return billeteraVirtual;
    }}

    

