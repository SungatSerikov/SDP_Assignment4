# Online Order Processing — Facade Pattern

The Facade pattern provides a simplified interface to a complex subsystem.

In this project, `OrderFacade` coordinates four services:

- **InventoryService** — checks stock, reserves laptops, releases reservations, and completes purchases.
- **PaymentProcessor** — checks the balance and processes payments.
- **ShippingService** — validates addresses and creates tracking numbers.
- **NotificationService** — validates the recipient and displays an order confirmation.

`Main` is the client and uses only `OrderFacade`. The services do not depend on the facade and can be used independently. Delivery and notifications are simulated.

## How It Works

The client places an order through a single method:

```java
OrderFacade shop = new OrderFacade(5, 1000, 300);
boolean success = shop.placeOrder(2, "Abay Street, 10", "student@example.com");
```

The constructor sets the initial stock, balance, and price per laptop.

The facade handles the following steps:

1. Validate the address and email, and calculate the total price.
2. Reserve laptops.
3. Process payment.
4. Create a delivery and complete the purchase.
5. Display an order confirmation.

If payment is declined, the facade releases the reserved laptops and returns `false`. Stock is restored, the balance stays unchanged, and delivery and notification are skipped. This is the rollback implemented in this project.

## Project Structure

```text
src/
├── Main.java
├── OrderFacade.java
├── InventoryService.java
├── PaymentProcessor.java
├── ShippingService.java
└── NotificationService.java
```

## Technologies

- Java 17
- Facade Design Pattern
- Object-Oriented Programming (OOP)

## Running the Project

Open the project in IntelliJ IDEA, select JDK 17, and run `Main.java`.

The program demonstrates two orders:

- The first order buys 2 laptops for 600. Stock becomes 3 and the balance becomes 400.
- The second order also costs 600, but the balance is insufficient. Payment is declined and the reservation is released. Stock remains 3 and the balance remains 400.

## Clean Code Principles

- **Meaningful names** — names such as `availableStock` and `reserve()` describe their purpose.
- **Single Responsibility Principle** — each service handles one part of the order process.
- **Encapsulation** — the facade keeps its service objects private.
- **DRY** — `validateQuantity()` is reused for stock operations.
- **Proper error handling and rollback** — invalid input is rejected and a declined payment releases the reservation.

## Conclusion

The Facade pattern simplifies order processing by hiding subsystem interactions behind one method. The client does not need to manage the order of service calls or the rollback after a declined payment.
