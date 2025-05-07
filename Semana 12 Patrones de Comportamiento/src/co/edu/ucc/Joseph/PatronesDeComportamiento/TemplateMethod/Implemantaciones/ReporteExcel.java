package co.edu.ucc.Joseph.PatronesDeComportamiento.TemplateMethod.Implemantaciones;

import co.edu.ucc.Joseph.PatronesDeComportamiento.TemplateMethod.GeneradorReporte;

public class ReporteExcel extends GeneradorReporte {
    protected void generarContenido() {
        System.out.println("Escribiendo contenido en celdas Excel.");
    }

    protected void formatear() {
        System.out.println("Formateando como hoja Excel.");
    }

}
