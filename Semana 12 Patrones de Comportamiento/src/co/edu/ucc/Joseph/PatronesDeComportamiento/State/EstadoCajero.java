package co.edu.ucc.Joseph.PatronesDeComportamiento.State;

public interface EstadoCajero {
    void insertarTarjeta();
    void ingresarPin(int pin);
    void retirarDinero(double monto);
}
