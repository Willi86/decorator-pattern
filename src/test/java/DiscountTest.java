import org.example.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DiscountTest {

    @Test
    public void testMilkDiscount() {
        // Product: Milk (eligible for milk discount)
        Product milk = new Product("milk", 40, 6);  // 6 units of milk, 40 kronor each
        Discount discountChain = new MilkDiscount(null);  // Only apply MilkDiscount

        double discount = discountChain.apply(milk);
        assertEquals(12.0, discount, 0.01);  // Expecting a 5% discount of 240 = 12
    }

    @Test
    public void testFridayDiscount() {
        // Product: Bread (eligible for Friday discount)
        Product bread = new Product("bread", 30, 2);  // 2 loaves of bread, 30 kronor each
        Discount discountChain = new FridayDiscount(null);  // Only apply FridayDiscount

        double discount = discountChain.apply(bread);
        assertEquals(6.0, discount, 0.01);  // Expecting a 10% discount of 60 = 6
    }

    @Test
    public void testQuantityDiscount() {
        // Product: Any product with quantity >= 5 (eligible for QuantityDiscount)
        Product product = new Product("tea", 10, 5);  // 5 units of tea, 10 kronor each
        Discount discountChain = new QuantityDiscount(null);  // Only apply QuantityDiscount

        double discount = discountChain.apply(product);
        assertEquals(50.0, discount, 0.01);  // Expecting 10 kronor per unit for 5 units = 50
    }

    @Test
    public void testAllDiscounts() {
        // Product: Milk (eligible for all discounts on a Friday with quantity >= 5)
        Product milk = new Product("milk", 40, 6);  // 6 units of milk, 40 kronor each
        Discount discountChain = new FridayDiscount(new MilkDiscount(new QuantityDiscount(null)));

        double discount = discountChain.apply(milk);
        assertEquals(96.0, discount, 0.01);  // 24 (Friday) + 12 (Milk) + 60 (Quantity) = 96 total discount
    }
}
