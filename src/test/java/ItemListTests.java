import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemListTests {

    @Test
    void itemListTest1(){
        CheckOutOrder checkOutOrder = new CheckOutOrder();
        checkOutOrder.addToOrder("Banana");
        checkOutOrder.addToOrder("Carrot");
        checkOutOrder.addToOrder("Pineapple");
        ArrayList<String> finalOrder = checkOutOrder.getFinalOrder();
        ArrayList<String> expected = new ArrayList<>();
        expected.add("banana");
        expected.add("carrot");
        expected.add("pineapple");
        assertEquals(expected, finalOrder);
    }

    @Test
    void itemListTest2(){
        CheckOutOrder checkOutOrder = new CheckOutOrder();
        checkOutOrder.addToOrder("Banana");
        checkOutOrder.addToOrder("Carrot");
        checkOutOrder.addToOrder("Pineapple");
        checkOutOrder.removeFromOrder("Pineapple");
        ArrayList<String> finalOrder = checkOutOrder.getFinalOrder();
        ArrayList<String> expected = new ArrayList<>();
        expected.add("banana");
        expected.add("carrot");
        assertEquals(expected, finalOrder);
    }

    @Test
    void itemListTest3(){
        CheckOutOrder checkOutOrder = new CheckOutOrder();
        checkOutOrder.addToOrder("Banana");
        checkOutOrder.addToOrder("Carrot");
        checkOutOrder.addToOrder("Pineapple");
        checkOutOrder.addToOrder("Pineapple");
        ArrayList<String> finalOrder = checkOutOrder.getFinalOrder();
        ArrayList<String> expected = new ArrayList<>();
        expected.add("banana");
        expected.add("carrot");
        expected.add("pineapple");
        expected.add("pineapple");
        assertEquals(expected, finalOrder);
    }

    @Test
    void itemListTest4(){
        CheckOutOrder checkOutOrder = new CheckOutOrder();
        checkOutOrder.addToOrder("Banana", 2);
        checkOutOrder.addToOrder("Carrot", 5);
        checkOutOrder.addToOrder("pineapple", 7);
        ArrayList<String> finalOrder = checkOutOrder.getFinalOrder();
        ArrayList<String> expected = new ArrayList<>();
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
        assertEquals(expected, finalOrder);
    }

    @Test
    void itemListTest5(){
        CheckOutOrder checkOutOrder = new CheckOutOrder();
        checkOutOrder.addToOrder("Banana", 2);
        checkOutOrder.addToOrder("Carrot", 5);
        checkOutOrder.addToOrder("pineapple", 7);
        checkOutOrder.removeFromOrder("Banana", 2);
        checkOutOrder.removeFromOrder("Carrot", 5);
        checkOutOrder.removeFromOrder("pineapple", 7);
        ArrayList<String> finalOrder = checkOutOrder.getFinalOrder();
        ArrayList<String> expected = new ArrayList<>();
        assertEquals(expected, finalOrder);
    }

}
