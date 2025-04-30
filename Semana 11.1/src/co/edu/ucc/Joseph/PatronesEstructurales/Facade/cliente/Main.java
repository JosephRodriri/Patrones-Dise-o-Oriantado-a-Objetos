package co.edu.ucc.Joseph.PatronesEstructurales.Facade.cliente;

import co.edu.ucc.Joseph.PatronesEstructurales.Facade.fachada.FacadeReservaHotel;
import co.edu.ucc.Joseph.PatronesEstructurales.Requerimientos.Requerimientos;

public class Main {
    public static void main(String[] args) {
        Requerimientos.main(null);
        Requerimientos.getIdentidad();
        FacadeReservaHotel facade = new FacadeReservaHotel();
        facade.reservar();
    }
}
