
package co.edu.ucc.JosephRodriguez.TallerSemana3;
// Implementación de la Ley 78
public class Ley78 implements LeyPension {
    @Override
    public double calcularPension(double salarioBase, int aniosServicio) {
        return salarioBase * 15;
    }

    @Override
    public String getNombreLey() {
        return "Ley 78";
    }
}

