import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class CheckOutOrder {

    List<String> itemList = new ArrayList<>();

    public Map<String, BigDecimal> getAllItemsAndPrices() {
        return allItemsAndPrices;
    }

    List<String> activeDeals = new ArrayList<>();

    private static Map<String, BigDecimal> allItemsAndPrices = new HashMap<>();

    private static Map<String, BigDecimal> finalOrder = new HashMap<>();

    public BigDecimal total = BigDecimal.valueOf(0);
    public CheckOutOrder() {
        makePriceList();
    }

    public CheckOutOrder(List<String> activeDeals){
        this.activeDeals = activeDeals;
    }

    void addToOrder(String itemName)
            throws IllegalArgumentException{
        boolean found = false;
        for(Map.Entry<String, BigDecimal> entry : allItemsAndPrices.entrySet()){
            if(entry.getKey().equalsIgnoreCase(itemName)){
                found = true;
                finalOrder.put(entry.getKey().toLowerCase(), entry.getValue());
                total = total.add(new BigDecimal(String.valueOf(entry.getValue())));
                break;
            }
        }
        if(!found) throw new IllegalArgumentException(itemName + " not found");
    }

    void addToOrder(String itemName, int itemQuantity){

    }

    private void addToOrder(String itemName,
                            double itemWeight)
            throws IllegalArgumentException {

    }

    void removeFromOrder(String itemName){
        finalOrder.remove(itemName.toLowerCase());
        total = total.subtract(new BigDecimal(String.valueOf(allItemsAndPrices.get(itemName.toLowerCase()))));
    }

    void removeFromOrder(String itemName, int itemQuantity){

    }

    public BigDecimal getTotalAmount() {
        return total;
    }

    public void makePriceList(){
        for(Item c : Item.values()){
            allItemsAndPrices.put(c.name().toLowerCase(), c.getPrice());
        }
    }


    public Map<String, BigDecimal> getFinalOrder() {
        return finalOrder;
    }

    //need methods for markdown
    //need methods for when there is a promo like by 1 get 1 free
}
