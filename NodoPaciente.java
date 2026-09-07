package pacientes;

/**
 * Nodo de la lista enlazada simple. Cada nodo guarda un {@link Paciente}
 * (el dato) y una referencia al siguiente nodo de la lista.
 * Esta es la unidad básica sobre la que se construye la estructura
 * "lista sencillamente encadenada" pedida en el enunciado.
 */
public class NodoPaciente {

    private Paciente dato;
    private NodoPaciente siguiente;

    public NodoPaciente(Paciente dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public Paciente getDato() {
        return dato;
    }

    public void setDato(Paciente dato) {
        this.dato = dato;
    }

    public NodoPaciente getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoPaciente siguiente) {
        this.siguiente = siguiente;
    }
}
