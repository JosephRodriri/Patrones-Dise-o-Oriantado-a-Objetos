package co.edu.ucc.Joseph.PatronesEstructurales.Flyweight;

import co.edu.ucc.Joseph.PatronesEstructurales.Flyweight.fabrica.FabricaLetras;
import co.edu.ucc.Joseph.PatronesEstructurales.Flyweight.interfaces.ILetra;
import co.edu.ucc.Joseph.PatronesEstructurales.Requerimientos.Requerimientos;

public class Main {
    public static void main(String[] args) {
        Requerimientos.main(null);
        Requerimientos.getIdentidad();
        ILetra letraA1 = FabricaLetras.obtenerLetra('A');
        ILetra letraA2 = FabricaLetras.obtenerLetra('A');
        ILetra letraB = FabricaLetras.obtenerLetra('B');

        letraA1.mostrar("1");
        letraA2.mostrar("2");
        letraB.mostrar("3");
    }
}
