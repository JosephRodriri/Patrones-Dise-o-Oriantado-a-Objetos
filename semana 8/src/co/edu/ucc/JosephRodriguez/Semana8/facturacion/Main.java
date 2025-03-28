package co.edu.ucc.JosephRodriguez.Semana8.facturacion;

import co.edu.ucc.JosephRodriguez.Semana8.Requerido;

interface ReporteNuevo {
    void generar(String datos);
}

class SistemaContableAntiguo {
    public void exportar(String contenido) {
        System.out.println("Exportando a sistema contable antiguo: " + contenido);
    }
}

class AdaptadorReporte implements ReporteNuevo {
    private final SistemaContableAntiguo sistema;

    public AdaptadorReporte(SistemaContableAntiguo sistema) {
        this.sistema = sistema;
    }

    public void generar(String datos) {
        sistema.exportar(datos);
    }
}

public class Main {
    public static void main(String[] args) {
        Requerido.main(null);
        Requerido.getIdentidad();
        ReporteNuevo reporte = new AdaptadorReporte(new SistemaContableAntiguo());
        reporte.generar("Factura #123 - Total: $50000");
    }
}
