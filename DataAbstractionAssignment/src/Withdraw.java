import java.util.Date;

public class Withdraw {
    private double amount;
    private Date date;
    private String account;

    Withdraw(double amount, Date date, String account){
        this.amount = amount;
        this.date = date;
        this.account = account;
    }

    //Requires: A Withdraw Object
    //modifies: nothing
    //effects: returns a string representation of the Withdraw Object
    public String toString(){
        //code here
        return "\nWithdraw of: " + amount + " " + "Date: " + date + " " + "into account:" + " " + account;
    }
}
