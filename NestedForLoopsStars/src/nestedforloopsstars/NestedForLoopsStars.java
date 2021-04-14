/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nestedforloopsstars;

/**
 *
 * @author KELVO FRAYAY
 */
public class NestedForLoopsStars {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        for (int j=1;j<=2;j++){
            System.out.println();
            for (int i=1;i<=3;i++){
                System.out.print("*"); 
            }
        }
        System.out.println();
        for (int i=1;i<=2;i++){
            for (int j=1;j<=6;j++){
                System.out.print("*");
            }
            System.out.println();
        }
        for (int j=1;j<=2;j++){
            for (int i=1;i<=3;i++){
                System.out.print("*"); 
            }
            System.out.println();
        }
        
        // TODO code application logic here
    }
    
}
