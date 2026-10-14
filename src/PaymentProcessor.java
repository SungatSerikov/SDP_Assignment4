public class PaymentProcessor {
    private int balance;

    public PaymentProcessor(int initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance must not be negative");
        }
        balance = initialBalance;
    }

    public boolean pay(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Payment amount must be positive");
        }
        if (balance < amount) {
            return false;
        }

        balance -= amount;
        return true;
    }

    public int getBalance() {
        return balance;
    }
}
