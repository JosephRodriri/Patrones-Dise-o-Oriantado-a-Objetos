package co.edu.ucc.josephrodriguez.ejemplo1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;

public class Main {
    public static void main(String[] args) {
        encabezado();
        Database db1 = Database.getInstance();
        db1.ejecutarConsulta("SELECT * FROM pedidos");
        getIdentidad();
    }
    public static void encabezado() {

        String nombre = "Joseph Rodriguez";
        String campus = "Campus Cali, U. Cooperativa de colombia";
        String repositorio = "https://github.com/JosephRodriri/Patrones-Dise-o-Oriantado-a-Objetos";

        LocalDateTime ahora = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fecha = ahora.format(formatter);

        System.out.println("****************************************************");
        System.out.println("* \uD83D\uDE80 Nombre: " + nombre+" \uD83D\uDE80");
        System.out.println("* Campus: " + campus);
        System.out.println("*\uD83D\uDCDA Repositorio:   " + repositorio +"\uD83D\uDCDA");
        System.out.println("*\uD83C\uDFEB Fecha: " + fecha+ " \uD83C\uDFEB ");
        System.out.println("****************************************************");
        System.out.println("* Este programa implementa el patrón Singleton para");
        System.out.println("* gestionar un sistema de logging.");
        System.out.println("****************************************************");
    }
    public static void getIdentidad() {
        String nombreCompleto = "Joseph Rodriguez";
        String nombreCodificado = Base64.getEncoder().encodeToString(nombreCompleto.getBytes());

        System.out.println("\n🔐 Identidad codificada en Base64: " + nombreCodificado);
    }
}
