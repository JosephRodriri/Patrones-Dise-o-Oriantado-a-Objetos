package co.edu.ucc.Joseph.PatronesDeComportamiento.TemplateMethod;


import co.edu.ucc.Joseph.PatronesDeComportamiento.TemplateMethod.Implemantaciones.ReporteExcel;
import co.edu.ucc.Joseph.PatronesDeComportamiento.TemplateMethod.Implemantaciones.ReportePDF;
import co.edu.ucc.Joseph.Requerimientos.Requerimientos;

public class Main {
    public static void main(String[] args) {
        Requerimientos.main(null);
        Requerimientos.getIdentidad();
      GeneradorReporte pdf = new ReportePDF();
      GeneradorReporte excel = new ReporteExcel();

        System.out.println("==== Generando PDF ====");
        pdf.generar();

        System.out.println("\n==== Generando Excel ====");
        excel.generar();

    }
}