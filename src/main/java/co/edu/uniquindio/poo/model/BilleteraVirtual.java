package co.edu.uniquindio.poo.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.uniquindio.poo.exceptions.ClienteNoEncontradoException;
import co.edu.uniquindio.poo.exceptions.CuentaNoEncontradaException;
import co.edu.uniquindio.poo.exceptions.DatosErroneosException;
import co.edu.uniquindio.poo.exceptions.ObjetoExistenteException;
import co.edu.uniquindio.poo.exceptions.ObjetoNoExistenteException;
import co.edu.uniquindio.poo.exceptions.PresupuestoNoEncontradoException;
import co.edu.uniquindio.poo.exceptions.SaldoInsuficienteException;
import co.edu.uniquindio.poo.exceptions.TransaccionInvalidaException;
import co.edu.uniquindio.poo.exceptions.inicioFallidoException;

public class BilleteraVirtual implements  Serializable {
    private ArrayList<Cliente> clientes = new ArrayList<>();

    private ArrayList<Transaccion> transacciones = new ArrayList<>();
/* 
    @Override
    public void retirarDinero(double monto)
            throws TransaccionInvalidaException, SaldoInsuficienteException, PresupuestoNoEncontradoException {
        double saldoTotal = getSaldoTotal();
        if (monto <= 0) {
            throw new TransaccionInvalidaException("El monto a retirar debe ser mayor que 0.");
        }
        if (monto > saldoTotal) {
            throw new SaldoInsuficienteException("No hay suficiente saldo en la cuenta.");
        }
        Presupuesto disponible = buscarPresupuestoId("disponible");
        if (disponible == null) {
            throw new PresupuestoNoEncontradoException("No hay presupuesto disponible.");
        }
        disponible.disminuirMontoActual(monto);
        System.out.println("Retiro exitoso. Monto retirado: " + monto);
    }
        */

    public Usuario iniciarSesion(String ID, String contrasena) throws inicioFallidoException {
        Administrador admin = Administrador.obtenerInstancia();
        if (esAdministrador(ID, contrasena)) {
            return admin; // Retorna la instancia del administrador
        }
        // if (admin.getID().equals(ID) && admin.getContrasena().equals(contrasena)) {
        // return admin; // Retorna la instancia del administrador
        // }

        // Si no es el administrador, verifica si es un cliente
        for (Cliente cliente : clientes) {
            if (cliente.getID().equals(ID) && cliente.getContrasena().equals(contrasena)) {

                return cliente; // Retorna el cliente
            } // CORREGIR CICLOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO
        }

        throw new inicioFallidoException("Credenciales no válidas."); // Lanza excepción si no se encuentra
    }

    public boolean esCliente(String ID, String contrasena) {

        Cliente cliente = obtenerClientePorID(ID);

        return cliente != null && cliente.getContrasena().equals(contrasena);
    }

    public Cliente obtenerClientePorID(String ID) {

        List<Cliente> Clientes = listarClientes(); // Asumiendo que existe este método

        return obtenerClientePorID(Clientes, ID, 0);
    }

    private Cliente obtenerClientePorID(List<Cliente> Clientes, String ID, int indice) {
        if (indice >= Clientes.size()) {
            return null;
        }

        Cliente clienteActual = Clientes.get(indice);

        if (clienteActual.getID().equals(ID)) {
            return clienteActual;
        }

        return obtenerClientePorID(Clientes, ID, indice + 1);
    }

    public void registrarNuevoCliente(Cliente cliente) throws ObjetoExistenteException {
        if (buscarClientePorId(cliente.getID()) != null) {
            throw new ObjetoExistenteException("El cliente ya está registrado.");
        }
        clientes.add(cliente);
    }

    public Cliente buscarClientePorId(String id) {
        return buscarClientePorIdRecursivo(id, 0);
    }

    private Cliente buscarClientePorIdRecursivo(String id, int index) {
        // Caso base: Si el índice es igual al tamaño de la lista, no se encontró el
        // cliente
        if (index >= clientes.size()) {
            return null;
        }

        Cliente clienteActual = clientes.get(index);
        if (clienteActual.getID().equals(id)) {
            return clienteActual;
        }
        return buscarClientePorIdRecursivo(id, index + 1);
    }

