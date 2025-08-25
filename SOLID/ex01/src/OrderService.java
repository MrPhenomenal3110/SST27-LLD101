public class OrderService {
    private EmailClient email;
    private TaxService tax;

    public OrderService(EmailClient email, TaxService tax) {
        this.email = email;
        this.tax = tax;
    }

    void checkout(String customerEmail, double subtotal) {
        double total = tax.totalWithTax(subtotal);
        email.send(customerEmail, "Thanks! Your total is " + total);
        System.out.println("Order stored (pretend DB).");
    }
}