
package lab02;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author straycat
 */
public class Lab02
{
    
    public static void main(String[] args) {
        ArrayList<int[]> result = inicializar(4);     
        ArrayList<int[]> rigthSolutions = new ArrayList<int[]>();
        for(int[] array: result){
            if(validar(array)){
                rigthSolutions.add(array);
            }
        }
        
        for(int[] array: rigthSolutions)
            System.out.println(Arrays.toString(array));
        
        
        
    }
    public static int count(int limit){
        
        ArrayList<int[]> result = inicializar(limit);
        ArrayList<int[]> rigthSolutions = new ArrayList<int[]>();
        for(int[] array: result){
            if(validar(array)){
                rigthSolutions.add(array);
            }
        }
        return rigthSolutions.size() == 0 ?  -1: rigthSolutions.size();
        
    }
    /**
     *@param check
     * @return si el tablero es valido
    **/
    public static boolean validar(int[] check){
        for (int i = 0; i < check.length ; i++) {
            int count = 1;
            for (int j = i +1; j < check.length ; j++) {
               
                if(check[j] == check[i]) return false;
                
               
                if(check[i]-count == check[j]) return false;
                
                
                if(check[i]+count == check[j]) return false;
                
                count++;
            }
        }
        return true;
    
    }
    
    public static ArrayList<int[]>  inicializar(int limit){
        ArrayList<int[]> resultList = new ArrayList<int[]>();
        
        int base [] = new int[limit];
        for (int i = 0; i < limit; i++) {
            base[i] = 1;
        }
        resultList.add(base);
        count(resultList, limit);
        return resultList;
        
    }
    
    public static void count(ArrayList<int[]> resultList, int limit){

        
        int pasado[] = resultList.get(resultList.size()-1);
        
        int [] newArray = Arrays.copyOf(pasado, pasado.length);
        
        int valorAgregar = newArray[0] +1;
        newArray[0] = valorAgregar;
        
        
        resultList.add(newArray);
        
        
        if( valorAgregar >= limit ){
            int [] newArrayUP = Arrays.copyOf(newArray, newArray.length);
            
            if(up(1 ,newArrayUP,limit)) {return;}
            else {resultList.add(newArrayUP); count(resultList,limit);}
        }else{
             count(resultList,limit);
        }
        
        
    }
    
    public static boolean up(int pos,int[] newArrayUP, int limit){
        
        if(pos == newArrayUP.length  ){
            //Coronamos!
            return true;  
        }
        
        
        if(newArrayUP[pos] == limit){
           
            newArrayUP[pos -1] = 1;
            return up( pos +1,newArrayUP, limit);
        }else{
            newArrayUP[pos -1] = 1;
            
            newArrayUP[pos] = newArrayUP[pos] +1;
            
            return false;
        }
    
    
    }
}