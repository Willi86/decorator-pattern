package org.example;

public class MilkDiscount extends BaseDiscount {

    public MilkDiscount(Discount nextDiscount) {
        super(nextDiscount);
    }

    @Override
    protected boolean isApplicable(Product product) {
        return product.getName().equalsIgnoreCase("milk");  // Check if product is "milk"
    }

    @Override
    protected double calculateDiscount(Product product) {
        return product.getPrice() * product.getQuantity() * 0.05;  // 5% off total price
    }

    @Override
    public String getDescription(Product product) {
        return "5% Milk Discount";
    }
}
