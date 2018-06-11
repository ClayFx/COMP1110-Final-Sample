package comp1110.exam;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * COMP1110 Final Exam, Question 3i
 */
public class Q3SimpleStockManager {
    HashMap<String, String> itemName = new HashMap<>();
    HashMap<String, Double> itemPrice = new HashMap<>();
    HashMap<String, Integer> itemTargetStock = new HashMap<>();
    HashMap<String, Integer> itemActualStock = new HashMap<>();
    /**
     * A new product has been introduced.
     *
     * @param sku The product’s sku
     * @param name The product’s name
     * @param price The product’s price (per unit)
     */
    public void newItem(String sku, String name, double price) {
        // FIXME Question 3ia: complete this function
        itemName.put(sku,name);
        itemPrice.put(sku, price);
        itemActualStock.put(sku,0);
    }

    /**
     * Return the name of a product.
     *
     * @param sku The product’s sku
     * @return the name of the product
     */
    public String getItemName(String sku) {
       return itemName.get(sku); // FIXME Question 3ib: complete this function
    }

    /**
     * Return the price of a product.
     *
     * @param sku The product’s sku
     * @return the price of the product
     */
    public double getItemPrice(String sku) {
        return itemPrice.get(sku); // FIXME Question 3ic: complete this function
    }

    /**
     * Return the amount of stock for a product.
     *
     * @param sku The product’s sku
     * @return the number of items in stock
     */
    public int getStock(String sku) {
        return itemActualStock.get(sku); // FIXME Question 3id: complete this function
    }

    /**
     * An product has been sold; reduce current stock accordingly.
     *
     * @param sku The product’s sku
     * @param sold The quantity sold
     * @return The number of items of stock remaining after the sale
     */
    public int sale(String sku, int sold) {
        int stock = itemActualStock.get(sku);
        stock = stock - sold;
        itemActualStock.put(sku,stock);
        return stock;// FIXME Question 3ie: complete this function
    }

    /**
     * New stock has arrived; increase current stock accordingly.
     *
     * @param sku The product’s sku
     * @param added The quantity newly arrived
     */
    public void addStock(String sku, int added) {
        int stock = itemActualStock.get(sku);
        stock = stock + added;
        itemActualStock.put(sku,stock);// FIXME Question 3if: complete this function
    }

    /**
     * Set the target amount of stock for a product.
     *
     * @param sku The item’s sku
     * @param target The target quantity desired to be held in stock
     */
    public void setTargetStock(String sku, int target) {
        itemTargetStock.put(sku,target);// FIXME Question 3ig: complete this function
    }

    /**
     * Stock has been carefully counted. Set current stock correctly.
     *
     * @param sku The product’s sku
     * @param actual The quantity actually in the store
     * @return The stock loss or gain (new current – old current)
     */
    public int setActualStock(String sku, int actual) {
        int oldStock = itemActualStock.get(sku);
        itemActualStock.put(sku,actual);
        return actual-oldStock;// FIXME Question 3ih: complete this function
    }

    /**
     * Return the number of items required for a given product
     * in order to reach the target stock for that item (target - stock)
     *
     * @param sku The SKU of the item to be queried
     * @return The difference between target and actual stock for that item
     */
    public int getStockRequired(String sku) {
        int target = itemTargetStock.get(sku);
        int actual = itemActualStock.get(sku);
        return target - actual;// FIXME Question 3ii: complete this function
    }

    /**
     * @return the value of the currently held stock (the price of the
     * product multiplied by the number of items in stock, for all items).
     */
    public double totalStockValue() {
        int value = 0;
        Set item = itemName.entrySet();
        Iterator iter = item.iterator();
        while (iter.hasNext()){
            Map.Entry map = (Map.Entry) iter.next();
            String names = (String) map.getKey();
            double price = itemPrice.get(names);
            int stock = itemActualStock.get(names);
            value += price * stock;
        }
        return value;
    }
}
