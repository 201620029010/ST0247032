package proyectofinal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


/**
 * Clase principal o clase main
 *
 * @author Mateo Marulanda Cifuentes
 * @author Yashua Alexander Narvaez
 */
public class Main {

    public static void main(String[] args) throws IOException {
        ArrayList<Posicion> pathCor = new ArrayList<Posicion>();
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
        String str = sm.minCost(rmatrix);
        System.out.println(str);

        str = str.replace("-", "");
        
        int[] arrayTemp = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            arrayTemp[i] = Integer.parseInt(str.substring(i, i + 1));
            System.out.print(arrayTemp[i] + " ");
        }
        System.out.println("");
        bd.cordenatesTour(arrayTemp, rd, nodos);
        pathCor = bd.getPathCor();
        String cadenaUrl = "https://www.google.es/maps/dir/";
        for (int i = 0; i < pathCor.size(); i++) {
            cadenaUrl+= pathCor.get(i).getPosY() + ","+pathCor.get(i).getPosX()+"/";
            
        }
        cadenaUrl += "@"+pathCor.get(0).getPosY() + "," +pathCor.get(0).getPosX();
        System.out.println(cadenaUrl);
        
        

    }
}
