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
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opc = entrada.nextInt();
            entrada.nextLine();  // Limpiar el buffer

            switch (opc) {
                case 1:
                    System.out.print("Nombre del estudiante: ");
                    String nombre = entrada.nextLine();
                    System.out.print("Matrícula del estudiante: ");
                    int matricula = entrada.nextInt();
                    entrada.nextLine();  // Limpiar el buffer
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