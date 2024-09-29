package co.edu.uniquindio.poo.model;
import java.io.Serializable;
import java.util.ArrayList;

import co.edu.uniquindio.poo.exceptions.PresupuestoNoEncontradoException;
import co.edu.uniquindio.poo.exceptions.SaldoInsuficienteException;
import co.edu.uniquindio.poo.exceptions.TransaccionInvalidaException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@Getter
@Setter
@AllArgsConstructor
public class Cuenta implements Serializable, Retirable {

    private String idUsuario;
    private String banco;
    private int numeroCuenta;
    private TipoDeCuenta tipoDeCuenta;
    private ArrayList<Presupuesto> presupuesto;

    // Constructor
    public Cuenta(Cliente cliente, String banco, int numeroCuenta, TipoDeCuenta tipoDeCuenta) {
        this.idUsuario = cliente.getID();
        this.banco = banco;
        this.numeroCuenta = numeroCuenta;
        this.tipoDeCuenta = tipoDeCuenta;
        this.presupuesto = new ArrayList<>();
        this.presupuesto.add(Presupuesto.builder()
                .idPresupuesto("disponible")
                .nombre("disponible")
                .montoTotal(0)
                .montoGastado(0)
                .limite(-1)
                .categoria(new Categoria("disponible", "Disponible", "Saldo disponible en la cuenta"))
                .build());
    }

    @Override
    public void retirarDinero(double monto) throws TransaccionInvalidaException, SaldoInsuficienteException, PresupuestoNoEncontradoException {
        double saldoTotal = getSaldoTotal();
        if (monto <= 0) {
            throw new TransaccionInvalidaException("El monto a retirar debe ser mayor que 0.");
        }
        if (monto > saldoTotal) {
            throw new SaldoInsuficienteException ("No hay suficiente saldo en la cuenta.");
        }
        Presupuesto disponible = buscarPresupuestoId("disponible");
        if (disponible == null) {
            throw new PresupuestoNoEncontradoException("No hay presupuesto disponible.");
        }
        disponible.disminuirMontoActual(monto); 
        System.out.println("Retiro exitoso. Monto retirado: " + monto);
    }

    public Presupuesto buscarPresupuestoId  (String idPresupuesto){
        return presupuesto.stream()
                .filter(p -> p.getIdPresupuesto().equals(idPresupuesto))
                .findFirst()
                .orElse(null);
    }

    public double getSaldoTotal() {
        return calcularSaldoRecursivo(0);
    }

    private double calcularSaldoRecursivo(int index) {
        if (index >= presupuesto.size()) {
            return 0;
        }
        return presupuesto.get(index).getMontoActual() + calcularSaldoRecursivo(index + 1);
    }

    public void agregarPresupuesto(Presupuesto presupuesto) {
        if (buscarPresupuestoId(presupuesto.getIdPresupuesto()) != null) {
            throw new IllegalArgumentException("El presupuesto ya existe.");
        }
        this.presupuesto.add(presupuesto);
    }

    public void agregarADisponible(double monto) {
        Presupuesto disponible = buscarPresupuestoId("disponible");
        if (disponible == null) {
            throw new IllegalStateException("No hay presupuesto disponible.");
        }
        disponible.aumentarMonto(monto);
    }
}

