import java.util.HashMap;
import java.util.Map;

class Product {
    private String name;
    private int quantity;

    public Product(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

class InventoryManager {
    private Map<String, Product> products;

    public InventoryManager() {
        this.products = new HashMap<>();
    }

    public void addProduct(String name, int quantity) {
        products.put(name, new Product(name, quantity));
    }

    public void updateStock(String name, int soldQuantity) {
        Product product = products.get(name);
        if (product != null) {
            int currentQuantity = product.getQuantity();
            if (currentQuantity >= soldQuantity) {
                product.setQuantity(currentQuantity - soldQuantity);
                System.out.println(soldQuantity + " " + name + " sold. Remaining quantity: " + product.getQuantity());
            } else {
                System.out.println("Not enough stock for " + name + ". Available quantity: " + currentQuantity);
            }
        } else {
            System.out.println(name + " not found in the inventory.");
        }
    }

    public void displayStock() {
        System.out.println("Current Stock:");
        for (Product product : products.values()) {
            System.out.println(product.getName() + ": " + product.getQuantity());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        InventoryManager inventoryManager = new InventoryManager();

        // Bootstrap the inventory with initial products and quantities
        inventoryManager.addProduct("Product1", 100);
        inventoryManager.addProduct("Product2", 50);
        inventoryManager.addProduct("Product3", 75);

        // Simulate sales
        inventoryManager.updateStock("Product1", 20);
        inventoryManager.updateStock("Product2", 60);
        inventoryManager.updateStock("Product4", 10); // Product not in inventory

        // Display current stock
        inventoryManager.displayStock();
    }
}