    public void modificarPerfilClientePorId(String id, Cliente clienteModificado) throws ObjetoNoExistenteException {
        modificarPerfilClientePorIdRecursivo(id, clienteModificado, 0);
    }

    private void modificarPerfilClientePorIdRecursivo(String id, Cliente clienteModificado, int index)
            throws ObjetoNoExistenteException {
        // Caso base: Si el índice es igual al tamaño de la lista, no se encontró el
        // cliente
        if (index >= clientes.size()) {
            throw new ObjetoNoExistenteException("El cliente no fue encontrado");
        }

        Cliente clienteExistente = clientes.get(index);
        if (clienteExistente.getID().equals(id)) {
            // Si se encuentra el cliente, se actualizan sus datos
            clienteExistente.setNombre(clienteModificado.getNombre());
            clienteExistente.setCorreo(clienteModificado.getCorreo());
            clienteExistente.setTelefono(clienteModificado.getTelefono());
            clienteExistente.setDireccion(clienteModificado.getDireccion());
            clienteExistente.setContrasena(clienteModificado.getContrasena());
            return; // Salimos del método una vez que se actualiza el cliente
        }

        // Llamada recursiva para el siguiente índice
        modificarPerfilClientePorIdRecursivo(id, clienteModificado, index + 1);
    }

    private boolean esAdministrador(String ID, String contrasena) {
        return ID.equals("admin") && contrasena.equals("admin");
    }

    public double consultarSaldoPorId(String id) throws ClienteNoEncontradoException {
        return consultarSaldoPorIdRecursivo(id, 0);
    }

    private double consultarSaldoPorIdRecursivo(String id, int index) throws ClienteNoEncontradoException {

        if (index >= clientes.size()) {
            throw new ClienteNoEncontradoException("Cliente no encontrado.");
        }
        Cliente clienteActual = clientes.get(index);

        if (clienteActual.getID().equals(id)) {
            return clienteActual.getSaldoTotal();
        }

        return consultarSaldoPorIdRecursivo(id, index + 1);
    }

    private boolean esVerificado(String ID) {
        return ID != null && !ID.isEmpty();
    }

    public boolean eliminarCliente(String idCliente) {
        return clientes.removeIf(cliente -> cliente.getID().equals(idCliente));

    }

    public List<Cliente> listarClientes() {
        return clientes;
    }
/* 
    @Override
    public void realizarMovimiento(
            Cliente usuarioOrigen,
            String idCuentaOrigen,
            String idCuentaDestino,
            Cliente usuarioDestino,
            Double monto,
            String idPresupuesto,
            String descripcion,
            Categoria categoria) throws DatosErroneosException {
        Cliente clienteOrigen = buscarClientePorId(usuarioOrigen.getID());
        Cliente clienteDestino = buscarClientePorId(usuarioDestino.getID());
        if (clienteOrigen == null || clienteDestino == null) {
            throw new NullPointerException("Los datos son nulos verifique los datos ingresados");

        }
        Cuenta cuentaOrigen = clienteOrigen.buscarCuentaPorId(idCuentaOrigen);
        Cuenta cuentaDestino = clienteOrigen.buscarCuentaPorId(idCuentaDestino);

        Presupuesto presupuesto = cuentaOrigen.buscarPresupuestoId(idPresupuesto);
        if (presupuesto == null) {
            throw new DatosErroneosException("Los datos son nulos verifique los datos ingresados");
        }
        if (monto <= 0) {
            throw new DatosErroneosException("Los datos incorrecto verifique los datos ingresados");
        }
        if (monto > presupuesto.getMontoTotal()) {
            throw new DatosErroneosException("No hay suficiente saldo en el presupuesto");
        }
        presupuesto.disminuirMontoActual(monto);
        cuentaDestino.agregarADisponible(monto);

        String idTransaccion = UUID.randomUUID().toString();
        Transaccion transaccion = Transaccion.builder()
                .idTransaccion(idTransaccion)
                .fecha(LocalDate.now())
                .tipoTransaccion(TipoTransaccion.transferencia)
                .cuentaOrigen(cuentaOrigen)
                .cuentaDestino(cuentaDestino)
                .descripcion(descripcion)
                .monto(monto)
                .categoria(categoria)
                .build();
        transacciones.add(transaccion);
        clienteOrigen.agregarTransaccion(idTransaccion);

    }

   /* public void retirarDinero(Cliente cliente, String idCuenta, double monto)
            throws DatosErroneosException, CuentaNoEncontradaException {
        // Buscar la cuenta del cliente
        Cuenta cuenta = cliente.buscarCuentaPorId(idCuenta);

        if (cuenta == null) {
            throw new CuentaNoEncontradaException("La cuenta no fue encontrada");
        }

        // Verificar si la cuenta implementa la interfaz Retirable
        if (cuenta instanceof Retirable) {
            ((Retirable) cuenta).retirarDinero(monto);
        } else {
            throw new DatosErroneosException("La cuenta seleccionada no permite retiros.");
        }
    }
        */ 

