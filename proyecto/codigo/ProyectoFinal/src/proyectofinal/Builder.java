package proyectofinal;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Clase que se encarga de construir la matriz con las distancias
 *
 * @author Mateo Marulanda Cifuentes
 * @author Yashua Alexander Narvaez Pulgarin
 */
public class Builder {

    private double matrix[][];
    private double x1;
    private double y1;
    private double x2;
    private double y2;

    /**
     * Constructor de la clase Builder
     *
     * @param x longitud de la matriz que se crea
     */
    public Builder(int x) {
        matrix = new double[x][x];
    }

    /**
     * Metodo que se encarga de construir la matriz usando la API de Google Maps
     *
     * @param nodos HashMap con la clave y el valor
     * @param rd objeto de la clase Reader
     * @return Regresa la matriz ya construida
     */
    public double[][] build(HashMap<Integer, Posicion> nodos, Reader rd) {

        ArrayList<Integer> keys = rd.getKeys();
        int cont = 0;

        while (cont < nodos.size()) {
            x1 = nodos.get(keys.get(cont)).getPosX();
            y1 = nodos.get(keys.get(cont)).getPosY();

            for (int i = 0; i < nodos.size(); i++) {
                for (int j = i + 1; j < nodos.size(); j++) {
                    x2 = nodos.get(keys.get(j)).getPosX(); //capturo la posicion al inicio de la fila para comparar con todo
                    y2 = nodos.get(keys.get(j)).getPosY();
                    
                    /*double x = Math.pow((x2 - x1), 2);
                    double y = Math.pow((y2-y1),2);
                    double distancia = Math.sqrt(x+y);*/
                    matrix[i][j] = 1;
                }
            }
            cont++;
        }
        return matrix;
    }
}
