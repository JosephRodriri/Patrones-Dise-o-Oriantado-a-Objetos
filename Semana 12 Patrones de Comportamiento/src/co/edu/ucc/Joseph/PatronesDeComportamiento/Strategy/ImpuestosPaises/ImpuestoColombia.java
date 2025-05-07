package co.edu.ucc.Joseph.PatronesDeComportamiento.Strategy.ImpuestosPaises;

import co.edu.ucc.Joseph.PatronesDeComportamiento.Strategy.EstrategiaImpuesto;

public class ImpuestoColombia implements EstrategiaImpuesto {
    public double calcular(double monto) {
        return monto*19;
    }
}
