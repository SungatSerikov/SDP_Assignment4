public class InventoryService {
    private int availableStock;
    private int reservedStock;

    public InventoryService(int initialStock) {
        if (initialStock < 0) {
            throw new IllegalArgumentException("Initial stock must not be negative");
        }
        availableStock = initialStock;
    }
    public int getAvailableStock() {return availableStock;}
    public int getReservedStock() {return reservedStock;}


    public void reserve(int quantity) {
        validateQuantity(quantity);
        if (availableStock < quantity) {
            throw new IllegalStateException("Not enough laptops in stock");
        }

        availableStock -= quantity;
        reservedStock += quantity;
    }

    public void release(int quantity) {
        validateQuantity(quantity);
        if (reservedStock < quantity) {
            throw new IllegalStateException("Not enough reserved laptops");
        }
        reservedStock -= quantity;
        availableStock += quantity;
    }

    public void completePurchase(int quantity) {
        validateQuantity(quantity);
        if (reservedStock < quantity) {
            throw new IllegalStateException("Not enough reserved laptops");
        }
        reservedStock -= quantity;
    }

    private void validateQuantity(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }
    }
}
