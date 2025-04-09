package co.edu.ucc.Joseph.semana10.composite.Ejercicio2;
import co.edu.ucc.Joseph.semana10.Requerimientos;

import java.util.ArrayList;
import java.util.List;

interface ElementoMenu {
    void mostrar();
}

class Opcion implements ElementoMenu {
    private String nombre;

    public Opcion(String nombre) {
        this.nombre = nombre;
    }

    public void mostrar() {
        System.out.println("Opción: " + nombre);
    }
}
class Menu implements ElementoMenu {
    private String nombre;
    private List<ElementoMenu> elementos = new ArrayList<>();

    public Menu(String nombre) {
        this.nombre = nombre;
    }

    public void agregar(ElementoMenu elemento) {
        elementos.add(elemento);
    }

    public void mostrar() {
        System.out.println("Menú: " + nombre);
        for (ElementoMenu e : elementos) {
            e.mostrar();
        }
    }
}



public class Main {
    public static void main(String[] args) {
        Requerimientos.main(null);
        Requerimientos.getIdentidad();

        Menu menuPrincipal = new Menu("Principal");

        Opcion opcion1 = new Opcion("Abrir");
        Opcion opcion2 = new Opcion("Guardar");


        Menu subMenu = new Menu("Editar");
        Opcion opcion3 = new Opcion("Copiar");
        Opcion opcion4 = new Opcion("Pegar");

        subMenu.agregar(opcion3);
        subMenu.agregar(opcion4);

        menuPrincipal.agregar(opcion1);
        menuPrincipal.agregar(opcion2);
        menuPrincipal.agregar(subMenu);

        menuPrincipal.mostrar();
    }
}
