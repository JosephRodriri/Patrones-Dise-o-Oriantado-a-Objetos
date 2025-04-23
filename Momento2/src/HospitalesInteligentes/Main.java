package HospitalesInteligentes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

interface HistorialMedicoPrototype extends Cloneable {
    HistorialMedicoPrototype clonar() throws CloneNotSupportedException;
    void agregarDescripcionConsulta(String descripcion);
    void mostrarDetallesHistorial();
}

class HistorialMedico implements HistorialMedicoPrototype {
    private static final Logger LOGGER = Logger.getLogger(HistorialMedico.class.getName());
    private String idPaciente;
    private String nombrePaciente;
    private List<String> descripcionesConsultas;
    private Date fechaCreacion;
    private Date ultimaActualizacion;

    public HistorialMedico(String idPaciente, String nombrePaciente) {
        this.idPaciente = idPaciente;
        this.nombrePaciente = nombrePaciente;
        this.descripcionesConsultas = new ArrayList<>();
        this.fechaCreacion = new Date();
        this.ultimaActualizacion = new Date();
        LOGGER.log(Level.INFO, "Historial médico creado para el paciente: {0} (ID: {1})", new Object[]{nombrePaciente, idPaciente});
    }

    @Override
    public HistorialMedicoPrototype clonar() throws CloneNotSupportedException {
        HistorialMedico clon = (HistorialMedico) super.clone();
        clon.descripcionesConsultas = new ArrayList<>(this.descripcionesConsultas);
        clon.fechaCreacion = (Date) this.fechaCreacion.clone();
        clon.ultimaActualizacion = new Date();
        LOGGER.log(Level.INFO, "Historial médico clonado para el paciente: {0} (ID: {1})", new Object[]{nombrePaciente, idPaciente});
        return clon;
    }

    @Override
    public void agregarDescripcionConsulta(String descripcion) {
        this.descripcionesConsultas.add(descripcion);
        this.ultimaActualizacion = new Date();
        LOGGER.log(Level.INFO, "Se agregó una nueva consulta al historial del paciente {0} (ID: {1}): {2}", new Object[]{nombrePaciente, idPaciente, descripcion});
    }

    @Override
    public void mostrarDetallesHistorial() {
        System.out.println("\n--- Detalles del Historial Médico ---");
        System.out.println("Paciente: " + nombrePaciente);
        System.out.println("ID del Paciente: " + idPaciente);
        System.out.println("Fecha de Creación: " + fechaCreacion);
        System.out.println("Última Actualización: " + ultimaActualizacion);
        System.out.println("Descripciones de las Consultas:");
        if (descripcionesConsultas.isEmpty()) {
            System.out.println("- No hay consultas registradas.");
        } else {
            for (int i = 0; i < descripcionesConsultas.size(); i++) {
                System.out.println("- [" + (i + 1) + "] " + descripcionesConsultas.get(i));
            }
        }
    }

    public String getIdPaciente() {
        return idPaciente;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public List<String> getDescripcionesConsultas() {
        return new ArrayList<>(descripcionesConsultas);
    }
}

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        try {
            HistorialMedico historialOriginal = new HistorialMedico("P12345", "Juan Pérez");
            historialOriginal.agregarDescripcionConsulta("Consulta inicial - presión arterial 120/80 mmHg, frecuencia cardíaca 75 lpm.");
            historialOriginal.agregarDescripcionConsulta("Se confirma alergia a la penicilina según el relato del paciente.");

            System.out.println("Historial Original:");
            historialOriginal.mostrarDetallesHistorial();

            HistorialMedico historialClonado = (HistorialMedico) historialOriginal.clonar();
            historialClonado.agregarDescripcionConsulta("Segunda consulta - se prescribe antihistamínico loratadina 10mg por 7 días.");

            System.out.println("\nHistorial Clonado Modificado:");
            historialClonado.mostrarDetallesHistorial();

            System.out.println("\nHistorial Original (para verificar la independencia):");
            historialOriginal.mostrarDetallesHistorial();

            HistorialMedico historialParaEspecialista = (HistorialMedico) historialOriginal.clonar();
            historialParaEspecialista.agregarDescripcionConsulta("Se deriva a cardiología para una evaluación adicional debido a un soplo cardíaco detectado.");

            System.out.println("\nHistorial para el Especialista:");
            historialParaEspecialista.mostrarDetallesHistorial();

        } catch (CloneNotSupportedException e) {
            LOGGER.log(Level.SEVERE, "Error al clonar el historial médico", e);
            System.err.println("Ocurrió un error al intentar clonar el historial médico.");
        }
    }
}