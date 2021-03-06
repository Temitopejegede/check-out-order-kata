import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ThrowsErrorTests {

    @Test
    void itemNotFoundTest1(){
        assertThrows(IllegalArgumentException.class,
                () -> {
                        CheckOutOrder checkOutOrder = new CheckOutOrder();
                        checkOutOrder.addToOrder("avocado");
                });
    }

    @Test
    void itemNotFoundTest2(){
        assertDoesNotThrow(() -> {
            CheckOutOrder checkOutOrder = new CheckOutOrder();
            checkOutOrder.addToOrder("Banana");
        });
    }

    @Test
    void itemNotFound3(){

        assertThrows(IllegalArgumentException.class,
                () -> {
                    CheckOutOrder checkOutOrder = new CheckOutOrder();
                    checkOutOrder.addToOrder("banana");
                    checkOutOrder.addToOrder("mango");
                    checkOutOrder.addToOrder("tyson drumstick");
                    BigDecimal totalOfItems = checkOutOrder.getTotalAmount();
                });
    }
}
