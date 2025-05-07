package co.edu.ucc.Joseph.PatronesDeComportamiento.Observer.Observadores;

import co.edu.ucc.Joseph.PatronesDeComportamiento.Observer.Observador;


public class RegistroEvento implements Observador{
    public void actualizar(double temperatura){
        if(temperatura > 8.0){
            System.out.println("Evento registrado en base de datos -> " + temperatura + "°C");
        }
    }
}
