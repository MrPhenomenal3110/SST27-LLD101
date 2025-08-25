public class WalletPaymentProcessor implements PaymentProcessor {
    public String pay(Payment p) {
        return "Wallet debit: " + p.amount;
    }
}
