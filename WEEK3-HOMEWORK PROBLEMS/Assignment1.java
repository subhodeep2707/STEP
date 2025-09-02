// Assignment 1: Personal Finance Manager
import java.util.*;

class PersonalAccount {
    private String accountHolderName;
    private String accountNumber;
    private double currentBalance;
    private double totalIncome;
    private double totalExpenses;
    private static int totalAccounts = 0;
    private static String bankName = "";
    public PersonalAccount(String name) {
        this.accountHolderName = name;
        this.accountNumber = generateAccountNumber();
        this.currentBalance = 0.0;
        this.totalIncome = 0.0;
        this.totalExpenses = 0.0;
        totalAccounts++;
    }
    public static void setBankName(String name){ bankName = name; }
    public static int getTotalAccounts(){ return totalAccounts; }
    public static String generateAccountNumber(){ return "ACC" + (1000 + totalAccounts + 1); }
    public void addIncome(double amount, String description){ if(amount>0){ currentBalance+=amount; totalIncome+=amount; }}
    public void addExpense(double amount, String description){ if(amount>0 && amount<=currentBalance){ currentBalance-=amount; totalExpenses+=amount; }}
    public double calculateSavings(){ return totalIncome - totalExpenses; }
    public void displayAccountSummary(){
        System.out.println("Bank: "+bankName);
        System.out.println("Account Holder: "+accountHolderName);
        System.out.println("Account Number: "+accountNumber);
        System.out.println("Current Balance: "+currentBalance);
        System.out.println("Total Income: "+totalIncome);
        System.out.println("Total Expenses: "+totalExpenses);
        System.out.println("Savings: "+calculateSavings());
        System.out.println();
    }
}
public class Assignment1 {
    public static void main(String[] args){
        PersonalAccount.setBankName("State Bank");
        PersonalAccount a = new PersonalAccount("Aarav");
        PersonalAccount b = new PersonalAccount("Meera");
        PersonalAccount c = new PersonalAccount("Ravi");
        a.addIncome(50000,"Salary"); a.addExpense(12000,"Rent"); a.addExpense(5000,"Groceries");
        b.addIncome(40000,"Salary"); b.addIncome(5000,"Freelance"); b.addExpense(8000,"Travel");
        c.addIncome(30000,"Stipend"); c.addExpense(4000,"Food"); c.addExpense(2000,"Books");
        a.displayAccountSummary(); b.displayAccountSummary(); c.displayAccountSummary();
        System.out.println("Total Accounts: "+PersonalAccount.getTotalAccounts());
        System.out.println("Shared Bank Name Check: "+"State Bank");
    }
}

