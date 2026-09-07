package pacientes;

/**
 * Representa a un paciente atendido en alguna de las clínicas de la ciudad.
 * Es una clase de datos (POJO): no conoce nada sobre listas ni nodos,
 * solo almacena la información propia de un paciente.
 */
public class Paciente {

    private final int id;
    private String nombre;
    private int edad;
    private String clinica;

    public Paciente(int id, String nombre, int edad, String clinica) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.clinica = clinica;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getClinica() {
        return clinica;
    }

    public void setClinica(String clinica) {
        this.clinica = clinica;
    }

    @Override
    public String toString() {
        return String.format("ID: %-5d | Nombre: %-20s | Edad: %-3d | Clínica: %s",
                id, nombre, edad, clinica);
    }
}
