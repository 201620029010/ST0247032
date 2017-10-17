/*
Implementacion de DiGraph con DFS para el camino más corto
 */
package laboratory3;

import java.util.LinkedList;

public class DfsShortestPath {

    static int[] distancia = null;
    static boolean[] visitado = null;
    static Graph g = null;

    public static void main(String[] args) {
        distancia = new int[7];
        visitado = new boolean[7];
        g = new Graph(7);
        
        //Lleno el arreglo de distancias con infinito
        for (int i = 0; i < distancia.length; i++) {
            distancia[i] = Integer.MAX_VALUE;
            visitado[i] = false;
        }
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 0);
        g.addEdge(1, 4);
        g.addEdge(4, 1);
        g.addEdge(4, 3);
        g.addEdge(4, 5);
        g.addEdge(5, 4);
        g.addEdge(5, 3);
        g.addEdge(5, 6);
        g.addEdge(3, 4);
        g.addEdge(3, 5);
        g.addEdge(3, 6);
        g.addEdge(3, 2);
        g.addEdge(6, 2);
        g.addEdge(6, 3);
        g.addEdge(6, 5);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(2, 6);
        
        //Llamo el dfs      con el nodo raiz
        caminoMasCorto(0, 0);
        System.out.println("La distancia más corta desde 0 : ");
        for (int i = 1; i < distancia.length; i++) {
            System.out.println("Por nodo : " + i + " Distancia: " + distancia[i]);
        }
    }
    /**
     * Encuentra el camino más corto con DFS
     * 
     **/
    static public void caminoMasCorto(int actual, int nivel) {
        LinkedList temp = g.g[actual];
        visitado[actual] = true;
        for (int i = 0; i < temp.size(); i++) {
            int t = (Integer) temp.get(i);
            if ((nivel + 1 < distancia[t]) && !visitado[t]) {
                distancia[t] = nivel + 1;
                caminoMasCorto(t, nivel + 1);
            }
        }
        visitado[actual] = false;
    }

    static class Graph {

        LinkedList[] g = null;
        int V = 0;

        public Graph(int V) {
            this.V = V;
            g = new LinkedList[V];
            for (int i = 0; i < V; i++) {
                g[i] = new LinkedList<Integer>();
            }
        }

        public void addEdge(int u, int v) {
            g[u].add(v);
        }
    }
}
