import java.util.ArrayList;

public class ShoppingCart {

    ArrayList<CartItem> cart = new ArrayList<>();

    public void addProduct(Product product, int qty) {

        for(CartItem item : cart) {
            if(item.getProduct().getId() == product.getId()) {
                item.setQuantity(item.getQuantity() + qty);
                return;
            }
        }

        cart.add(new CartItem(product, qty));
    }

    public void removeProduct(int id) {

        cart.removeIf(item -> item.getProduct().getId() == id);
    }

    public void displayCart() {

        if(cart.isEmpty()) {
            System.out.println("Cart is Empty.");
            return;
        }

        System.out.println("---------------------------------------------");
        System.out.printf("%-5s %-15s %-8s %-8s %-10s\n",
                "ID","Product","Qty","Price","Total");

        for(CartItem item : cart) {

            System.out.printf("%-5d %-15s %-8d %-8.2f %-10.2f\n",
                    item.getProduct().getId(),
                    item.getProduct().getName(),
                    item.getQuantity(),
                    item.getProduct().getPrice(),
                    item.getTotalPrice());
        }
    }

    public ArrayList<CartItem> getCart() {
        return cart;
    }
}