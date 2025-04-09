
package co.edu.ucc.JosephRodriguez.TallerSemana3;
// Fábrica para la Ley 98
public class Ley98Factory implements LeyPensionFactory {
    @Override
    public LeyPension crearLeyPension() {
        return new Ley98();
    }
}

