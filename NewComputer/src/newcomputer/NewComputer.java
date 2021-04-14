/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newcomputer;

/**
 *
 * @author KELVO FRAYAY
 */
public class NewComputer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final double x=375.99;
        double screen,screen1,screen2,printer,antivirus,other,total;
        screen1=75.99;
        screen2=99.99;
        printer=125.00;
        antivirus=65.99;
        screen=screen2;
        other=printer;
        total=x+screen+other;
        System.out.println("Total cost = "+total);
        // TODO code application logic here
    }
    
}
