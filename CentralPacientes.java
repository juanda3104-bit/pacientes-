package pacientes;

import java.util.Scanner;

/**
 * Clase principal: expone un menú de consola para registrar, buscar,
 * eliminar y listar pacientes, delegando toda la gestión de datos a
 * {@link ListaPacientes}.
 */
public class CentralPacientes {

    private static final ListaPacientes listaPacientes = new ListaPacientes();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Seleccione una opción: ");

            switch (opcion) {
                case 1 -> registrarPaciente();
                case 2 -> buscarPaciente();
                case 3 -> eliminarPaciente();
                case 4 -> listaPacientes.mostrarPacientes();
                case 0 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción no válida. Intente de nuevo.");
            }
            System.out.println();

        } while (opcion != 0);

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("======= CENTRAL DE PACIENTES =======");
        System.out.println("1. Registrar paciente");
        System.out.println("2. Buscar paciente por ID");
        System.out.println("3. Eliminar paciente por ID");
        System.out.println("4. Listar todos los pacientes");
        System.out.println("0. Salir");
    }

    private static void registrarPaciente() {
        int id = leerEntero("ID del paciente: ");

        if (listaPacientes.buscarPorId(id) != null) {
            System.out.println("Ya existe un paciente registrado con ese ID.");
            return;
        }

        System.out.print("Nombre del paciente: ");
        String nombre = scanner.nextLine();
        int edad = leerEntero("Edad del paciente: ");
        System.out.print("Clínica de atención: ");
        String clinica = scanner.nextLine();

        Paciente paciente = new Paciente(id, nombre, edad, clinica);
        listaPacientes.agregarPaciente(paciente);
        System.out.println("Paciente registrado con éxito.");
    }

    private static void buscarPaciente() {
        int id = leerEntero("Ingrese el ID a buscar: ");
        Paciente paciente = listaPacientes.buscarPorId(id);

        if (paciente != null) {
            System.out.println("Paciente encontrado:");
            System.out.println(paciente);
        } else {
            System.out.println("No se encontró ningún paciente con ese ID.");
        }
    }

    private static void eliminarPaciente() {
        int id = leerEntero("Ingrese el ID del paciente a eliminar: ");
        boolean eliminado = listaPacientes.eliminarPorId(id);
        System.out.println(eliminado
                ? "Paciente eliminado con éxito."
                : "No se encontró ningún paciente con ese ID.");
    }

    /**
     * Lee un entero de consola validando la entrada para evitar que el
     * programa se caiga si el usuario escribe texto no numérico.
     */
    private static int leerEntero(String mensaje) {
        int valor;
        while (true) {
            try {
                System.out.print(mensaje);
                valor = Integer.parseInt(scanner.nextLine().trim());
                return valor;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Ingrese un número entero.");
            }
        }
    }
}
