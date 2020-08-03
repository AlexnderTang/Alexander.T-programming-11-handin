import java.util.Date;

public class Deposit {
    private double amount;
    private Date date;
    private String account;

    Deposit(double amount, Date date, String account){
        this.amount = amount;
        this.date = date;
        this.account = account;
    }

    //requires: A Deposit object
    //modifies: nothing
    //effects: returns a string representation of the Deposit object
    public String toString(){
        //code here
        return "\nDeposit of: " + amount + " " + "Date: " + date + " " + "into account:" + " " + account;
    }
}
