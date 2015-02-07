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
        printPatternX(8);
    }
    
    public static void printPatternX(int size){
        /*
                         1
                       2 3 2
                     3 4 5 4 3
                   4 5 6 7 6 5 4
                 5 6 7 8 9 8 7 6 5
               6 7 8 9 0 1 0 9 8 7 6
             7 8 9 0 1 2 3 2 1 0 9 8 7
           8 9 0 1 2 3 4 5 4 3 2 1 0 9 8
        
        for(int i = 1 ;i<=size;i++){
            for(int j = size-i+1;j>0;j--){
                System.out.printf("%2s"," ");
            }
            for(int k = i;k<i+i;k++){
                System.out.printf("%2d",k%10);
            }
            for(int m = (i*2)-2;m>=i;m--){
                System.out.printf("%2d",m%10);
            }
            System.out.println("");
        }*/
        
        /*
         1 2 3 4 5 4 3 2 1
         1 2 3 4   4 3 2 1
         1 2 3       3 2 1
         1 2           2 1
         1               1
        
        for(int i = 0;i<size;i++){
            for(int j = 0;j<size-i;j++){
                System.out.printf("%2d",j+1);
            }
            for(int k = 0;k<(i*2)-1;k++){
                System.out.printf("%2s"," ");
            }
            for(int m = size-i;m>0;m--){
                if(m == size){
                    m = size-1;
                }
                System.out.printf("%2d",m);
            }
            System.out.println("");
        }*/
        
        /*
         1               1
         1 2           2 1
         1 2 3       3 2 1
         1 2 3 4   4 3 2 1
         1 2 3 4 5 4 3 2 1
        
        for(int i = 0;i<size;i++){
            for(int j = 0;j<=i;j++){
                System.out.printf("%2d",j+1);
            }
            for(int k = 2*(size-i)-3;k>0;k--){
                System.out.printf("%2s"," ");
            }
            for(int m = i+1;m>0;m--){
                if(m >= 4){
                    m =4;
                }
                System.out.printf("%2d",m);
            }System.out.println("");
        }*/
        
        /*
         1 2 3 4 5 4 3 2 1
           1 2 3 4 3 2 1
             1 2 3 2 1
               1 2 1
                 1
        
        for(int i =0;i<size;i++){
            for(int j = 0;j<i;j++){
                System.out.printf("%2s"," ");
            }
            for(int k = 1;k<=size-i;k++){
                System.out.printf("%2d",k);
            }
            for(int l = size-i-1;l>0;l--){
                System.out.printf("%2d",l);
            }System.out.println("");
        }*/
        
        /*
                1
              1 2 1
            1 2 3 2 1
          1 2 3 4 3 2 1
        1 2 3 4 5 4 3 2 1
        
        for(int i =1;i<=size;i++){
            for(int j = 0;j<size-i;j++){
                System.out.printf("%2s"," ");
            }
            for(int k = 1;k<=i;k++){
                System.out.printf("%2d",k);
            }
            for(int l = i-1;l>0;l--){
                System.out.printf("%2d",l);
            }System.out.println("");
        }*/
        
        /*
        5 4 3 2 1
        4 3 2 1
        3 2 1
        2 1
        1
        for(int i = 0;i<size;i++){
            for(int j = size-i;j>0;j--){
                System.out.printf("%2d",j);
            }System.out.println("");
        }*/
        
        /*
                1
              2 1
            3 2 1
          4 3 2 1
        5 4 3 5 1
        
        for(int i = 1;i<=size;i++){
            for(int j = size;j>i;j--){
                System.out.printf("%2s"," ");
            }
            for(int k = i;k>0;k--){
                System.out.printf("%2d",k);
            }System.out.println("");
        }*/
        
        /*
            1 2 3 4 5
              1 2 3 4
                1 2 3
                  1 2
                    1
        for(int i = 0;i<size;i++){
            for(int j = 1;j<= i;j++){
                System.out.printf("%2s"," ");
            }
            for(int k = 1;k <= size-i;k++){
                System.out.printf("%2d",k);
            }System.out.println("");
        }*/
        
        /*
            1
            1 2
            1 2 3
            1 2 3 4
            1 2 3 4 5
        
        for(int i = 1;i<=size;i++){
            for(int j = 1;j<=i;j++){
                System.out.printf("%2d",j);
            }System.out.println("");
        }*/
        
        /*
                    #
                  # # #
                # # # # #
              # # # # # # #
            # # # # # # # # #
          # # # # # # # # # # #
            # # # # # # # # #
              # # # # # # #
                # # # # #
                  # # #
                    #
        for(int i = 0;i<=size;i++){
            for(int j = 0;j<size-i;j++){
                System.out.printf("%2s"," ");
            }
            for(int k = 0;k<i*2+1;k++){
                System.out.printf("%2s","#");
            }System.out.println("");
        }
        for(int i = 1;i<=size;i++){
            for(int k = 0;k<i;k++){
                System.out.printf("%2s"," ");
            }
            for(int j =0;j<=(size-i)*2;j++){
                System.out.printf("%2s","#");
            }System.out.println("");
        }*/
        
        /*
                    #
                  # # #            
                # # # # #           
              # # # # # # #         
            # # # # # # # # #   
        for(int i = 0;i<=size;i++){
            for(int j = 0;j<size-i;j++){
                System.out.printf("%2s"," ");
            }
            for(int k = 0;k<i*2+1;k++){
                System.out.printf("%2s","#");
            }System.out.println("");
        }*/
        
        /*
        # # # # # # # # # # #   
          # # # # # # # # #   
            # # # # # # #     
              # # # # #    
                # # #      
                  #    
        
        for(int i = 0;i<size;i++){
            for(int k = 0;k<i;k++){
                System.out.print("  ");
            }
            for(int j =0;j<=(size-i)*2;j++){
                System.out.print("# ");
            }System.out.println("");
        }*/
        
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
