public class Main {
    public static void main(String[] args) {
        OrderFacade shop = new OrderFacade(5, 1000, 300);

        System.out.println("buy 2 laptops");
        boolean firstOrder = shop.placeOrder(2, "Abay Street, 10", "student@example.com");
        System.out.println("Order successful: " + firstOrder);
        printStatus(shop);

        System.out.println();
        System.out.println("buy 2 more laptops with insufficient money");
        boolean secondOrder = shop.placeOrder(2, "Abay Street, 10", "student@example.com");
        System.out.println("Order successful: " + secondOrder);
        printStatus(shop);
    }

    private static void printStatus(OrderFacade shop) {
        System.out.println("Available laptops: " + shop.getAvailableStock());
        System.out.println("Reserved laptops: " + shop.getReservedStock());
        System.out.println("Balance: " + shop.getBalance());
    }
}
