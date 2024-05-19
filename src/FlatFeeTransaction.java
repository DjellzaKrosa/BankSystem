public class FlatFeeTransaction extends Transaction{

    private double flatFee;

    public FlatFeeTransaction(double amount, int originatingAccountId, int resultingAccountId,String transactionReason,double flatFee) {
        super(amount, originatingAccountId, resultingAccountId, transactionReason);
        this.flatFee=flatFee;
    }

    @Override
    public double getFee() {
        return flatFee;
    }

    @Override
    public double getTotalAmount() {
        return getAmount() + getFee();
    }
}
