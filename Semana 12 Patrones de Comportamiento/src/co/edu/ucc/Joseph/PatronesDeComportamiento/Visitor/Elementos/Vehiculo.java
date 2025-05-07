package co.edu.ucc.Joseph.PatronesDeComportamiento.Visitor.Elementos;

import co.edu.ucc.Joseph.PatronesDeComportamiento.Visitor.Interfaces.Activo;
import co.edu.ucc.Joseph.PatronesDeComportamiento.Visitor.Interfaces.ActivoVisitor;

public class Vehiculo implements Activo {
    public void aceptar (ActivoVisitor visitor){
        visitor.visitar(this);
    }
    public double calcularValorFiscal() {
        return 35000;
    }

}
