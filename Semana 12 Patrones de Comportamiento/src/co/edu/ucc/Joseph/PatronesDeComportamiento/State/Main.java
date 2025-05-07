package co.edu.ucc.Joseph.PatronesDeComportamiento.State;

import co.edu.ucc.Joseph.Requerimientos.Requerimientos;

public class Main {
    public static void main(String[] args) {
        Requerimientos.main(null);
        Requerimientos.getIdentidad();
       Cajero cajero = new Cajero();

       cajero.insertarTarjeta();
       cajero.ingresarPin(1111);
       cajero.ingresarPin(1234);
       cajero.retirarDinero(200);
    }
}