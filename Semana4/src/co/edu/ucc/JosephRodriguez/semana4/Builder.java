package co.edu.ucc.JosephRodriguez.semana4;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;

class Usuario {
    private String nombre;
    private int edad;
    private String direccion;
    private String telefono;

    private Usuario(UsuarioBuilder builder) {
        this.nombre = builder.nombre;
        this.edad = builder.edad;
        this.direccion = builder.direccion;
        this.telefono = builder.telefono;
    }

    public static class UsuarioBuilder {
        private String nombre;
        private int edad;
        private String direccion;
        private String telefono;

        public UsuarioBuilder(String nombre) {
            this.nombre = nombre;
        }

        public UsuarioBuilder setEdad(int edad) {
            this.edad = edad;
            return this;
        }

        public UsuarioBuilder setDireccion(String direccion) {
            this.direccion = direccion;
            return this;
        }

        public UsuarioBuilder setTelefono(String telefono) {
            this.telefono = telefono;
            return this;
        }

        public Usuario build() {
            return new Usuario(this);
        }
    }

    public String toString() {
        return "Usuario: " + nombre + ", Edad: " + edad + ", Dirección: " + direccion + ", Teléfono: " + telefono;
    }
}

public class Builder {
    public static void main(String[] args) {
        encabezado();
        getIdentidad();
        Usuario usuario = new Usuario.UsuarioBuilder("Juan Pérez")
                .setEdad(30)
                .setDireccion("Av. Principal 123")
                .setTelefono("123456789")
                .build();

        System.out.println(usuario);
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
        System.out.println("* Este programa implementa el patrón Builder");
        System.out.println("****************************************************");
    }
    public static void getIdentidad() {
        String nombreCompleto = "Joseph Rodriguez";
        String nombreCodificado = Base64.getEncoder().encodeToString(nombreCompleto.getBytes());

        System.out.println("\n🔐 Identidad codificada en Base64: " + nombreCodificado);
    }
}
