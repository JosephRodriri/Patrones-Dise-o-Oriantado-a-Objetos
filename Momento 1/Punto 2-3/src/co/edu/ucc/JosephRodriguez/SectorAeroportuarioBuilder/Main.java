package co.edu.ucc.JosephRodriguez.SectorAeroportuarioBuilder;

class Boleto {
    private String clase;
    private boolean equipajeExtra;
    private boolean seleccionAsiento;
    private boolean comidaEspecial;


    private Boleto(BoletoBuilder builder) {
        this.clase = builder.clase;
        this.equipajeExtra = builder.equipajeExtra;
        this.seleccionAsiento = builder.seleccionAsiento;
        this.comidaEspecial = builder.comidaEspecial;
    }

    public void MostrarDetalles() {
        System.out.println("Clase: " + clase +
                ", Equipaje Extra: " + equipajeExtra +
                ", Selección de Asiento: " + seleccionAsiento +
                ", Comida Especial: " + comidaEspecial);
    }

    public static class BoletoBuilder {
        private String clase;
        private boolean equipajeExtra;
        private boolean seleccionAsiento;
        private boolean comidaEspecial;

        public BoletoBuilder(String clase) {
            this.clase = clase;
        }

        public BoletoBuilder agregarEquipajeExtra() {
            this.equipajeExtra = true;
            return this;
        }

        public BoletoBuilder seleccionarAsiento() {
            this.seleccionAsiento = true;
            return this;
        }

        public BoletoBuilder agregarComidaEspecial() {
            this.comidaEspecial = true;
            return this;
        }

        public Boleto build() {
            return new Boleto(this);
        }
    }
}


public class Main {
    public static void main(String[] args) {
        requerido.main(null);
        requerido.getIdentidad();

        Boleto boleto = new Boleto.BoletoBuilder("Ejecutiva")
                .agregarEquipajeExtra()
                .seleccionarAsiento()
                .agregarComidaEspecial()
                .build();

        boleto.MostrarDetalles();
    }
}