package co.edu.ucc.JosephRodriguez.Semana8.Transporte;

import co.edu.ucc.JosephRodriguez.Semana8.Requerido;

interface LocalizadorWeb {
    void mostrarUbicacion(String coordenadas);
}

class GPSCamion {
    public String obtenerUbicacion() {
        return "Lat: 4.60971, Lon: -74.08175";
    }
}

class AdaptadorGPS implements LocalizadorWeb {
    private final GPSCamion gps;

    public AdaptadorGPS(GPSCamion gps) {
        this.gps = gps;
    }

    public void mostrarUbicacion(String coordenadas) {
        String ubicacion = gps.obtenerUbicacion();
        System.out.println("Ubicación del camión: " + ubicacion);
    }
}

public class Main {
    public static void main(String[] args) {
        Requerido.main(null);
        Requerido.getIdentidad();
        LocalizadorWeb localizador = new AdaptadorGPS(new GPSCamion());
        localizador.mostrarUbicacion("153.1248.59");
    }
}
