
package co.edu.ucc.JosephRodriguez.TallerSemana3;
// Interfaz base para todas las leyes de pensión
public interface LeyPension {
    double calcularPension(double salarioBase, int aniosServicio);
    String getNombreLey();
}

