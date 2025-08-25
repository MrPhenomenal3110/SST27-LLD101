
public class PaymentService {
    PaymentProcessingService paymentProcessingService = new PaymentProcessingService();

    String pay(Payment p){
        PaymentProcessor processor = paymentProcessingService.getPaymentProcessor(p.provider);
        return processor.pay(p);
    }
}