import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
}
