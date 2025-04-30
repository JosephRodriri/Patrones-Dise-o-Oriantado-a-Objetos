package co.edu.ucc.Joseph.PatronesEstructurales.Requerimientos;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;

public class Requerimientos   {

    public static void main(String[] args) {
        String nombre = "Joseph Rodriguez";
        String campus = "Campus Cali, U. Cooperativa de Colombia";
        String repositorio = "https://github.com/JosephRodriri/Patrones-Dise-o-Drientado-a-Objetos";
        LocalDateTime ahora = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fecha = ahora.format(formatter);

        System.out.println("****************************************************");
        System.out.println("* \uD83D\uDC68 Nombre: " + nombre + " \uD83D\uDC68");
        System.out.println("* Campus: " + campus);
        System.out.println("* Repositorio: " + repositorio + " \uD83D\uDCDA");
        System.out.println("* Fecha: " + fecha + " \uD83D\uDFEB");
        System.out.println("****************************************************");
        System.out.println("* Este programa implementa patrones Fecade, Proxy y Flyweight");
        System.out.println("****************************************************");
    }

    public static void getIdentidad() {
        String nombreCompleto = "Joseph Rodriguez";
        String nombreCodificado = Base64.getEncoder().encodeToString(nombreCompleto.getBytes());
        System.out.println("\nIdentidad codificada en Base64: " + nombreCodificado);
    }
}