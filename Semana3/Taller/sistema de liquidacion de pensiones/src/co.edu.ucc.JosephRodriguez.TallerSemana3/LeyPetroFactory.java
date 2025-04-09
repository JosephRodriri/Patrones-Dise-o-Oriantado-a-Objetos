
package co.edu.ucc.JosephRodriguez.TallerSemana3;
// Fábrica para la Ley Petro
public class LeyPetroFactory implements LeyPensionFactory {
    private boolean esMenorEdad;

    public LeyPetroFactory(boolean esMenorEdad) {
        this.esMenorEdad = esMenorEdad;
    }

    @Override
    public LeyPension crearLeyPension() {
        return new LeyPetro(esMenorEdad);
    }
}

