package pacientes;

/**
 * Lista sencillamente encadenada (singly linked list) que administra los
 * pacientes registrados en el sistema. No usa ninguna colección de la
 * librería estándar de Java (ArrayList, LinkedList, etc.): la estructura
 * se construye manualmente encadenando objetos {@link NodoPaciente}.
 *
 * Complejidades (n = número de pacientes almacenados):
 *  - agregarPaciente: O(n)  -> se recorre hasta el final para insertar
 *  - buscarPorId:     O(n)  -> en el peor caso se recorre toda la lista
 *  - eliminarPorId:   O(n)  -> en el peor caso se recorre toda la lista
 *  - mostrarPacientes:O(n)  -> se recorre toda la lista una vez
 */
public class ListaPacientes {

    private NodoPaciente cabeza;
    private int tamano;

    public ListaPacientes() {
        this.cabeza = null;
        this.tamano = 0;
    }

    public boolean estaVacia() {
        return cabeza == null;
    }

    public int getTamano() {
        return tamano;
    }

    /**
     * Agrega un paciente al final de la lista.
     */
    public void agregarPaciente(Paciente paciente) {
        NodoPaciente nuevo = new NodoPaciente(paciente);

        if (estaVacia()) {
            cabeza = nuevo;
        } else {
            NodoPaciente actual = cabeza;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevo);
        }
        tamano++;
    }

    /**
     * Busca un paciente por su identificador único.
     * @return el paciente si existe, o null si no se encuentra.
     */
    public Paciente buscarPorId(int id) {
        NodoPaciente actual = cabeza;
        while (actual != null) {
            if (actual.getDato().getId() == id) {
                return actual.getDato();
            }
            actual = actual.getSiguiente();
        }
        return null;
    }

    /**
     * Elimina el paciente que tenga el id indicado.
     * @return true si se eliminó un paciente, false si no existía.
     */
    public boolean eliminarPorId(int id) {
        if (estaVacia()) {
            return false;
        }

        // Caso especial: el paciente a eliminar es la cabeza de la lista.
        if (cabeza.getDato().getId() == id) {
            cabeza = cabeza.getSiguiente();
            tamano--;
            return true;
        }

        NodoPaciente anterior = cabeza;
        NodoPaciente actual = cabeza.getSiguiente();
        while (actual != null) {
            if (actual.getDato().getId() == id) {
                anterior.setSiguiente(actual.getSiguiente());
                tamano--;
                return true;
            }
            anterior = actual;
            actual = actual.getSiguiente();
        }
        return false;
    }

    /**
     * Imprime en consola la información de todos los pacientes registrados.
     */
    public void mostrarPacientes() {
        if (estaVacia()) {
            System.out.println("No hay pacientes registrados.");
            return;
        }

        System.out.println("----- Lista de pacientes (" + tamano + ") -----");
        NodoPaciente actual = cabeza;
        while (actual != null) {
            System.out.println(actual.getDato());
            actual = actual.getSiguiente();
        }
    }
}
