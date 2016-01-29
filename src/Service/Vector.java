
package Service;
import  Service.Matriz;

public class Vector {
    
    public static double[][]I(int k, int l ){
        double[][] unit = new double[k][l];
        for(int i=0;i<k;i++){
            for(int j=0;j<l; j++){
                unit[i][j]=1;            
            }                        
        }
        Matriz.imprimir(unit);
        
        return unit;        
    }
    
    public static double media(double[][] X){
        double[][] I, media1;
        I = Vector.I(X.length, X[0].length);        
        double media, n,media2;
        n = X.length;
        media1 = Matriz.producto(Matriz.transpuesta(I),X);
        media2 = media1[0][0]; 
        media = media2/n;

    
        return media;
    }
    
    public static double varianza(double[][] X){
        double[][] var= new double[X.length][X[0].length];
        double[][] var1 = null;
        int n = X.length;
        double var2, varianza;
        
        for(int i=0;i<X.length;i++){
            for(int j=0;j<X[0].length;j++){                
                var[i][j] += X[i][j]-Vector.media(X);
            }
        }
        var1 = Matriz.producto(Matriz.transpuesta(var), var);
        var2 = var1[0][0];
        varianza = var2/n;
        return varianza;
    }
}
