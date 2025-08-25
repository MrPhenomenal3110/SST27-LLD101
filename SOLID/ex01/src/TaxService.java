public class TaxService {
    double taxRate = 0.18;

    double calculateTax(double subtotal) {
        return subtotal * taxRate;
    }

    double totalWithTax(double subtotal) {
        return subtotal + calculateTax(subtotal);
    }
}
