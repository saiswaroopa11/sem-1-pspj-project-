import java.util.Scanner;

class Order {
    void orderStatus() {
        System.out.println("Order Status: Processing");
    }
}

class OnlineOrder extends Order {
    @Override
    void orderStatus() {
        System.out.println("Order Status: Order Confirmed");
    }
}

public class OnlineStoreCart {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] products = {"Laptop", "Headphones", "Mobile", "Keyboard"};
        int[] prices = {50000, 2000, 20000, 1000};

        int total = 0;
        int choice;

        System.out.println("===== ONLINE STORE CART =====");

        // Loop
        while (true) {

            System.out.println("\n1. Laptop - ₹50000");
            System.out.println("2. Headphones - ₹2000");
            System.out.println("3. Mobile - ₹20000");
            System.out.println("4. Keyboard - ₹1000");
            System.out.println("5. Checkout");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            // if-else
            if (choice >= 1 && choice <= 4) {

                System.out.print("Enter quantity: ");
                int quantity = sc.nextInt();

                int amount = prices[choice - 1] * quantity;
                total = total + amount;

                System.out.println(products[choice - 1] +
                        " added to cart.");
                System.out.println("Amount = ₹" + amount);

            } 
            else if (choice == 5) {
                break;
            } 
            else {
                System.out.println("Invalid choice!");
            }
        }

        // Operator
        double discount;

        if (total >= 30000) {
            discount = total * 0.10;
        } 
        else {
            discount = total * 0.05;
        }

        double finalAmount = total - discount;

        System.out.println("\n===== ORDER SUMMARY =====");
        System.out.println("Total Amount = ₹" + total);
        System.out.println("Discount = ₹" + discount);
        System.out.println("Final Amount = ₹" + finalAmount);

        // Method Overloading
        displayOrder("Online Order", finalAmount);
        displayOrder("Online Order", finalAmount, "Cash on Delivery");

        // Method Overriding
        Order order = new OnlineOrder();
        order.orderStatus();

        sc.close();
    }

    // Method Overloading - 2 parameters
    static void displayOrder(String type, double amount) {
        System.out.println("Order Type: " + type);
        System.out.println("Amount: ₹" + amount);
    }

    // Method Overloading - 3 parameters
    static void displayOrder(String type, double amount, String payment) {
        System.out.println("Order Type: " + type);
        System.out.println("Amount: ₹" + amount);
        System.out.println("Payment: " + payment);
    }
}