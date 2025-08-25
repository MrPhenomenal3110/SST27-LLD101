public class ExpressShippingStrategy implements ShippingStrategy {
    public double cost(Shipment s) {
        return 80 + 8*s.weightKg;
    }
}
