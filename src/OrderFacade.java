public class OrderFacade {
    private final InventoryService inventory;
    private final PaymentProcessor payment;
    private final ShippingService shipping;
    private final NotificationService notification;
    private final int laptopPrice;

    public OrderFacade(int initialStock, int initialBalance, int laptopPrice) {
        if (laptopPrice <= 0) {
            throw new IllegalArgumentException("Laptop price must be positive");
        }
        this.laptopPrice = laptopPrice;
        inventory = new InventoryService(initialStock);
        payment = new PaymentProcessor(initialBalance);
        shipping = new ShippingService();
        notification = new NotificationService();
    }

    public boolean placeOrder(int quantity, String address, String email) {
        shipping.validateAddress(address);
        notification.validateEmail(email);
        int totalPrice = Math.multiplyExact(quantity, laptopPrice);

        inventory.reserve(quantity);

        if (!payment.pay(totalPrice)) {
            inventory.release(quantity);
            System.out.println("Payment declined. Reserved laptops returned to stock.");
            return false;
        }

        String trackingNumber = shipping.createDelivery(address);
        inventory.completePurchase(quantity);
        notification.sendConfirmation(email, trackingNumber);
        return true;
    }

    public int getAvailableStock() {
        return inventory.getAvailableStock();
    }

    public int getReservedStock() {
        return inventory.getReservedStock();
    }

    public int getBalance() {
        return payment.getBalance();
    }
}
