package co.edu.ucc.Joseph.PatronesDeComportamiento.State.Estados;

import co.edu.ucc.Joseph.PatronesDeComportamiento.State.Cajero;
import co.edu.ucc.Joseph.PatronesDeComportamiento.State.EstadoCajero;

public class Autenticado implements EstadoCajero {
    private Cajero cajero;

    public Autenticado(Cajero cajero) {
        this.cajero = cajero;
    }

    public void insertarTarjeta() {
        System.out.println("Ya autenticado, no necesita reiniciar");
    }

    public void ingresarPin(int pin) {
        System.out.println("ya autenticado");
    }

    public void retirarDinero(double monto) {
        System.out.println("Retirando $" + monto);
        cajero.setEstado(new SinTarjeta(cajero));
    }

}
