
package co.edu.ucc.JosephRodriguez.TallerSemana3;
// Implementación de la Ley 98
public class Ley98 implements LeyPension {
    @Override
    public double calcularPension(double salarioBase, int aniosServicio) {
        return salarioBase * 2.5;
    }

    @Override
    public String getNombreLey() {
        return "Ley 98";
    }
}

