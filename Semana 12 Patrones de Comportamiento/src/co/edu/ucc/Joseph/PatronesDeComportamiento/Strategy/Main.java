package co.edu.ucc.Joseph.PatronesDeComportamiento.Strategy;

import co.edu.ucc.Joseph.PatronesDeComportamiento.Strategy.ImpuestosPaises.ImpuestoArgentina;
import co.edu.ucc.Joseph.PatronesDeComportamiento.Strategy.ImpuestosPaises.ImpuestoColombia;
import co.edu.ucc.Joseph.PatronesDeComportamiento.Strategy.ImpuestosPaises.ImpuestoEcuador;
import co.edu.ucc.Joseph.Requerimientos.Requerimientos;

public class Main {
    public static void main(String[] args) {
        Requerimientos.main(null);
        Requerimientos.getIdentidad();
        CalculadoraImpuesto calculadora = new CalculadoraImpuesto();

        calculadora.setEstrategia(new ImpuestoColombia());
        System.out.println("Colombia: " + calculadora.calcularImpuesto(100000));

        calculadora.setEstrategia(new ImpuestoArgentina());
        System.out.println("Argentina: " + calculadora.calcularImpuesto(100000));

        calculadora.setEstrategia(new ImpuestoEcuador());
        System.out.println("Ecuador: " + calculadora.calcularImpuesto(100000));
    }
}
