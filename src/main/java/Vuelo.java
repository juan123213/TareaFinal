public class Vuelo {
    private String origen;
    private String destino;
    private String tipo;

    private int duraciontotal;
    private double preciototal;


    public Vuelo(String origen, String destino, int duraciontotal, double preciototal,String tipo) {
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


