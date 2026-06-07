
public class CartItems {
    private int foodId; 
    private String name;
    private float price;
    private int quantity;
    private String imageName;
    
    public CartItems(int foodId, String name, float price, int quantity, String imageName) {
        this.foodId = foodId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.imageName = imageName;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public int getFoodId() { 
        return foodId; 
    }
    
    public String getName() { 
        return name; 
    }
    public float getPrice() { 
        return price; 
    }
    public int getQuantity() { 
        return quantity; 
    }
    public String getImageName() { 
        return imageName; 
    }
    public float getTotalPrice() { 
        return price * quantity; 
    }
}