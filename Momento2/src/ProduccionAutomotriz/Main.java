package ProduccionAutomotriz;

class Auto {
    private String tipoMotor;
    private String sistemaAudio;
    private boolean sensoresProximidad;
    private String modelo;

    public Auto(String modelo) {
        this.modelo = modelo;
    }

    public String getTipoMotor() {
        return tipoMotor;
    }

    public void setTipoMotor(String tipoMotor) {
        this.tipoMotor = tipoMotor;
    }

    public String getSistemaAudio() {
        return sistemaAudio;
    }

    public void setSistemaAudio(String sistemaAudio) {
        this.sistemaAudio = sistemaAudio;
    }

    public boolean isTieneSensoresProximidad() {
        return sensoresProximidad;
    }

    public void setTieneSensoresProximidad(boolean tieneSensoresProximidad) {
        this.sensoresProximidad = sensoresProximidad;
    }

    public String getModelo() {
        return modelo;
    }

    @Override
    public String toString() {
        return "Auto{" +
                "modelo='" + modelo + '\'' +
                ", tipoMotor='" + tipoMotor + '\'' +
                ", sistemaAudio='" + sistemaAudio + '\'' +
                ", sensoresProximidad=" + (sensoresProximidad ? "Sí" : "No") +
                '}';
    }
}

interface AutoBuilder {
    void construirTipoMotor();
    void construirSistemaAudio();
    void construirSensoresProximidad();
    Auto getAuto();
}

class AutoBasicoBuilder implements AutoBuilder {
    private Auto auto;

    public AutoBasicoBuilder(String modelo) {
        this.auto = new Auto(modelo);
    }

    @Override
    public void construirTipoMotor() {
        auto.setTipoMotor("gasolina");
    }

    @Override
    public void construirSistemaAudio() {
        auto.setSistemaAudio("estándar");
    }

    @Override
    public void construirSensoresProximidad() {
        auto.setTieneSensoresProximidad(false);
    }

    @Override
    public Auto getAuto() {
        return auto;
    }
}

class AutoPremiumBuilder implements AutoBuilder {
    private Auto auto;

    public AutoPremiumBuilder(String modelo) {
        this.auto = new Auto(modelo);
    }

    @Override
    public void construirTipoMotor() {
        auto.setTipoMotor("eléctrico");
    }

    @Override
    public void construirSistemaAudio() {
        auto.setSistemaAudio("premium");
    }

    @Override
    public void construirSensoresProximidad() {
        auto.setTieneSensoresProximidad(true);
    }

    @Override
    public Auto getAuto() {
        return auto;
    }
}

class Director {
    private AutoBuilder autoBuilder;

    public void setAutoBuilder(AutoBuilder ab) {
        autoBuilder = ab;
    }

    public Auto getAuto() {
        return autoBuilder.getAuto();
    }

    public void construirAuto() {
        autoBuilder.construirTipoMotor();
        autoBuilder.construirSistemaAudio();
        autoBuilder.construirSensoresProximidad();
    }
}

public class Main {
    public static void main(String[] args) {
        Director director = new Director();

        AutoBuilder basicoBuilder = new AutoBasicoBuilder("Modelo Básico 2023");
        director.setAutoBuilder(basicoBuilder);
        director.construirAuto();

        Auto autoBasico = director.getAuto();
        System.out.println("Auto básico construido: " + autoBasico);

        AutoBuilder premiumBuilder = new AutoPremiumBuilder("Modelo Premium 2023");
        director.setAutoBuilder(premiumBuilder);
        director.construirAuto();

        Auto autoPremium = director.getAuto();
        System.out.println("Auto premium construido: " + autoPremium);

    }
}