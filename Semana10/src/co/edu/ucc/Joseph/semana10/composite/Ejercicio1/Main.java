package co.edu.ucc.Joseph.semana10.composite.Ejercicio1;

import co.edu.ucc.Joseph.semana10.Requerimientos;

import java.util.ArrayList;
import java.util.List;

interface ArchivoComponent{
    void mostrar();
}

class Archivo implements ArchivoComponent{
    private String nombre;
    public Archivo(String nombre){
        this.nombre = nombre;
    }
    public void mostrar(){
        System.out.println("Archivo: "+nombre);
    }
}

class Carpeta implements ArchivoComponent{
    private String nombre;
    private List<ArchivoComponent> elementos = new ArrayList<>();

    public Carpeta(String nombre){
        this.nombre = nombre;
    }

    public void agregar(ArchivoComponent componente){
       elementos.add(componente);
    }
    public void mostrar(){
        System.out.println("Carpeta: "+nombre);
        for(ArchivoComponent c : elementos){
            c.mostrar();
        }
    }
}


public class Main {
    public static void main(String[] args) {
        Requerimientos.main(null);
        Requerimientos.getIdentidad();
        Carpeta Root = new Carpeta("root");
        Archivo archivo1 = new Archivo("archivo.txt");
        Carpeta sub = new Carpeta("sub");
        Archivo archivo2 = new Archivo("Imageb.jpg");

        Root.agregar(archivo1);
        Root.agregar(sub);
        sub.agregar(archivo2);

        Root.mostrar();
    }



}
