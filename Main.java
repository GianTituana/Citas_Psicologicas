// Clase abstracta
abstract class Cita {
    protected String fecha;
    protected String hora;
    protected String paciente;
    protected String psicologo;

    public Cita(String fecha, String hora, String paciente, String psicologo) {
        this.fecha = fecha;
        this.hora = hora;
        this.paciente = paciente;
        this.psicologo = psicologo;
    }

    public abstract String detalles();
}

// Subclase para citas en línea
class CitaEnLinea extends Cita {
    private String enlace; // Encapsulamiento

    public CitaEnLinea(String fecha, String hora, String paciente, String psicologo, String enlace) {
        super(fecha, hora, paciente, psicologo);
        this.enlace = enlace;
    }

    public String getEnlace() { // Método para acceder al enlace
        return enlace;
    }

    @Override
    public String detalles() {
        return "Cita en línea con " + psicologo + " el " + fecha + " a las " + hora + ". Enlace: " + enlace;
    }
}

// Subclase para citas presenciales
class CitaPresencial extends Cita {
    private String direccion;

    public CitaPresencial(String fecha, String hora, String paciente, String psicologo, String direccion) {
        super(fecha, hora, paciente, psicologo);
        this.direccion = direccion;
    }

    @Override
    public String detalles() {
        return "Cita presencial con " + psicologo + " el " + fecha + " a las " + hora + " en " + direccion + ".";
    }
}

// Main
public class Main {
    public static void main(String[] args) {
        Cita citaOnline = new CitaEnLinea("20/01/2025", "10:00", "Juan Pérez", "Dr. López", "https://zoom.com/abc123");
        Cita citaPresencial = new CitaPresencial("21/01/2025", "11:00", "Ana Torres", "Dra. Martínez", "Av. Central 123");
        
        System.out.println(citaOnline.detalles());
        System.out.println(citaPresencial.detalles());
    }
}
