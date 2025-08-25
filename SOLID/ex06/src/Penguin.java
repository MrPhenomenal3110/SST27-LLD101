public class Penguin extends Bird {
    public void walk() {
        System.out.println("Walking!");
    }

    @Override
    public void action(){
        walk();
    }
}