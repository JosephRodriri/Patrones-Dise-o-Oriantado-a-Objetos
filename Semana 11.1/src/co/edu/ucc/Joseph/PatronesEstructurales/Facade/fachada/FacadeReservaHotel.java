package co.edu.ucc.Joseph.PatronesEstructurales.Facade.fachada;

import co.edu.ucc.Joseph.PatronesEstructurales.Facade.interfaces.ISistemaFacturacion;
import co.edu.ucc.Joseph.PatronesEstructurales.Facade.interfaces.ISistemaPagos;
import co.edu.ucc.Joseph.PatronesEstructurales.Facade.interfaces.ISistemaReservas;
import co.edu.ucc.Joseph.PatronesEstructurales.Facade.servicios.SistemaFacturacion;
import co.edu.ucc.Joseph.PatronesEstructurales.Facade.servicios.SistemaPagos;
import co.edu.ucc.Joseph.PatronesEstructurales.Facade.servicios.SistemaReservas;

public class FacadeReservaHotel {
    private ISistemaReservas reservas;
    private ISistemaPagos pagos;
    private ISistemaFacturacion facturacion;

    public FacadeReservaHotel() {
        this.reservas = new SistemaReservas();
        this.pagos = new SistemaPagos();
        this.facturacion = new SistemaFacturacion();
    }

    public void reservar() {
        reservas.verificarDisponibilidad();
        pagos.procesarPago();
        facturacion.generarFactura();
        System.out.println("Reserva completada.");
    }
}
