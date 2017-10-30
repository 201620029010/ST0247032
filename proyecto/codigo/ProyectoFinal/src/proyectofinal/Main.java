
package proyectofinal;

import java.io.IOException;
import java.util.HashMap;


/**
 *
 * @author Yeshúa
 */
public class Main {
    public static void main(String[] args) throws IOException {
       HashMap nodos = Reader.read();
       Builder bd = new Builder(nodos.size());
       bd.build(nodos);
    }
}
