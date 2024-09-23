package org.example;
// visually testing
public class MainTest {
    public static void main(String[] args) {
        // Create some products
        Product milk = new Product("milk", 40, 6);  // 6 units of milk, 40 kronor each
        Product bread = new Product("bread", 30, 2);  // 2 loaves of bread, 30 kronor each

        // Create a chain of discounts: FridayDiscount -> MilkDiscount -> QuantityDiscount
        Discount discountChain = new FridayDiscount(new MilkDiscount(new QuantityDiscount(null)));

        // Apply discounts to the milk product
        System.out.println("Processing product: " + milk.getName());

        double totalMilkDiscount = 0;
        double milkTotalPrice = milk.getPrice() * milk.getQuantity();  // Total price for milk

        // Individual discount application
        Discount fridayDiscountObj = new FridayDiscount(null); // Apply Friday discount separately
        double fridayDiscount = fridayDiscountObj.apply(milk);
        if (fridayDiscount > 0) {
            System.out.println(fridayDiscountObj.getDescription(milk) + ": " + fridayDiscount);
            totalMilkDiscount += fridayDiscount;
        }

        Discount milkDiscountObj = new MilkDiscount(null); // Apply Milk discount separately
        double milkDiscount = milkDiscountObj.apply(milk);
        if (milkDiscount > 0) {
            System.out.println(milkDiscountObj.getDescription(milk) + ": " + milkDiscount);
            totalMilkDiscount += milkDiscount;
        }

        Discount quantityDiscountObj = new QuantityDiscount(null); // Apply Quantity discount separately
        double quantityDiscount = quantityDiscountObj.apply(milk);
        if (quantityDiscount > 0) {
            System.out.println(quantityDiscountObj.getDescription(milk) + ": " + quantityDiscount);
            totalMilkDiscount += quantityDiscount;
        }

        double milkFinalPrice = milkTotalPrice - totalMilkDiscount;  // Final price after discount

        System.out.println("Total discount on milk: " + totalMilkDiscount);
        System.out.println("Final price for milk: " + milkFinalPrice);

        // Apply discounts to the bread product
        System.out.println("\nProcessing product: " + bread.getName());

        double totalBreadDiscount = 0;
        double breadTotalPrice = bread.getPrice() * bread.getQuantity();  // Total price for bread

        // Individual discount application for bread
        fridayDiscountObj = new FridayDiscount(null);
        fridayDiscount = fridayDiscountObj.apply(bread);
        if (fridayDiscount > 0) {
            System.out.println(fridayDiscountObj.getDescription(bread) + ": " + fridayDiscount);
            totalBreadDiscount += fridayDiscount;
        }

        milkDiscountObj = new MilkDiscount(null);
        milkDiscount = milkDiscountObj.apply(bread);
        if (milkDiscount > 0) {
            System.out.println(milkDiscountObj.getDescription(bread) + ": " + milkDiscount);
            totalBreadDiscount += milkDiscount;
        }

        quantityDiscountObj = new QuantityDiscount(null);
        quantityDiscount = quantityDiscountObj.apply(bread);
        if (quantityDiscount > 0) {
            System.out.println(quantityDiscountObj.getDescription(bread) + ": " + quantityDiscount);
            totalBreadDiscount += quantityDiscount;
        }

        double breadFinalPrice = breadTotalPrice - totalBreadDiscount;  // Final price after discount

        System.out.println("Total discount on bread: " + totalBreadDiscount);
        System.out.println("Final price for bread: " + breadFinalPrice);
    }
}
