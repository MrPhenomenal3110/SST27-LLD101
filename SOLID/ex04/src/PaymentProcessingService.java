public class PaymentProcessingService {
    public PaymentProcessor getPaymentProcessor(String provider) {
        switch (provider) {
            case "CARD": return new CardPaymentProcessor();
            case "UPI": return new UPIPaymentProcessor();
            case "WALLET": return new WalletPaymentProcessor();
            default: throw new IllegalArgumentException("Unknown provider: " + provider);
        }
    }
}
