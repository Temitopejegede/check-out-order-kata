import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ThrowsErrorTests {

    @Test
    void itemNotFoundTest(){
        assertThrows(IllegalArgumentException.class,
                new Executable() {
                    @Override
                    public void execute() throws Throwable {
                        CheckOutOrder checkOutOrder = new CheckOutOrder();
                        checkOutOrder.addToOrder("avocado");
                    }
                });
    }


}
