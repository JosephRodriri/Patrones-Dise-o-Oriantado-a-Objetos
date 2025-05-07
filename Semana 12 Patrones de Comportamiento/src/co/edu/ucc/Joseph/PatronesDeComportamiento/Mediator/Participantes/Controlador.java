package co.edu.ucc.Joseph.PatronesDeComportamiento.Mediator.Participantes;

import co.edu.ucc.Joseph.PatronesDeComportamiento.Mediator.TorreControl;

public class Controlador extends Participante{
    public Controlador(String nombre, TorreControl torre) {
        super(nombre, torre);
    }
    public void recibir(String mensaje){
        System.out.println("Controlador " + nombre + " recibe: " + mensaje);
    }
}
