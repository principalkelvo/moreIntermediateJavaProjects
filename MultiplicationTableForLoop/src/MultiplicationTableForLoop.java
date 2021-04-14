import java.util.Scanner;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author KELVO FRAYAY
 */
public class MultiplicationTableForLoop {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        char reply;
        Scanner keyboard = new Scanner(System.in);
        int j;
        do{
        System.out.println("Input a whole number");
        j=keyboard.nextInt();
        while(j<2){
            System.out.println("Sorry,please input a Whole number greater than two");
            j=keyboard.nextInt();
        }
        for(int i=1;i<=12;i++){
                System.out.println(i+" X "+j+" = "+i*j);
        }
        System.out.println("would you like to repeat(y/n)?");
        reply=keyboard.next().charAt(0);
        }
        while(reply=='y'||reply=='Y');
        // TODO code application logic here
        
        }
}