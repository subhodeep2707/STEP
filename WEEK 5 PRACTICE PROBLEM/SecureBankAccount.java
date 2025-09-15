public class SecureBankAccount {
    private String accountNumber;
    private double balance;
    private int pin;
    private boolean isLocked;
    private int failedAttempts;
    private static final int MAX_FAILED_ATTEMPTS = 3;
    private static final double MIN_BALANCE = 0.0;

    public SecureBankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance >= MIN_BALANCE ? initialBalance : 0.0;
        this.pin = 0;
        this.isLocked = false;
        this.failedAttempts = 0;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
    public double getBalance() {
        if (!isLocked) return balance;
        return -1;
    }
    public boolean isAccountLocked() {
        return isLocked;
    }
    public void setPin(int oldPin, int newPin) {
        if (this.pin == oldPin) this.pin = newPin;
    }

    private void lockAccount() {
        isLocked = true;
    }
    private void resetFailedAttempts() {
        failedAttempts = 0;
    }
    private void incrementFailedAttempts() {
        failedAttempts++;
        if (failedAttempts >= MAX_FAILED_ATTEMPTS) lockAccount();
    }
    private boolean validatePin(int enteredPin) {
        if (isLocked) return false;
        if (this.pin == enteredPin) {
            resetFailedAttempts();
            return true;
        } else {
            incrementFailedAttempts();
            return false;
        }
    }

    public void deposit(double amount, int pin) {
        if (validatePin(pin) && amount > 0) balance += amount;
    }
    public void withdraw(double amount, int pin) {
        if (validatePin(pin) && amount > 0 && balance >= amount) balance -= amount;
    }
    public void transfer(SecureBankAccount target, double amount, int pin) {
        if (validatePin(pin) && balance >= amount) {
            this.withdraw(amount, pin);
            target.deposit(amount, pin);
        }
    }

    public static void main(String[] args) {
        SecureBankAccount acc1 = new SecureBankAccount("ACC001", 500);
        SecureBankAccount acc2 = new SecureBankAccount("ACC002", 1000);
        acc1.setPin(0, 1234);
        acc2.setPin(0, 4321);
        acc1.deposit(200, 1234);
        acc1.withdraw(100, 1234);
        acc1.transfer(acc2, 50, 1234);
        acc1.withdraw(50, 1111);
        acc1.withdraw(50, 1111);
        acc1.withdraw(50, 1111);
        acc1.deposit(100, 1234);
    }
}
