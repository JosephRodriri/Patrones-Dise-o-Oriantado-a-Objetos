package co.edu.ucc.josephrodriguez.ejemplo2;

interface Figura {
    void dibujar();
}

class Circulo implements Figura {
    public void dibujar() {
        System.out.println("Dibujando un círculo");
    }
}

class Cuadrado implements Figura {
    public void dibujar() {
        System.out.println("Dibujando un cuadrado");
    }
}

class FiguraFactory {
    public static Figura crearFigura(String tipo) {
        if (tipo.equalsIgnoreCase("circulo")) return new Circulo();
        else if (tipo.equalsIgnoreCase("cuadrado")) return new Cuadrado();
        return null;
    }
}


