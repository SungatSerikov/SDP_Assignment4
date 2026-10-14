public class NotificationService {
    private String lastMessage;

    public void sendConfirmation(String email, String trackingNumber) {
        validateEmail(email);
        if (trackingNumber == null || trackingNumber.isBlank()) {
            throw new IllegalArgumentException("Tracking number must not be blank");
        }

        lastMessage = "To: " + email
                + " | Your order is confirmed. Tracking number: " + trackingNumber;
        System.out.println(lastMessage);
    }

    public void validateEmail(String email) {
        if (email == null || email.isBlank() || !email.contains("@")) {
            throw new IllegalArgumentException("Email must contain @ and must not be blank");
        }
    }

    public String getLastMessage() {
        return lastMessage;
    }
}
