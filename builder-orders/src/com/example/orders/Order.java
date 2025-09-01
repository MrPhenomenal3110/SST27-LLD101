package com.example.orders;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Immutable Order with Builder pattern. Validates all inputs and prevents mutability leaks.
 */
public class Order {
    private final String id;
    private final String customerEmail;
    private final List<OrderLine> lines;
    private final Integer discountPercent; // 0..100 enforced
    private final boolean expedited;
    private final String notes;

    // Private constructor - only accessible through Builder
    private Order(String id, String customerEmail, List<OrderLine> lines, 
                 Integer discountPercent, boolean expedited, String notes) {
        this.id = id;
        this.customerEmail = customerEmail;
        this.lines = new ArrayList<>(lines); // Defensive copy
        this.discountPercent = discountPercent;
        this.expedited = expedited;
        this.notes = notes;
    }

    // Getters - no setters for immutability
    public String getId() { return id; }
    public String getCustomerEmail() { return customerEmail; }
    public List<OrderLine> getLines() { 
        return Collections.unmodifiableList(new ArrayList<>(lines)); // Defensive copy + unmodifiable
    }
    public Integer getDiscountPercent() { return discountPercent; }
    public boolean isExpedited() { return expedited; }
    public String getNotes() { return notes; }

    public int totalBeforeDiscount() {
        int sum = 0;
        for (OrderLine l : lines) sum += l.getQuantity() * l.getUnitPriceCents();
        return sum;
    }

    public int totalAfterDiscount() {
        int base = totalBeforeDiscount();
        if (discountPercent == null) return base;
        return base - (base * discountPercent / 100);
    }

    // Builder for Order with validation
    public static class Builder {
        private String id;
        private String customerEmail;
        private List<OrderLine> lines = new ArrayList<>();
        private Integer discountPercent;
        private boolean expedited = false;
        private String notes;

        public Builder(String id, String customerEmail) {
            this.id = id;
            this.customerEmail = customerEmail;
        }

        public Builder addLine(OrderLine line) {
            if (line != null) {
                lines.add(line);
            }
            return this;
        }

        public Builder addLines(List<OrderLine> lines) {
            if (lines != null) {
                this.lines.addAll(lines);
            }
            return this;
        }

        public Builder discountPercent(Integer discountPercent) {
            this.discountPercent = discountPercent;
            return this;
        }

        public Builder expedited(boolean expedited) {
            this.expedited = expedited;
            return this;
        }

        public Builder notes(String notes) {
            this.notes = notes;
            return this;
        }

        public Order build() {
            // Centralized validation
            validateId();
            validateEmail();
            validateLines();
            validateDiscount();
            
            return new Order(id, customerEmail, lines, discountPercent, expedited, notes);
        }

        private void validateId() {
            if (id == null || id.trim().isEmpty()) {
                throw new IllegalArgumentException("Order ID cannot be null or empty");
            }
        }

        private void validateEmail() {
            if (!PricingRules.isValidEmail(customerEmail)) {
                throw new IllegalArgumentException("Invalid email format: " + customerEmail);
            }
        }

        private void validateLines() {
            if (lines == null || lines.isEmpty()) {
                throw new IllegalArgumentException("Order must have at least one line");
            }
            // Validate individual lines
            for (OrderLine line : lines) {
                if (line == null) {
                    throw new IllegalArgumentException("Order line cannot be null");
                }
            }
        }

        private void validateDiscount() {
            if (!PricingRules.isValidDiscount(discountPercent)) {
                throw new IllegalArgumentException("Discount must be between 0 and 100, got: " + discountPercent);
            }
        }
    }
}
