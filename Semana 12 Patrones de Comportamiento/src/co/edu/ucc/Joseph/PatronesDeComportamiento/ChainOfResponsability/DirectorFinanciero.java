package co.edu.ucc.Joseph.PatronesDeComportamiento.ChainOfResponsability;

public class DirectorFinanciero extends Aprobador{
    public void procesarSolicitud(double monto){
        if (monto > 5000) {
            System.out.println("Aprobado por Director Financiero.");
        } else if (siguiente != null) {
            siguiente.procesarSolicitud(monto);
        }

    }
}
