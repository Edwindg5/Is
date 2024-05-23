package models;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ArbolBinario {
    Nodo raiz;

    public void agregarEstudiante(Estudiante estudiante) {
        if (raiz == null) {
            raiz = new Nodo(estudiante);
        } else {
            agregarRecursivo(raiz, estudiante);
        }
    }

    private void agregarRecursivo(Nodo actual, Estudiante estudiante) {
        if (estudiante.getMatricula() < actual.getDato().getMatricula()) {
            if (actual.getIzq() == null) {
                actual.setIzq(new Nodo(estudiante));
            } else {
                agregarRecursivo(actual.getIzq(), estudiante);
            }
        } else if (estudiante.getMatricula() > actual.getDato().getMatricula()) {
            if (actual.getDer() == null) {
                actual.setDer(new Nodo(estudiante));
            } else {
                agregarRecursivo(actual.getDer(), estudiante);
            }
        }
    }

    public void visualizarListaTutorados() {
        inorden(raiz);
    }

    private void inorden(Nodo nodo) {
        if (nodo != null) {
            inorden(nodo.getIzq());
            System.out.println("Nombre: " + nodo.getDato().getNombre() + ", Matrícula: " + nodo.getDato().getMatricula());
            inorden(nodo.getDer());
        }
    }

    public void visualizarEstadisticas() {
        Map<String, Integer> estadisticas = new HashMap<>();
        for (String estatus : new String[]{"activo", "inactivo", "baja definitiva", "baja académica", "baja temporal", "egresado", "titulado"}) {
            estadisticas.put(estatus, 0);
        }
        contarEstatus(raiz, estadisticas);
        for (String estatus : estadisticas.keySet()) {
            System.out.println(estatus + ": " + estadisticas.get(estatus));
        }
    }

    private void contarEstatus(Nodo nodo, Map<String, Integer> estadisticas) {
        if (nodo != null) {
            contarEstatus(nodo.getIzq(), estadisticas);
            String estatus = nodo.getDato().getEstatus();
            estadisticas.put(estatus, estadisticas.get(estatus) + 1);
            contarEstatus(nodo.getDer(), estadisticas);
        }
    }

    public void guardarInformacion(String archivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            guardarNodo(raiz, writer);
            writer.newLine();
            writer.write("Estadísticas:");
            writer.newLine();
            Map<String, Integer> estadisticas = new HashMap<>();
            for (String estatus : new String[]{"activo", "inactivo", "baja definitiva", "baja académica", "baja temporal", "egresado", "titulado"}) {
                estadisticas.put(estatus, 0);
            }
            contarEstatus(raiz, estadisticas);
            for (String estatus : estadisticas.keySet()) {
                writer.write(estatus + ": " + estadisticas.get(estatus));
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar la información: " + e.getMessage());
        }
    }

    private void guardarNodo(Nodo nodo, BufferedWriter writer) throws IOException {
        if (nodo != null) {
            writer.write(nodo.getDato().getNombre() + "," + nodo.getDato().getMatricula() + "," + nodo.getDato().getEstatus());
            writer.newLine();
            guardarNodo(nodo.getIzq(), writer);
            guardarNodo(nodo.getDer(), writer);
        }
    }
}
