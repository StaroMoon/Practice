
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
public class NumberConversion {
    public static void main(String[] args){
        String in;
        int a,b;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number and radix : ");
        in = input.next();
        System.out.print("Enter the input radix: ");
        a = input.nextInt();
        System.out.print("Enter the output radix: ");
        b = input.nextInt();
        toRadix(in,a,b);
    }
    
    public static void toRadix(String in, int inRadix,int outRadix){
        int input = Integer.parseInt(in, inRadix);
        String output = Integer.toString(input, outRadix);
        System.out.printf("%s in radix %d is \"%s\" in radix %d.\n",in,inRadix,output,outRadix);
    }
}
