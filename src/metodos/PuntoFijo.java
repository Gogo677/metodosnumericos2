/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

import java.text.DecimalFormat;

public class PuntoFijo {
    Double X;
    Double Y;
    
    public PuntoFijo(Double X, Double Y){
        this.X=X;
        this.Y=Y;
    }
    
    public Double calculaX(Double X, Double Y){
        return (X*X+Y*Y+8)/10;
    }
    
    public Double calculaY(Double X, Double Y){
        return (X*Y*Y+X+8)/10;
    }
    
    public Double ec1(Double X, Double Y){
        return X*X+Y*Y+8-10*X;
    }
    
    public Double ec2(Double X, Double Y){
        return X*Y*Y+X+8-10*Y;
    }
    
    public String metodo(){
        DecimalFormat for1 = new DecimalFormat("#.000");
        String tabla ="Ec1: x^2-10x+y^2+8 \nEc2: xy^2+x-10y+8 \n\n";
        tabla+=" n \t x \t y \t ec1 \t ec2 \n";
        double tempX,tempY;
        for (int i=0;i<=15; i++){
            tabla+=" "+i+" \t "+for1.format(X)+" \t "+for1.format(X)+" \t "+for1.format(ec1(X,Y))+" \t "+for1.format(ec1(X,Y))+" \n";
            tempX=X.doubleValue();
            tempY=Y.doubleValue();
            X=calculaX(tempX,tempY);
            Y=calculaY(tempX,tempY);
        }
        
        
        
        return tabla;
    }
}
