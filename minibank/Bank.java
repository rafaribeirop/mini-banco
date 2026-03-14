package minibank;
import java.util.Scanner;

public class Bank {
    private int accNumber;
    private String type;
    private String owner;
    private double balance;
    private boolean status;
    
    public void displayStatus(){
    //  Display account status
    System.out.println("Status: " + (status? "Open": "Closed"));
       if (isStatus()){
            System.out.println("Account number: " + this.getAccNumber());
            System.out.println("Name: " + this.getOwner());
            System.out.println("Account type: "+ this.getType());
            System.out.format("Balance: $ %.2f%n",   this.getBalance());
       } 
    }
    // Set acc type (checking or savings)
    public void accType(Scanner input){
        int accType;
        do {
            System.out.println(getOwner() +", which type of account would you like to open?");
            System.out.println("[1] - Checking | [2]- Savings");
            accType = input.nextInt();
            if (accType !=1 && accType !=2) {
                System.out.println("Invalid option - please try again!");
            }
        } while (accType != 1 && accType !=2);

        if (accType == 1){
            setType("Checking");
        } else if (accType == 2){
            setType("Savings");
        }
    }
    
    //Getters and Setters
    public int getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(int accNumber) {
        this.accNumber = accNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance){
        this.balance = balance;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void openAccount(){
        this.status = true;
        monthlyFeePaid = false;

    }
    
    public void closeAccount(){
        if (getBalance() > 0){
            System.out.println("Your account still has a balance of $" + this.getBalance());
            System.out.println("You cannot close the account yet!");
        } else {
            this.setStatus(false);
            System.out.println("Account successfully closed!");
        }
    }

    //Withdraw money
    public void withdraw(double amount){
        if (!isStatus()){
            System.out.println("Your account is closed");
        } else {
            if (getBalance() >= amount){
                setBalance(getBalance() - amount);
                System.out.println("Withdrawal of $" + amount + " successful!");
                System.out.println("Current balance: $" + this.getBalance());
            } else {
                System.out.println("INSUFFICIENT FUNDS");
            }
        }
    }  
    //Deposit money
    public void deposit(double amount){
        if (!isStatus()){
            System.out.println("Your account is closed");
        } else {
            setBalance(getBalance() + amount);
            System.out.println("Deposit of $" + amount + " successful!");
            System.out.println("Current balance: $" + this.getBalance());
        }
    }

    //Monthly fee
    private boolean monthlyFeePaid = false;
    public void monthlyFee(){
        if(!isStatus()){
            System.out.println("Your account is closed");
        } else {
            //Fee: Checking = $12 | Savings = $20
            int fee = (getType().equalsIgnoreCase("Checking")? 12:20);
             if (monthlyFeePaid){
                System.out.println("Monthly fee already paid");
            }
            if (!monthlyFeePaid){
                if (getBalance() >= fee){
                    setBalance(getBalance() - fee);
                    System.out.println("Monthly fee of $" + fee + " paid");
                    monthlyFeePaid = true;
                } else {
                    System.out.println("Insufficient balance for monthly fee");
                }
            }
        }
    }
}
