public class FabricaCuentaAhorros implements FabricaBancaria {
    @Override
    public Cuenta crearCuenta() {
        return new CuentaAhorros();
    }

    @Override
    public Tarjeta crearTarjeta() {
        return new TarjetaCredito();
    }
}