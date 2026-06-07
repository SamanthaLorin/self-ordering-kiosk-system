import java.util.ArrayList;
import java.util.List;

public class CartManager {
    private static CartManager instance;        // reference sa CartManager object na ginagamit sa overall system ni customer
    private List<CartItems> cartList;           // dito napupunta yung mga items na pinaga-add to cart ni customer
    public static String orderMethod = "";
    public static String discountType = "";   
    public static float discountAmount = 0.0f;

    private CartManager() {
        cartList = new ArrayList<>();           // ArrayList for Storing
    }
    
    // Basically ito yung pang 'call' ng CartManager sa iba pang Frame/Dialog/Classes since nagdeclare tayo ng Private CartManager().
    public static synchronized CartManager getInstance() {
        if (instance == null) {
            instance = new CartManager();
        }
        return instance;
    }
    
    // Check item in Cart --> Add Quantity (x1) --> Return (Para no duplicates) 
    public void addItem(int foodId, String name, float price, int qty, String imageName) {
        for (CartItems item : cartList) {
            if (item.getFoodId() == foodId) {
                item.setQuantity(item.getQuantity() + qty);
                return;
            }
        }
        cartList.add(new CartItems(foodId, name, price, qty, imageName));
    }
    
    // para makuha at ma-loop ang lahat ng items sa cart
    public List<CartItems> getCartList() {
        return cartList;
    }
    
    
    public float calculateTotal() {
        float total = 0;                        // variable for total
        
        // LOOP! Find Item sa Cart --> Price * Qty --> Add All Items for Total
        for (CartItems item : cartList) {       
            total += item.getTotalPrice();
        }
        return total;
    }
    
    // Parang ++ lang siya :> 
    public void updateQuantityUp(int foodId) {
        for (CartItems item : cartList) {
            if (item.getFoodId() == foodId) {
                item.setQuantity(item.getQuantity() + 1); 
                return; 
            }
        }
    }
    
    public void updateQuantityDown(int foodId) {
        for (CartItems item : cartList) {
            if (item.getFoodId() == foodId) {
                if (item.getQuantity() > 1) {
                    item.setQuantity(item.getQuantity() - 1);
                }
                return; 
            }
        }
    }
    public void removeItem(int foodId) {  
        cartList.removeIf(item -> item.getFoodId() == foodId);
}   
    public void clearCart() {
    cartList.clear();
    orderMethod = "";
    discountType = "";   
    discountAmount = 0.0f; 
    }
}


