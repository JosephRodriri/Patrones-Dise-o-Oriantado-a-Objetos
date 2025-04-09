public class Main {
    public static void main(String[] args) {
        FabricaBancaria fabricaCorriente = new FabricaCuentaCorriente();
        Cuenta cuentaCorriente = fabricaCorriente.crearCuenta();
        Tarjeta tarjetaDebito = fabricaCorriente.crearTarjeta();

        cuentaCorriente.abrir();
        tarjetaDebito.emitir();

        FabricaBancaria fabricaAhorros = new FabricaCuentaAhorros();
        Cuenta cuentaAhorros = fabricaAhorros.crearCuenta();
        Tarjeta tarjetaCredito = fabricaAhorros.crearTarjeta();

        cuentaAhorros.abrir();
        tarjetaCredito.emitir();
    }
}