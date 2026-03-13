package minibank;
import java.util.Scanner;
public class bankAccount {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Bank account = new Bank();

        System.out.println(" == Welcome to Rafa's Bank ^^  == ");
        //Owner's name 
        System.out.println("Type your first name: ");
        account.setOwner(input.next());
        //Choose account type
        account.accType(input);
        System.out.println("Selected account type: " + account.getType());
        //Assign account number
        account.setAccNumber(123456);
        System.out.println("Your account number: " + account.getAccNumber());
        //Open account
        account.openAccount();

        int choose = -1;
        do {
            if (account.isStatus()){
                //Bank menu
                System.out.println("======= Rafa's Bank ========");
                System.out.println("[1] Deposit");
                System.out.println("[2] Withdraw");
                System.out.println("[3] Pay monthly fee");
                System.out.println("[4] Display account status");
                System.out.println("[5] Close account");
                System.out.println("[0] Exit");
                choose = input.nextInt();
           
                switch (choose) {
                    // Deposit
                    case 1:
                    System.out.println("Enter deposit amount");
                    double amount = input.nextDouble();
                    account.deposit(amount);
                        break;
                    // withdraw
                    case 2:
                    System.out.println("Enter withdraw amount: ");
                    amount = input.nextDouble();
                    account.withdraw(amount);
                        break;
                    //Monthly fee
                    case 3:
                        account.monthlyFee();
                        break;
                    //Display acc status
                    case 4:
                        account.displayStatus();
                        break;
                    //Close account
                    case 5:
                        account.closeAccount();
                        if (!account.isStatus()){
                        choose = 0;
                    }
                        break;
                    //Exit
                    case 0:
                        System.out.println("..Exiting..");
                        break;
                    default:
                        System.out.println("Invalid option");
                        break;
               }
            } else { 
                System.out.println("Account closed");
            }
            System.out.println("");
        } while (choose !=0);
        input.close();

    }
    
}
 