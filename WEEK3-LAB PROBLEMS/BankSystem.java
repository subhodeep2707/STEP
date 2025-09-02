// Program: Bank Account Management System
import java.util.Scanner;

class BankAccount {
    // Private instance variables
    private String accountNumber;
    private String accountHolderName;
    private double balance;

    // Static variables
    private static int totalAccounts = 0;
    private static int accountCounter = 1;

    // Constructor
    public BankAccount(String name, double initialDeposit) {
        this.accountHolderName = name;
        this.balance = initialDeposit;
        this.accountNumber = generateAccountNumber();
        totalAccounts++;
    }

    // Generate unique account number like ACC001, ACC002
    private static String generateAccountNumber() {
        return String.format("ACC%03d", accountCounter++);
    }

    // Deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    // Withdraw money with validation
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount!");
        } else if (amount > balance) {
            System.out.println("Insufficient funds!");
        } else {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        }
    }

    // Check balance
    public void checkBalance() {
        System.out.println("Current Balance: " + balance);
    }

    // Display account details
    public void displayAccountInfo() {
        System.out.println("----- Account Info -----");
        System.out.println("Account No: " + accountNumber);
        System.out.println("Holder Name: " + accountHolderName);
        System.out.println("Balance: " + balance);
        System.out.println("-------------------------");
    }

    // Static method to get total accounts
    public static int getTotalAccounts() {
        return totalAccounts;
    }
}

public class BankSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create array of BankAccount objects
        System.out.print("Enter number of accounts to create: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline
        BankAccount[] accounts = new BankAccount[n];

        // Create accounts
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Account " + (i + 1));
            System.out.print("Account Holder Name: ");
            String name = sc.nextLine();
            System.out.print("Initial Deposit: ");
            double deposit = sc.nextDouble();
            sc.nextLine();
            accounts[i] = new BankAccount(name, deposit);
        }

        // Perform transactions on first account as demo
        System.out.println("\nPerforming transactions on first account...");
        accounts[0].displayAccountInfo();
        accounts[0].deposit(2000);
        accounts[0].withdraw(1000);
        accounts[0].checkBalance();
        accounts[0].displayAccountInfo();

        // Display total accounts
        System.out.println("\nTotal Accounts Created: " + BankAccount.getTotalAccounts());

        sc.close();
    }
}
