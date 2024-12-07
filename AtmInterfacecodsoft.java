import java.util.Scanner;
        //Java Programming Internship Task 3 by  ANUKRITI BISHT
class BankAccount {
    private double balance;

    public BankAccount(double StartingBalance) {
        balance = StartingBalance;
    }

    public double fetchBalance() {
        return balance;
    }

    public void Credit(double amount) {
        balance = balance + amount;
    }

    public boolean Debit(double amount) {
        if (amount <= balance) {
            balance =balance - amount;
            return true;
        }
        return false;
    }
}       //Java Programming Internship Task 3 by  ANUKRITI BISHT

class ATM {
    private BankAccount account;

    public ATM(BankAccount bankAccount) {
        account = bankAccount;
    }

    public void displayATMMenu() {
        System.out.println("WELCOME to the ATM ");
        System.out.println("1. Check Balance of Your  Account");
        System.out.println("2. Deposit Amount to Your Account");
        System.out.println("3. Withdraw Amount from Your Account");
        System.out.println("4. Exit the ATM");
    }       //Java Programming Internship Task 3 by  ANUKRITI BISHT

    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayATMMenu();
            System.out.print("Please select an option: ");
            int ch= scanner.nextInt();

            switch (ch) {
                case 1:
                    System.out.println("Your balance is: Rs. " + account.fetchBalance());
                    break;
                case 2:
                    System.out.print("Enter amount to be deposited: ");
                    double AmountDeposit = scanner.nextDouble();
                    account.Credit(AmountDeposit);
                    System.out.println("Deposit successful. Your balance is: Rs. " + account.fetchBalance());
                    break;
                case 3:
                    System.out.print("Enter amount to be withdrawn: ");
                    double AmountWithdrwan = scanner.nextDouble();
                    if (account.Debit(AmountWithdrwan)) {
                        System.out.println("Withdrawal successful. Your balance is: Rs. " + account.fetchBalance());
                    } else {
                        System.out.println("Insufficient Balance in your account.");
                    }
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM");
                    scanner.close();
                    return;
                default:
                    System.out.println("Please select a valid option.");
            }
        }
    }
}       //Java Programming Internship Task 3 by  ANUKRITI BISHT

public class codsoft {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000); // Initial balance
        ATM atm = new ATM(userAccount);
        atm.run();
    }
}           //Java Programming Internship Task 3 by  ANUKRITI BISHT