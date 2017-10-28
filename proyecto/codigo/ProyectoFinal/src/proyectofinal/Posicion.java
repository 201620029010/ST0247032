package proyectofinal;

/**
 * Clase Pareja que almacena la longitud y latitud del nodo
 *
 * @author Mateo Marulanda Cifuentes
 * @author Yashua Alexander Narvaez
 */
public class Posicion {

    private double posX;
    private double posY;

    public Posicion(double y, double x) {
        posX = x;
        posY = y;
    }

    public double getPosX() {
        return posX;
    }

    public double getPosY() {
        return posY;
    }
}
