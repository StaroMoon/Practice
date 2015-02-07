/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author StaroMoon
 */
public class PrintTriangles {
    public static void main(String[] args){
        printXxxTriangle(8);
    }
    
    public static void printXxxTriangle(int size){
        
        /*
                           1
                         1   1
                       1   2   1
                     1   3   3   1
                   1   4   6   4   1
                 1   5  10  10   5   1
               1   6  15  20  15   6   1
             1   7  21  35  35  21   7   1
        
        for(int i = 0;i<size;i++){
            int number = 1;
            System.out.printf("%" + (size-i)*2+"s", "");
            for(int j = 0;j<=i;j++){
                System.out.printf("%4d",number);
                number = number * (i-j) / (j+1);
            }System.out.println("");
        }*/
        
        /*
          1
          1  1
          1  2  1
          1  3  3  1
          1  4  6  4  1
          1  5 10 10  5  1
          1  6 15 20 15  6  1
          1  7 21 35 35 21  7  1
        
        for(int i = 0;i<size;i++){
            int number = 1;
            for(int j = 0;j<=i;j++){
                System.out.printf("%3d",number);
                number = number * (i-j) / (j+1);
            }System.out.println("");
        }*/
        
        /*
                         1
                      1  2  1
                   1  2  4  2  1
                1  2  4  8  4  2  1
             1  2  4  8 16  8  4  2  1
        
        for(int i = 0;i<size;i++){
            for(int j = 0;j<size-i;j++){
                System.out.printf("%3s","");
            }
            for(int k = 0;k<=i;k++){
                System.out.printf("%3d",(int)Math.pow(2, k));
            }
            for(int m = i;m>0;m--){
                System.out.printf("%3d",(int)Math.pow(2, m-1));
            }
            System.out.println("");
        }*/
    }
}
