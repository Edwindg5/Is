import models.ArbolBinario;
import models.Estudiante;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();
        Scanner entrada = new Scanner(System.in);
        int opc;

        do {
            System.out.println("1. Agregar estudiante");
            System.out.println("2. Visualizar lista de tutorados");
            System.out.println("3. Visualizar estadísticas");
            System.out.println("4. Guardar información y salir");
            System.out.print("Seleccione una opción: ");
            opc = entrada.nextInt();
            entrada.nextLine();  // Limpiar el buffer

            switch (opc) {
                case 1:
                    System.out.print("Nombre del estudiante: ");
                    String nombre = entrada.nextLine();
                    int matricula = 0;
                    boolean matriculaValida = false;
                    while (!matriculaValida) {
                        System.out.print("Matrícula del estudiante: ");
                        if (entrada.hasNextInt()) {
                            matricula = entrada.nextInt();
                            entrada.nextLine();  // Limpiar el buffer
                            if (arbol.esMatriculaValida(matricula)) {
                                matriculaValida = true;
                            } else {
                                System.out.println("Matrícula inválida o ya existente. Intente nuevamente.");
                            }
                        } else {
                            System.out.println("Por favor, ingrese un número válido.");
                            entrada.nextLine();  // Limpiar el buffer
                        }
                    }
                    System.out.print("Estatus del estudiante: ");
                    String estatus = entrada.nextLine();
                    arbol.agregarEstudiante(new Estudiante(nombre, matricula, estatus));
                    break;
                case 2:
                    System.out.println("Lista de tutorados:");
                    arbol.visualizarListaTutorados();
                    break;
                case 3:
                    System.out.println("Estadísticas:");
                    arbol.visualizarEstadisticas();
                    break;
                case 4:
                    System.out.println("Guardando información y saliendo...");
                    arbol.guardarInformacion("estudiantes.txt");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (opc != 4);

        entrada.close();
    }
}