    public List<String> obtenerCategorias() {
        ArrayList<String> categorias = new ArrayList<>();
        categorias.add("Universidad");
        categorias.add("Salud");
        categorias.add("Comida");
        categorias.add("Transporte");
        categorias.add("Educación");

        return categorias;
    }

    public Presupuesto crearPresupuesto(String idCliente, String nombre, double montoTotal, double limite,
            double montoGastado, String categoriaNombre) throws ClienteNoEncontradoException {
        Cliente cliente = buscarClientePorId(idCliente);
        if (cliente == null) {
            throw new ClienteNoEncontradoException("Cliente datoa guardados exitosamente.");
        }

        Presupuesto nuevoPresupuesto = Presupuesto.builder()
                .idPresupuesto(UUID.randomUUID().toString())
                .nombre(nombre)
                .montoTotal(montoTotal)
                .montoGastado(montoGastado) // Now accepting montoGastado as a parameter
                .limite(limite)
                .categoria(new Categoria(categoriaNombre, categoriaNombre, "Descripción de " + categoriaNombre))
                .build();

        // Supongamos que deseas agregar el presupuesto a la primera cuenta del cliente
        Cuenta primeraCuenta = cliente.getCuentas().values().stream().findFirst().orElse(null);
        if (primeraCuenta != null) {
            primeraCuenta.agregarPresupuesto(nuevoPresupuesto);
        }

        return nuevoPresupuesto;
    }

    public ArrayList<Presupuesto> listarPresupuestosPorIdCliente(String idCliente) throws ClienteNoEncontradoException {
        
        Cliente cliente = obtenerClientePorID(idCliente);

        if (cliente == null) {
            throw new ClienteNoEncontradoException("Cliente no encontrado.");
        }

        ArrayList<Presupuesto> presupuestos = new ArrayList<>();
        
        for (Cuenta cuenta : cliente.getCuentas().values()) {
            presupuestos.addAll(cuenta.getPresupuesto()); // 
        }

        return presupuestos;
    }

    public void crearTransaccionTemporal(Transaccion transaccion) throws ObjetoExistenteException {
        if (buscarTransaccionPorId(transaccion.getIdTransaccion
        ()) != null) {
            throw new ObjetoExistenteException("El cliente ya está registrado.");
        }
        transacciones.add(transaccion);
    }

    public Transaccion buscarTransaccionPorId(String id) {
        return buscarTransaccionPorIdRecursivo(id, 0);
    }

    private Transaccion buscarTransaccionPorIdRecursivo(String id, int index) {
        // Caso base: Si el índice es igual al tamaño de la lista, no se encontró el
        // cliente
        if (index >= transacciones.size()) {
            return null;
        }

        Transaccion transaccionActual = transacciones.get(index);
        if (transaccionActual.getIdTransaccion().equals(id)) {
            return transaccionActual;
        }
        return buscarTransaccionPorIdRecursivo(id, index + 1);
    }


    public ArrayList<Transaccion> listarTranscciones(){
        return transacciones;
    }






}