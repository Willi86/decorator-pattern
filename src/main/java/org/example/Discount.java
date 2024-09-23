package org.example;

public interface Discount {
    double apply(Product product);  // Method to apply the discount

    String getDescription(Product product);  // Method to get the discount description
}
