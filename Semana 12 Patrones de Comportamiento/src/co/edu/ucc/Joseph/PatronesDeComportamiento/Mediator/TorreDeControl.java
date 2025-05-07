package co.edu.ucc.Joseph.PatronesDeComportamiento.Mediator;

import co.edu.ucc.Joseph.PatronesDeComportamiento.Mediator.Participantes.Participante;

import java.util.ArrayList;
import java.util.List;

public class TorreDeControl implements TorreControl {
    private List<Participante> participantes = new ArrayList<>();

    public void registrarParticipante(Participante p) {
        participantes.add(p);
    }

    public void enviarMensaje(String mensaje, Participante emisor) {
        for (Participante p : participantes) {
            if (p != emisor) {
                p.recibir(mensaje + " (de " + emisor.getNombre() + ")");
            }
        }
    }
}


