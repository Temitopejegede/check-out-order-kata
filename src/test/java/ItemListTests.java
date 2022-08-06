import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.nio.channels.Pipe;
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
        Set<String> itemNames = finalOrder.keySet();
        Set<String> expected = new HashSet<>();
        expected.add("banana");
        expected.add("carrot");
        expected.add("pineapple");
        assertEquals(expected, itemNames);
    }

    @Test
    void itemListTest2(){
        CheckOutOrder checkOutOrder = new CheckOutOrder();
        checkOutOrder.addToOrder("Banana");
        checkOutOrder.addToOrder("Carrot");
        checkOutOrder.addToOrder("Pineapple");
        checkOutOrder.removeFromOrder("Pineapple");
        Map<String, BigDecimal> finalOrder = checkOutOrder.getFinalOrder();
        Set<String> itemNames = finalOrder.keySet();
        Set<String> expected = new HashSet<>();
        expected.add("banana");
        expected.add("carrot");
        assertEquals(expected, itemNames);
    }

    @Test
    void itemListTest3(){
        CheckOutOrder checkOutOrder = new CheckOutOrder();
        checkOutOrder.addToOrder("Banana");
        checkOutOrder.addToOrder("Carrot");
        checkOutOrder.addToOrder("Pineapple");
        checkOutOrder.addToOrder("Pineapple");
        Map<String, BigDecimal> finalOrder = checkOutOrder.getFinalOrder();
        Set<String> itemNames = finalOrder.keySet();
        Set<String> expected = new HashSet<>();
        expected.add("banana");
        expected.add("carrot");
        expected.add("pineapple");
//        expected.add("pineapple");
        assertEquals(expected, itemNames);
    }

    @Test
    void itemListTest4(){
        CheckOutOrder checkOutOrder = new CheckOutOrder();
        checkOutOrder.addToOrder("Banana", 2);
        checkOutOrder.addToOrder("Carrot", 5);
        checkOutOrder.addToOrder("pineapple", 7);
        Map<String, BigDecimal> finalOrder = checkOutOrder.getFinalOrder();
        Set<String> itemNames = finalOrder.keySet();
        Set<String> expected = new HashSet<>();
        expected.add("banana");
        expected.add("banana");
        expected.add("carrot");
        expected.add("carrot");
        expected.add("carrot");
        expected.add("carrot");
        expected.add("carrot");
        expected.add("pineapple");
        expected.add("pineapple");
        expected.add("pineapple");
        expected.add("pineapple");
        expected.add("pineapple");
        expected.add("pineapple");
        expected.add("pineapple");
        assertEquals(expected, itemNames);
    }

}
