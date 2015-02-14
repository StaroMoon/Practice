
import java.util.Scanner;

public class WordGuess {
    
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String word = "iamthebesthehe";
        int wordl = word.length();
        boolean[] check = new boolean[wordl];
        args = new String[wordl];
        int count=0;
        
        for(int i = 0;i<wordl;i++){
            check[i] = false;
        }
        
        for(int i = 0;i<100;i++){
            System.out.printf("Key in one character or your guess word: ");
            String inword = in.next();
            int inputl = inword.length();
            
            if(inputl == wordl){
                if(inword.equals(word)){
                    System.out.printf("Trail %d: Congratulation!!!\n",i+1);
                    System.out.printf("You got in %d trials",i+1);
                    System.exit(0);
                }else{
                    System.out.println("You are wrong.");
                }
            }else if(inputl == 1){
                System.out.printf("Trail %d: ",i+1);
                for(int j = 0;j<wordl;j++){
                    if(inword.charAt(0) == word.charAt(j)){
                        check[j] = true;
                        count++;
                    }
                    if(check[j]){
                        args[j] = word.valueOf(word.charAt(j));
                    }else{
                        args[j] = "_";
                    }
                    if(count == wordl){
                        System.out.println("Congratulation!");
                        System.out.printf("You got in %d trials",i+1);
                        System.exit(0);
                    }else{
                        System.out.printf("%2s",args[j]);
                    }
                }
                System.out.println("");
            }else{
                System.out.println("Insert one characther or guess word");
                i--;
            }
        }
    }
}
