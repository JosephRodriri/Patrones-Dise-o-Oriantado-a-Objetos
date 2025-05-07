package co.edu.ucc.Joseph.PatronesDeComportamiento.TemplateMethod.Implemantaciones;

import co.edu.ucc.Joseph.PatronesDeComportamiento.TemplateMethod.GeneradorReporte;

public class ReportePDF extends GeneradorReporte {
    protected void generarContenido() {
        System.out.println("Escribiendo contenido en PDF.");
    }

    protected void formatear() {
        System.out.println("Formateando como documento PDF.");
    }
}

