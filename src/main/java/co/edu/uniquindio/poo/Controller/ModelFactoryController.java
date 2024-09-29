package co.edu.uniquindio.poo.Controller;

import java.time.LocalDate;
import java.util.ArrayList;

import co.edu.uniquindio.poo.Utils.Serializacion;
import co.edu.uniquindio.poo.exceptions.ClienteNoEncontradoException;
import co.edu.uniquindio.poo.exceptions.inicioFallidoException;
import co.edu.uniquindio.poo.model.BilleteraVirtual;
import co.edu.uniquindio.poo.model.Cliente;
import co.edu.uniquindio.poo.model.Presupuesto;
import co.edu.uniquindio.poo.model.TipoCategoria;
import co.edu.uniquindio.poo.model.TipoTransaccion;
import co.edu.uniquindio.poo.model.Transaccion;
import co.edu.uniquindio.poo.model.Usuario;

public class ModelFactoryController {
    private static ModelFactoryController instance;

    public static ModelFactoryController getInstance() {
        if (instance == null) {
            instance = new ModelFactoryController();
        }
        return instance;
    }

    public Usuario iniciarSesion(String ID, String contrasena) throws inicioFallidoException {
        BilleteraVirtual billeteraVirtual = Serializacion.obternerDatos();
        return billeteraVirtual.iniciarSesion(ID, contrasena);
    }

    public void registrarNuevoCliente(String id, String nombre, String email, String telefono, String contrasena,
            String direccion) throws Exception {
        BilleteraVirtual billeteraVirtual = Serializacion.obternerDatos();
        Cliente c = new Cliente(email, nombre, email, telefono, contrasena, direccion);
        billeteraVirtual.registrarNuevoCliente(c);
        Serializacion.guardarDatos(billeteraVirtual);

    }

    public ArrayList<Cliente> listarClientes() {
        BilleteraVirtual billeteraVirtual = Serializacion.obternerDatos();
        return (ArrayList<Cliente>) billeteraVirtual.listarClientes();
    }

    public boolean eliminarCliente(String IDUsuario) {
        BilleteraVirtual billeteraVirtual = Serializacion.obternerDatos();
        return billeteraVirtual.eliminarCliente(IDUsuario);

    }

    public void modificarPerfilClientePorId(String id, String nombre, String email, String telefono, String contrasena,
            String direccion) throws Exception {
        BilleteraVirtual billeteraVirtual = Serializacion.obternerDatos();
        Cliente clienteModificado = new Cliente(id, nombre, email, telefono, contrasena, direccion);
        billeteraVirtual.modificarPerfilClientePorId(clienteModificado.getID(), clienteModificado);
        Serializacion.guardarDatos(billeteraVirtual);

    }

    public ArrayList<String> obtenerCategorias() {
        BilleteraVirtual billeteraVirtual = Serializacion.obternerDatos();
        return (ArrayList<String>) billeteraVirtual.obtenerCategorias();
    }

    public Cliente obtenerClientePorId(String idCuenta) {
        BilleteraVirtual billeteraVirtual = Serializacion.obternerDatos();
        return billeteraVirtual.obtenerClientePorID(idCuenta);

    }

   
    public ArrayList<Presupuesto> listarPresupuestosPorIdCliente(String idCliente) throws ClienteNoEncontradoException {
        BilleteraVirtual billeteraVirtual = Serializacion.obternerDatos();
        return billeteraVirtual.listarPresupuestosPorIdCliente(idCliente);

       
    }
    public Presupuesto crearPresupuesto(String idCliente, String nombre, double montoTotal, double limite,
            double montoGastado, String categoriaNombre) throws ClienteNoEncontradoException {
        BilleteraVirtual billeteraVirtual = Serializacion.obternerDatos();
        return billeteraVirtual.crearPresupuesto(idCliente, nombre, montoTotal, limite, limite, categoriaNombre);

    }

    public void crearTransaccionTemporal(String idtransaccion, LocalDate fecha, TipoTransaccion tipoTransaccion, Double monto, String descripcion, String origen, String destino, TipoCategoria categoria ) throws Exception{
        BilleteraVirtual billeteraVirtual=Serializacion.obternerDatos();
        //Transaccion deposito= Transaccion.builder().tipoTransaccion(tipoTransaccion.DEPOSITO).build();
        //Transaccion retiro= Transaccion.builder().tipoTransaccion(tipoTransaccion.RETIRO).build();
        //Transaccion transfe= Transaccion.builder().tipoTransaccion(tipoTransaccion.TRANSFERENCIA).build();
       
        
        Transaccion transaccion= Transaccion.builder().idTransaccion(idtransaccion).fecha(fecha).tipoTransaccion(tipoTransaccion).monto(monto).descripcion(descripcion).cuentaOrigen(origen).cuentaDestino(destino).categoria(categoria).build();
        billeteraVirtual.crearTransaccionTemporal(transaccion);
        Serializacion.guardarDatos(billeteraVirtual);
         
        

    }
    public ArrayList<Transaccion> listarTransacciones() {
        BilleteraVirtual billeteraVirtual = Serializacion.obternerDatos();
        ArrayList<Transaccion> transacciones = (ArrayList<Transaccion>) billeteraVirtual.listarTranscciones();
        return transacciones;
    }



}
        
        
