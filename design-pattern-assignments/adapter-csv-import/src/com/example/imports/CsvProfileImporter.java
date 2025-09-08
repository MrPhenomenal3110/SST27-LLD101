package com.example.imports;

import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

public class CsvProfileImporter implements ProfileImporter {
    private final NaiveCsvReader csvReader;
    private final ProfileService profileService;
    
    public CsvProfileImporter(NaiveCsvReader csvReader, ProfileService profileService) {
        this.csvReader = Objects.requireNonNull(csvReader, "csvReader");
        this.profileService = Objects.requireNonNull(profileService, "profileService");
    }
    
    @Override
    public int importFrom(Path csvFile) {
        Objects.requireNonNull(csvFile, "csvFile");
        
        List<String[]> rows = csvReader.read(csvFile);
        int successfulImports = 0;
        
        for (String[] row : rows) {
            if (isValidRow(row)) {
                try {
                    String id = row[0].trim();
                    String email = row[1].trim();
                    String displayName = row[2].trim();
                    
                    profileService.createProfile(id, email, displayName);
                    successfulImports++;
                } catch (Exception e) {
                    System.out.println("Skipped invalid row: " + String.join(",", row) + " - " + e.getMessage());
                }
            } else {
                System.out.println("Skipped invalid row: " + String.join(",", row) + " - missing required fields or invalid email");
            }
        }
        
        return successfulImports;
    }
    
    private boolean isValidRow(String[] row) {
        if (row == null || row.length < 3) {
            return false;
        }
        
        String id = row[0];
        String email = row[1];
        String displayName = row[2];
        
        // Check for missing required fields
        if (id == null || id.trim().isEmpty() || 
            email == null || email.trim().isEmpty() || 
            displayName == null || displayName.trim().isEmpty()) {
            return false;
        }
        
        // Check for valid email format
        if (!email.trim().contains("@")) {
            return false;
        }
        
        return true;
    }
}
