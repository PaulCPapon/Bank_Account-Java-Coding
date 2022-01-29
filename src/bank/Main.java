package bank;
import java.text.NumberFormat;
import java.util.Date;


//Class Account
class Account {
    //Attributes of
    private int id = 0;
    private double balance = 0.0;
    private static double annualInterestRate = 0.0;
    private final Date dateCreated;

    public Account()
    {
        //constructor
        dateCreated = new Date();
    }

    public Account(int id, double balance) {
        //Parametric Constructor
        this();
        this.id = id;
        this.balance = balance;
    }

    //Getters
    public int getId()
    {
        return this.id;
    }

    public double getBalance()
    {
        return this.balance;
    }

    public double getAnnualInterestRate()
    {
        return annualInterestRate;
    }

    //data of account creation
    public String getDateCreated()
    {
        return this.dateCreated.toString();
    }

    //Setters
    public void setId(int id)
    {
        this.id = id;
    }

    public void setBalance(double balance)
    {
        this.balance = balance;
    }

    //set annual interest rate value
    public void setAnnualInterestRate(double annualInterestRate)
    {
        Account.annualInterestRate = annualInterestRate;
    }

    //formula to calculate the monthly amount
    public double getMonthlyInterestRate()
    {
        return (annualInterestRate / 100) / 12 ;
    }

    //calculate interest in money
    public double getMonthlyInterest()
    {
        return balance * getMonthlyInterestRate();
    }
    // Formula to calculate Withdraw
    public void withdraw(double amount)
    { //withdraw amount is taken out the balance amount
        this.balance -= amount;
    }
    // Formula to calculate deposit
    public void deposit(double amount)
    { //deposit amount is added to balance amount
        this.balance += amount;
    }
}

public class Main {

    public static void main(String[] args) {

        //Test account
        Account MyAccount = new Account(1122, 20000);
        MyAccount.setAnnualInterestRate(4.5);
        MyAccount.withdraw(2500.0);
        MyAccount.deposit(3000.0);
        //converting to british currency
        NumberFormat englishPound = NumberFormat.getCurrencyInstance();
        //output to print
        System.out.println("Your Balance is: " + englishPound.format(MyAccount.getBalance()));
        System.out.println("Your Monthly Interest: " + englishPound.format(MyAccount.getMonthlyInterest()));
        System.out.println("Date: " + MyAccount.getDateCreated());
    }

}