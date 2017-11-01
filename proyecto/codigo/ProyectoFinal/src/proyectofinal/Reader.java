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
     * Metodo que lee la entrada tipo archivo
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
        return nodos;
    }

    /**
     * Metodo que se encarga de leer las entradas tipo url
     *
     * @param link String de la url del mapa
     * @return Hasmap con las coordenadas
     */
    public HashMap readLink(String link) {
        HashMap<Integer, Posicion> nodos = new HashMap<Integer, Posicion>();
        String str = link.substring(31, link.length() - 18);

        int id = 0;
        double posY = 0, posX = 0;
        StringTokenizer token = new StringTokenizer(str, "/");

        while (token.hasMoreTokens()) {
            String strTemp = token.nextToken();
            if (token.hasMoreTokens()) {
                String[] parts = strTemp.split(",");
                posY = Double.parseDouble(parts[0]);
                posX = Double.parseDouble(parts[1]);

                Posicion latLon = new Posicion(posY, posX);
                keys.add(id);
                nodos.put(id, latLon);
                id++;
            } else {
                strTemp = strTemp.replace('@', ' ');
                String[] parts = strTemp.split(",");
                posY = Double.parseDouble(parts[0]);
                posX = Double.parseDouble(parts[1]);

                Posicion latLon = new Posicion(posY, posX);
                keys.add(id);
                nodos.put(id, latLon);
                id++;
            }
        }
        Posicion latLon = new Posicion(posY, posX);

        keys.add(id);
        nodos.put(id, latLon);
        return nodos;
    }

    public ArrayList<Integer> getKeys() {
        return keys;
    }

}
