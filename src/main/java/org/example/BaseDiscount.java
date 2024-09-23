package org.example;

public abstract class BaseDiscount implements Discount {
    protected Discount nextDiscount;  // This allows chaining

    public BaseDiscount(Discount nextDiscount) {
        this.nextDiscount = nextDiscount;
    }
    @Override
    public double apply(Product product) {
        double discount = 0;

        // Apply current discount if applicable
        if (isApplicable(product)) {
            discount += calculateDiscount(product);
        }

        // Apply next discount in chain (if there is one)
        if (nextDiscount != null) {
            discount += nextDiscount.apply(product);
        }

        // Ensure total discount does not exceed total price of the product
        double totalProductPrice = product.getPrice() * product.getQuantity();
        return Math.min(discount, totalProductPrice);
    }


    // Abstract methods for checking applicability and calculating discount
    protected abstract boolean isApplicable(Product product);
    protected abstract double calculateDiscount(Product product);
}
