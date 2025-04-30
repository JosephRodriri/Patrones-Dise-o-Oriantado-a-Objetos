package co.edu.ucc.Joseph.PatronesEstructurales.Facade.servicios;

import co.edu.ucc.Joseph.PatronesEstructurales.Facade.interfaces.ISistemaReservas;

public class SistemaReservas implements ISistemaReservas {
    public void verificarDisponibilidad() {
        System.out.println("Hotel disponible.");
    }
}
