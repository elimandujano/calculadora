package Service;

public class Matriz {
    
    //Método que suma dos matrices cuadradas.  
    public double[][] suma(double[][] A,double[][] B){
        double [][] suma = new double[A.length][A.length];
        System.out.println("Suma de Dos Matrices:");
    
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                suma[i][j] = A[i][j]+ B[i][j];                
            }           
        }
        return suma;
    }
    
    //Método que imprime una matriz cuadrada tipo double[][].
    public static void  imprimir(double[][] C){
        System.out.println("----------------");
        for (int i = 0; i < C.length; i++) {                        
            for (int j = 0; j < C.length; j++) {
                System.out.printf(C[i][j]+"\t");  
            }   
                System.out.println();
        }        
    }
    
    //Método que imprime una escalar tipo double
    public static void  imprimir(double C){
        System.out.println(C);            
    }
    
    //Método que imprime dos matrices cuadradas de misma dimension  
    public double[][] producto(double[][] A, double[][] B){
        double[][] producto = new double[A.length][A.length];
        System.out.println("Multiplicacion de Dos Matrices:");

        for (int i = 0; i <A.length; i++) {
            for (int j = 0; j < A.length; j++) {
                for (int k = 0; k < A.length; k++) {
                    producto[i][j] += A[i][k]*B[k][j];
                }                
            }            
        }
        return producto;
    }
    
    // Método que calcula la determinante de una matriz cuadrada (*observado*)    
    public double determinante(double[][] matriz){
        double det;
        System.out.println("Determinante:");
    if(matriz.length==2)
    {
        det=(matriz[0][0]*matriz[1][1])-(matriz[1][0]*matriz[0][1]);
        return det;
    }
    double suma=0;
    for(int i=0; i<matriz.length; i++){
    double[][] nm=new double[matriz.length-1][matriz.length-1];
    
        for(int j=0; j<matriz.length; j++){
            if(j!=i){
                for(int k=1; k<matriz.length; k++){
                    int indice=-1;
                    if(j<i){
                        indice=j;
                    }else if(j>i){
                        indice=j-1;
                        nm[indice][k-1] = matriz[j][k];
                    }
                }
            }
        
        if(i%2==0){
            suma+=matriz[i][0] * determinante(nm);
        }else{
            suma-=matriz[i][0] * determinante(nm);
        }}
    }
    return suma;
    }
 
    // Método que Multiplica un numero escalar "n" por una matriz cuadrada 
    public double[][] producto(double n, double[][] matriz) {
        double[][] producto = new double[matriz.length][matriz.length];
        double multiplicacion=0;
        System.out.println("Multiplicacion escalar ="+n+" y matriz:");
        
        for(int i=0;i<matriz.length;i++){
            for(int j=0;j<matriz.length;j++){
               producto[i][j] = matriz[i][j]*n;
            }
        }
		return producto;
    }
    
    // Método para halla la matriz adjunta
    public double[][] adjunta(double [][] matriz){
        System.out.println("Matriz Adjunta:");
        return transpuesta(cofactor(matriz));
    }
    
    //Método para hallar la matriz de cofactores
    public double[][] cofactor(double[][] matriz){
        double[][] nuevaMatriz=new double[matriz.length][matriz.length];
        System.out.println("Matriz Cofactor:");
        
        for(int i=0;i<matriz.length;i++){
            for(int j=0;j<matriz.length;j++){
                double[][] det=new double[matriz.length-1][matriz.length-1];
                double detValor;
                
                for(int k=0;k<matriz.length;k++){
                    if(k!=i){
                        for(int l=0;l<matriz.length;l++){
                            if(l!=j){
                                int indice1=k<i ? k : k-1 ;
                                int indice2=l<j ? l : l-1 ;
                                det[indice1][indice2]=matriz[k][l];
                            }
                        }
                    }
                }
                detValor=determinante(det);
                nuevaMatriz[i][j]=detValor * (double)Math.pow(-1, i+j+2);
            }
        }   
        return nuevaMatriz;
    }
    
    //Método que halla la transpuesta de una matriz
    public double[][] transpuesta(double[][] matriz){
        double[][]nuevamatriz=new double[matriz[0].length][matriz.length];
        System.out.println("Transpuesta:");
        
        for(int i=0; i<matriz.length; i++){
            for(int j=0; j<matriz.length; j++){
                nuevamatriz[i][j]=matriz[j][i];
            }
        }
        return nuevamatriz;
    }
    
    // Método para hallar inversa de una matriz cuadrada  
    public double[][] inversa(double[][] matriz) {
    
        double invDet=1/determinante(matriz);        
        double[][] nuevaMatriz=adjunta(matriz);
        double[][] matrizInversa = producto(invDet,nuevaMatriz);           
        
        return matrizInversa;        
    }    

    // Método Constructor de la Clase Matriz
    public Matriz() {
    }      
}
