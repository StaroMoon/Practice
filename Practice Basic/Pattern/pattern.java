/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author StaroMoon
 */
public class pattern {
    public static void main(String[] args){
        printPatternX(5);
    }
    
    public static void printPatternX(int size){
        /*
                  #
                # #
              # # #
            # # # #
          # # # # #
        for(int i = 1;i<=size;i++){
            for(int j = 0;j <size-i;j++){
                System.out.printf("%2s"," ");
            }
            for(int k = 0; k < i;k++){
                System.out.printf("%2s","#");
            }System.out.println("");
        }*/
        
        /*
         # # # # #
           # # # #
             # # #
               # #
                 #
        for(int i = size;i>0;i--){
            for(int j = 0;j<size-i;j++){
                System.out.printf("%2s"," ");
            }
            for(int j = 0; j < i;j++){
                System.out.printf("%2s","#");
            }System.out.println("");
        }*/
        
        /*
        # # # # # 
        # # # # 
        # # # 
        # # 
        # 
        for(int i = size;i > 0;i--){
            for(int j = i;j > 0;j--){
                System.out.print("# ");
            }System.out.println("");
        }*/
        
        /*
        # 
        # # 
        # # # 
        # # # # 
        # # # # # 
        for(int i = 0;i < size;i++){
            for(int j = 0;j < i;j++){
                System.out.print("# ");
            }System.out.println("");
        }*/
    }
}
