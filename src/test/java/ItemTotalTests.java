import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemTotalTests {

    @Test
    void scannedItemsTotalTest1(){
        CheckOutOrder checkOutOrder = new CheckOutOrder();
        checkOutOrder.addToOrder("banana");
        checkOutOrder.addToOrder("mango");
        checkOutOrder.addToOrder("tyson drumstick");
        BigDecimal totalOfItems = checkOutOrder.getTotalAmount();
        assertEquals(BigDecimal.valueOf(10), totalOfItems);
    }

    @Test
    void scannedItemsTotalTest2(){
        CheckOutOrder checkOutOrder = new CheckOutOrder();
        checkOutOrder.addToOrder("grapes");
        checkOutOrder.addToOrder("avocado");
        checkOutOrder.addToOrder("beans");
        BigDecimal totalOfItems = checkOutOrder.getTotalAmount();
        assertEquals(BigDecimal.valueOf(12.73), totalOfItems);
    }

    @Test
    void scannedItemsTotalTest3(){
        CheckOutOrder checkOutOrder = new CheckOutOrder();
        checkOutOrder.addToOrder("apples");
        checkOutOrder.addToOrder("oranges");
        checkOutOrder.addToOrder("tomatoes");
        checkOutOrder.removeFromOrder("apples");
        checkOutOrder.addToOrder("avocado");
        checkOutOrder.removeFromOrder("oranges");
        BigDecimal totalOfItems = checkOutOrder.getTotalAmount();
        assertEquals(BigDecimal.valueOf(3.47), totalOfItems);
    }
}
