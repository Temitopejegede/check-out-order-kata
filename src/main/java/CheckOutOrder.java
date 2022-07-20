import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CheckOutOrder {

    List<Item> itemList;
    List<String> activeDeals = new ArrayList<>();
    public CheckOutOrder() {

    }

    public CheckOutOrder(List<String> activeDeals){
        this.activeDeals = activeDeals;
    }

    void addToOrder(String itemName) throws IllegalArgumentException{
        for(Item c : Item.values()){
            if(c.name().equals(itemName)){
                itemList.add(c);

            }
            else {
                throw new IllegalArgumentException(itemName + " not found");
            }
        }
    }

    private void addToOrder(String itemName,
                            double itemWeight)
            throws IllegalArgumentException {

    }

    void removeFromOrder(String itemName){

    }

    public BigDecimal getTotalAmount() {

        return null;
    }



    //need methods for markdown
    //need methods for when there is a promo like by 1 get 1 free
}
