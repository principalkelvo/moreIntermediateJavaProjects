/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package overridingdemo;

/**
 *
 * @author KELVO FRAYAY
 */
public class OverridingDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean ok;
        //declare BankAccount obbject
        BankAccount bankAcc= new BankAccount("123","Ordinary account");
        
        //declare a GoldAccount object
        GoldAccount goldAcc= new GoldAccount ("A124","Gold account",500);
        //deposit in all accounts
        bankAcc.deposit(1000);
        goldAcc.deposit(1000);
        //withdrawal of amount more than balance
        ok= bankAcc.withdraw(1250);//the withdraw method of BankAccount is called
        if (ok){
            System.out.println("money withdrawn.");
        }
        else{
            System.out.println("Insufficient Funds");
        }
        System.out.println("Balance of "+bankAcc.getAccountName()+" is "
                +bankAcc.getBalance());
        System.out.println();
        
        ok= goldAcc.withdraw(1250);//the withdraw method of GoldAccount is called
        if (ok){
            System.out.println("money withdrawn.");
        }
        else{
            System.out.println("Insufficient Funds");
        }
        System.out.println("Balance of "+goldAcc.getAccountName()+" is "
                +goldAcc.getBalance());
        System.out.println();
    }
    
}
