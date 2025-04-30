package co.edu.ucc.Joseph.PatronesEstructurales.Facade.servicios;

import co.edu.ucc.Joseph.PatronesEstructurales.Facade.interfaces.ISistemaPagos;

public class SistemaPagos implements ISistemaPagos {
    public void procesarPago() {
        System.out.println("Pago procesado.");
    }
}
