import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemTotalTests {



    @Test
    void scannedItemsTotalTest2(){
        CheckOutOrder checkOutOrder = new CheckOutOrder();
        checkOutOrder.addToOrder("banana");
        checkOutOrder.addToOrder("carrot");
        checkOutOrder.addToOrder("noodles");
        BigDecimal totalOfItems = checkOutOrder.getTotalAmount();
        assertEquals(BigDecimal.valueOf(0.83), totalOfItems);
    }

    @Test
    void scannedItemsTotalTest3(){
        CheckOutOrder checkOutOrder = new CheckOutOrder();
        checkOutOrder.addToOrder("noodles");
        checkOutOrder.addToOrder("strawberry");
        checkOutOrder.addToOrder("carrot");
        checkOutOrder.removeFromOrder("noodles");
        checkOutOrder.addToOrder("carrot");
        checkOutOrder.removeFromOrder("strawberry");
        BigDecimal totalOfItems = checkOutOrder.getTotalAmount().stripTrailingZeros();
        assertEquals(BigDecimal.valueOf(1), totalOfItems);
    }

    @Test
    void scannedItemsTotalTest4(){
        CheckOutOrder checkOutOrder = new CheckOutOrder();
        checkOutOrder.addToOrder("Banana", 2);
        checkOutOrder.addToOrder("Carrot", 5);
        checkOutOrder.addToOrder("pineapple", 7);
        checkOutOrder.removeFromOrder("Banana", 2);
        checkOutOrder.removeFromOrder("Carrot", 5);
        checkOutOrder.removeFromOrder("pineapple", 7);
        BigDecimal finalAmount = checkOutOrder.getTotalAmount();
        BigDecimal expected = new BigDecimal(0);
        assertEquals(expected.precision(), finalAmount.precision());

    }
}
