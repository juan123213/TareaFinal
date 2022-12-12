package Controlador;

import Entidades.Ruta;
import Entidades.Vuelo;

import java.util.ArrayList;
import java.util.List;

public class ControlVuelo {
    /* Lista de rutas disponibles */
    List<Ruta> rutas = new ArrayList<>();

    /* Lista de vuelos que están disponibles según la búsqueda del usuario */
    List<Ruta> vuelos = new ArrayList<>();

    public ControlVuelo() {
    }

    /* se encarga de llenar la lista de rutas  */
    public void cargarVuelo(){
        Ruta ruta1= new Ruta("manizales","medellin",8,20.000);
        Ruta ruta2= new Ruta("medellin","bogota",8,20.000);
        rutas.add(ruta1);
        rutas.add(ruta2);

    }


    /* recorre la lista para ver que destinos puede usar el usuario */
    public void filtrar(String origen, String destino) throws Exception{
        /* Lista de rutas que le pueden servir al usuario */
        List<Ruta> posibles = new ArrayList<>();
        for (int i = 0; i < rutas.size(); i++) {
            /* recorre la lista de todas las rutas y crea una instancia de estas para ver su información */
            Ruta ruta1= rutas.get(i);
            if(ruta1.getOrigen()==origen){
                /* si el origen de la ruta es igual al ingresado por el usuario entra */
                if(ruta1.getDestino()==destino){
                    /* Si el destino de la ruta es igual al ingresado quiere decir que
                    * hay un viaje directo para el vuelo y lo añade*/
                    posibles.add(ruta1);
                }else{
                    /* si no hay un vuelo directo busca un vuelo escalar buscando que el destino
                    * de las rutas que comparten el origen ingresado ahora sean origen de esta ruta */
                    for(int j=0; j<rutas.size();j++){
                        Ruta ruta2=rutas.get(j);
                        if(ruta1.getDestino()==ruta2.getOrigen() && ruta2.getDestino()==destino){
                            /*si encuentra una ruta y además su destino es el destino ingresado
                            quiere decir que nos sirve como un viaje escalar y lo añade
                             */
                            posibles.add(ruta1);
                            posibles.add(ruta2);

                        }
                    }
                }
            }
        }
        if(posibles.isEmpty()){
            /* si no hay vuelos posbiles devuelve una excepción diciendo que el viaje no se puede realizar
            * debido a que no hay una ruta válida */
            throw new Exception("No hay un vuelo posible");
        }
        vuelos=posibles;
    }

    public String esEscalar(List<Ruta> datos){
        /* si la longitud del vuelo es mayor a 1 quiere decir que es escalar */
        if (datos.size()==1){
            return "Directo";
        }
        return "Escalar";
    }

    public int calcularDuracion(List<Ruta> datos){
        /* recorre la lista de vuelos sumando el precio de cada una para obtener el precio total */
        int total=0;
        for (int i = 0; i < datos.size(); i++) {
            Ruta data=datos.get(i);
            total=total+data.getDuracion();
        }
        return total;
    }

    public double calcularPrecio(List<Ruta> datos){
        /* recorre la lista de vuelos sumando la duración de cada una para obtener la duración total */
        double total=0;
        for (int i = 0; i < datos.size(); i++) {
            Ruta data=datos.get(i);
            total=total+data.getPrecio();
        }
        return total;
    }

    public Vuelo calcularVuelo(String origen, String destino) throws Exception{
        /* Función que carga las rutas, las filtra y luego crea un vuelo para el usuario*/
        cargarVuelo();
        filtrar(origen,destino);
        Vuelo vuelo1=new Vuelo(origen,destino,calcularDuracion(vuelos),calcularPrecio(vuelos),esEscalar(vuelos));
        return vuelo1;
    }

}