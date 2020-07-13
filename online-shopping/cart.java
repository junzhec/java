public class cart {
    public static void printCart(String[] cars, int[] price, int[] cartli) {
        //function that print out the shopping cart
        //If the cart is empty, it will say the cart is empty and does not print anything
        System.out.println("\nYou choose option D. Here is the shopping cart");
        int sum = 0;
        for (int i = 0; i < cartli.length; i++) {
            sum = sum + cartli[i];
        }
        if (sum == 0) {
            System.out.println("\nYour cart is currently empty.\n");
        } else {
            System.out.println("itemID\titem name\t\tprice\tnumber");
            int subTotal = 0;
            for (int i = 0; i < cars.length; i++) {
                if (cartli[i] != 0) {
                    System.out.println(i + 1 + "\t" + cars[i] + "\t\t\t" + price[i] + "\t" + cartli[i]);
                    subTotal = subTotal + price[i] * cartli[i];
                }

            }
            System.out.println("Subtotal: " + subTotal);
            System.out.println("Taxes (7.5%): " + subTotal * 0.075);
            System.out.println("Total: " + subTotal * 1.075);
        }

        System.out.println("\n-------------------------------------------------------");
        System.out.println("Please choose your option:");
        System.out.println("-------------------------------------------------------");
    }
}