import java.util.*;

public class ShoppingApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Product> products = new ArrayList<>();

        products.add(new Product(101,"Laptop",60000,10));
        products.add(new Product(102,"Mouse",500,50));
        products.add(new Product(103,"Keyboard",1000,30));
        products.add(new Product(104,"Headphones",2500,20));
        products.add(new Product(105,"Pendrive",800,40));

        ShoppingCart cart = new ShoppingCart();

        int choice;

        do {

            System.out.println("\n====== SHOPPING MENU ======");
            System.out.println("1.View Products");
            System.out.println("2.Add to Cart");
            System.out.println("3.View Cart");
            System.out.println("4.Remove Product");
            System.out.println("5.Generate Bill");
            System.out.println("6.Exit");

            System.out.print("Enter Choice : ");
            choice = sc.nextInt();

            switch(choice) {

                case 1:

                    System.out.println("--------------------------------------------");
                    System.out.printf("%-5s %-15s %-10s\n",
                            "ID","Product","Price");

                    for(Product p : products) {

                        System.out.printf("%-5d %-15s ₹%-10.2f\n",
                                p.getId(),
                                p.getName(),
                                p.getPrice());
                    }

                    break;

                case 2:

                    System.out.print("Enter Product ID : ");
                    int id = sc.nextInt();

                    System.out.print("Enter Quantity : ");
                    int qty = sc.nextInt();

                    for(Product p : products) {

                        if(p.getId() == id) {

                            if(qty <= p.getStock()) {

                                cart.addProduct(p, qty);
                                p.reduceStock(qty);

                                System.out.println("Added Successfully.");
                            }
                            else {
                                System.out.println("Insufficient Stock.");
                            }
                        }
                    }

                    break;

                case 3:
                    cart.displayCart();
                    break;

                case 4:

                    System.out.print("Enter Product ID : ");
                    int remove = sc.nextInt();

                    cart.removeProduct(remove);

                    System.out.println("Removed Successfully.");

                    break;

                case 5:
                    Billing.generateBill(cart);
                    break;

                case 6:
                    System.out.println("Thank You for Shopping.");
                    break;

                default:
                    System.out.println("Invalid Choice.");
            }

        } while(choice != 6);

        sc.close();
    }
}