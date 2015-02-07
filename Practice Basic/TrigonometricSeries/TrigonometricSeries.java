/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author StaroMoon
 */
public class TrigonometricSeries {
    public static void main(String[] args){
        sin(30,8); //find sin
        cos(60,8); //find cos
    }
    
    public static double sin(double x,int numTerms){
        double sum = 0, sumplus = 0, summinus = 0,fac,fac2,radius,value;
        radius = Math.toRadians(x);
        value = Math.sin(radius);
        for(int i =1;i<numTerms*2;i+=4){
            fac = 1;
            for(int j = 1;j<=i;j++){
                fac *= j;
            }
            sumplus += Math.pow(value, i) / fac;
        }
        for(int i =3;i<numTerms*2;i+=4){
            fac2 = 1;
            for(int j = 1;j<=i;j++){
                fac2 *= j;
            }
            summinus += Math.pow(value, i) / fac2;
        }
        sum = sumplus-summinus;
        System.out.printf("The sum of sin radius %d is %f \n",(int)x,sum);
        return sum;
    }
    
    public static double cos(double x,int numTerms){
        double sum = 0,sumplus = 0, summinus = 0, radius,fac,fac2,value;
        radius = Math.toRadians(x);
        value = Math.cos(radius);
        for(int i = 0;i<numTerms*2;i+=4){
            fac = 1;
            for(int j = 1;j<i;j++){
                fac  *= j;
            }
            sumplus += Math.pow(value, i) / fac;
        }
        for(int i = 2;i<numTerms*2;i+=4){
            fac2 = 1;
            for(int j = 1;j<i;j++){
                fac2  *= j;
            }
            summinus += Math.pow(value, i) / fac2;
        }
        sum = sumplus - summinus;
        System.out.printf("The sum of cos radius %d is %f \n",(int)x,sum);
        return sum;
    }
}
