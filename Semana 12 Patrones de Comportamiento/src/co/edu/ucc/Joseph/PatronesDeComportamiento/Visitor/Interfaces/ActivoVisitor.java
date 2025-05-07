package co.edu.ucc.Joseph.PatronesDeComportamiento.Visitor.Interfaces;

import co.edu.ucc.Joseph.PatronesDeComportamiento.Visitor.Elementos.Inmueble;
import co.edu.ucc.Joseph.PatronesDeComportamiento.Visitor.Elementos.Vehiculo;

public interface ActivoVisitor {
    void visitar(Vehiculo i);
    void visitar(Inmueble v);
}
