package co.edu.ucc.Joseph.sistema9;

import co.edu.ucc.Joseph.Sistema9.requerido;

interface IGPSDataProvider {
    Location getLocation();
    String getStatus();
}

class Location {
    double latitude;
    double longitude;

    public Location(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }
}

class GarminAPI {
    public double getLatitude() {
        return 12.34;
    }

    public double getLongitude() {
        return 56.78;
    }

    public String getDeviceStatus() {
        return "Conectado";
    }
}

class GarminAdapter implements IGPSDataProvider {
    private GarminAPI garminAPI;

    public GarminAdapter(GarminAPI garminAPI) {
        this.garminAPI = garminAPI;
    }

    @Override
    public Location getLocation() {
        return new Location(garminAPI.getLatitude(), garminAPI.getLongitude());
    }

    @Override
    public String getStatus() {
        return garminAPI.getDeviceStatus();
    }
}


class RastreoPanel {
    private IRastreoPanelRenderer renderer;
    private IGPSDataProvider gpsDataProvider;

    public RastreoPanel(IRastreoPanelRenderer renderer, IGPSDataProvider gpsDataProvider) {
        this.renderer = renderer;
        this.gpsDataProvider = gpsDataProvider;
    }

    public void mostrarUbicacion() {
        Location location = gpsDataProvider.getLocation();
        renderer.drawMap(location.latitude, location.longitude);
    }

    public void mostrarEstado() {
        String status = gpsDataProvider.getStatus();
        renderer.displayStatus(status);
    }
}

interface IRastreoPanelRenderer {
    void drawMap(double latitude, double longitude);
    void displayStatus(String status);
}

class DesktopRastreoPanelRenderer implements IRastreoPanelRenderer {
    @Override
    public void drawMap(double latitude, double longitude) {
        System.out.println("Dibujando mapa en escritorio con ubicación: " + latitude + ", " + longitude);
    }

    @Override
    public void displayStatus(String status) {
        System.out.println("Mostrando estado en escritorio: " + status);
    }
}

class MobileRastreoPanelRenderer implements IRastreoPanelRenderer {
    @Override
    public void drawMap(double latitude, double longitude) {
        System.out.println("Dibujando mapa en móvil con ubicación: " + latitude + ", " + longitude);
    }

    @Override
    public void displayStatus(String status) {
        System.out.println("Mostrando estado en móvil: " + status);
    }
}

public class Main {
    public static void main(String[] args) {
        requerido.main(null);
        requerido.getIdentidad();
        GarminAPI garminAPI = new GarminAPI();
        GarminAdapter garminAdapter = new GarminAdapter(garminAPI);

        IRastreoPanelRenderer desktopRenderer = new DesktopRastreoPanelRenderer();
        IRastreoPanelRenderer mobileRenderer = new MobileRastreoPanelRenderer();

        RastreoPanel panelEscritorio = new RastreoPanel(desktopRenderer, garminAdapter);
        panelEscritorio.mostrarUbicacion();
        panelEscritorio.mostrarEstado();

        RastreoPanel panelMovil = new RastreoPanel(mobileRenderer, garminAdapter);
        panelMovil.mostrarUbicacion();
        panelMovil.mostrarEstado();
    }
}