package Entidades;

public class Ruta {
    private String origen;
    private String destino;
    private int duracion;
    private double precio;


    public Ruta(String origen, String destino, int duracion, double precio) {
        this.origen = origen;
        this.destino = destino;
        this.duracion = duracion;
        this.precio = precio;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public int getDuracion() {
        return duracion;
    }

    public double getPrecio() {
        return precio;
    }
}
