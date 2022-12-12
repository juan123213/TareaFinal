import static org.junit.jupiter.api.Assertions.*;

import Controlador.ControlVuelo;
import Entidades.Vuelo;
import org.junit.jupiter.api.Test;

class ControlVueloTest {
    @Test
    void tipoIncorrecto()  {
        ControlVuelo c1 = new ControlVuelo();
        assertThrows(Exception.class,
                ()-> c1.calcularVuelo("mawaniki","macondo"));
    }


    @Test
    void precioValidoDirecto() throws Exception {
        ControlVuelo c1 = new ControlVuelo();
        Vuelo v1= new Vuelo("manizales","medellin",8,20.000,"Directo");
        assertEquals(v1.getPreciototal(),c1.calcularVuelo("manizales","medellin").getPreciototal());
    }
    @Test
    void tipoValidoDirecto() throws Exception {
        ControlVuelo c1 = new ControlVuelo();
        assertEquals("Directo",c1.calcularVuelo("manizales","medellin").getTipo());
    }
    @Test
    void tipoValidoEscalar() throws Exception {
        ControlVuelo c1 = new ControlVuelo();
        assertEquals("Escalar",c1.calcularVuelo("manizales","bogota").getTipo());
    }
    @Test
    void precioValidoESCALAR() throws Exception {
        ControlVuelo c1 = new ControlVuelo();
        Vuelo v1= new Vuelo("manizales","bogota",16,40.000,"Escalar");
        assertEquals(v1.getPreciototal(),c1.calcularVuelo("manizales","bogota").getPreciototal());
    }
    @Test
    void duracionValidaESCALAR() throws Exception {
        ControlVuelo c1 = new ControlVuelo();
        Vuelo v1= new Vuelo("manizales","bogota",16,40.000,"Escalar");
        assertEquals(v1.getDuraciontotal(),c1.calcularVuelo("manizales","bogota").getDuraciontotal());
    }

    @Test
    void tipoIncorrectoFiltro()  {
        ControlVuelo c1 = new ControlVuelo();
        assertThrows(Exception.class,
                ()-> c1.filtrar("macondo","tolemaida"));
    }
    @Test
    void FuncioneFiltro() throws Exception {
        /* se envía */
        ControlVuelo c1 = new ControlVuelo();
        c1.cargarVuelo();
        assertDoesNotThrow(()->c1.filtrar("manizales","medellin"));
    }

}