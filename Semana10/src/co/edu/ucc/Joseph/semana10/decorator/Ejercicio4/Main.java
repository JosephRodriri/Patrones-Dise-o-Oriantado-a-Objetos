package co.edu.ucc.Joseph.semana10.decorator.Ejercicio4;

import co.edu.ucc.Joseph.semana10.Requerimientos;

interface Cafe {
    String descripcion();
    double costo();
}

class CafeBasico implements Cafe {
    public String descripcion() { return "Café básico"; }
    public double costo() { return 5.0; }
}

abstract class CafeDecorator implements Cafe {
    protected Cafe cafe;

    public CafeDecorator(Cafe cafe) {
        this.cafe = cafe;
    }

    public String descripcion() {
        return cafe.descripcion();
    }

    public double costo() {
        return cafe.costo();
    }
}

class ConLeche extends CafeDecorator {
    public ConLeche(Cafe cafe) {
        super(cafe);
    }

    public String descripcion() {
        return super.descripcion() + " + Leche";
    }

    public double costo() {
        return super.costo() + 1.5;
    }
}

class ConAzucar extends CafeDecorator {
    public ConAzucar(Cafe cafe) {
        super(cafe);
    }

    public String descripcion() {
        return super.descripcion() + " + Azúcar";
    }

    public double costo() {
        return super.costo() + 0.5;
    }
}

public class Main {
    public static void main(String[] args) {
        Requerimientos.main(null);
        Requerimientos.getIdentidad();

        Cafe cafe = new CafeBasico();
        System.out.println(cafe.descripcion() + " - Costo: $" + cafe.costo());

        Cafe cafeConLeche = new ConLeche(new CafeBasico());
        System.out.println(cafeConLeche.descripcion() + " - Costo: $" + cafeConLeche.costo());

        Cafe cafeConAzucar = new ConAzucar(new CafeBasico());
        System.out.println(cafeConAzucar.descripcion() + " - Costo: $" + cafeConAzucar.costo());

        Cafe cafeCompleto = new ConAzucar(new ConLeche(new CafeBasico()));
        System.out.println(cafeCompleto.descripcion() + " - Costo: $" + cafeCompleto.costo());
    }
}
