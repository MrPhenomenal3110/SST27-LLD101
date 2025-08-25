public class CardPaymentProcessor implements PaymentProcessor {
    public String pay(Payment p) {
        return "Charged card: " + p.amount;
    }
}
