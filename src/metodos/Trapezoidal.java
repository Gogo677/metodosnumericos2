/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

import java.text.DecimalFormat;

/**
 *
 * @author diego
 */
public class Trapezoidal {
    Double X[];
    Double FX[];
    int n;
    
    public Trapezoidal(Double X[],Double FX[],int n){
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
           
                ci=2;

            cifx=FX[i]*ci;
            suma+=cifx;
            intermediaCad+="  "+i+"  \t  "+X[i]+"  \t "+FX[i]+" \t "+ci+" \t "+cifx+" \n";
            
        }
        tabla+=primerCad+intermediaCad+ultimaCad;

        tabla = tabla+"La suma cif(xi)= "+suma+"\n";
        suma=suma*(h/2);
        tabla = tabla+"La suma cif(xi) multiplicada por h/3 nuestra aproximacion es: \n"+suma+"\n";
        
        return tabla;   
        }
}
