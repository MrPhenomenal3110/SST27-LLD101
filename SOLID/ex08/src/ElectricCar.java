public class ElectricCar implements ElectricVehicle {
    @Override
    public void recharge(int kWh){
        System.out.println("Recharging " + kWh + " kWh");
    }
}
