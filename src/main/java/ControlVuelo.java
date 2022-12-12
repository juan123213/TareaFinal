import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ControlVuelo {
    List<Ruta> rutas = new ArrayList<>();
    List<Ruta> vuelos = new ArrayList<>();

    public ControlVuelo() {
    }

    public void cargarVuelo(){
        Ruta ruta1= new Ruta("manizales","medellin",8,20.000);
        Ruta ruta2= new Ruta("medellin","bogota",8,20.000);
        rutas.add(ruta1);
        rutas.add(ruta2);

    }



    public void filtrar(String origen, String destino) throws Exception{
        List<Ruta> posibles = new ArrayList<>();
        for (int i = 0; i < rutas.size(); i++) {

            Ruta ruta1= rutas.get(i);
            if(ruta1.getOrigen()==origen){
                if(ruta1.getDestino()==destino){
                    posibles.add(ruta1);
                }else{
                    for(int j=0; j<rutas.size();j++){
                        Ruta ruta2=rutas.get(j);
                        if(ruta1.getDestino()==ruta2.getOrigen() && ruta2.getDestino()==destino){
                            posibles.add(ruta1);
                            posibles.add(ruta2);

                        }
                    }
                }
            }
        }
        if(posibles.isEmpty()){
            throw new Exception("No hay un vuelo posible");
        }
        vuelos=posibles;
    }

    public String esEscalar(List<Ruta> datos){
        if (datos.size()==1){
            return "Directo";
        }
        return "Escalar";
    }

    public int calcularDuracion(List<Ruta> datos){
        int total=0;
        for (int i = 0; i < datos.size(); i++) {
            Ruta data=datos.get(i);
            total=total+data.getDuracion();
        }
        return total;
    }

    public double calcularPrecio(List<Ruta> datos){
        double total=0;
        for (int i = 0; i < datos.size(); i++) {
            Ruta data=datos.get(i);
            total=total+data.getPrecio();
        }
        return total;
    }

    public Vuelo calcularVuelo(String origen, String destino) throws Exception{
        cargarVuelo();
        filtrar(origen,destino);
        Vuelo vuelo1=new Vuelo(origen,destino,calcularDuracion(vuelos),calcularPrecio(vuelos),esEscalar(vuelos));
        return vuelo1;
    }

}