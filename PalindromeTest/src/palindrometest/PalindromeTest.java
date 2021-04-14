/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palindrometest;

/**
 *
 * @author KELVO FRAYAY
 */
public class PalindromeTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String newString = "";
        String reverseString = "";
        System.out.print("Enter a string to check if is a palindrome: ");
        String inputString = EasyScanner.nextString();
        int length = inputString.length();
        int ifInALoop= 1;
       // String sub="";
        
        for(int i=0; i<=length;i++){
            for(int j=i+1; j<=length;j++){
                //sub= inputString.substring(i, j);
                //System.out.println("SUBSTRING "+inputString.substring(i, j));
                for (int k = inputString.substring(i, j).length() - 1; k >= 0; k--) {
                    newString = newString + inputString.substring(i, j).charAt(k);
                       // System.out.println("NEWsTRNG "+newString);
                        
                      
                    
                }
                for (int m = newString.length() - 1; m >= 0; m--) {
                    reverseString = reverseString + newString.charAt(m);
                        //System.out.println("reverse 02 "+reverseString);
                        
                         
                    
                    }
                if (newString.equalsIgnoreCase(reverseString)&& reverseString.length()>1){
                        System.out.println(reverseString);
                        ifInALoop= 2;
                }
                
                
                    newString= "";
                      
                    reverseString= ""; 
            }
        }
       if (ifInALoop== 1){
           System.out.println("No palindrome words");
       }
        
            
        /*for (int k = length - 1; k >= 0; k--) {
            reverseString = reverseString + inputString.charAt(k);
            System.out.println("reverse "+reverseString);
        }*/
        
        
        
       
       /* if (inputString.equalsIgnoreCase(reverseString)) {
            System.out.println("The input string is a palindrome");
        } else {
            System.out.println("The input string is not a palindrome ");
        }*/
    }

}