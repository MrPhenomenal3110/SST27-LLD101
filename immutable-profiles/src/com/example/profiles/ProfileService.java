package com.example.profiles;

import java.util.Objects;

/**
 * Creates immutable profiles with consistent validation.
 */
public class ProfileService {

    // Returns a fully built immutable profile
    public UserProfile createMinimal(String id, String email) {
        return new UserProfile.Builder(id, email).build();
    }

    // Returns a new immutable profile with updated display name
    public UserProfile updateDisplayName(UserProfile profile, String displayName) {
        Objects.requireNonNull(profile, "profile");
        
        return new UserProfile.Builder(profile.getId(), profile.getEmail())
            .phone(profile.getPhone())
            .displayName(displayName)
            .address(profile.getAddress())
            .marketingOptIn(profile.isMarketingOptIn())
            .twitter(profile.getTwitter())
            .github(profile.getGithub())
            .build();
    }
    
    // Helper method to create a complete profile
    public UserProfile createCompleteProfile(String id, String email, String phone, 
                                           String displayName, String address, 
                                           boolean marketingOptIn, String twitter, String github) {
        return new UserProfile.Builder(id, email)
            .phone(phone)
            .displayName(displayName)
            .address(address)
            .marketingOptIn(marketingOptIn)
            .twitter(twitter)
            .github(github)
            .build();
    }
}
