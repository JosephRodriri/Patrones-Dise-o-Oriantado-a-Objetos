import java.util.Base64;

// Producto abstracto
interface Medicamento {
    void administrar();
    String getIdentidad();
}
// Producto concreto: Analgésico
class Analgesico implements Medicamento {
    @Override
    public void administrar() {
        System.out.println("Administrando analgésico para el dolor.");
    }

    @Override
    public String getIdentidad() {
        String nombreCompleto = "Tu Nombre Completo Aquí"; // Reemplaza con tu nombre completo
        return Base64.getEncoder().encodeToString(nombreCompleto.getBytes());
    }
}

// Producto concreto: Antibiótico
class Antibiotico implements Medicamento {
    @Override
    public void administrar() {
        System.out.println("Administrando antibiótico para la infección.");
    }

    @Override
    public String getIdentidad() {
        String nombreCompleto = "Tu Nombre Completo Aquí"; // Reemplaza con tu nombre completo
        return Base64.getEncoder().encodeToString(nombreCompleto.getBytes());
    }
}
// Fábrica abstracta
abstract class FarmaciaFactory {
    public abstract Medicamento crearMedicamento(); // Factory Method

    public void mostrarIdentidad() {
        Medicamento medicamento = crearMedicamento();
        System.out.println("Identidad codificada: " + medicamento.getIdentidad());
    }
}
// Fábrica concreta: Analgésico
class FarmaciaAnalgesico extends FarmaciaFactory {
    @Override
    public Medicamento crearMedicamento() {
        return new Analgesico();
    }
}

// Fábrica concreta: Antibiótico
class FarmaciaAntibiotico extends FarmaciaFactory {
    @Override
    public Medicamento crearMedicamento() {
        return new Antibiotico();
    }
}