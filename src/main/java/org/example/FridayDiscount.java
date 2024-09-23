package org.example;

public class FridayDiscount extends BaseDiscount {

    public FridayDiscount(Discount nextDiscount) {
        super(nextDiscount);
    }

    @Override
    protected boolean isApplicable(Product product) {
        // It should apply if it's Friday
        return true;  // If user pass true when it's Friday,  FridayDiscount applies
    }

    @Override
    protected double calculateDiscount(Product product) {
        return product.getPrice() * product.getQuantity() * 0.10;  // 10% off total price
    }

    @Override
    public String getDescription(Product product) {
        return "10% Friday Discount";
    }
}
