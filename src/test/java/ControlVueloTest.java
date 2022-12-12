import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ControlVUeloTest {
    @Test
    void tipoIncorrecto()  {
        ControlVuelo c1 = new ControlVuelo();
        assertThrows(Exception.class,
                ()-> c1.calcularVuelo("manizales","macondo"));
    }

    @Test
    void vueloValido() throws Exception {
        ControlVuelo c1 = new ControlVuelo();
        Vuelo v1= new Vuelo("manizales","medellin",8,20.000,"Directo");
        assertEquals(v1.getDuraciontotal(),c1.calcularVuelo("manizales","medellin").getDuraciontotal());
    }
    @Test
    void precioValido() throws Exception {
        ControlVuelo c1 = new ControlVuelo();
        Vuelo v1= new Vuelo("manizales","medellin",8,20.000,"Directo");
        assertEquals(v1.getPreciototal(),c1.calcularVuelo("manizales","medellin").getPreciototal());
    }
    @Test
    void tipoValido() throws Exception {
        ControlVuelo c1 = new ControlVuelo();
        Vuelo v1= new Vuelo("manizales","medellin",8,20.000,"Directo");
        assertEquals(v1.getTipo(),c1.calcularVuelo("manizales","medellin").getTipo());
    }
    @Test
    void tipoValidoEscalar() throws Exception {
        ControlVuelo c1 = new ControlVuelo();
        Vuelo v1= new Vuelo("manizales","bogota",16,40.000,"Directo");
        assertEquals(v1.getPreciototal(),c1.calcularVuelo("manizales","bogota").getPreciototal());
    }
}