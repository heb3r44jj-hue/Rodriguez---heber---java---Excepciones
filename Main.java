import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void validarUsuario(String nombre, int edad, String correo, double salario) throws NombreInvalidoExcepciones, EdadInvalidaExcepciones, CorreoInvalidoExcepciones, SalarioInvalidoExcepciones {
        if (nombre.isEmpty()) {
            throw new NombreInvalidoExcepciones("El nombre no puede estar vacío");
        }
        if (nombre.length() < 3) {
            throw new NombreInvalidoExcepciones("El nombre debe tener al menos 3 caracteres");
        }
        if (edad < 18) {
            throw new EdadInvalidaExcepciones("La edad debe ser mayor o igual a 18 años");
        }
        if (edad > 100) {
            throw new EdadInvalidaExcepciones("La edad debe ser menor o igual a 100 años");
        }
        if (!correo.contains("@") || !correo.contains(".")) {
            throw new CorreoInvalidoExcepciones("El correo electrónico no es válido");
        }
        if (salario <= 0) {
            throw new SalarioInvalidoExcepciones("El salario no puede ser negativo");
        }
    }
    
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int opcion = -1;

        do {
            System.out.println("=========================");
            System.out.println("  REGISTRO DE USUARIOS");
            System.out.println("=========================");
            System.out.println("1. Registrar usuario");
            System.out.println("2. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = scanner.nextInt();
                scanner.nextLine(); 
                if (opcion == 1) {

                    // Leer datos del usuario
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();

                    int edad = 0;
                    try {
                        System.out.print("Edad: ");
                        edad = scanner.nextInt();
                        scanner.nextLine();
                    } catch (InputMismatchException e) {
                        System.out.println("Error: Debe ingresar un número válido.");
                        scanner.nextLine(); // limpiar el buffer
                        continue;
                    }

                    System.out.print("Correo: ");
                    String correo = scanner.nextLine();

                    double salario = 0;
                    try {
                        System.out.print("Salario: ");
                        salario = scanner.nextDouble();
                        scanner.nextLine();
                    } catch (InputMismatchException e) {
                        System.out.println("Error: Debe ingresar un número válido.");
                        scanner.nextLine(); // limpiar el buffer
                        continue;
                    }

                    
                    try {
                        validarUsuario(nombre, edad, correo, salario);
                        System.out.println("Usuario registrado correctamente.");

                    } catch (NombreInvalidoExcepciones e) {
                        System.out.println("Error: " + e.getMessage());

                    } catch (EdadInvalidaExcepciones e) {
                        System.out.println("Error: " + e.getMessage());

                    } catch (CorreoInvalidoExcepciones e) {
                        System.out.println("Error: " + e.getMessage());

                    } catch (SalarioInvalidoExcepciones e) {
                        System.out.println("Error: " + e.getMessage());

                    } finally {
                        System.out.println("Proceso finalizado.");
                    }

                } else if (opcion == 2) {
                    System.out.println("Saliendo del sistema...");

                } else {
                    System.out.println("Opción no válida. Intente de nuevo.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un número válido.");
                scanner.nextLine();
            }

            System.out.println();

        } while (opcion != 2);

        scanner.close();
    }
}
