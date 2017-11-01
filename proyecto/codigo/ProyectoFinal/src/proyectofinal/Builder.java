package proyectofinal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Clase que se encarga de construir la matriz con las distancias
 *
 * @author Mateo Marulanda Cifuentes
 * @author Yashua Alexander Narvaez Pulgarin
 */
public class Builder {

    private double matrix[][];
    private double x1;
    private double y1;
    private double x2;
    private double y2;
    private ArrayList<Posicion> pathCor = new ArrayList<Posicion>();

    /**
     * Constructor de la clase Builder
     *
     * @param x longitud de la matriz que se crea
     */
    public Builder(int x) {
        matrix = new double[x][x];
    }

    public double[][] build(HashMap<Integer, Posicion> nodos) {
        Iterator it = nodos.entrySet().iterator();
        while (it.hasNext()) {

            Map.Entry e = (Map.Entry) it.next();

            System.out.println(e.getKey() + " " + e.getValue());
        }
        return matrix;
    }

    /**
     * Metodo que se encarga de construir la matriz usando la API de Google Maps
     *
     * @param nodos HashMap con la clave y el valor
     * @param rd objeto de la clase Reader
     * @return Regresa la matriz ya construida
     */
    public double[][] build(HashMap<Integer, Posicion> nodos, Reader rd) {

        ArrayList<Integer> keys = rd.getKeys();
        int cont = 0;

        for (int i = 0; i < nodos.size(); i++) {
            x1 = nodos.get(keys.get(i)).getPosX();
            y1 = nodos.get(keys.get(i)).getPosY();
            for (int j = i + 1; j < nodos.size(); j++) {

                x2 = nodos.get(keys.get(j)).getPosX(); //capturo la posicion al inicio de la fila para comparar con todo
                y2 = nodos.get(keys.get(j)).getPosY();
                double puntos = distance(y1, x1, y2, x2, 'K');
                puntos = puntos * 1000;
                /*double x = Math.pow((x2 - x1), 2);
                 double y = Math.pow((y2-y1),2);
                 double distancia = Math.sqrt(x+y);*/
                matrix[i][j] = puntos;

                matrix[j][i] = puntos;
            }
        }
        cont++;
        return matrix;
    }

    /**
     * Metodo para redondar los valores de los metros
     *
     * @param matriz se reconstruye una matriz double a int
     * @return la matriz reconstruida
     */
    public int[][] rebuild(double[][] matriz) {
        int rebuilder = 0;
        int newMatriz[][] = new int[matriz.length][matriz.length];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                rebuilder = (int) matriz[i][j];
                newMatriz[i][j] = rebuilder;

            }
        }
        return newMatriz;
    }

    public void cordenatesTour(int[] arrayTemp, Reader rd, HashMap<Integer, Posicion> nodos) {
        ArrayList<Integer> keys = rd.getKeys();
        for (int i = 0; i < nodos.size(); i++) {

            //   System.out.print(nodos.get(keys.get(arrayTemp[i])).getPosY() + " " + nodos.get(keys.get(arrayTemp[i])).getPosX()); 
            double y = nodos.get(keys.get(arrayTemp[i])).getPosY();
            double x = nodos.get(keys.get(arrayTemp[i])).getPosX();
            Posicion yx = new Posicion(y, x);
            pathCor.add(yx);

        }

    //System.out.print(nodos.get(keys.get(arrayTemp[0])).getPosY() + " " + nodos.get(keys.get(arrayTemp[0])).getPosX()); //Para repetir el primero porque el arreglo es menor al tamaño del mapa
        /* for(Posicion yx: pathCor){ 
         System.out.println(yx.getPosY() + " " + yx.getPosX());
         }*/
    }

    public double haversine(double lat1, double lng1, double lat2, double lng2) {
        int r = 6371; // average radius of the earth in km
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lng2 - lng1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double d = r * c;
        return d;
    }

    private double gps2m(double lat_a, double lng_a, double lat_b, double lng_b) {
        double pk = (double) (180 / 3.14169);

        double a1 = lat_a / pk;
        double a2 = lng_a / pk;
        double b1 = lat_b / pk;
        double b2 = lng_b / pk;

        double t1 = (double) (Math.cos(a1) * Math.cos(a2) * Math.cos(b1) * Math.cos(b2));
        double t2 = (double) (Math.cos(a1) * Math.sin(a2) * Math.cos(b1) * Math.sin(b2));
        double t3 = (double) (Math.sin(a1) * Math.sin(b1));
        double tt = Math.acos(t1 + t2 + t3);

        return 6366000 * tt;
    }

    public final double distance(double lat1, double lon1, double lat2, double lon2, char unit) {
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;

        if (unit == 'K') {
            dist = dist * 1.609344;
        } else if (unit == 'N') {
            dist = dist * 0.8684;
        }

        return (dist);
    }

    private static final double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    /**
     * <p>
     * This function converts radians to decimal degrees.</p>
     *
     * @param rad - the radian to convert
     * @return the radian converted to decimal degrees
     */
    private static final double rad2deg(double rad) {
        return (rad * 180 / Math.PI);
    }

    public ArrayList<Posicion> getPathCor() {
        return pathCor;
    }

}
