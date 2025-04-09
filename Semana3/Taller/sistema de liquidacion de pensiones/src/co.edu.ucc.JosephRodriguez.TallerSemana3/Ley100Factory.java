
package co.edu.ucc.JosephRodriguez.TallerSemana3;
// Fábrica para la Ley 100
public class Ley100Factory implements LeyPensionFactory {
    private double[] salariosUltimos10Anios;

    public Ley100Factory(double[] salariosUltimos10Anios) {
        this.salariosUltimos10Anios = salariosUltimos10Anios;
    }

    @Override
    public LeyPension crearLeyPension() {
        return new Ley100(salariosUltimos10Anios);
    }
}

