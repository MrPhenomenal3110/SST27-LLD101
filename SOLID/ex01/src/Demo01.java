public class Demo01 {
    public static void main(String[] args) {
        EmailClient email = new EmailClient();
        TaxService tax = new TaxService();
        OrderService order = new OrderService(email, tax);
        order.checkout("a@shop.com", 100.0);
    }
}
