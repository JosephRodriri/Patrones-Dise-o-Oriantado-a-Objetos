import java.util.Base64;

public class Banco {
    private static Banco instance;
    private String nombreBanco;

    private Banco() {
        nombreBanco = "Banco Central";
    }

    public static Banco getInstance() {
        if (instance == null) {
            instance = new Banco();
        }
        return instance;
    }D

    public void mostrarNombre() {
        System.out.println("Bienvenido al " + nombreBanco);
    }

    public String getIdentidad() {
        String nombreCompleto = "Joseph Arnulfo Rodriguez Rivera";
        String nombreCodificado = Base64.getEncoder().encodeToString(nombreCompleto.getBytes());
        return nombreCodificado;
    }

    public static void main(String[] args) {
        Banco banco = Banco.getInstance();
        banco.mostrarNombre();


        System.out.println("Identidad codificada: " + banco.getIdentidad());
    }
}