package proyectofinal;

import java.io.IOException;
import java.util.HashMap;

/**
 * Clase principal o clase main
 *
 * @author Mateo Marulanda Cifuentes
 * @author Yashua Alexander Narvaez
 */
public class Main {

    public static void main(String[] args) throws IOException {
        Reader rd = new Reader();
        HashMap nodos = rd.read();
        Builder bd = new Builder(nodos.size());
        double matrix[][] = bd.build(nodos, rd);
        int rmatrix[][] = new int[matrix.length][matrix.length];
        rmatrix = bd.rebuild(matrix);
        for (int i = 0; i < rmatrix.length; i++) {
            for (int j = 0; j < rmatrix.length; j++) {
                System.out.print(rmatrix[i][j] + " ");
            }
            System.out.println("");
        }
        SalesMan sm = new SalesMan();
        System.out.println("funciona");
        System.out.println(sm.minCost(rmatrix));

    }
}
