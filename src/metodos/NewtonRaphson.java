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
public class NewtonRaphson {
    Double X;
    Double Y;
    Double Ja[][]= new Double[2][2];
    
    public NewtonRaphson(Double X, Double Y){
        this.X=X;
        this.Y=Y;
    }
    
    
    public Double f1(Double X, Double Y){
        return X*X+Y*Y+8-10*X;
    }
    
    public Double f2(Double X, Double Y){
        return X*Y*Y+X+8-10*Y;
    }
    
    public Double determinante(Double X, Double Y){
        return 4*X*X*Y-20*X -20*X*Y-2*Y*Y*Y-2*Y+100;
    }
    
    public Double[][] Jacobiano(Double X, Double Y){
        Double J[][]= new Double[2][2];
        Double det=determinante(X,Y);
        J[0][0]=(2*X*Y-10)/det;
        J[0][1]=(-2*Y)/det;
        J[1][0]=(-Y*Y-1)/det;
        J[1][1]=(2*X-10)/det;
        
        return J;
    }
    
    public Double[] multiplica(Double[][] J,Double f1, Double f2){
        Double vec[] =new Double[2];
        vec[0]=J[0][0]*f1+J[0][1]*f2;
        vec[1]=J[1][0]*f1+J[1][1]*f2;
        return vec;
    }
    
    public String metodo(){
        DecimalFormat for1 = new DecimalFormat("0.0000");
        String tabla ="Ec1: x^2-10x+y^2+8 \nEc2: xy^2+x-10y+8 \n\n";
        tabla+="   \t xn \t  J-1 \t J-1 \t f1 \t J-1*f \t xn+1\n";
        tabla+=" n \t yn \t  J-1 \t J-1 \t f2 \t       \t yn+1\n";
        double tempX,tempY;
        Double vec[]=new Double[2];
        Double fu1,fu2;
        fu1=f1(X,Y);
        fu2=f2(X,Y);
        Ja=Jacobiano(X,Y);
        vec=multiplica(Ja,fu1,fu2);
        tempX=X-vec[0];
        tempY=Y-vec[1];
        for (int i=0;i<=15; i++){
            tabla+=" "+i+" \t "+for1.format(X)+" \t "+for1.format(Ja[0][0])+" \t "+for1.format(Ja[0][1])+" \t "+for1.format(fu1)+" \t"+for1.format(vec[0])+"\t"+for1.format(tempX)+"\n";
            tabla+="    \t "+for1.format(Y)+" \t "+for1.format(Ja[1][0])+" \t "+for1.format(Ja[1][1])+" \t "+for1.format(fu2)+" \t"+for1.format(vec[1])+"\t"+for1.format(tempY)+"\n";
            X=tempX;
            Y=tempY;
            fu1=f1(tempX,tempY);
            fu2=f2(tempX,tempY);
            Ja=Jacobiano(tempX,tempY);
            vec=multiplica(Ja,fu1,fu2);
            X=tempX;
            Y=tempY;
            tempX=X-vec[0];
            tempY=Y-vec[1];
        }
        
        
        
        return tabla;
    }
}
