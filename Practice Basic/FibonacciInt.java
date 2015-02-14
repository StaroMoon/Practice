/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author StaroMoon
 */
public class FibonacciInt {
    public static void main(String[] args){
        for(long i = 1;i<=25;i++){
            if(Long.MAX_VALUE / factorial(i-1) < i+1){
                System.out.printf("The facorial of %d is out of range\n",i);
            }else{
                System.out.printf("The factorial of %2d is %d\n",i,factorial(i));
            }
        }
    }
    public static int fibonacci(int x){
        if(x == 0){
            return 0;
        }else if(x == 1){
            return 1;
        }else{
            return fibonacci(x-1) + fibonacci(x-2);
        }
    }
    
    public static long factorial(long x){
        long sum = 1;
        for(int i = 1;i<=x;i++){
            sum *= i;
        }
        return sum;
    }
}
