/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mpesa;


public class MshwariAccount extends MpesaAccount {
    
    private double loan;
    private double loanLimit;
    private double mshwariSave;
    private double interestRate;
    private double mshwariBalance;
    private double save;
    
    //constructor
    public MshwariAccount(String numberIn, String nameIn, String pinIn,double saveIn) {
        super(numberIn, nameIn, pinIn);
        loan=0;
        loanLimit=0;
        mshwariBalance= saveIn;
        save=0;
    }
    //sets
    public void setLoan(double loanIn){
        loan=loanIn;
    }
    public void setSaving(double saveIn){
        save=saveIn;
    }
    public void setLoanLimit(double limitIn){
        loanLimit= limitIn;
    }
    public void setInterestRate(double rateIn){
        interestRate= rateIn;
    }
    //gets
    public double getLoan(){
        return loan;
    }
    public double getLoanLimit(){
        return loanLimit;
    }
    public double getInterestRate(){
        return interestRate;
    }
    public double getSavings(){//lock savings account
        return save;
    }
    
    public double getMshwariBalance(){
        return mshwariBalance;
    }
    //methods for loan
    public boolean requestLoan(double amountIn){
        if(amountIn<=loanLimit){
            loan= loan+amountIn;
            loanLimit= loanLimit-amountIn;
            mshwariBalance= mshwariBalance+ amountIn;
            return true;
        }
        else{
            return false;
        }
    }
    public boolean payLoan(double amountIn){
        if(amountIn<=mshwariBalance&&loan>0){
            loan= loan-amountIn;
            loanLimit= loanLimit+amountIn;
            mshwariBalance= mshwariBalance - amountIn;
            return true;
        }
        else{
            return false;
        }
    }
    //methods for savings
    public boolean depositToSavings(double amountIn){
        if(amountIn<= mshwariBalance){
            save= save+amountIn;
            mshwariBalance=mshwariBalance-amountIn;
            return true;
        }
        else{
            return false;
        }
        
    }
    
    public boolean withdrawFromSavings(double amountIn){
        if(amountIn<= save){
            save= save- amountIn;
            mshwariBalance= mshwariBalance+ amountIn;
            return true;
        }
        else{
            return false;
        }
    }
    //method for interest
    public void addInterestRate(){
        mshwariBalance= mshwariBalance+(mshwariBalance*interestRate)/100;
    }
    //methods for mshwari main account
   public boolean depositToMshwari(double amountIn){
       if(amountIn<= mshwariBalance){
            mshwariBalance=mshwariBalance+amountIn;
            balance= balance-amountIn;
            return true;
       }
       else{
           return false;
       }
    }
    
    @Override
    public boolean withdraw(double amountIn){
        if(amountIn<= mshwariBalance){
            mshwariBalance= mshwariBalance- amountIn;
            balance= balance+ amountIn;
            return true;
        }
        else{
            return false;
        }
    }
}
