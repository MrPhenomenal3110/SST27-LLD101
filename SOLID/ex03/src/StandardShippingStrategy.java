public class StandardShippingStrategy implements ShippingStrategy {
    public double cost(Shipment s) {
        return 50 + 5*s.weightKg;
    }
}
