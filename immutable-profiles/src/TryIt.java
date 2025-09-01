import com.example.profiles.*;

public class TryIt {
    public static void main(String[] args) {
        ProfileService svc = new ProfileService();
        
        // Create minimal profile using Builder
        UserProfile p = svc.createMinimal("u1", "a@b.com");
        System.out.println("Before: " + p.getEmail());
        
        // Try to modify the profile - this won't work because it's immutable
        // p.setEmail("evil@example.com"); // This line is commented out because UserProfile is now immutable
        System.out.println("After:  " + p.getEmail());
        System.out.println("=> In the solution, this setter disappears and object becomes immutable.");
        
        // Demonstrate that the profile is truly immutable
        System.out.println("\nDemonstrating immutability:");
        System.out.println("Profile ID: " + p.getId());
        System.out.println("Profile Email: " + p.getEmail());
        
        // Create a new profile with updated display name (immutable update)
        UserProfile updatedProfile = svc.updateDisplayName(p, "John Doe");
        System.out.println("\nOriginal profile display name: " + p.getDisplayName());
        System.out.println("Updated profile display name: " + updatedProfile.getDisplayName());
        System.out.println("Original profile unchanged - immutability preserved");
        
        // Demonstrate Builder pattern with all optional fields
        System.out.println("\nDemonstrating Builder pattern:");
        UserProfile completeProfile = new UserProfile.Builder("u2", "prem@gmail.com")
            .phone("+91-9876543210")
            .displayName("Prem Shah")
            .address("123 Main St, Mumbai, Maharashtra")
            .marketingOptIn(true)
            .twitter("@premshah")
            .github("premshah")
            .build();
            
        System.out.println("Complete profile created:");
        System.out.println("  ID: " + completeProfile.getId());
        System.out.println("  Email: " + completeProfile.getEmail());
        System.out.println("  Phone: " + completeProfile.getPhone());
        System.out.println("  Display Name: " + completeProfile.getDisplayName());
        System.out.println("  Address: " + completeProfile.getAddress());
        System.out.println("  Marketing Opt-in: " + completeProfile.isMarketingOptIn());
        System.out.println("  Twitter: " + completeProfile.getTwitter());
        System.out.println("  GitHub: " + completeProfile.getGithub());
        
        // Demonstrate validation
        System.out.println("\nDemonstrating validation:");
        try {
            new UserProfile.Builder("", "valid@email.com").build();
            System.out.println("ERROR: Should have thrown exception for blank ID!");
        } catch (IllegalArgumentException e) {
            System.out.println("Correctly validated ID: " + e.getMessage());
        }
        
        try {
            new UserProfile.Builder("u3", "invalid-email").build();
            System.out.println("ERROR: Should have thrown exception for invalid email!");
        } catch (IllegalArgumentException e) {
            System.out.println("Correctly validated email: " + e.getMessage());
        }
        
        try {
            new UserProfile.Builder("u4", null).build();
            System.out.println("ERROR: Should have thrown exception for null email!");
        } catch (IllegalArgumentException e) {
            System.out.println("Correctly validated null email: " + e.getMessage());
        }
    }
}
