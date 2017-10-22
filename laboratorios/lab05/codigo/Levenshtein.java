package laboratory05;

public class Levenshtein {
    /**
     * Encuentra el minimo de un minimo
     * @param a
     * @param b
     * @param c
     **/
    public static int minimum(int a, int b, int c) {                            
        return Math.min(Math.min(a, b), c);                                      
    }  

 
    
    /**
     * Encuentra la distamcia levenshtein de dos cadenas
     * @param a
     * @param b
     **/
    public static int levenshtein(String a, String b) {      
        int[][] matriz = new int[a.length() + 1][b.length() + 1];        
                                                                                 
        for (int i = 0; i <= a.length(); i++)                                 
            matriz[i][0] = i;                                                  
        for (int j = 1; j <= b.length(); j++)                                 
            matriz[0][j] = j;                                                  
                                                                                 
        for (int i = 1; i <= a.length(); i++)                                 
            for (int j = 1; j <= b.length(); j++)                             
                matriz[i][j] = minimum(                                        
                        matriz[i - 1][j] + 1,                                  
                        matriz[i][j - 1] + 1,                                  
                        matriz[i - 1][j - 1] + ((a.charAt(i - 1) == b.charAt(j - 1)) ? 0 : 1));
                                                                                 
        return matriz[a.length()][b.length()];                           
    }                                    

    public static void main(String[] args) {
        String a = "carro";
        String b = "casa";
        System.out.println(levenshtein(a, b)); 
    }

}
