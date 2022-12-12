package Entidades;

public class Vuelo {
    private String origen;
    private String destino;

    /*Los tipos son escalar o directo*/
    private String tipo;

    /*suma de la duración de todas las rutas*/

    private int duraciontotal;

    /*suma del precio de todas las rutas*/

    private double preciototal;


    public Vuelo(String origen, String destino, int duraciontotal, double preciototal, String tipo) {
        this.origen = origen;
        this.destino = destino;
        this.duraciontotal = duraciontotal;
        this.preciototal = preciototal;
        this.tipo=tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPreciototal() {
        return preciototal;
    }

    public int getDuraciontotal(){
        return duraciontotal;
    }
}


