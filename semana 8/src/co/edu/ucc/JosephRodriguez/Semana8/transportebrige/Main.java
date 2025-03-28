package co.edu.ucc.JosephRodriguez.Semana8.transportebrige;

import co.edu.ucc.JosephRodriguez.Semana8.Requerido;

interface ModoReporte {
    void imprimir(String contenido);
}

class Consola implements ModoReporte {
    public void imprimir(String contenido) {
        System.out.println("Reporte en consola: " + contenido);
    }
}

class ArchivoTexto implements ModoReporte {
    public void imprimir(String contenido) {
        System.out.println("Guardando en archivo: " + contenido);
    }
}

abstract class ReporteVehiculo {
    protected ModoReporte salida;

    public ReporteVehiculo(ModoReporte salida) {
        this.salida = salida;
    }

    public abstract void generar(String estado);
}

class ReporteEstado extends ReporteVehiculo {
    public ReporteEstado(ModoReporte salida) {
        super(salida);
    }

    public void generar(String estado) {
        salida.imprimir("Estado del vehículo: " + estado);
    }
}

public class Main {
    public static void main(String[] args) {
        Requerido.main(null);
        Requerido.getIdentidad();
        ReporteVehiculo reporte = new ReporteEstado(new Consola());
        reporte.generar("Motor funcionando, llantas en buen estado");
        ReporteVehiculo reporteArchivo = new ReporteEstado(new ArchivoTexto());
        reporteArchivo.generar("Falta x");
    }
}
