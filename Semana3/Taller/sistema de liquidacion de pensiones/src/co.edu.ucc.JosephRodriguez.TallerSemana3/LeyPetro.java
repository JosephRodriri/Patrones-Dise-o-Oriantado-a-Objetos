
package co.edu.ucc.JosephRodriguez.TallerSemana3;
// Implementación de la Ley Petro
public class LeyPetro implements LeyPension {
    private static final double SALARIO_MINIMO = 1400000;
    private static final double TOPE_MAXIMO = 3.5;
    private static final double PORCENTAJE_MENORES = 0.7;
    private boolean esMenorEdad;

    public LeyPetro(boolean esMenorEdad) {
        this.esMenorEdad = esMenorEdad;
    }

    @Override
    public double calcularPension(double salarioBase, int aniosServicio) {
        double salarioEnSalarioMinimos = salarioBase / SALARIO_MINIMO;

        // Aplicar tope máximo
        if (salarioEnSalarioMinimos > TOPE_MAXIMO) {
            return SALARIO_MINIMO * TOPE_MAXIMO;
        }

        // Aplicar reducción para menores
        if (esMenorEdad) {
            return salarioBase * PORCENTAJE_MENORES;
        }

        return salarioBase;
    }

    @Override
    public String getNombreLey() {
        return "Ley Petro";
    }
}

