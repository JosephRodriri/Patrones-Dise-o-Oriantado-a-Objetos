package co.edu.ucc.JosephRodriguez.Semana8.facturacionbrige;

import co.edu.ucc.JosephRodriguez.Semana8.Requerido;

interface FormatoFactura {
    void generarFactura(String datos);
}

class FormatoPDF implements FormatoFactura {
    public void generarFactura(String datos) {
        System.out.println("Generando factura en PDF: " + datos);
    }
}

class FormatoXML implements FormatoFactura {
    public void generarFactura(String datos) {
        System.out.println("Generando factura en XML: " + datos);
    }
}

abstract class Factura {
    protected FormatoFactura formato;

    public Factura(FormatoFactura formato) {
        this.formato = formato;
    }

    public abstract void emitir(String datos);
}

class FacturaElectronica extends Factura {
    public FacturaElectronica(FormatoFactura formato) {
        super(formato);
    }

    public void emitir(String datos) {
        formato.generarFactura(datos);
    }
}

public class Main {
    public static void main(String[] args) {
        Requerido.main(null);
        Requerido.getIdentidad();
        Factura factura1 = new FacturaElectronica(new FormatoPDF());
        factura1.emitir("Factura #789 - Total: $1.200.000");
        Factura factura2 = new FacturaElectronica(new FormatoXML());
        factura2.emitir("Factura #790 - Total: $1.900.000");
    }
}

