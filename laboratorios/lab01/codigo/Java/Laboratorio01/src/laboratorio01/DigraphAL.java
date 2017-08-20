package laboratorio01;

import java.util.ArrayList;
import java.util.Collection;

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

    @Override
    public void addArc(int source, int destination, int weight) {
        lista.get(source).add(new Pareja(destination, weight));

    }

    @Override
    public int getWeight(int source, int destination) {
        for (int i = 0; i < lista.get(source).size(); i++) {
            if (lista.get(source).get(i).vertice == destination) {
                return lista.get(source).get(i).peso;
            }

        }
        return 0;
    }

    @Override
    public ArrayList<Integer> getSuccessors(int vertice) {
        ArrayList<Integer> sucesores = new ArrayList<>();

        for (int i = 0; i < lista.get(vertice).size(); i++) {
            
               
                    sucesores.add(lista.get(vertice).get(i).vertice);
                
          

        }
        return sucesores;

    }

    public static void main(String[] args) {
        System.out.println("hola");
        DigraphAL grafo = new DigraphAL(5);

        grafo.addArc(1, 2, 5);
        grafo.addArc(1, 3, 1);        
        grafo.addArc(2, 4, 5);


        for (Integer i : grafo.getSuccessors(1)) {
            System.out.println(i);
        }

       
    }
}
