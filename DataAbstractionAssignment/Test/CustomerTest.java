import org.junit.Before;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Date;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {
    Date date = new Date();
    Customer tester = new Customer("Alex", 1234, 200, 200);

    @Test
    public void testWithdrawToString() {
        //Create a Withdraw object
        Withdraw object = new Withdraw(100.0, date, Customer.SAVING);
        //Check Withdraw toString is the same as the return code
        assertEquals("\nWithdraw of: " + 100.0 + " " + "Date: " + date + " " + "into account:" + " " + Customer.SAVING, object.toString());
    }


    @Test
    public void testDepositToString() {
        //Create a Deposit object
        Deposit object = new Deposit(100.0, date, Customer.CHECKING);
        //Check Deposit toString is the same as the return code
        assertEquals("\nDeposit of: " + 100.0 + " " + "Date: " + date + " " + "into account:" + " " + Customer.CHECKING, object.toString());
    }

    @Test
    public void testCustomerDeposit() {
        //Check if Arraylist<Deposit> deposits is empty
        assertEquals(0, tester.getDeposits().size());

        //add a deposit to Checking
        tester.deposit(100.0, date, Customer.CHECKING);

        //check ArrayList<Deposit> deposits size is equals to one
        assertEquals(1, tester.getDeposits().size());

        //Check checkBalance is equals to amount deposited plus original checkBalance
        assertEquals(300.0, tester.getCheckBalance(), 0.01);

        //Check the display of deposit if it has Deposit.toString
        Boolean checkingDepositTest = false;
        for (int i = 0; i < tester.getDeposits().size(); i++) {
            if (tester.getDeposits().get(i).toString().equals("\nDeposit of: " + 100.0 + " " + "Date: " + date + " " + "into account:" + " " + Customer.CHECKING))
            checkingDepositTest = true;
        }
        assertTrue(checkingDepositTest);

        //add a deposit to Savings
        tester.deposit(100, date, Customer.SAVING);

        //Check ArrayList<Deposit> deposits size equals to two
        assertEquals(2, tester.getDeposits().size());

        //Check savingBalance is equals to amount deposited plus original saving Balance
        assertEquals(300.0, tester.getSavingBalance(), 0.01);

        //Check the display of deposit if it has Deposit.toString
        Boolean savingDepositTest = false;
        for (int x = 0; x < tester.getDeposits().size(); x++) {
            if (tester.getDeposits().get(x).toString().equals("\nDeposit of: " + 100.0 + " " + "Date: " + date + " " + "into account:" + " " + Customer.SAVING))
            savingDepositTest = true;
        }
        assertTrue(savingDepositTest);
    }

    @Test
    public void testCustomerWithdraw() {
        //Check if ArrayList<Withdraw> withdraws is empty
        assertEquals(0, tester.getWithdraws().size());

        //withdraw from Checking
        tester.withdraw(100, date, Customer.CHECKING);

        //Check if Arraylist<Withdraw> withdraws size is equal to one
        assertEquals(1, tester.getWithdraws().size());

        //Check if checkBalance is equals to original checkBalance minus amount
        assertEquals(100, tester.getCheckBalance(), 0.01);

        //Check the display of withdraw if it has Withdraw.toString

        Boolean checkingWithdrawTest = false;
        for( int i= 0; i<tester.getWithdraws().size();i++)
            if (tester.getWithdraws().get(i).toString().equals("\nWithdraw of: " + 100.0 + " " + "Date: " + date + " " + "into account:" + " " + Customer.CHECKING))
            checkingWithdrawTest= true;
        assertTrue(checkingWithdrawTest);

        //withdraw from Saving
        tester.withdraw(100, date, Customer.SAVING);

        //Check ArrayList<Withdraw> withdraws size equals to two
        assertEquals(2, tester.getWithdraws().size());

        //Check if savingBalance is equals to original savingBalance minus amount
        assertEquals(100, tester.getSavingBalance(), 0.01);

        //Check the display of withdraw if it had Withdraw.toString
        Boolean savingWithdrawTest = false;
        for (int r = 0; r < tester.getWithdraws().size(); r++) {
            if (tester.getWithdraws().get(r).toString().equals("\nWithdraw of: " + 100.0 + " " + "Date: " + date + " " + "into account:" + " " + Customer.SAVING))
            savingWithdrawTest = true;
        }
        assertTrue(savingWithdrawTest);

        //Check Overdraft by withdrawing an  (amount> account balance + 100)
        assertTrue(tester.withdraw(500, date, Customer.SAVING)==-1);


    }
}