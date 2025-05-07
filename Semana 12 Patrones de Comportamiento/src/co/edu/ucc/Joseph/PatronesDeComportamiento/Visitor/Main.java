package co.edu.ucc.Joseph.PatronesDeComportamiento.Visitor;


import co.edu.ucc.Joseph.PatronesDeComportamiento.Visitor.Elementos.Inmueble;
import co.edu.ucc.Joseph.PatronesDeComportamiento.Visitor.Elementos.Vehiculo;
import co.edu.ucc.Joseph.PatronesDeComportamiento.Visitor.Interfaces.Activo;
import co.edu.ucc.Joseph.PatronesDeComportamiento.Visitor.Interfaces.ActivoVisitor;
import co.edu.ucc.Joseph.Requerimientos.Requerimientos;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Requerimientos.main(null);
        Requerimientos.getIdentidad();
        List<Activo> activos = new ArrayList<>();
        activos.add(new Inmueble());
        activos.add(new Vehiculo());

        ActivoVisitor reporte = new ReporteFiscalVisitor();

        for (Activo a : activos) {
            a.aceptar(reporte);
        }



    }
}