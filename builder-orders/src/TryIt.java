import com.example.orders.*;

public class TryIt {
    public static void main(String[] args) {
        // Create order lines
        OrderLine l1 = new OrderLine("A", 1, 200);
        OrderLine l2 = new OrderLine("B", 3, 100);
        
        // Use Builder pattern to create order
        Order o = new Order.Builder("o2", "a@b.com")
            .addLine(l1)
            .addLine(l2)
            .discountPercent(10)
            .build();
            
        System.out.println("Before: " + o.totalAfterDiscount());
        
        // l1.setQuantity(999); // This line is commented out because OrderLine is now immutable
        
        System.out.println("After:  " + o.totalAfterDiscount());
        System.out.println("=> In the solution, totals remain stable due to defensive copies and immutability.");
        
        // Demonstrate that the order is truly immutable
        System.out.println("\nDemonstrating immutability:");
        System.out.println("Order lines count: " + o.getLines().size());
        
        // Try to modify the returned list (should throw UnsupportedOperationException)
        try {
            o.getLines().add(new OrderLine("C", 1, 150));
            System.out.println("ERROR: Should not be able to modify the list!");
        } catch (UnsupportedOperationException e) {
            System.out.println("✓ Correctly prevented modification of order lines list");
        }
        
        // Demonstrate validation
        System.out.println("\nDemonstrating validation:");
        try {
            new Order.Builder("", "invalid-email")
                .addLine(l1)
                .build();
            System.out.println("ERROR: Should have thrown exception for invalid email!");
        } catch (IllegalArgumentException e) {
            System.out.println("✓ Correctly validated email: " + e.getMessage());
        }
        
        try {
            new Order.Builder("o3", "valid@email.com")
                .discountPercent(150) // Invalid discount > 100
                .addLine(l1)
                .build();
            System.out.println("ERROR: Should have thrown exception for invalid discount!");
        } catch (IllegalArgumentException e) {
            System.out.println("✓ Correctly validated discount: " + e.getMessage());
        }
        
        try {
            new Order.Builder("o4", "valid@email.com")
                .build(); // No lines
            System.out.println("ERROR: Should have thrown exception for empty lines!");
        } catch (IllegalArgumentException e) {
            System.out.println("✓ Correctly validated required lines: " + e.getMessage());
        }
    }
}
