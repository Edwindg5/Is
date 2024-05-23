package models;

public class Estudiante {
    private String nombre;
    private int matricula;
    private String estatus;

    public Estudiante(String nombre, int matricula, String estatus) {
        this.nombre = nombre;
        this.matricula = matricula;
        this.estatus = estatus;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }
}