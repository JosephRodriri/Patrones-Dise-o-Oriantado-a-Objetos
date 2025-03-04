
package co.edu.ucc.JosephRodriguez.TallerSemana3;
// Fábrica para la Ley 78
public class Ley78Factory implements LeyPensionFactory {
    @Override
    public LeyPension crearLeyPension() {
        return new Ley78();
    }
}

