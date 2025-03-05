package co.edu.ucc.JosephRodriguez.semana4;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;

class Documento implements Cloneable {
    private String contenido;

    public Documento(String contenido) {
        this.contenido = contenido;
    }

    public void mostrar() {
        System.out.println("Contenido del documento: " + contenido);
    }

    @Override
    protected Documento clone() throws CloneNotSupportedException {
        return (Documento) super.clone();
    }
}

public class Prototype {
    public static void main(String[] args) {
        encabezado();
        getIdentidad();
        try {
            Documento docOriginal = new Documento("Plantilla Base");
            Documento docClonado = docOriginal.clone();

            // Mostrar el contenido del documento original
            docOriginal.mostrar();

            // Mostrar el contenido del documento clonado
            docClonado.mostrar();

            // Modificar el contenido del documento clonado para demostrar que son independientes
            docClonado = new Documento("Contenido Modificado");
            docClonado.mostrar();

            // Mostrar nuevamente el contenido del documento original para verificar que no ha cambiado
            docOriginal.mostrar();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

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