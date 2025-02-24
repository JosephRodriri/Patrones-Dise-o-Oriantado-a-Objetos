public class FabricaCuentaCorriente implements FabricaBancaria {
    @Override
    public Cuenta crearCuenta() {
        return new CuentaCorriente();
    }

    @Override
    public Tarjeta crearTarjeta() {
        return new TarjetaDebito();
    }
}