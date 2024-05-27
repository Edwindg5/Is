package models;
public class Nodo {
    private Estudiante dato;
    private Nodo izq;
    private Nodo der;

    public Nodo(Estudiante dato) {
        this.dato = dato;
    }

    public Nodo getIzq() {
        return izq;
    }

    public Nodo getDer() {
        return der;
    }

    public Estudiante getDato() {
        return dato;
    }

    public void setIzq(Nodo izq) {
        this.izq = izq;
    }

    public void setDer(Nodo der) {
        this.der = der;
    }
}
