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

    //maybe make a "deals" class with custom attributes
    List<String> activeDeals = new ArrayList<>();

    private  Map<String, BigDecimal> allItemsAndPrices = new HashMap<>();

    private ArrayList<String> finalOrder = new ArrayList<>();

    public BigDecimal total = BigDecimal.valueOf(0);
    public CheckOutOrder() {
        makePriceList();
    }

    public CheckOutOrder(List<String> activeDeals){
        this.activeDeals = activeDeals;
    }

    void addToOrder(String itemName)
            throws IllegalArgumentException{
        if(!getAllItemsAndPrices().containsKey(itemName.toLowerCase())) throw new IllegalArgumentException(itemName + " not found");
        finalOrder.add(itemName.toLowerCase());
        total = total.add(allItemsAndPrices.get(itemName.toLowerCase()));
    }

    void addToOrder(String itemName, int itemQuantity)
            throws IllegalArgumentException{
        if(!getAllItemsAndPrices().containsKey(itemName.toLowerCase())) throw new IllegalArgumentException(itemName + " not found");
        for(int i = 0; i< itemQuantity; i++) finalOrder.add(itemName.toLowerCase());
        BigDecimal cost = getAllItemsAndPrices().get(itemName.toLowerCase()).multiply(new BigDecimal(itemQuantity));
        total = total.add(cost);
    }

    private void addToOrder(String itemName,
                            double itemWeight)
            throws IllegalArgumentException {

    }

    void removeFromOrder(String itemName){
        finalOrder.remove(itemName.toLowerCase());
        total = total.subtract(allItemsAndPrices.get(itemName.toLowerCase()));
    }

    void removeFromOrder(String itemName, int itemQuantity){
        for(int i = 0; i< itemQuantity; i++) finalOrder.remove(itemName.toLowerCase());
        BigDecimal cost = getAllItemsAndPrices().get(itemName.toLowerCase()).multiply(new BigDecimal(itemQuantity));
        total = total.subtract(cost);
    }

    public BigDecimal getTotalAmount() {
        return total;
    }

    public void makePriceList(){
        for(Item c : Item.values()){
            allItemsAndPrices.put(c.name().toLowerCase(), c.getPrice());
        }
    }


    public ArrayList<String> getFinalOrder() {
        return finalOrder;
    }

    //need methods for markdown
    //need methods for when there is a promo like by 1 get 1 free
}
