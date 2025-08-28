public class BankAccount {
    // Static variables (shared by all accounts)
    private static String bankName;
    private static int totalAccounts = 0;
    private static double interestRate;

    // Instance variables (unique for each account)
    private String accountNumber;
    private String accountHolder;
    private double balance;

    // Constructor
    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
        totalAccounts++; // Increment total accounts whenever a new account is created
    }

    // Static methods
    public static void setBankName(String name) {
        bankName = name;
    }

    public static void setInterestRate(double rate) {
        interestRate = rate;
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }

    public static void displayBankInfo() {
        System.out.println("Bank Name: " + bankName);
        System.out.println("Total Accounts: " + totalAccounts);
        System.out.println("Interest Rate: " + interestRate + "%");
        System.out.println("----------------------------");
    }

    // Instance methods
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(accountHolder + " deposited " + amount + ". New balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(accountHolder + " withdrew " + amount + ". New balance: " + balance);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds.");
        }
    }

    public double calculateInterest() {
        return balance * (interestRate / 100);
    }

    public void displayAccountInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: " + balance);
        System.out.println("Interest Earned: " + calculateInterest());
        System.out.println("----------------------------");
    }

    public static void main(String[] args) {
        BankAccount.setBankName("State Bank");
        BankAccount.setInterestRate(5.0);

        BankAccount acc1 = new BankAccount("1001", "Subho", 1000.0);
        BankAccount acc2 = new BankAccount("1002", "Nayan", 2000.0);

        acc1.deposit(500);
        acc2.withdraw(300);

   
        acc1.displayAccountInfo();
        acc2.displayAccountInfo();

      
        BankAccount.displayBankInfo();  
        acc1.displayBankInfo();         

        System.out.println("Total accounts created: " + BankAccount.getTotalAccounts());
    }
}
