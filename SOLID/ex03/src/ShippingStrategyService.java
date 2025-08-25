public class ShippingStrategyService {
    public ShippingStrategy getStrategy(String type) {
        switch (type) {
            case "EXPRESS": return new ExpressShippingStrategy();
            case "OVERNIGHT": return new OvernightShippingStrategy();
            case "STANDARD": return new StandardShippingStrategy();
            default: throw new IllegalArgumentException("Unknown type: " + type);
        }
    }
}
