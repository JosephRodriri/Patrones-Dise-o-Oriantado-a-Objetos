package co.edu.ucc.Joseph.PatronesDeComportamiento.Observer;

import java.util.ArrayList;
import java.util.List;

class Sensor {
    private List<Observador> observadores = new ArrayList<>();
    private double temperatura;

    public void agregarObservador(Observador o) {
        observadores.add(o);
    }

    public void removerObservador(Observador o) {
        observadores.remove(o);
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
        notificarObservadores();
    }

    private void notificarObservadores() {
        for (Observador o : observadores) {
            o.actualizar(temperatura);
        }
    }
}
