package co.edu.ucc.Joseph.PatronesEstructurales.Facade.servicios;

import co.edu.ucc.Joseph.PatronesEstructurales.Facade.interfaces.ISistemaFacturacion;

public class SistemaFacturacion implements ISistemaFacturacion {
    public void generarFactura() {
        System.out.println("Factura generada.");
    }
}
