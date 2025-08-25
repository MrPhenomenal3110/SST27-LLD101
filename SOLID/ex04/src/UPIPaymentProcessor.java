public class UPIPaymentProcessor implements PaymentProcessor {
    public String pay(Payment p) {
        return "Paid via UPI: " + p.amount;
    }
}
