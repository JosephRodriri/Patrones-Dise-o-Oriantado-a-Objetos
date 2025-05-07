package co.edu.ucc.Joseph.PatronesDeComportamiento.Command.Comandos;

import co.edu.ucc.Joseph.PatronesDeComportamiento.Command.Comando;
import co.edu.ucc.Joseph.PatronesDeComportamiento.Command.Receptores.Luz;

public class ComandoEncenderLuz implements Comando {
    private Luz luz;
    public ComandoEncenderLuz(Luz luz){
        this.luz = luz;
    }
    public void ejecutar(){
        luz.encender();
    }
}
