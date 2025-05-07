package co.edu.ucc.Joseph.PatronesDeComportamiento.Observer;


import co.edu.ucc.Joseph.PatronesDeComportamiento.Observer.Observadores.NotificadorEmail;
import co.edu.ucc.Joseph.PatronesDeComportamiento.Observer.Observadores.OrdenTecnica;
import co.edu.ucc.Joseph.PatronesDeComportamiento.Observer.Observadores.RegistroEvento;
import co.edu.ucc.Joseph.Requerimientos.Requerimientos;

public class Main {
    public static void main(String[] args) {
        Requerimientos.main(null);
        Requerimientos.getIdentidad();
        Sensor sensor = new Sensor();
        sensor.agregarObservador(new NotificadorEmail());
        sensor.agregarObservador(new RegistroEvento());
        sensor.agregarObservador(new OrdenTecnica());

        sensor.setTemperatura(6.5);
        sensor.setTemperatura(8.5);
    }
}
