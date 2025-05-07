package co.edu.ucc.Joseph.PatronesDeComportamiento.Mediator.Participantes;

import co.edu.ucc.Joseph.PatronesDeComportamiento.Mediator.TorreControl;

public class Avion extends Participante{
    public Avion(String nombre, TorreControl torre) {
        super(nombre,torre);
    }
    public void recibir(String mensaje){
        System.out.println("Avión " + nombre + " recibe: " + mensaje);
    }
}
