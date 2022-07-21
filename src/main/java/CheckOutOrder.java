import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CheckOutOrder {

    List<String> itemList = new ArrayList<>();
    List<String> activeDeals = new ArrayList<>();

    Map<String, BigDecimal> prices = new HashMap<>();

    public BigDecimal total = BigDecimal.valueOf(0);
    public CheckOutOrder() {

    }

    public CheckOutOrder(List<String> activeDeals){
        this.activeDeals = activeDeals;
    }

    void addToOrder(String itemName)
            throws IllegalArgumentException{
        for(Item c : Item.values()){
            if(c.name().equalsIgnoreCase(itemName)){
                String item = c.name();
                itemList.add(item);
                break;
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
        itemList.remove(itemName);
    }

    public BigDecimal getTotalAmount() {
        return null;
    }

    public void makePriceList(){
        for(Item c : Item.values()){
            prices.put(c.name(), c.getPrice());
        }
    }



    //need methods for markdown
    //need methods for when there is a promo like by 1 get 1 free
}
