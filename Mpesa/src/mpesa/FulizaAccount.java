/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mpesa;


public class FulizaAccount extends MpesaAccount {
    private double overdraftLimit;
    
    public FulizaAccount(String numberIn, String nameIn, String pinIn,double limitIn) {
        super(numberIn, nameIn, pinIn);
        overdraftLimit= limitIn;
    }
    public void setLimit(double limitIn){
        overdraftLimit = limitIn;
    }
    public double getLimit(){
        return overdraftLimit;
    }
    @Override
    public boolean withdraw(double amountIn){
        if(amountIn<=balance+overdraftLimit){
            balance= balance- amountIn;
            return true;
        }
        else{
            return false;
        }
    }
}
