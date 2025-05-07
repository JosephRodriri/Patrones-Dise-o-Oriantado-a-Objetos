package co.edu.ucc.Joseph.PatronesDeComportamiento.Command;


import co.edu.ucc.Joseph.PatronesDeComportamiento.Command.Comandos.ComandoEncenderLuz;
import co.edu.ucc.Joseph.PatronesDeComportamiento.Command.Comandos.ComandoSubirCortina;
import co.edu.ucc.Joseph.PatronesDeComportamiento.Command.Receptores.Cortina;
import co.edu.ucc.Joseph.PatronesDeComportamiento.Command.Receptores.Luz;
import co.edu.ucc.Joseph.Requerimientos.Requerimientos;

public class Main {
    public static void main(String[] args) {
        Requerimientos.main(null);
        Requerimientos.getIdentidad();
        Luz luz = new Luz();
        Cortina cortina = new Cortina();

        Comando cmdLuz = new ComandoEncenderLuz(luz);
        Comando cmdCortina = new ComandoSubirCortina(cortina);

        Boton boton1 = new Boton(cmdLuz);
        Boton boton2 = new Boton(cmdCortina);

        boton1.presionar();
        boton2.presionar();
    }
}