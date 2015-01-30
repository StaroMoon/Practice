/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author StaroMoon
 */
public class practice2 {
    public static int[] grades;     //Declare an int array of grades, to be allocated later
    public static int[] bins = new int[10];     //Declare and allocate an int array for histogram bins.
        // 10 bins for 0-9, 10-19,..., 90-100
    public static int largest;
    public static void main(String[] args) throws FileNotFoundException{
        readGrades("grades.in");
        computeHistogram();
        printHistogramHorizontal();
        printHistogramVertical();
    }
    
    //Read the grades from "filename", store in "grades" array.
    //Assume that the inputs are valid.
    public static void readGrades(String filename) throws FileNotFoundException{
        Scanner in = new Scanner(new File(filename + ".txt"));
        int number = in.nextInt();
        System.out.println("Number of student : " + number);
        grades = new int[number];
        System.out.print("Score of each students : ");
        for(int i = 0;i < number;i++){
            grades[i] = in.nextInt();
            System.out.printf("%d ",grades[i]);
        }
    }
    
    //Based on "grades" array, populate the "bins" array.
    public static void computeHistogram(){
        for(int i = 0;i<grades.length;i++){
            if(grades[i] >= 0 && grades[i] <= 9){           bins[0]++;}
            else if(grades[i] >= 10 && grades[i] <= 19){    bins[1]++;}
            else if(grades[i] >= 20 && grades[i] <= 29){    bins[2]++;}
            else if(grades[i] >= 30 && grades[i] <= 39){    bins[3]++;}
            else if(grades[i] >= 40 && grades[i] <= 49){    bins[4]++;}
            else if(grades[i] >= 50 && grades[i] <= 59){    bins[5]++;}
            else if(grades[i] >= 60 && grades[i] <= 69){    bins[6]++;}
            else if(grades[i] >= 70 && grades[i] <= 79){    bins[7]++;}
            else if(grades[i] >= 80 && grades[i] <= 89){    bins[8]++;}
            else if(grades[i] >= 90 && grades[i] <= 100){   bins[9]++;}
            else{System.out.println("Invalid number");}
            
            for(int j = 0;j<bins.length;j++){
                if(bins[j] > largest){
                    largest = bins[j];
                }
            }
        }
    }
    
    //Print histogram based on the "bins" array.
    public static void printHistogramHorizontal(){
        System.out.println("");
        for(int i =0;i<bins.length;i++){
            if(i != 9){
                System.out.printf("%2d - %2d : ",i*10,(i*10+9));
            }else{
                System.out.printf("%2d -%2d : ",i*10,(i*10+10));
            }
            for(int j = 0;j<bins[i];j++){
                System.out.print("* ");
            }System.out.printf("\n");
        }
    }
    
    //Print histogram based on the "bins" array.
    public static void printHistogramVertical(){
        System.out.println("");
        for(int i = largest;i>0;i--){
            for(int j = 0;j < bins.length;j++){
                if(bins[j] < i){
                    System.out.printf("%3s%-3s"," "," ");
                }else{
                    System.out.printf("%3s%-3s","*"," ");
                }
            }System.out.println("");
        }
        for(int k = 0;k<bins.length;k++){
            if(k!=9){
                System.out.printf("%2s-%-3s",k*10,(k*10+9));
            }else{
                System.out.printf("%2s-%-3s",k*10,(k*10+10));
            }
        }
    }
}
