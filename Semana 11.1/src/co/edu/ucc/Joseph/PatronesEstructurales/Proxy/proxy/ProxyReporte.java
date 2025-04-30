package co.edu.ucc.Joseph.PatronesEstructurales.Proxy.proxy;

import co.edu.ucc.Joseph.PatronesEstructurales.Proxy.implementacion.ReporteReal;
import co.edu.ucc.Joseph.PatronesEstructurales.Proxy.interfaces.IReporte;

public class ProxyReporte implements IReporte {
    private ReporteReal reporteReal;
    private String rolUsuario;

    public ProxyReporte(String rolUsuario) {
        this.rolUsuario = rolUsuario;
    }

    public void mostrar() {
        if ("gerente".equalsIgnoreCase(rolUsuario)) {
            if (reporteReal == null) {
                reporteReal = new ReporteReal();
            }
            reporteReal.mostrar();
        } else {
            System.out.println("Acceso denegado: " + rolUsuario);
        }
    }
}
