package laboratorio01;

import java.io.*;
import java.util.*;

/**
 * Esta clase es una implementación de un digrafo usando listas de adyacencia
 *
 * @author Mauricio Toro
 * @version 1
 */
public class DigraphAL extends Graph {

    private int size;
    ArrayList<Pareja> aux;
    ArrayList<ArrayList<Pareja>> lista;
    Pareja pareja;
    private int tamano;
    private int tamaux;

    public DigraphAL(int size) {

        super(size);
        aux = new ArrayList<Pareja>();
        lista = new ArrayList<ArrayList<Pareja>>();
        for (int i = 0; i < size; i++) {
            lista.add(new ArrayList<Pareja>());

        }
        tamano = lista.size();
        tamaux = aux.size();

    }
 /**
  * Add an arc into the Graph
  * @param source
  * @param destination 
  * @param weight 
  **/
    @Override
    public void addArc(int source, int destination, int weight) {
        lista.get(source).add(new Pareja(destination, weight));

    }
/** It gets the weight 
 * @param source 
 * @param destination 
 * @return Weight
 **/
    @Override
    public int getWeight(int source, int destination) {
        for (int i = 0; i < lista.get(source).size(); i++) {
            if (lista.get(source).get(i).vertice == destination) {
                return lista.get(source).get(i).peso;
            }

        }
        return 0;
    }
  
    /** gets a list with the successors 
     * @param vertice 
     * @return A List with successors
     **/
    @Override
    public ArrayList<Integer> getSuccessors(int vertice) {
        ArrayList<Integer> sucesores = new ArrayList<>();

        for (int i = 0; i < lista.get(vertice).size(); i++) {
            
               
                    sucesores.add(lista.get(vertice).get(i).vertice);
                
          

        }
        return sucesores;

    }
    public void bfs (int s) {
         boolean visited[] = new boolean[tamano];
          LinkedList<Integer> queue = new LinkedList<Integer>();
           visited[s]=true;
           queue.add(s);
            while (queue.size() != 0)
        {
            // Dequeue a vertex from queue and print it
            s = queue.poll();
            System.out.print(s+" ");
 
            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            
            ListIterator <Pareja> i = lista.get(s).listIterator();
            while (i.hasNext())
            {
                int n =  i.next().vertice;
                if (!visited[n])
                {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    public static void main(String[] args) {
       
        DigraphAL grafo = new DigraphAL(5);

        grafo.addArc(0, 1, 5);
        grafo.addArc(0, 2, 1);        
        grafo.addArc(1, 2, 5);
        grafo.addArc(2, 0, 5);
        grafo.addArc(2, 3, 5);
        grafo.addArc(3, 3, 5);
        grafo.bfs(2);
     /**   for (Integer i : grafo.getSuccessors(4)) {
            System.out.println(i);
        }**/

       
    }
}
