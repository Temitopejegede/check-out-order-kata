import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemTotalTests {

    @Test
    void scannedItemsTotalTest1(){
        Cart cart = new Cart();
        cart.add("banana");
        cart.add("mango");
        cart.add("tyson drumstick");
        BigDecimal totalOfItems = cart.getTotal();
        assertEquals(10, totalOfItems);
    }

    @Test
    void scannedItemsTotalTest2(){
        Cart cart = new Cart();
        cart.add("grapes");
        cart.add("avocado");
        cart.add("beans");
        BigDecimal totalOfItems = cart.getTotal();
        assertEquals(12.73, totalOfItems);
    }

    @Test
    void scannedItemsTotalTest3(){
        Cart cart = new Cart();
        cart.add("apples");
        cart.add("oranges");
        cart.add("tomatoes");
        cart.remove("apples");
        cart.add("avocado");
        cart.remove("oranges");
        BigDecimal totalOfItems = cart.getTotal();
        assertEquals(3.74, totalOfItems);
    }
}
