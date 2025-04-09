package co.edu.ucc.Joseph.semana10.decorator.Ejercicio3;

import co.edu.ucc.Joseph.semana10.Requerimientos;

interface Notificacion {
    void enviar(String mensaje);
}

class NotificacionBasica implements Notificacion {
    public void enviar(String mensaje) {
        System.out.println("Notificación básica: " + mensaje);
    }
}

abstract class NotificacionDecorator implements Notificacion {
    protected Notificacion wrappee;

    public NotificacionDecorator(Notificacion n) {
        this.wrappee = n;
    }

    public void enviar(String mensaje) {
        wrappee.enviar(mensaje);
    }
}

class NotificacionEmail extends NotificacionDecorator {
    public NotificacionEmail(Notificacion n) {
        super(n);
    }

    public void enviar(String mensaje) {
        super.enviar(mensaje);
        System.out.println("Enviando email: " + mensaje);
    }
}

class NotificacionSMS extends NotificacionDecorator {
    public NotificacionSMS(Notificacion n) {
        super(n);
    }

    public void enviar(String mensaje) {
        super.enviar(mensaje);
        System.out.println("Enviando SMS: " + mensaje);
    }
}



public class Main {
    public static void main(String[] args) {
        Requerimientos.main(null);
        Requerimientos.getIdentidad();

        Notificacion notificacion = new NotificacionBasica();
        notificacion.enviar("Miraaaa kbron");
        System.out.println("---");

        Notificacion emailNotificacion = new NotificacionEmail(new NotificacionBasica());
        emailNotificacion.enviar("Hola soy el frailejon hernesto perez");
        System.out.println("---");

        Notificacion smsNotificacion = new NotificacionSMS(new NotificacionBasica());
        smsNotificacion.enviar("Ella quiere q la haga sudar");
        System.out.println("---");

        Notificacion combinada = new NotificacionSMS(new NotificacionEmail(new NotificacionBasica()));
        combinada.enviar("Ella quiere hum ah hum");
    }
}
