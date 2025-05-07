package co.edu.ucc.Joseph.PatronesDeComportamiento.Visitor;

import co.edu.ucc.Joseph.PatronesDeComportamiento.Visitor.Elementos.Inmueble;
import co.edu.ucc.Joseph.PatronesDeComportamiento.Visitor.Elementos.Vehiculo;
import co.edu.ucc.Joseph.PatronesDeComportamiento.Visitor.Interfaces.ActivoVisitor;

public class ReporteFiscalVisitor implements ActivoVisitor {
    public void visitar(Inmueble i) {
        System.out.println("Inmueble - Valor fiscal: $" + i.calcularValorFiscal());
    }

    public void visitar(Vehiculo v) {
        System.out.println("Vehículo - Valor fiscal: $" + v.calcularValorFiscal());
    }
}
