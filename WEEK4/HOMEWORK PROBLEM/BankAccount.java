import java.util.Random;

class BankAccount {
    private String accountHolder;
    private int accountNumber;
    private double balance;

    // Default → balance = 0
    public BankAccount() {
        this("Unknown", randomAccNo(), 0.0);
    }

    // Name only → random account number
    public BankAccount(String accountHolder) {
        this(accountHolder, randomAccNo(), 0.0);
    }

    // Name + initial balance
    public BankAccount(String accountHolder, double initialBalance) {
        this(accountHolder, randomAccNo(), initialBalance);
    }

    // Full (private for chaining)
    private BankAccount(String accountHolder, int accountNumber, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.balance = Math.max(0.0, balance);
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit must be positive");
        }
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal must be positive");
        }
        if (amount > balance) {
            throw new IllegalStateException("Insufficient balance");
        }
        balance -= amount;
    }

    public void displayAccount() {
        System.out.printf(" 🏦  %s | Acct#: %d | Balance: ₹%.2f%n", accountHolder, accountNumber, balance);
    }

    private static int randomAccNo() {
        return 100000 + new Random().nextInt(900000);
    }

    public static void main(String[] args) {
        System.out.println("--- Bank Account System ---");
        BankAccount a1 = new BankAccount();
        BankAccount a2 = new BankAccount("Kalpana");
        BankAccount a3 = new BankAccount("Murali", 5000);
        a2.deposit(2500);
        a3.withdraw(1000);
        a1.displayAccount();
        a2.displayAccount();
        a3.displayAccount();
    }
}