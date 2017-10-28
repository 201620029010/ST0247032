package proyectofinal;

import java.util.HashMap;

/**
 * Clase que se encarga de construir la matriz con las distancias
 *
 * @author Mateo Marulanda Cifuentes
 * @author Yashua Alexander Narvaez Pulgarin
 */
public class Builder {

    private int matrix[][];

    /**
     * Constructor de la clase Builder
     *
     * @param x longitud de la matriz que se crea
     */
    public Builder(int x) {
        matrix = new int[x][x];
    }

    /**
     * Metodo que se encarga de construir la matriz usando la API de Google Maps
     *
     * @param nodos HashMap con la clave y el valor
     * @return Regresa la matriz ya construida
     */
    public int[][] build(HashMap<Integer, Posicion> nodos) {
        return matrix;
    }
}
