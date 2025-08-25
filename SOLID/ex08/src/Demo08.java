public class Demo08 {
    public static void main(String[] args) {
        Bicycle b = new Bicycle();
        b.pedal(10);

        Car c = new Car();
        c.startEngine();

        ElectricCar ec = new ElectricCar();
        ec.recharge(10);
    }
}
