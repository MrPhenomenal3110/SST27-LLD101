package exercise;

import java.util.Objects;

public class EmployeeCSVAdapter implements Employee {
    private final EmployeeCSV csvEmployee;
    
    public EmployeeCSVAdapter(EmployeeCSV csvEmployee) {
        this.csvEmployee = Objects.requireNonNull(csvEmployee);
    }
    
    @Override
    public String getId() {
        String[] tokens = csvEmployee.tokens();
        return tokens.length > 0 ? tokens[0] : "";
    }
    
    @Override
    public String getFirstName() {
        String[] tokens = csvEmployee.tokens();
        return tokens.length > 1 ? tokens[1] : "";
    }
    
    @Override
    public String getLastName() {
        String[] tokens = csvEmployee.tokens();
        return tokens.length > 2 ? tokens[2] : "";
    }
    
    @Override
    public String getEmail() {
        String[] tokens = csvEmployee.tokens();
        return tokens.length > 3 ? tokens[3] : "";
    }
}
