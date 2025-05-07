package co.edu.ucc.Joseph.PatronesDeComportamiento.ChainOfResponsability;

abstract class Aprobador {
    protected Aprobador siguiente;

    public void setSiguiente(Aprobador siguiente){
        this.siguiente = siguiente;
    }
    public abstract void  procesarSolicitud(double monto);
}
