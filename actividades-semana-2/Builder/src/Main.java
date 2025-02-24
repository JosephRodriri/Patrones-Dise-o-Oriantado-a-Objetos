import java.util.Base64;

class Paciente {
    private String nombre;
    private int edad;
    private String diagnostico;

    private Paciente() {}

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    // Método para codificar la identidad en Base64
    public String getIdentidad() {
        String datosPaciente = nombre + "," + edad + "," + diagnostico;
        return Base64.getEncoder().encodeToString(datosPaciente.getBytes());
    }

    public static class Builder {
        private Paciente paciente;

        public Builder() {
            paciente = new Paciente();
        }

        public Builder setNombre(String nombre) {
            paciente.nombre = nombre;
            return this;
        }

        public Builder setEdad(int edad) {
            paciente.edad = edad;
            return this;
        }

        public Builder setDiagnostico(String diagnostico) {
            paciente.diagnostico = diagnostico;
            return this;
        }

        public Paciente build() {
            if (paciente.nombre == null || paciente.diagnostico == null) {
                throw new IllegalStateException("Nombre y diagnóstico son obligatorios.");
            }
            return paciente;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Paciente paciente = new Paciente.Builder()
                .setNombre("Juan Pérez")
                .setEdad(30)
                .setDiagnostico("Dolor de cabeza")
                .build();

        System.out.println("Nombre: " + paciente.getNombre());
        System.out.println("Edad: " + paciente.getEdad());
        System.out.println("Diagnóstico: " + paciente.getDiagnostico());

        System.out.println("Identidad codificada: " + paciente.getIdentidad());
    }
}