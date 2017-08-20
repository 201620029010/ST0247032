package Taller3;
import java.util.ArrayList;

/**
 * Clase en la cual se implementan los metodos del Taller de Clase #2
 * 
 * @author Mauricio Toro, Mateo Agudelo
 */
public class Taller2 {

	public static boolean sumaGrupo(int start, int[] nums, int target) {
            if(target == 0){
                return true;
            } else if (start > nums.length){
                return false;
            }else {
                return sumaGrupo(start+1,nums,target-nums[start])||sumaGrupo(start+1,nums,target);
            }
	}

	public static ArrayList<String> combinations(String s) {
		return null;
	}

	// recomendacion
	private static void combinations(String pre, String pos, ArrayList<String> list) {
		// complete...
	}

	public static ArrayList<String> permutations(String s) {
		return null;
	}

	// recomendacion
	private static void permutations(String pre, String pos, ArrayList<String> list) {
		// complete...
	}

	public static void imprimirTablero(int[] tablero) {
		int n = tablero.length;
		System.out.print("    ");
		for (int i = 0; i < n; ++i)
			System.out.print(i + " ");
		System.out.println("\n");
		for (int i = 0; i < n; ++i) {
			System.out.print(i + "   ");
			for (int j = 0; j < n; ++j)
				System.out.print((tablero[i] == j ? "Q" : "#") + " ");
			System.out.println();
		}
		System.out.println();
	}

	public static boolean esValido(int[] tablero) {
		return false;
	}

	public static int queens(int n) {
		return 0;
	}

}
