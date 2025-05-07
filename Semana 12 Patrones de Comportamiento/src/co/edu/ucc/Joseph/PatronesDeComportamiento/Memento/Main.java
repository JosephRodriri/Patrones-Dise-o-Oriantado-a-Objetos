package co.edu.ucc.Joseph.PatronesDeComportamiento.Memento;

import co.edu.ucc.Joseph.Requerimientos.Requerimientos;

public class Main {
    public static void main(String[] args) {
        Requerimientos.main(null);
        Requerimientos.getIdentidad();
        EditorTexto editor = new EditorTexto();
        Historial historial = new Historial();

        editor.escribir("Hola");
        historial.guardar(editor.guardar());

        editor.escribir(" mundo");
        historial.guardar(editor.guardar());

        editor.escribir(" cruel");

        System.out.println("Actual: " + editor.getContenido()); // Hola mundo cruel

        editor.restaurar(historial.deshacer());
        System.out.println("Undo 1: " + editor.getContenido()); // Hola mundo

        editor.restaurar(historial.deshacer());
        System.out.println("Undo 2: " + editor.getContenido()); // Hola

    }
}
