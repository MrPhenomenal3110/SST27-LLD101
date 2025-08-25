public class ShippingCostCalculator {
    ShippingStrategyService strategyService = new ShippingStrategyService();

    double cost(Shipment s){
        ShippingStrategy strategy = strategyService.getStrategy(s.type);
        return strategy.cost(s);
    }
}
