/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mpesa;

/**
 *
 * @author KELVO FRAYAY
 */
public class MpesaAccount {
    //attributes
    private String accountNumber;
    private String accountName;
    private String pin;
    protected double balance;
    
    //constructor
    public MpesaAccount(String numberIn,String nameIn,String pinIn){
        accountNumber= numberIn;
        accountName= nameIn;
        pin= pinIn;
        balance= 0; 
    }
    public void setPin(String pinIn){
        pin= pinIn;
    }
    public void setBalance(double balanceIn){
        balance= balanceIn;
    }
    public String getAccountNumber(){
        return accountNumber;
    }
    public String getAccountName(){
        return accountName;
    }
    public String getPin(){
        return pin;
    }
    public double getBalance(){
        return balance;
    }
    public void deposit(double amountIn){
        balance= balance+ amountIn;
    }
    public boolean withdraw(double amountIn){
        if(amountIn<= balance){
            balance= balance-amountIn;
            return true;
        }
        else{
            return false;
        }
    }
    
}