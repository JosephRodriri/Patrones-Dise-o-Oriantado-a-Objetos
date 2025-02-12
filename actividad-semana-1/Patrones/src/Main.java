// Facade para simplificar la reserva
class BookingFacade {
    private HotelAPI hotelAPI;
    private PaymentService paymentService;

    public BookingFacade() {
        this.hotelAPI = new HotelAPI();
        this.paymentService = new PaymentService();
    }

    public void reservarHabitacion(String usuario, String hotel, double monto) {
        hotelAPI.buscarHotel(hotel);
        paymentService.procesarPago(usuario, monto);
        System.out.println("Reserva completada para: " + usuario);
    }
}

// Clases de soporte
class HotelAPI {
    public void buscarHotel(String hotel) {
        System.out.println("Buscando disponibilidad en " + hotel);
    }
}

class PaymentService {
    public void procesarPago(String usuario, double monto) {
        System.out.println("Procesando pago de $" + monto + " para " + usuario);
    }
}


