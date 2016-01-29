
package Prueba;
import  Service.Matriz;

public class Prueba {

    public static void main (String[]Args){
        double A[][] = new double [3][3];
        double A1[][] = new double [3][3];
        double B[][] = new double [3][3];
        double n = 2;
        
        // A = {{1,2,3},{4,5,6},{7,8,9}}; // no puedo asignar de esa forma valoresa A
        
        A[0][0]=1;
        A[0][1]=2;
        A[0][2]=3;
        A[1][0]=4;
        A[1][1]=5;
        A[1][2]=6;
        A[2][0]=7;
        A[2][1]=8;
        A[2][2]=7;
        
        B[0][0]=1;
        B[0][1]=2;
        B[0][2]=3;
        B[1][0]=4;
        B[1][1]=5;
        B[1][2]=6;
        B[2][0]=7;
        B[2][1]=8;
        B[2][2]=5;
        
        Matriz matriz = new Matriz();
        Matriz.imprimir(matriz.suma(A,B));
        Matriz.imprimir(matriz.producto(A,B));
        Matriz.imprimir(matriz.producto(n,A));
        Matriz.imprimir(matriz.transpuesta(A));
        Matriz.imprimir(matriz.determinante(A));
        Matriz.imprimir(matriz.cofactor(A));
        Matriz.imprimir(matriz.adjunta(A));
        Matriz.imprimir(matriz.inversa(A));
        A1 = matriz.inversa(A);
        Matriz.imprimir(matriz.producto(A,A1));
    }
}