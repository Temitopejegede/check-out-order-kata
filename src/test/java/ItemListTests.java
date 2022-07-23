import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ItemListTests {

    @Test
    void itemListTest1(){
        CheckOutOrder checkOutOrder = new CheckOutOrder();
        checkOutOrder.addToOrder("Banana");
        checkOutOrder.addToOrder("Carrot");
        checkOutOrder.addToOrder("Pineapple");
        Map<String, BigDecimal> finalOrder = checkOutOrder.getFinalOrder();
        Set<String> strings = finalOrder.keySet();
        Set<String> answer = new HashSet<>();
        answer.add("banana");
        answer.add("carrot");
        answer.add("pineapple");
        assertEquals(answer, strings);
    }

    @Test
    void itemListTest2(){
        CheckOutOrder checkOutOrder = new CheckOutOrder();
        checkOutOrder.addToOrder("Banana");
        checkOutOrder.addToOrder("Carrot");
        checkOutOrder.addToOrder("Pineapple");
        checkOutOrder.removeFromOrder("Pineapple");
        Map<String, BigDecimal> finalOrder = checkOutOrder.getFinalOrder();
        Set<String> strings = finalOrder.keySet();
        Set<String> answer = new HashSet<>();
        answer.add("banana");
        answer.add("carrot");
        assertEquals(answer, strings);
    }


}
