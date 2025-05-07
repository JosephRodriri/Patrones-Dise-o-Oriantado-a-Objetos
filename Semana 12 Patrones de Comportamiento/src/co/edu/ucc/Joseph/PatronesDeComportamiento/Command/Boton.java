package co.edu.ucc.Joseph.PatronesDeComportamiento.Command;

public class Boton {
    private Comando comando;
    public Boton(Comando comando){
        this.comando = comando;
    }
    public void presionar(){
        comando.ejecutar();
    }
}
