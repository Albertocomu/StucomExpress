package model;

public class ListaEnvios {
    private String nombre;
    private int envios;

    public ListaEnvios() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEnvios() {
        return envios;
    }

    public void setEnvios(int envios) {
        this.envios = envios;
    }

    @Override
    public String toString() {
        return "ListaEnvios:" +
                "Nombre= '" + nombre + '\'' +
                ", Nº Envios= " + envios +
                '}';
    }
}