package co.edu.ucc.Joseph.PatronesDeComportamiento.State.Estados;

import co.edu.ucc.Joseph.PatronesDeComportamiento.State.Cajero;
import co.edu.ucc.Joseph.PatronesDeComportamiento.State.EstadoCajero;


public class SinTarjeta implements EstadoCajero {
    private Cajero cajero;

    public SinTarjeta(Cajero cajero){
        this.cajero = cajero;
    }
    @Override
    public void insertarTarjeta() {
        System.out.printf("Tarjeta Insertada");
        cajero.setEstado(new ConTarjeta(cajero));

    }

    public void ingresarPin (int pin){
        System.out.println("Primero Inserte una tarjeta");
    }

    public void retirarDinero(double monto){
        System.out.println("primero inserte una tarjeta");
    }
}
