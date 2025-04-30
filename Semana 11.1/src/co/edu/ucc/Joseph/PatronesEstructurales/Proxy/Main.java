package co.edu.ucc.Joseph.PatronesEstructurales.Proxy;

import co.edu.ucc.Joseph.PatronesEstructurales.Proxy.interfaces.IReporte;
import co.edu.ucc.Joseph.PatronesEstructurales.Proxy.proxy.ProxyReporte;
import co.edu.ucc.Joseph.PatronesEstructurales.Requerimientos.Requerimientos;

public class Main {
    public static void main(String[] args) {
        Requerimientos.main(null);
        Requerimientos.getIdentidad();
        IReporte reporte1 = new ProxyReporte("gerente");
        reporte1.mostrar();

        IReporte reporte2 = new ProxyReporte("empleado");
        reporte2.mostrar();
    }
}
