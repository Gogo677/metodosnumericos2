/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

import java.text.DecimalFormat;
import java.io.*;
public class InterpolacionNewton 
{
 Double X[];
 Double FX[];
 int n;
 public InterpolacionNewton(Double X[],Double FX[],int n)
 {
     this.X=X;
     this.FX=FX;
     this.n=n;	 
 }
public String metodo()
{
	DecimalFormat fo = new DecimalFormat("#.000");
	String resu="";
	double c0,c1,c2,c3;
	resu+="\t INTERPOLACION DE DIFERENCIAS DE NEWTON  4 PTOS.\n";

	//Hacia adelante		}		
	c0=FX[0];
	c1=(FX[1]-FX[0])/(X[1]-X[0]);
	c2=(FX[2]- (c0 + c1*(X[2]-X[0])))/(X[2]-X[0])*(X[2]-X[1]);
	c3=(FX[3]-(c0 + c1*(X[3]-X[0]) + c2*((X[3]-X[0])*(X[3]-X[1]))))/(X[3]-X[0])*(X[3]-X[1])*(X[3]-X[2]);
    resu+="\nPolinomio interpolador hacia adelante: \n" + fo.format(c0) + "+ " + fo.format(c1) + "(x-" + X[0] + ") +" + fo.format(c2) + 
    		                                                "(x-" + X[0] + ")(x-" + X[2] + ") +" + fo.format(c3) + "(x-" +X[0] +")(x-" 
    		                                                + X[1] + ")(x-" + X[2] + ")\n";
    //Hacia atras
    c0=FX[3];
    c1=(FX[2]-FX[3])/(X[2]-X[3]);
	c2=(FX[1]- (c0 + c1*(X[1]-X[3])))/(X[1]-X[3])*(X[1]-X[2]);
	c3=(FX[0]-(c0 + c1*(X[0]-X[3]) + c2*((X[0]-X[3])*(X[0]-X[2]))))/(X[0]-X[3])*(X[0]-X[2])*(X[0]-X[1]);
	resu+="Polinomio interpolador hacia atras: \n" + fo.format(c0) + "+ " + fo.format(c1) + "(x-" + X[3] +") + " + fo.format(c2) 
			                                                 + "(x-" + X[3] + ")(x-" + X[2] + ") + " + fo.format(c3) + 
			                                                 "(x- " + X[3] + ")(x-" + X[2] + ")(x-" + X[1] + ")\n";
	
	return resu;
	}

public double lee()
{
	double num;
	try{
		InputStreamReader isr = new InputStreamReader (System.in);
		BufferedReader br = new BufferedReader(isr);
		String sdato;
		sdato = br.readLine();
		num = Double.parseDouble(sdato);
	}
	catch(IOException ioe){
		num=0.0;
	}
	return num;
	}
}