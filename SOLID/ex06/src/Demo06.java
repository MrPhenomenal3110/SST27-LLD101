public class Demo06 {
    public static void main(String[] args) {
        new Aviary().release(new Sparrow());
        new Aviary().release(new Penguin()); // no runtime error as now the action is specific to the bird
        // new Penguin().walk();
    }
}
