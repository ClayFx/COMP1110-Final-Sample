package comp1110.exam;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * COMP1110 Final Exam, Question 3ii
 */
public class Q3StockManager {
    public class Item{
        String sku;
        String vid;
        String name;
        double price;
        Integer targetStock;
        Integer actualStock;

        Item(String sku, String vid, String name, double price){
            this.sku = sku;
            this.vid = vid;
            this.name =name;
            this.price = price;
        }
    }

    HashMap<String,String> vendor = new HashMap<>();
    HashMap<String, Item> itemHashMap =new HashMap<>();
    HashMap<String, Integer> itemActualStock = new HashMap<>();
    HashMap<String, Integer> itemTargetStock = new HashMap<>();
    /**
     * A new vendor has been introduced.
     *
     * @param vid The vid of the new vendor vendor
     * @param name The vendor’s name
     */
    public void newVendor(String vid, String name) {
        vendor.put(vid,name);// FIXME Question 3iia: complete this function
    }

    /**
     * A new product has been introduced.
     *
     * @param sku The product’s sku
     * @param vid The vid of the product's vendor
     * @param name The product’s name
     * @param price The product’s price (per unit)
     */
    public void newItem(String sku, String vid, String name, double price) {
        Item i = new Item(sku,vid,name,price);
        itemHashMap.put(sku,i);
        itemActualStock.put(sku,0);// FIXME Question 3iib: complete this function
    }

    /**
     * Return the name of a product.
     *
     * @param sku The product’s sku
     * @return the name of the product
     */
    public String getItemName(String sku) {
        Item a = itemHashMap.get(sku);
        return a.name;// FIXME Question 3iic: complete this function
    }

    /**
     * Return the name of a product's vendor.
     *
     * @param sku The product’s sku
     * @return the name of the product's vendor
     */
    public String getItemVendorName(String sku) {
        Item a = itemHashMap.get(sku);
        String vendorID = a.vid;
        return vendor.get(vendorID); // FIXME Question 3iid: complete this function
    };

    /**
     * Return the price of a product.
     *
     * @param sku The product’s sku
     * @return the price of the product
     */
    public double getItemPrice(String sku) {
        Item a = itemHashMap.get(sku);
        return a.price; // FIXME Question 3iie: complete this function
    };

    /**
     * Return the amount of stock for a product.
     *
     * @param sku The product’s sku
     * @return the number of items in stock
     */
    public int getStock(String sku) {
        return itemActualStock.get(sku) ; // FIXME Question 3iif: complete this function
    };

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
        return stock; // FIXME Question 3iig: complete this function
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
        itemActualStock.put(sku,stock);// FIXME Question 3iih: complete this function
    }

    /**
     * Set the target amount of stock for a product.
     *
     * @param sku The item’s sku
     * @param target The target quantity desired to be held in stock
     */
    public void setTargetStock(String sku, int target) {
        itemTargetStock.put(sku,target);// FIXME Question 3iij: complete this function
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
        return actual-oldStock;  // FIXME Question 3iik: complete this function
    }

    /**
     * For a given vendor, return a map indicating for each product provided by
     * that vendor, the number of items required in order to reach the target
     * stock for that item (target - stock).   A positive number indicates that
     * stock is needed, a negative number indicates that there is extra stock.
     *
     * @param vid The VID of the vendor to be queried
     * @return A map of item SKUs and the difference between target and actual stock for that item
     */
    public Map<String, Integer> getStockRequired(String vid) {
        HashMap<String, Integer> map = new HashMap<>();
        Set s = itemHashMap.entrySet();
        Iterator iter = s.iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Item a = (Item) entry.getValue();
            if (a.vid==vid) {
                int required = itemTargetStock.get(a.sku)-itemActualStock.get(a.sku);
                map.put(a.sku, required);
            }
        }
        return map;
    }
}
