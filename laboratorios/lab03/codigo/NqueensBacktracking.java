package laboratory3;

import java.util.Arrays;

public class NqueensBacktracking {

    static int result[];
    /**
     * @param x2
     * @param y2
     * @return True si  una reina puede ser colocada en la fila x2 y columna y2
     **/
    public static boolean esSeguro(int x2, int y2) {
 
        for (int i = 0; i < x2; i++) {

            if ((result[i] == y2)
                    || (Math.abs(i - x2) == Math.abs(result[i] - y2))) {
                return false;
            }
        }
        return true;
    }
      /**
     * @param x
     * @param size
     * Usando BackTracking  este metodo imprime todas las posibles combinaciones de n reinas donde no se ataquen
     **/
    public static void placeQueens(int x, int size) {
        for (int i = 0; i < size; i++) {

            if (esSeguro(x, i)) {
                result[x] = i;
                if (x == size - 1) {
                    System.out.println("Orden de " + size + " Reinas"
                            + Arrays.toString(result));
                }
                placeQueens(x + 1, size);
            }
        }
    }

    public static void main(String[] args) {
        int n = 4;
        result = new int[n];
        placeQueens(0, n);
    }

}
