package co.edu.ucc.JosephRodriguez.semana4;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;

interface Boton {
    void render();
}

// Interfaz común para Ventana
interface Ventana {
    void mostrar();
}

// Implementaciones para Light Mode
class BotonLight implements Boton {
    public void render() { System.out.println("Renderizando botón Light"); }
}
class VentanaLight implements Ventana {
    public void mostrar() { System.out.println("Mostrando ventana Light"); }
}

// Implementaciones para Dark Mode
class BotonDark implements Boton {
    public void render() { System.out.println("Renderizando botón Dark"); }
}
class VentanaDark implements Ventana {
    public void mostrar() { System.out.println("Mostrando ventana Dark"); }
}

// Abstract Factory
interface GUIFactory {
    Boton crearBoton();
    Ventana crearVentana();
}

// Fábricas concretas
class LightFactory implements GUIFactory {
    public Boton crearBoton() { return new BotonLight(); }
    public Ventana crearVentana() { return new VentanaLight(); }
}

class DarkFactory implements GUIFactory {
    public Boton crearBoton() { return new BotonDark(); }
    public Ventana crearVentana() { return new VentanaDark(); }
}

// Cliente
public class AbstractFactory {
    public static void main(String[] args) {
        encabezado();
        getIdentidad();

        GUIFactory factory = new DarkFactory(); // Puede cambiarse por LightFactory
        Boton boton = factory.crearBoton();
        Ventana ventana = factory.crearVentana();
        boton.render();
        ventana.mostrar();
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
        System.out.println("* Este programa implementa el patrón Abstrac Factory");
        System.out.println("****************************************************");
    }
    public static void getIdentidad() {
        String nombreCompleto = "Joseph Rodriguez";
        String nombreCodificado = Base64.getEncoder().encodeToString(nombreCompleto.getBytes());

        System.out.println("\n🔐 Identidad codificada en Base64: " + nombreCodificado);
    }
}
