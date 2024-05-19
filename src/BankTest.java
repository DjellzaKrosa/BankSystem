import java.text.DecimalFormat;
import java.util.Scanner;

public class BankTest {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println("***Bank System***");
        System.out.print("Enter bank name: ");
        String bankName=scanner.nextLine();
        Bank bank=new Bank(bankName);
        boolean running=true;
        while(running) {
            System.out.println("Bank System Menu:");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer");
            System.out.println("5. View transactions");
            System.out.println("6. View account balance");
            System.out.println("7. List of bank accounts");
            System.out.println("8. Check bank total transaction fee amount");
            System.out.println("9. Check bank total transfer amount");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");
            int choice=scanner.nextInt();
            scanner.nextLine();
            try {
                switch(choice) {
                    case 1:
                        System.out.print("Enter user name: ");
                        String userName=scanner.nextLine();
                        System.out.print("Enter initial balance: ");
                        double initialBalance=scanner.nextDouble();
                        bank.createAccount(userName, initialBalance);
                        System.out.println("Account created successfully.");
                        break;
                    case 2:
                        System.out.print("Enter account ID for deposit: ");
                        int depositAccountId=scanner.nextInt();
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount=scanner.nextDouble();
                        bank.deposit(depositAccountId, depositAmount);
                        System.out.println("Deposit successful.");
                        break;
                    case 3:
                        System.out.print("Enter account ID for withdrawal: ");
                        int withdrawAccountId = scanner.nextInt();
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = scanner.nextDouble();
                        bank.withdraw(withdrawAccountId, withdrawAmount);
                        System.out.println("Withdrawal successful.");
                        break;
                    case 4:
                        System.out.print("Enter originating account ID for transfer: ");
                        int originatingAccountId = scanner.nextInt();
                        System.out.print("Enter resulting account ID for transfer: ");
                        int resultingAccountId = scanner.nextInt();
                        System.out.print("Enter amount to transfer: ");
                        double transferAmount = scanner.nextDouble();
                        System.out.print("Enter transaction reason: ");
                        scanner.nextLine();
                        String transactionReason = scanner.nextLine();
                        System.out.print("Is this a flat fee transaction (true/false)? ");
                        boolean isFlatFee = scanner.nextBoolean();
                        System.out.print("Enter fee amount: ");
                        double fee = scanner.nextDouble();
                        bank.transfer(originatingAccountId, resultingAccountId, transferAmount, transactionReason, isFlatFee, fee);
                        System.out.println("Transfer successful.");
                        break;
                    case 5:
                        System.out.print("Enter account ID to view transactions: ");
                        int transactionsAccountId = scanner.nextInt();
                        System.out.println("Transactions for account ID " + transactionsAccountId + ":");
                        for (Transaction transaction : bank.getTransactions(transactionsAccountId)) {
                            System.out.println("Amount: $" + df.format(transaction.getAmount()) + ", From: " + transaction.getOriginatingAccountId() + ", To: " + transaction.getResultingAccountId() + ", Reason: " + transaction.getTransactionReason());
                        }
                        break;
                    case 6:
                        System.out.print("Enter account ID to view balance: ");
                        int balanceAccountId = scanner.nextInt();
                        double balance = bank.getAccountBalance(balanceAccountId);
                        System.out.println("Account balance: $ " + df.format(balance));
                        break;
                    case 7:
                        System.out.println("List of all accounts:");
                        for (Account account : bank.getAccounts()) {
                            System.out.println("Account ID: " + account.getAccountId() + ", User Name: " + account.getUserName() + ", Balance: $" + df.format(account.getBalance()));
                        }
                        break;
                    case 8:
                        System.out.println("Total transaction fee amount: $"+df.format(bank.getTotalTransactionFeeAmount()));
                        break;
                    case 9:
                        System.out.println("Total transfer amount: $" + df.format(bank.getTotalTransferAmount()));
                        break;
                    case 10:
                        running = false;
                        System.out.println("Exiting");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            }
            catch(Exception e) {
                System.out.println("Error: "+e.getMessage());
            }
        }
        scanner.close();
    }
}
