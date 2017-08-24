package taller03;
import java.util.ArrayList;

/**
 * Clase en la cual se implementan los metodos del Taller de Clase #2
 *
 * @author Mauricio Toro, Mateo Agudelo
 */
public class Taller2 {

    public static boolean sumaGrupo(int start, int[] nums, int target) {
        if (target == 0) {
            return true;
        } else if (start > nums.length) {
            return false;
        } else {
            return sumaGrupo(start + 1, nums, target - nums[start]) || sumaGrupo(start + 1, nums, target);
        }
    }

    public static ArrayList<String> permutation(String s) {
        ArrayList<String> list = new ArrayList<String>();
        combinations("", s, list);
        return list;

    }

    // recomendacion
    private static void combinations(String pre, String pos, ArrayList<String> list) {
        int n = pos.length();
        if (n == 0) {
            list.add(pre);
        } else {
            for (int i = 0; i < n; i++) {
                combinations(pre + pos.charAt(i), pos.substring(0, i) + pos.substring(i + 1, n), list);

            }
        }
    }

    // recomendacion
    public static void main(String[] args) {

        ArrayList<String> list = permutation("abc");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

    }

    public static void imprimirTablero(int[] tablero) {
        int n = tablero.length;
        System.out.print("    ");
        for (int i = 0; i < n; ++i) {
            System.out.print(i + " ");
        }
        System.out.println("\n");
        for (int i = 0; i < n; ++i) {
            System.out.print(i + "   ");
            for (int j = 0; j < n; ++j) {
                System.out.print((tablero[i] == j ? "Q" : "#") + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static boolean esValido(int[] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                if (tablero[i] == j || Math.abs(i - tablero.length) == Math.abs(j - tablero[i])) {
                    return false;
                }

            }

        }
        return true;
    }

    public static int queens(int n) {
        int c;
        int cont = 0;
        if(c == n) {
            return 0;
        } else {
            
        }
    }
    
    public static void columnas(int c) {
        
    }

}

