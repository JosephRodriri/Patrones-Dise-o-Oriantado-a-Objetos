package co.edu.ucc.JosephRodriguez.TallerSemana3;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Base64;

public class SistemaPensiones {
    private static List<Persona> personas = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        encabezado();
        getIdentidad();
        boolean ejecutar = true;

        // Cargar datos de ejemplo
        cargarDatosEjemplo();

        while (ejecutar) {
            mostrarMenu();
            int opcion = obtenerOpcion();

            switch (opcion) {
                case 1:
                    agregarPersona();
                    break;
                case 2:
                    consultarPension();
                    break;
                case 3:
                    mostrarTodasLasPersonas();
                    break;
                case 4:
                    ejecutar = false;
                    System.out.println("¡Gracias por usar el Sistema de Liquidación de Pensiones!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n===== SISTEMA DE LIQUIDACIÓN DE PENSIONES =====");
        System.out.println("1. Agregar persona");
        System.out.println("2. Consultar pensión por nombre");
        System.out.println("3. Mostrar todas las personas");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static int obtenerOpcion() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private static void agregarPersona() {
        System.out.println("\n----- AGREGAR NUEVA PERSONA -----");

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Salario base: ");
        double salarioBase = Double.parseDouble(scanner.nextLine());

        System.out.print("Años de servicio: ");
        int aniosServicio = Integer.parseInt(scanner.nextLine());

        System.out.println("\nSeleccione la ley aplicable:");
        System.out.println("1. Ley 78 (15 salarios)");
        System.out.println("2. Ley 86 (5 salarios)");
        System.out.println("3. Ley 98 (2.5 salarios)");
        System.out.println("4. Ley 100 (promedio últimos 10 años)");
        System.out.println("5. Ley Petro (tope máximo 3.5 salarios)");
        System.out.print("Opción: ");

        int leyOpcion = Integer.parseInt(scanner.nextLine());
        LeyPension leyPension = null;

        switch (leyOpcion) {
            case 1:
                leyPension = new Ley78Factory().crearLeyPension();
                break;
            case 2:
                leyPension = new Ley86Factory().crearLeyPension();
                break;
            case 3:
                leyPension = new Ley98Factory().crearLeyPension();
                break;
            case 4:
                double[] salarios = obtenerSalariosUltimos10Anios();
                leyPension = new Ley100Factory(salarios).crearLeyPension();
                break;
            case 5:
                System.out.print("¿Es menor de edad? (s/n): ");
                boolean esMenor = scanner.nextLine().toLowerCase().startsWith("s");
                leyPension = new LeyPetroFactory(esMenor).crearLeyPension();
                break;
            default:
                System.out.println("Opción no válida. Se usará Ley 78 por defecto.");
                leyPension = new Ley78Factory().crearLeyPension();
        }

        Persona nuevaPersona = new Persona(nombre, salarioBase, aniosServicio, leyPension);
        personas.add(nuevaPersona);

        System.out.println("\nPersona agregada exitosamente.");
        mostrarDetallesPersona(nuevaPersona);
    }

    private static double[] obtenerSalariosUltimos10Anios() {
        double[] salarios = new double[10];

        System.out.println("\nIngrese los salarios de los últimos 10 años:");

        for (int i = 0; i < 10; i++) {
            System.out.print("Salario año " + (10 - i) + ": ");
            salarios[i] = Double.parseDouble(scanner.nextLine());
        }

        return salarios;
    }

    private static void consultarPension() {
        System.out.print("\nIngrese el nombre de la persona a consultar: ");
        String nombreBuscar = scanner.nextLine();

        boolean encontrado = false;

        for (Persona persona : personas) {
            if (persona.getNombre().toLowerCase().contains(nombreBuscar.toLowerCase())) {
                mostrarDetallesPersona(persona);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontró ninguna persona con ese nombre.");
        }
    }

    private static void mostrarTodasLasPersonas() {
        System.out.println("\n----- LISTADO DE TODAS LAS PERSONAS -----");
        System.out.printf("%-25s | %-10s | %-15s | %-15s | %-15s%n",
                "NOMBRE", "LEY", "SALARIO BASE", "AÑOS SERVICIO", "PENSIÓN");
        System.out.println("-------------------------------------------------------------------------------------");

        for (Persona persona : personas) {
            System.out.printf("%-25s | %-10s | $%,13.0f | %13d | $%,13.0f%n",
                    persona.getNombre(),
                    persona.getLeyNombre(),
                    persona.getSalarioBase(),
                    persona.getAniosServicio(),
                    persona.calcularPensionMensual());
        }
    }

    private static void mostrarDetallesPersona(Persona persona) {
        System.out.println("\n----- DETALLES DE PENSIÓN -----");
        System.out.println("Nombre: " + persona.getNombre());
        System.out.println("Ley aplicable: " + persona.getLeyNombre());
        System.out.printf("Salario base: $%,.0f%n", persona.getSalarioBase());
        System.out.println("Años de servicio: " + persona.getAniosServicio());
        System.out.printf("Pensión mensual: $%,.0f%n", persona.calcularPensionMensual());
    }

    private static void cargarDatosEjemplo() {
        // Ley 78: 3 personas salario $850mil
        LeyPensionFactory fabricaLey78 = new Ley78Factory();
        for (int i = 1; i <= 3; i++) {
            personas.add(new Persona("Persona Ley78-" + i, 850000, 20, fabricaLey78.crearLeyPension()));
        }

        // Ley 86: 2 personas salario $930mil
        LeyPensionFactory fabricaLey86 = new Ley86Factory();
        for (int i = 1; i <= 2; i++) {
            personas.add(new Persona("Persona Ley86-" + i, 930000, 15, fabricaLey86.crearLeyPension()));
        }

        // Ley 98: 3 personas salario $1020mil, 2 personas salario doble
        LeyPensionFactory fabricaLey98 = new Ley98Factory();
        for (int i = 1; i <= 3; i++) {
            personas.add(new Persona("Persona Ley98-" + i, 1020000, 10, fabricaLey98.crearLeyPension()));
        }
        for (int i = 4; i <= 5; i++) {
            personas.add(new Persona("Persona Ley98-" + i, 2040000, 10, fabricaLey98.crearLeyPension()));
        }

        // Ley 100: 2 personas salario $1200mil últimos 10 años
        double[] salariosPersona1 = new double[10];
        for (int i = 0; i < 10; i++) {
            salariosPersona1[i] = 1200000;
        }

        // 1 persona $1230mil últimos 5 años +$1300 ultimos 10-5 años
        double[] salariosPersona2 = new double[10];
        for (int i = 0; i < 5; i++) {
            salariosPersona2[i] = 1230000;
        }
        for (int i = 5; i < 10; i++) {
            salariosPersona2[i] = 1300000;
        }

        LeyPensionFactory fabricaLey100Persona1 = new Ley100Factory(salariosPersona1);
        LeyPensionFactory fabricaLey100Persona2 = new Ley100Factory(salariosPersona2);

        personas.add(new Persona("Persona Ley100-1", 1200000, 25, fabricaLey100Persona1.crearLeyPension()));
        personas.add(new Persona("Persona Ley100-2", 1200000, 25, fabricaLey100Persona1.crearLeyPension()));
        personas.add(new Persona("Persona Ley100-3", 1230000, 25, fabricaLey100Persona2.crearLeyPension()));

        // Ley Petro: 4 personas 4 salarios mínimos de $1400mil
        LeyPensionFactory fabricaLeyPetroAdulto = new LeyPetroFactory(false);
        for (int i = 1; i <= 4; i++) {
            personas.add(new Persona("Persona LeyPetro-" + i, 5600000, 5, fabricaLeyPetroAdulto.crearLeyPension()));
        }

        // 3 personas $1400mil
        for (int i = 5; i <= 7; i++) {
            personas.add(new Persona("Persona LeyPetro-" + i, 1400000, 5, fabricaLeyPetroAdulto.crearLeyPension()));
        }
    }
    public static void encabezado() {

        String nombre = "Joseph Rodriguez";
        String campus = "Campus Cali, U. Cooperativa de colombia";
        String repositorio = "https://github.com/JosephRodriri/Patrones-Dise-o-Oriantado-a-Objetos";

        LocalDateTime ahora = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String fecha = ahora.format(formatter);

        System.out.println("****************************************************");
        System.out.println("* \uD83D\uDE80 Nombre: " + nombre+" \uD83D\uDE80");
        System.out.println("* Campus: " + campus);
        System.out.println("*\uD83D\uDCDA Repositorio:   " + repositorio +"\uD83D\uDCDA");
        System.out.println("*\uD83C\uDFEB Fecha: " + fecha+ " \uD83C\uDFEB ");
        System.out.println("****************************************************");
        System.out.println("* Este programa implementa el patrón Singleton para");
        System.out.println("* gestionar un sistema de logging.");
        System.out.println("****************************************************");
    }
    public static void getIdentidad() {
        String nombreCompleto = "Joseph Rodriguez";
        String nombreCodificado = Base64.getEncoder().encodeToString(nombreCompleto.getBytes());

        System.out.println("\n🔐 Identidad codificada en Base64: " + nombreCodificado);
    }
}

