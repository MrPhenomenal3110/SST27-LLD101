public class Sparrow extends Bird implements Flyable {
    public void fly(){
        System.out.println("Flying!");
    }

    @Override
    public void action(){
        fly();
    }
}