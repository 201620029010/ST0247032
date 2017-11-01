package proyectofinal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Clase principal o clase main
 *
 * @author Mateo Marulanda Cifuentes
 * @author Yashua Alexander Narvaez
 */
public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        ArrayList<Posicion> pathCor = new ArrayList<Posicion>();
        Reader rd = new Reader();
        System.out.println("Escriba 1 si va leer de un archivo, cualquier otro número para leer el link");
        if (sc.nextInt() == 1) {

            HashMap nodos = rd.read();
            Builder bd = new Builder(nodos.size());
            double matrix[][] = bd.build(nodos, rd);
            int rmatrix[][] = new int[matrix.length][matrix.length];

            rmatrix = bd.rebuild(matrix);

            SalesMan sm = new SalesMan();
            String str = sm.minCost(rmatrix);
            System.out.println(str);

            str = str.replace("-", "");

            int[] arrayTemp = new int[str.length()];
            for (int i = 0; i < str.length(); i++) {
                arrayTemp[i] = Integer.parseInt(str.substring(i, i + 1));

            }
            bd.cordenatesTour(arrayTemp, rd, nodos);
            pathCor = bd.getPathCor();
            String cadenaUrl = "https://www.google.es/maps/dir/";
            for (int i = 0; i < pathCor.size(); i++) {
                cadenaUrl += pathCor.get(i).getPosY() + "," + pathCor.get(i).getPosX() + "/";

            }
            cadenaUrl += "@" + pathCor.get(0).getPosY() + "," + pathCor.get(0).getPosX();
            System.out.println(cadenaUrl);

        } else {
            HashMap nodos = rd.readLink("https://www.google.es/maps/dir/6.1521026,-75.6158273/6.1769038,-75.5853826/6.150728,-75.5312788/6.2007872,-75.5786226/6.236831,-75.5706288/6.1868153,-75.5914233/6.1742041,-75.3394911/6.2646443,-75.5684491/6.2541748,-75.4211777/@6.2402553,-75.6186275,11z/data=!3m1!4b1");
            Builder bd = new Builder(nodos.size());
            double matrix[][] = bd.build(nodos, rd);
            int rmatrix[][] = new int[matrix.length][matrix.length];

            rmatrix = bd.rebuild(matrix);

            SalesMan sm = new SalesMan();
            String str = sm.minCost(rmatrix);
            System.out.println(str);

            str = str.replace("-", "");

            int[] arrayTemp = new int[str.length()];
            for (int i = 0; i < str.length(); i++) {
                arrayTemp[i] = Integer.parseInt(str.substring(i, i + 1));

            }
            bd.cordenatesTour(arrayTemp, rd, nodos);
            pathCor = bd.getPathCor();
            String cadenaUrl = "https://www.google.es/maps/dir/";
            for (int i = 0; i < pathCor.size(); i++) {
                cadenaUrl += pathCor.get(i).getPosY() + "," + pathCor.get(i).getPosX() + "/";

            }
            cadenaUrl += "@" + pathCor.get(0).getPosY() + "," + pathCor.get(0).getPosX();
            System.out.println(cadenaUrl);
        }
    }
}
