
package co.edu.ucc.JosephRodriguez.TallerSemana3;
// Implementación de la Ley 100
public class Ley100 implements LeyPension {
    private double[] salariosUltimos10Anios;

    public Ley100(double[] salariosUltimos10Anios) {
        this.salariosUltimos10Anios = salariosUltimos10Anios;
    }

    @Override
    public double calcularPension(double salarioBase, int aniosServicio) {
        // Calcular el promedio de los últimos 10 años
        double suma = 0;
        for (double salario : salariosUltimos10Anios) {
            suma += salario;
        }
        return suma / salariosUltimos10Anios.length;
    }

    @Override
    public String getNombreLey() {
        return "Ley 100";
    }
}

