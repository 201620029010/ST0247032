package laboratorio01;
import java.util.ArrayList;
import java.util.Collection;


public class DigraphAM extends Graph
{

   private int size;
   private int matriz[][];
   ArrayList <Integer> sucesores = new  ArrayList <Integer>(); 
   
   public DigraphAM(int size) {
      super(size);
       this.size = size;
       matriz = new int [this.size][this.size];   
   }
   
    
   
   
   @Override
   public int getWeight(int source, int destination)
   {
        return matriz[source][destination];
    }
   
    /**
  * Add an arc into the Graph
  * @param source
  * @param destination 
  * @param weight 
  **/
   @Override
   public void addArc(int source, int destination, int weight)
   {
         matriz[source][destination] = weight;
   }
   /** gets a list with the successors 
     * @param vertice 
     * @return A List with successors
     **/
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
   
    public void imprimir(){
        for(int i=0; i< matriz.length; i++){
            for(int j=0; j< matriz[i].length; j++){
                System.out.print( matriz[i][j] + "  " );        
            }
            System.out.println();
        }  
    }
     public static void main(String[] args) {
        DigraphAM grafo = new DigraphAM(5);
        
        grafo.addArc(1, 2, 1);
        grafo.addArc(1, 3, 1);
        grafo.addArc(2, 3, 5);
        grafo.addArc(2, 4, 6);
        grafo.imprimir();
         
       
       ArrayList  <Integer> grafos = grafo.getSuccessors(2);
       
       
        
        for (int i = 0; i <  grafos.size(); i++) {
            System.out.println(grafos.get(i));
            
        }
                
    }
}
