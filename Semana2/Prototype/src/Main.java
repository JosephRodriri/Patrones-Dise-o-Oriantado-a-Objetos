import java.util.Base64;

// Prototipo
interface CuentaBancaria extends Cloneable {
    CuentaBancaria clone() throws CloneNotSupportedException;
    void mostrarInfo();
    String getIdentidad();
}

// Producto concreto: Cuenta de Ahorros
class CuentaAhorros implements CuentaBancaria {
    private String titular;
    private double saldo;

    public CuentaAhorros(String titular, double saldo) {
        this.titular = titular;
        this.saldo = saldo;
    }

    @Override
    public CuentaBancaria clone() throws CloneNotSupportedException {
        return (CuentaAhorros) super.clone();
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Titular: " + titular);
        System.out.println("Saldo: " + saldo);
    }

    @Override
    public String getIdentidad() {
        String datosCuenta = titular + "," + saldo;
        return Base64.getEncoder().encodeToString(datosCuenta.getBytes());
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            CuentaBancaria cuentaOriginal = new CuentaAhorros("Juan Pérez", 1000.0);
            System.out.println("Cuenta Original:");
            cuentaOriginal.mostrarInfo();
            System.out.println("Identidad codificada: " + cuentaOriginal.getIdentidad());

            CuentaBancaria cuentaClonada = cuentaOriginal.clone();
            System.out.println("\nCuenta Clonada:");
            cuentaClonada.mostrarInfo();
            System.out.println("Identidad codificada: " + cuentaClonada.getIdentidad());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}