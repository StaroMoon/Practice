
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author StaroMoon
 */
public class NumberGuess {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args){
        System.out.println("Key in your guess : ");
        numberGuess(10);
    }
    
    public static void numberGuess(int x){
        int rand = (int)(Math.random()*100);
        int count = 1;
        for(int i = 0;i<x;i++){
            x = in.nextInt();
            if(x > 100 || x < 0){
                System.out.println("Input only number between 0-100");
            }else{
                if(x > rand){
                    System.out.println("Try lower");
                    count++;
                }else if(x < rand){
                    System.out.println("Try higher");
                    count++;
                }else{
                    System.out.printf("You got it in %d trials!",count);
                    System.exit(0);
                }
            }
        }
    }
}
