package laboratorio01;

import java.util.ArrayList;
import java.util.Collection;
/**
 * Esta clase es una implementación de un digrafo usando listas de adyacencia
 * 
 * @author Mauricio Toro 
 * @version 1
 */
public class DigraphAL extends Graph
{
   private int size;
   ArrayList <Pareja> aux;
      ArrayList <ArrayList <Pareja>> lista; 
   public DigraphAL(int size)
   {
       
       super(size);
       aux= new ArrayList <Pareja>();
       lista = new  ArrayList <ArrayList <Pareja>>(); 
     
     
   }
   
   @Override
   public void addArc(int source, int destination, int weight)
   { 
      Pareja pareja = new Pareja(destination, weight); 
      
      
       
           
   }
   
   @Override
   public int getWeight(int source, int destination)
   {
      return matriz[source][destination];
   }
  
   @Override
   public ArrayList<Integer> getSuccessors(int vertice)
   {
       for (int i = vertice; i < matriz.length; i++) {
           for (int j = 0; j < matriz[i].length; j++) {
              if(matriz[i][j]!=0) {
                  sucesores.add(j);
              }
               
           }
           
       }
       return sucesores;
   }
   
    public static void main(String[] args) {
        DigraphAM grafo = new DigraphAM(5);
        
        grafo.addArc(1, 2, 1);
        grafo.addArc(1, 3, 1);
        
       
        grafo.getSuccessors(1);
        ArrayList<Integer> ls = new ArrayList<Integer>();
        ls.addAll((Collection<? extends Integer>) grafo);
        
        for (int i = 0; i < ls.size(); i++) {
            System.out.println(ls.get(i));
            
        }
                
    }
}