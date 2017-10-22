
package laboratory05;

import java.util.Arrays;
import java.util.ArrayList;

public class LCS {
    /**
     * Encuentra la subsecuencia común más larga
     * @param a
     * @param b
    **/
    public static String lcs(String a, String b) {
        int[][] tams = new int[a.length() + 1][b.length() + 1];

        //fila 0 y columna 0 ya estan inicializadas en 0
        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < b.length(); j++) {
                if (a.charAt(i) == b.charAt(j)) {
                    tams[i + 1][j + 1] = tams[i][j] + 1;
                } else {
                    tams[i + 1][j + 1] = Math.max(tams[i + 1][j], tams[i][j + 1]);
                }
            }
        }

        // leer la subcadena afuera desde la matriz
        StringBuffer sb = new StringBuffer();
        for (int x = a.length(), y = b.length();
                x != 0 && y != 0;) {
            if (tams[x][y] == tams[x - 1][y]) {
                x--;
            } else if (tams[x][y] == tams[x][y - 1]) {
                y--;
            } else {
                assert a.charAt(x - 1) == b.charAt(y - 1);
                sb.append(a.charAt(x - 1));
                x--;
                y--;
            }
        }
        

        return sb.reverse().toString();
    }
    
    public static void main(String[] args) {
        System.out.println(lcs("AXYT", "AYZX"));
    }

}
