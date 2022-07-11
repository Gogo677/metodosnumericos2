package metodos;

import java.text.DecimalFormat;

public class SimpsonTresOctavos {
    
    Double X[];
    Double FX[];
    int n;
    //donde n=4,7,10...
    public SimpsonTresOctavos(Double X[],Double FX[],int n){
        this.X=X;
        this.FX=FX;
        this.n=n;
    }
    
    public String metodo(){
        
        double h=(X[n-1]-X[0])/(n-1),suma=0,cifx,ci;
        
        
        DecimalFormat formato1 = new DecimalFormat("#.000");
        String tabla = "Tabla de la integral de la funcion dada: \n";
        tabla +="  i  \t Xi \t f(Xi) \t Ci \t Cif(Xi) \n";
        //generar tabla de cadena
        
        String primerCad="  0  \t  "+X[0]+"  \t "+FX[0]+" \t 1 \t "+FX[0]+" \n";
        String ultimaCad="  "+(n-1)+"  \t  "+X[n-1]+"  \t "+FX[n-1]+" \t 1 \t "+FX[n-1]+" \n";
        String intermediaCad="";
        suma+=FX[0]+FX[n-1];
        
        for(int i=1;i<n-1;i++){
           
            if(i%3==0){
                ci=2;
            }else{
                ci=3;
            }
            cifx=FX[i]*ci;
            suma+=cifx;
            intermediaCad+="  "+i+"  \t  "+X[i]+"  \t "+FX[i]+" \t "+ci+" \t "+cifx+" \n";
            
        }
        tabla+=primerCad+intermediaCad+ultimaCad;

        tabla = tabla+"La suma cif(xi)= "+suma+"\n";
        suma=suma*(3*h/8);
        tabla = tabla+"La suma cif(xi) multiplicada por h/3 nuestra aproximacion es: \n"+suma+"\n";
        
        return tabla;   
        }
}
