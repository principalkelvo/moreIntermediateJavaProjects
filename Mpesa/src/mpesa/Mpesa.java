/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mpesa;
import java.util.ArrayList;
/**
 *
 * @author KELVO FRAYAY
 */
public class Mpesa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        double fulizaBalance,mpesaBalance;
        
        MpesaAccount mpesa= new MpesaAccount("0799444133","mpesa account","4478");
        MshwariAccount mshwari= new MshwariAccount("123","mshwari account","9997",500);
        FulizaAccount fuliza= new FulizaAccount("123","fuliza account","9997",300);
        mpesaBalance=(mpesa.getBalance()+mshwari.getBalance()+fuliza.getBalance());
        mpesa.deposit(300);
        mshwari.depositToMshwari(100);
        mpesa.withdraw(50);
        fulizaBalance= (mpesa.getBalance()+mshwari.getBalance());
        fuliza.setBalance(fulizaBalance);
        fuliza.withdraw(300);
        mshwari.withdraw(0);
        System.out.println("mpesa balance: "+mpesaBalance);
        System.out.println("mshwari balance: "+mshwari.getMshwariBalance());
        System.out.println("fuliza balance: "+fuliza.getBalance());
        System.out.println("mshwari balance: "+mshwari.getBalance());
        
        
        //mpesa app with java
        //we will use the easyscanner method instead of keyboardScanner
        //register for mpesa account
        ArrayList<MpesaAccount>mpesaUser= new ArrayList<>();
        char choice;
        String name,number,pin;
        System.out.println(" M-PESA Activate");
        //get details from user
        System.out.println("Enter number: ");
        number= EasyScanner.nextString();
        System.out.println("Enter name: ");
        name= EasyScanner.nextString();
        System.out.println("Enter pin: ");
        pin=EasyScanner.nextString();
        //add account to list
        boolean success= mpesaUser.add(new MpesaAccount (number,name,pin));
        if(success){
            System.out.println("Account added Successfully");
        }
        else{
            System.out.println("Registrarion unsuccessfull");
        }
        
        do{
        System.out.println(" M-PESA");
        //drop-down menu
        System.out.println("1.Send money");
        System.out.println("2.Withdraw money");
        System.out.println("3.Buy Airtime");
        System.out.println("4.Loans and Savings");
        System.out.println("5.Lipa na mpesa");
        System.out.println("6.My Account");
        System.out.println("7.quit");
        System.out.println();
        System.out.print("Enter choice 1-7: ");
        choice=EasyScanner.nextChar();
        System.out.println();
        switch(choice){
            case '1': sendMoney(mpesaUser);
                    break;
            case '2': withdrawMoney(mpesaUser);
                    break;
            case '3': buyAirtime(mpesaUser);
                    break;
            case '4': loansSavings(mpesaUser,number,name,pin);
                        
            case '5': lipaNaMpesa(mpesaUser);
                    break;
            case '6': accountDetails(mpesaUser);
                    break;
            default: System.out.println("Enter choices 1-7 only");
        }
        }while(choice!='7');
    }
    
    static void sendMoney(ArrayList mpesaUserIn){
        System.out.println("Enter number to Send");
        String number= EasyScanner.nextString();
        System.out.println("Enter amount to Send");
        double amount= EasyScanner.nextDouble();
        
        MpesaAccount item= (MpesaAccount) mpesaUserIn.get(0);//change to object
        
        item.setBalance(100);//lets set balance to 100..just for testing
        
        boolean pass= item.withdraw(amount);//decrease mpesa account balance.
        if(pass){
        System.out.println("Confirmed "+ amount+" sent to "+number
                +".Your balance is "+item.getBalance());
        }
        else{
            System.out.println("low balance");
        }
    }
    static void withdrawMoney(ArrayList mpesaUserIn){
        System.out.println("Enter agent number");
        String agent= EasyScanner.nextString();
        System.out.println("Enter amount to withdraw");
        double amount= EasyScanner.nextDouble();
        MpesaAccount item= (MpesaAccount) mpesaUserIn.get(0);//change to object
        
        item.setBalance(100);//lets set balance to 100..just for testing
        
        boolean pass= item.withdraw(amount);//decrease mpesa account balance.
        if(pass){
        System.out.println("Confirmed you have widthdrawn "+ amount+" from "+agent
                +".Your balance is "+item.getBalance());
        }
        else{
            System.out.println("low balance");
        }
    }
    static void buyAirtime(ArrayList mpesaUserIn){
        System.out.println("Enter amount of airtime");
        double amount= EasyScanner.nextDouble();
        
        MpesaAccount item= (MpesaAccount) mpesaUserIn.get(0);//change to object
        
        item.setBalance(100);//lets set balance to 100..just for testing
        
        boolean pass= item.withdraw(amount);//decrease mpesa account balance.
        if(pass){
        System.out.println("Confirmed you bought"+ amount
                +" of airtime.Your balance is "+item.getBalance());
        }
        else{
            System.out.println("low balance");
        }
    }
    static void loansSavings(ArrayList mpesaUserIn, String numberIn, String nameIn, String pinIn) {
        MshwariAccount mshwari;
        String pin;
        //confirm pin
        System.out.println("Enter Mpesa pin to activate");
        pin = EasyScanner.nextString();
        for(int i=0;i<pinIn.length();i++){
            while(pin.charAt(i)!= pinIn.charAt(i)){
                System.out.println("Registration failed.");
                System.out.println("Enter Mpesa pin to activate");
                pin = EasyScanner.nextString();
            }
        }
        System.out.println("Registration Successfully");
        //deposit to open account
        System.out.println("Enter amount to deposit to mshwari");
        double amount = EasyScanner.nextDouble();
        mshwari = new MshwariAccount(numberIn, nameIn, pin, amount);
        char choosen;
        do {
            System.out.println("1.Send to mshwari");
            System.out.println("2.Withdraw from mshwari");
            System.out.println("3.Lock savings account");
            System.out.println("4.Loan");
            System.out.println("5.check balance");
            System.out.println("6.Mini Statement");
            System.out.println("7.Back");
            System.out.print("Enter choice 1-7: ");
            System.out.println();
            choosen = EasyScanner.nextChar();
            System.out.println();

            switch (choosen) {
                case '1': sendToMshwari(mshwari,mpesaUserIn);
                    break;
                case '2':withdrawFromMshwari(mshwari,mpesaUserIn);
                    break;
                case '3':lockSavingsAccount(mshwari);
                    break;
                case '4':loan(mshwari);
                    break;
                case '5':checkBalance(mshwari);
                    break;
                case '6':miniStatement(mshwari);
                    break;
                default: System.out.println("Enter choices 1-7 only");
            }
        } while (choosen != '7');

    }
    static void lipaNaMpesa(ArrayList mpesaUserIn){
        
    }
    static void accountDetails(ArrayList mpesaUserIn){
        
    }
    
    
    //Mshwari methods
    //method from another method
    static void sendToMshwari(MshwariAccount mshwariIn,ArrayList mpesaUserIn){
        MpesaAccount mpesaIn= (MpesaAccount) mpesaUserIn.get(0);
        mpesaIn.setBalance(100);
        System.out.println("enter amount to deposit to mshwari: ");
        double amount= EasyScanner.nextDouble();
        boolean pass= mshwariIn.depositToMshwari(amount); 
        if(pass){
            System.out.println("confirmed you deposited "+amount+" to mshwari account"+'\n'
                +" your Mshwari balance: "+mshwariIn.getMshwariBalance()+".Mpesa balance: "+'\n'
                + (mpesaIn.getBalance()+mshwariIn.getBalance()));
        }
        else{
            System.out.println("No enough Money"+'\n'+"Mpesa balance: "
                    +mshwariIn.getBalance());
        }
        
    }
    static void withdrawFromMshwari(MshwariAccount mshwariIn,ArrayList mpesaUserIn){
        MpesaAccount mpesaIn= (MpesaAccount) mpesaUserIn.get(0);
        System.out.println("enter amount to withdraw from mshwari: ");
        double amount= EasyScanner.nextDouble();
        boolean success=mshwariIn.withdraw(amount);
        if(success){
            System.out.println("confirmed you have withdrawn "+amount+" from mshwari account"+'\n'
                +" your Mshwari balance: "+mshwariIn.getMshwariBalance()+'\n'
                    +"Mpesa balance: "+ (mpesaIn.getBalance()+mshwariIn.getBalance()));
        }
        else{
            System.out.println("No enough Money");
        }
    }
    static void lockSavingsAccount(MshwariAccount mshwariIn){
        char choice;
        do {
            System.out.println("1.Save");
            System.out.println("2.Withdraw from savings");
            System.out.println("3.back");
            choice= EasyScanner.nextChar();
            switch(choice){
                case '1': System.out.println("Enter amount to save");
                          double amount= EasyScanner.nextDouble();
                          
                          boolean pass=mshwariIn.depositToSavings(amount);
                          if (pass){
                               System.out.println("Mshwari savings: "+mshwariIn.getSavings());
                           }
                           else{
                               System.out.println("you have insufficient funds"+'\n'
                                       +".Mshwari balance: "+mshwariIn.getBalance());
                           }
                          
                    break;
                case '2': System.out.println("Enter amount to withdraw from savings");
                           double withdrawAmount= EasyScanner.nextDouble();
                           boolean success= mshwariIn.withdrawFromSavings(withdrawAmount);
                           if (success){
                               System.out.println("confirmed you have withdrawn "+withdrawAmount+" from savings account"+'\n'
                +" your Mshwari balance: "+mshwariIn.getMshwariBalance()+'\n'
                    +"savings balance: "+ mshwariIn.getSavings());
                           }
                           else{
                               System.out.println("you have insufficient funds"+'\n'
                                       +".Mshwari savings: "+mshwariIn.getSavings());
                           }
                    break;
                default: System.out.println("Enter choices 1-3 only");
            }
        }while(choice!='3');
        
    }
   static void loan(MshwariAccount mshwariIn){
       char choice;
        do {
            mshwariIn.setLoanLimit(300);
            System.out.println("1.Request loan");
            System.out.println("2.Pay loan");
            System.out.println("3.Check Loan limit");
            System.out.println("4.check loan balance");
            System.out.println("5.Back");
            choice= EasyScanner.nextChar();
            switch(choice){
                case '1': System.out.println("enter amount to be lent: ");
                          double amount= EasyScanner.nextDouble();
                          boolean pass=mshwariIn.requestLoan(amount);
                          if (pass){
                               System.out.println("confirmed you have received loan: "+amount
                               +" Mshwari balance: "+mshwariIn.getMshwariBalance());
                           }
                           else{
                               System.out.println("your loan limit is:"+mshwariIn.getLoanLimit());
                           }
                          
                    break;
                case '2': System.out.println("Enter amount to pay: ");
                           double payAmount= EasyScanner.nextDouble();
                           boolean success= mshwariIn.payLoan(payAmount);
                           if (success){
                               System.out.println("confirmed you have received loan: "+payAmount
                               +" Mshwari balance: "+mshwariIn.getMshwariBalance()+'\n'
                                       +"Your outstamding loan: "+mshwariIn.getLoan());
                           }
                           else{
                               System.out.println("you have insufficient funds"+'\n'
                                       +".Mshwari balance: "+mshwariIn.getMshwariBalance());
                           }
                    break;
                case '3': System.out.println("Loan limit: "+ mshwariIn.getLoanLimit());
                    break;
                case '4': System.out.println("Outstanding Loan balance: "+ mshwariIn.getLoan()+'\n');
                    break;
                    
                default: System.out.println("Enter choices 1-5 only");
            }
        }while(choice!='5');
        
    }
   static void checkBalance(MshwariAccount mshwariIn){
        
        System.out.println("Mshwari balance: "+mshwariIn.getMshwariBalance()+'\n'
                +"Outstanding loan: "+mshwariIn.getLoan()+'\n'
                +"your savings: "+mshwariIn.getSavings());
    }
   static void miniStatement(MshwariAccount mshwariIn){
    }
}
