public class Main {
    public static void main(String[] args) {
        FarmaciaFactory fabricaAnalgesico = new FarmaciaAnalgesico();
        Medicamento analgesico = fabricaAnalgesico.crearMedicamento();
        analgesico.administrar();
        fabricaAnalgesico.mostrarIdentidad();

        FarmaciaFactory fabricaAntibiotico = new FarmaciaAntibiotico();
        Medicamento antibiotico = fabricaAntibiotico.crearMedicamento();
        antibiotico.administrar();
        fabricaAntibiotico.mostrarIdentidad();
    }
}