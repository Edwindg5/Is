package models;

class Nodo {
    private Estudiante dato;
    private Nodo izq;
    private Nodo der;

    public Nodo(Estudiante dato) {
        this.dato = dato;
    }

    public Nodo() {
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

    public void setDato(Estudiante dato) {
        this.dato = dato;
    }

    public void setIzq(Nodo nodo) {
        izq = nodo;
    }

    public void setDer(Nodo nodo) {
        der = nodo;
    }
}
