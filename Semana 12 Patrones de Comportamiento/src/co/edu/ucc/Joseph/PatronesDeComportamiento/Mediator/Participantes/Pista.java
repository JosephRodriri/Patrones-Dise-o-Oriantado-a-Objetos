package co.edu.ucc.Joseph.PatronesDeComportamiento.Mediator.Participantes;

import co.edu.ucc.Joseph.PatronesDeComportamiento.Mediator.TorreControl;

public class Pista extends Participante{
    public Pista(String nombre, TorreControl torre) {
        super(nombre, torre);
    }
    public void recibir(String mensaje){
        System.out.println("Pista " + nombre + " recibe: " + mensaje);
    }
}
