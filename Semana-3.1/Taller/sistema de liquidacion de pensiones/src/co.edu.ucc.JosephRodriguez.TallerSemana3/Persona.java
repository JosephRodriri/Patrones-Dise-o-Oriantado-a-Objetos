package co.edu.ucc.JosephRodriguez.TallerSemana3;

// Clase para representar a una persona con pensión
public class Persona {
    private String nombre;
    private double salarioBase;
    private int aniosServicio;
    private LeyPension leyPension;

    public Persona(String nombre, double salarioBase, int aniosServicio, LeyPension leyPension) {
        this.nombre = nombre;
        this.salarioBase = salarioBase;
        this.aniosServicio = aniosServicio;
        this.leyPension = leyPension;
    }

    public double calcularPensionMensual() {
        return leyPension.calcularPension(salarioBase, aniosServicio);
    }

    public String getNombre() {
        return nombre;
    }

    public String getLeyNombre() {
        return leyPension.getNombreLey();
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public int getAniosServicio() {
        return aniosServicio;
    }
}

