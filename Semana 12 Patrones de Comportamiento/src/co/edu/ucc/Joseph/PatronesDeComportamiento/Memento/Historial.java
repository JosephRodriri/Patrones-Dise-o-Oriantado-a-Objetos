package co.edu.ucc.Joseph.PatronesDeComportamiento.Memento;

import java.util.Stack;

public class Historial {
    private Stack<EditorTexto.Memento> pila = new Stack<>();

    public void guardar (EditorTexto.Memento m){
        pila.push(m);
    }
    public EditorTexto.Memento deshacer(){
        if (!pila.isEmpty()) {
            return pila.pop();
        }
        return null;
    }

}
