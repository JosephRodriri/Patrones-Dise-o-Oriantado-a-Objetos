package co.edu.ucc.Joseph.PatronesDeComportamiento.State.Estados;

import co.edu.ucc.Joseph.PatronesDeComportamiento.State.Cajero;
import co.edu.ucc.Joseph.PatronesDeComportamiento.State.EstadoCajero;

public class ConTarjeta implements EstadoCajero {
    private Cajero cajero;

    public ConTarjeta(Cajero cajero) {
        this.cajero = cajero;
    }

    public void insertarTarjeta() {
        System.out.printf("ya hay una Tarjeta Insertada");
    }

    public void ingresarPin(int pin){
        if (pin == 1234) {
            System.out.println("PIN correcto.");
            cajero.setEstado(new Autenticado(cajero));
        } else {
            System.out.println("PIN incorrecto.");
        }

    }

    public void retirarDinero(double monto){
        System.out.println("debe ingresar pin primero");
    }
}
