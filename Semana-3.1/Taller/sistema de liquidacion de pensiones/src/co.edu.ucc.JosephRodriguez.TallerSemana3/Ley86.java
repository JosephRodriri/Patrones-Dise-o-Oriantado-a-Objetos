
package co.edu.ucc.JosephRodriguez.TallerSemana3;
// Implementación de la Ley 86
public class Ley86 implements LeyPension {
    @Override
    public double calcularPension(double salarioBase, int aniosServicio) {
        return salarioBase * 5;
    }

    @Override
    public String getNombreLey() {
        return "Ley 86";
    }
}

