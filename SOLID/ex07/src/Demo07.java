public class Demo07 {
    public static void main(String[] args) {
        Printer p = new BasicPrinter();
        p.print("Hello");
        // p.scan("/tmp/out"); // blows up

        Machine m = new MultiPurposeMachine();
        m.print("Hello");
        m.scan("/tmp/out");
        m.fax("1234567890");
    }
}
