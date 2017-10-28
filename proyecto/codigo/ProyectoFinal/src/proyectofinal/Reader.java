package proyectofinal;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Yeshúa
 */
public class Reader {
    
    /**
     * @return retorna un hash map con los nodos y las coordenadas
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public static HashMap read() throws FileNotFoundException, IOException{
        BufferedReader br = null;
        FileReader fr = new FileReader("medellin_colombia-grande.txt");
        br = new BufferedReader(fr);
        String str = "";

        ArrayList<Integer> keys = new ArrayList<Integer>();
        HashMap<Integer, Posicion> nodos = new HashMap<Integer, Posicion>();
        int id = 0;
        float posY = 0, posX = 0;

        while ((str = br.readLine()) != null) {

            //Capturo cada dato en una variable
            StringTokenizer token = new StringTokenizer(str, " ");
            int cont = 0;

            if (cont == 0) {
                id = Integer.parseInt(token.nextToken());
                cont++;
            }
            if (cont == 1) {
                posY = Float.parseFloat(token.nextToken());
                cont++;
            }
            if (cont == 2) {
                posX = Float.parseFloat(token.nextToken());
            }

            Posicion latLon = new Posicion(posY, posX);

            keys.add(id);
            nodos.put(id, latLon);
        }

        for (int i = 0; i < nodos.size(); i++) { // se debe borrar
            System.out.println(nodos.get(keys.get(i)).getPosY()
                    + " " + nodos.get(keys.get(i)).getPosX()); //Obtiene el identificador de la Posicion en i    
        }
        return nodos;
    }
}