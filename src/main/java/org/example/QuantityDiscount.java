package org.example;

public class QuantityDiscount extends BaseDiscount {

    public QuantityDiscount(Discount nextDiscount) {
        super(nextDiscount);
    }

    @Override
    protected boolean isApplicable(Product product) {
        return product.getQuantity() >= 5;  // Apply if quantity is 5 or more
    }

    @Override
    protected double calculateDiscount(Product product) {
        return 10 * product.getQuantity();  // 10 kronor per product
    }

    @Override
    public String getDescription(Product product) {
        return "10 kronor per product discount for 5 or more products";
    }
}
