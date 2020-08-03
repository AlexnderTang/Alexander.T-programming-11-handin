import javax.security.sasl.SaslClient;
import java.util.ArrayList;
import java.util.Date;

public class Customer {
    private int accountNumber;
    private ArrayList<Deposit> deposits;
    private ArrayList<Withdraw> withdraws;
    private double checkBalance;
    private double savingBalance;
    private double savingRate;
    private String name;
    public static final String CHECKING = "Checking";
    public static final String SAVING = "Saving";
    private final int OVERDRAFT = -100;

    //default constructor
    Customer(){
        //code here
        name = "no name";
        deposits = new ArrayList<Deposit>();
        withdraws = new ArrayList<Withdraw>();
        this.checkBalance = 0;
        this.savingBalance = 0;
    }

    Customer(String name, int accountNumber, double checkDeposit, double savingDeposit){
        //code here
        deposits = new ArrayList<Deposit>();
        withdraws = new ArrayList<Withdraw>();
        this.name = name;
        this.accountNumber = accountNumber;
        this.checkBalance = checkDeposit;
        this.savingBalance = savingDeposit;
    }
    //Requires: amt>0, date, account
    //modifies: this, deposits
    //effects: adds amt to to the account's corresponding balance and returns the new balance, creates a Deposit object called money with the same parameters as the deposit method
    //and adds it to the ArrayList<Deposit> deposits. If requires clause isn't met then return -1.
    public double deposit(double amt, Date date, String account){
        //code here
        if (account.equals(CHECKING) && (amt>0)){
            checkBalance = checkBalance + amt;
            Deposit money = new Deposit(amt, date, account);
            deposits.add(money);
            return checkBalance;
        }

        else if ((account.equals(SAVING)) && (amt>0)) {
            savingBalance = savingBalance + amt;
            Deposit money = new Deposit(amt, date, account);
            deposits.add(money);
            return savingBalance;
        }

        else
            return -1;
    }
    //Requires: amt>0, date, account
    //modifies: this, withdraws
    //Effects: Deducts amt from the account's corresponding balance and returns new balance, creates a Withdraw object called money with the same parameters as the withdraw method
    //and adds it to the ArrayList<Withdraw> withdraws. If Overdraft, or requires clause isn't met then return -1.
    public double withdraw(double amt, Date date, String account){
        //your code here
        if (!checkOverdraft(amt, account)){
            if (account.equals(CHECKING) && (amt>0)){
                checkBalance = checkBalance - amt;
                Withdraw money = new Withdraw(amt, date, account);
                withdraws.add(money);
                return checkBalance;
            }
            else if (account.equals(SAVING) && (amt>0)){
                savingBalance = savingBalance - amt;
                Withdraw money = new Withdraw(amt, date, account);
                withdraws.add(money);
                return savingBalance;
            }
        }
        return -1;
    }

    private boolean checkOverdraft(double amt, String account){
        //your code here
        if((account.equals(CHECKING) && (checkBalance - amt < OVERDRAFT)) || (account.equals(SAVING) && savingBalance - amt < OVERDRAFT)){
            return true;
        }
        return false;

    }
    //do not modify
    public void displayDeposits(){
        for(Deposit d : deposits){
            System.out.println(d);
        }
    }

    //do not modify
    public void displayWithdraws(){
        for(Withdraw w : withdraws){
            System.out.println(w);
        }

    }
    public ArrayList<Withdraw> getWithdraws() {
        return withdraws;
    }
    public ArrayList<Deposit> getDeposits() {
        return deposits;
    }

    public double getCheckBalance() {
        return checkBalance;
    }

    public double getSavingBalance() {
        return savingBalance;
    }

}



