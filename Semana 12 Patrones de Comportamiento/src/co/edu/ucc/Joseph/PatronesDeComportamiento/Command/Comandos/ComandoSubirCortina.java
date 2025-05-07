package co.edu.ucc.Joseph.PatronesDeComportamiento.Command.Comandos;

import co.edu.ucc.Joseph.PatronesDeComportamiento.Command.Comando;
import co.edu.ucc.Joseph.PatronesDeComportamiento.Command.Receptores.Cortina;

public class ComandoSubirCortina implements Comando {
    private Cortina cortina;

    public ComandoSubirCortina(Cortina cortina){
        this.cortina = cortina;
    }
    public void ejecutar(){
        cortina.subir();
    }
}
