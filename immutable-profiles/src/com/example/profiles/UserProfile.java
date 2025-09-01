package com.example.profiles;

/**
 * Immutable UserProfile with Builder pattern. No mutability leaks.
 */
public class UserProfile {
    private final String id;
    private final String email;
    private final String phone;
    private final String displayName;
    private final String address;
    private final boolean marketingOptIn;
    private final String twitter;
    private final String github;

    // Private constructor - only accessible through Builder
    private UserProfile(String id, String email, String phone, String displayName, 
                      String address, boolean marketingOptIn, String twitter, String github) {
        this.id = id;
        this.email = email;
        this.phone = phone;
        this.displayName = displayName;
        this.address = address;
        this.marketingOptIn = marketingOptIn;
        this.twitter = twitter;
        this.github = github;
    }

    // Getters only - no setters for immutability
    public String getId() { return id; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getDisplayName() { return displayName; }
    public String getAddress() { return address; }
    public boolean isMarketingOptIn() { return marketingOptIn; }
    public String getTwitter() { return twitter; }
    public String getGithub() { return github; }

    /**
     * Builder for UserProfile with centralized validation
     */
    public static class Builder {
        private String id;
        private String email;
        private String phone;
        private String displayName;
        private String address;
        private boolean marketingOptIn = false;
        private String twitter;
        private String github;

        public Builder(String id, String email) {
            this.id = id;
            this.email = email;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder displayName(String displayName) {
            this.displayName = displayName;
            return this;
        }

        public Builder address(String address) {
            this.address = address;
            return this;
        }

        public Builder marketingOptIn(boolean marketingOptIn) {
            this.marketingOptIn = marketingOptIn;
            return this;
        }

        public Builder twitter(String twitter) {
            this.twitter = twitter;
            return this;
        }

        public Builder github(String github) {
            this.github = github;
            return this;
        }

        public UserProfile build() {
            // Centralized validation using Validation helpers
            validateId();
            validateEmail();
            validateDisplayName();
            
            return new UserProfile(id, email, phone, displayName, address, marketingOptIn, twitter, github);
        }

        private void validateId() {
            Validation.requireNonBlank(id, "id");
        }

        private void validateEmail() {
            if (email == null) {
                throw new IllegalArgumentException("email must not be null");
            }
            Validation.requireEmail(email);
        }

        private void validateDisplayName() {
            if (displayName != null && displayName.length() > 100) {
                // Consistent policy: trim to 100 characters
                displayName = displayName.substring(0, 100);
            }
        }
    }
}
