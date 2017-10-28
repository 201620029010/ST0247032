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
        bd.build(nodos);
    }
}
