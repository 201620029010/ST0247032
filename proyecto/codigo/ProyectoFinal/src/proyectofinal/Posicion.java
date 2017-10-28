package proyectofinal;

/**
 * Clase Pareja que almacena la longitud y latitud del nodo
 *
 * @author Mateo Marulanda Cifuentes
 * @author Yashua Alexander Narvaez
 */
public class Posicion {

    private float posX;
    private float posY;

    public Posicion(float y, float x) {
        posX = x;
        posY = y;
    }

    public float getPosX() {
        return posX;
    }

    public float getPosY() {
        return posY;
    }
}
