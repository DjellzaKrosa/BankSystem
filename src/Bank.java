import java.util.ArrayList;
import java.util.List;

public class Bank{

    private String bankName;
    private List<Account> accounts;
    private double totalTransactionFeeAmount;
    private double totalTransferAmount;

    public Bank(String bankName) {
        this.bankName = bankName;
        this.accounts = new ArrayList<>();
    }

    public void createAccount(String userName,double initialBalance) {
        Account account=new Account(userName,initialBalance);
        accounts.add(account);
    }

    private Account findAccountById(int accountId) {
        for(Account account:accounts) {
            if(account.getAccountId()==accountId) {
                return account;
            }
        }
        return null;
    }

    public void deposit(int accountId,double amount)throws Exception {
        Account account=findAccountById(accountId);
        if(account != null) {
            account.deposit(amount);
            totalTransferAmount+=amount;
        }
        else {
            throw new Exception("Account not found");
        }
    }

    public void withdraw(int accountId, double amount) throws Exception{
        Account account = findAccountById(accountId);
        if (account != null) {
            account.withdraw(amount);
            totalTransferAmount += amount;
        } else {
            throw new Exception("Account not found");
        }
    }

    public void transfer(int originatingAccountId, int resultingAccountId, double amount, String transactionReason, boolean isFlatFee, double fee) throws Exception {
        Account originatingAccount = findAccountById(originatingAccountId);
        Account resultingAccount = findAccountById(resultingAccountId);
        if (originatingAccount != null && resultingAccount != null) {
            Transaction transaction;
            if (isFlatFee) {
                transaction = new FlatFeeTransaction(amount, originatingAccountId, resultingAccountId, transactionReason, fee);
            } else {
                transaction = new PercentFeeTransaction(amount, originatingAccountId, resultingAccountId, transactionReason, fee);
            }
            double totalAmount = transaction.getTotalAmount();
            if (originatingAccount.getBalance() >= totalAmount) {
                originatingAccount.withdraw(totalAmount);
                resultingAccount.deposit(amount);
                totalTransferAmount += amount;
                totalTransactionFeeAmount += transaction.getFee();
                originatingAccount.addTransaction(transaction);
                resultingAccount.addTransaction(transaction);
            } else {
                throw new Exception("Not enough funds");
            }
        } else {
            throw new Exception("Account not found");
        }
    }

    public List<Transaction> getTransactions(int accountId)throws Exception {
        Account account = findAccountById(accountId);
        if (account != null) {
            return account.getTransactions();
        }
        else {
            throw new Exception("Account not found");
        }
    }

    public double getAccountBalance(int accountId) throws Exception{
        Account account = findAccountById(accountId);
        if (account != null) {
            return account.getBalance();
        }
        else {
            throw new Exception("Account not found");
        }
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public double getTotalTransactionFeeAmount() {
        return totalTransactionFeeAmount;
    }

    public double getTotalTransferAmount() {
        return totalTransferAmount;
    }
}
