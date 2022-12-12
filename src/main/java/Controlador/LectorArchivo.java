package Controlador;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Lee datos de un archivo de texto plano,
 * donde cada línea tiene información de una entidad
 *  (separadas por coma).
 */
public class LectorArchivo{
    private String nombreArchivo;

    public LectorArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }


    public List<String[]> obtenerDatosBase() throws IOException {
        List<String[]> datosArchivo = new ArrayList<>();

        Path rutaArchivo = Paths.get(nombreArchivo);
        try (BufferedReader lector = Files.newBufferedReader(rutaArchivo)) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                String[] datosLinea = linea.split(",");
                datosArchivo.add(datosLinea);
            }
        }
        return datosArchivo;
    }
}