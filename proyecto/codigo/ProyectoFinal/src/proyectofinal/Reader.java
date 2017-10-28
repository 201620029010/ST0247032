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
 * Clase que se encarga de la lectura de los archivos o entradas
 *
 * @author Mateo Marulanda Cifuentes
 * @author Yashua Alexander Narvaez
 */
public class Reader {

    private ArrayList<Integer> keys = new ArrayList<Integer>();

    /**
     * Metodo que lee la entrada
     *
     * @return retorna un hash map con los nodos y las coordenadas
     * @throws FileNotFoundException
     * @throws IOException
     */
    public HashMap read() throws FileNotFoundException, IOException {
        BufferedReader br = null;
        FileReader fr = new FileReader("medellin_colombia-grande.txt");
        br = new BufferedReader(fr);
        String str = "";

        HashMap<Integer, Posicion> nodos = new HashMap<Integer, Posicion>();
        int id = 0;
        double posY = 0, posX = 0;

        while ((str = br.readLine()) != null) {

            //Capturamos cada dato en una variable
            StringTokenizer token = new StringTokenizer(str, " ");
            int cont = 0;

            if (cont == 0) {
                id = Integer.parseInt(token.nextToken());
                cont++;
            }
            if (cont == 1) {
                posY = Double.parseDouble(token.nextToken());
                cont++;
            }
            if (cont == 2) {
                posX = Double.parseDouble(token.nextToken());
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

    public ArrayList<Integer> getKeys() {
        return keys;
    }

}
