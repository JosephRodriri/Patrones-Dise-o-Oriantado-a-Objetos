package co.edu.ucc.Joseph.PatronesDeComportamiento.Visitor.Elementos;

import co.edu.ucc.Joseph.PatronesDeComportamiento.Visitor.Interfaces.Activo;
import co.edu.ucc.Joseph.PatronesDeComportamiento.Visitor.Interfaces.ActivoVisitor;

public class Inmueble implements Activo {
    public void aceptar(ActivoVisitor visitor){
        visitor.visitar(this);
    }
    public double calcularValorFiscal(){
        return 100000;
    }
}
