package co.edu.ucc.Joseph.PatronesEstructurales.Proxy.implementacion;

import co.edu.ucc.Joseph.PatronesEstructurales.Proxy.interfaces.IReporte;

public class ReporteReal implements IReporte {
    public void mostrar() {
        System.out.println("Mostrando reporte confidencial.");
    }
}

