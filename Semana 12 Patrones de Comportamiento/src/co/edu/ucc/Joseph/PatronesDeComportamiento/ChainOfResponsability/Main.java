package co.edu.ucc.Joseph.PatronesDeComportamiento.ChainOfResponsability;

import co.edu.ucc.Joseph.Requerimientos.Requerimientos;


public class Main {
    public static void main(String[] args) {
        Requerimientos.main(null);
        Requerimientos.getIdentidad();
        Aprobador supervisor = new Supervisor();
        Aprobador jefe = new JefeDepartamento();
        Aprobador director = new DirectorFinanciero();

        supervisor.setSiguiente(jefe);
        jefe.setSiguiente(director);

        supervisor.procesarSolicitud(300);   // Supervisor
        supervisor.procesarSolicitud(3000);  // Jefe de Departamento
        supervisor.procesarSolicitud(15000); // Director Financiero

    }
}