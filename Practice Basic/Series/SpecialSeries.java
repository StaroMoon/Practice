/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author StaroMoon
 */
public class SpecialSeries {
    public static void main(String[] args){
        sumOfSeries(1,5);
    }
    
    public static double sumOfSeries(double x,int numTerms){
        double sum = 0,top,bot,back;
        for(int i = 1;i<numTerms*2;i+=2){
            if(x > 1 || x < -1){
                System.out.println("Invalid input number");
            }else{
                top = 1;
                back = 1;
                bot = 1;
                for(int j = 1;j<i;j++){
                    if(j % 2 == 0){
                        bot *= j;
                    }else{
                        top *= j;
                    }
                }
                back = Math.pow(x, i)/i;
                System.out.println(back);
                sum += (top/bot) * back;
            }
        }
        System.out.println("sum is : " + sum);
        return sum;
    }
}
