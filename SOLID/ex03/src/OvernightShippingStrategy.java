public class OvernightShippingStrategy implements ShippingStrategy {
    public double cost(Shipment s) {
        return 120 + 10*s.weightKg;
    }
}
