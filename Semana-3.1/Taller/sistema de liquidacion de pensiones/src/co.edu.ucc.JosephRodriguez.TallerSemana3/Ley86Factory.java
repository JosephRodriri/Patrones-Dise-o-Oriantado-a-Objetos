
package co.edu.ucc.JosephRodriguez.TallerSemana3;
// Fábrica para la Ley 86
public class Ley86Factory implements LeyPensionFactory {
    @Override
    public LeyPension crearLeyPension() {
        return new Ley86();
    }
}

