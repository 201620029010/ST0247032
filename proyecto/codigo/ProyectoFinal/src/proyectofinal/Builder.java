package proyectofinal;

import java.util.HashMap;

public class Builder {

    private int matrix[][];

    public Builder(int x) {
        matrix = new int[x][x];
    }

    public int[][] build(HashMap<Integer, Posicion> nodos) {
        return matrix;
    }
}
