package co.edu.ucc.Joseph.PatronesDeComportamiento.Mediator;

import co.edu.ucc.Joseph.PatronesDeComportamiento.Mediator.Participantes.Avion;
import co.edu.ucc.Joseph.PatronesDeComportamiento.Mediator.Participantes.Controlador;
import co.edu.ucc.Joseph.PatronesDeComportamiento.Mediator.Participantes.Participante;
import co.edu.ucc.Joseph.PatronesDeComportamiento.Mediator.Participantes.Pista;
import co.edu.ucc.Joseph.Requerimientos.Requerimientos;

public class Main {
    public static void main(String[] args) {
        Requerimientos.main(null);
        Requerimientos.getIdentidad();
        TorreControl torre = new TorreDeControl();

        Participante avion1 = new Avion("Latam 123", torre);
        Participante controlador = new Controlador("ATC Norte",torre);
        Participante pista = new Pista("Pista A", torre);

        avion1.enviar("Solicito autorizacion para aterrizar");
        controlador.enviar("Autorizo aterrizaje");
    }
}
