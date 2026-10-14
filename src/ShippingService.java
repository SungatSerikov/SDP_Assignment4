public class ShippingService {
    private int deliveryCount;
    private String lastAddress;

    public String createDelivery(String address) {
        validateAddress(address);

        deliveryCount++;
        lastAddress = address;
        return "SHIP-" + deliveryCount;
    }

    public void validateAddress(String address) {
        if (address == null || address.isBlank()) {
            throw new IllegalArgumentException("Delivery address must not be blank");
        }
    }

    public int getDeliveryCount() {
        return deliveryCount;
    }

    public String getLastAddress() {
        return lastAddress;
    }
}
