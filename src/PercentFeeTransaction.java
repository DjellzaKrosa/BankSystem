public class PercentFeeTransaction extends Transaction {

    private double percentFee;

    public PercentFeeTransaction(double amount, int originatingAccountId, int resultingAccountId,String transactionReason,double percentFee) {
        super(amount, originatingAccountId, resultingAccountId, transactionReason);
        this.percentFee=percentFee;
    }

    @Override
    public double getFee() {
        return getAmount()*percentFee/100;
    }

    @Override
    public double getTotalAmount() {
        return getAmount() + getFee();
    }
}
