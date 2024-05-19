import java.util.ArrayList;
import java.util.List;

public class Account {

    private static int counter=1;
    private int accountId;
    private String userName;
    private double balance;
    private List<Transaction> transactions;

    public Account(String userName,double initialbalance) {
        this.accountId=counter++;
        this.userName=userName;
        this.balance=initialbalance;
        this.transactions = new ArrayList<>();
    }

    public int getAccountId() {
        return accountId;
    }

    public String getUserName() {
        return userName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance+=amount;
    }

    public void withdraw(double amount) throws Exception{
        if( balance >= amount ) {
            balance -= amount;}
        else {
            throw new Exception("Not enough founds");
        }
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);

    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
