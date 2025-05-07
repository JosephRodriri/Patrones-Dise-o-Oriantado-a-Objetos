package co.edu.ucc.Joseph.PatronesDeComportamiento.Mediator;


import co.edu.ucc.Joseph.PatronesDeComportamiento.Mediator.Participantes.Participante;

public interface TorreControl {
    void enviarMensaje(String mensaje, Participante emisor);
    void registrarParticipante(Participante p);
}
