public class Billing {

    public static void generateBill(ShoppingCart cart) {

        double subtotal = 0;

        System.out.println("\n========== BILL ==========");

        for(CartItem item : cart.getCart()) {

            subtotal += item.getTotalPrice();

            System.out.printf("%-15s x%-3d ₹%.2f\n",
                    item.getProduct().getName(),
                    item.getQuantity(),
                    item.getTotalPrice());
        }

        double gst = subtotal * 0.18;
        double total = subtotal + gst;

        System.out.println("----------------------------");
        System.out.printf("Subtotal : ₹%.2f\n", subtotal);
        System.out.printf("GST (18%%): ₹%.2f\n", gst);
        System.out.println("----------------------------");
        System.out.printf("Grand Total : ₹%.2f\n", total);
    }
}