package co.edu.ucc.Joseph.PatronesDeComportamiento.Strategy;

class CalculadoraImpuesto {
    private EstrategiaImpuesto estrategia;

    public void setEstrategia(EstrategiaImpuesto estrategia) {
        this.estrategia = estrategia;
    }

    public double calcularImpuesto(double monto) {
        return estrategia.calcular(monto);
    }
}
