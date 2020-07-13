import java.util.Scanner;

public class payment {
    public static String makePayment(String[] cars, int[] price, int[] cartli) {
        //function that will print out the item list that user want to purchase and ask user for final decision
        System.out.println("\nYou choose option M. Here is the shopping cart");
        int sum = 0;
        for (int i = 0; i < cartli.length; i++) {
            sum = sum + cartli[i];
        }
        if (sum == 0) {
            System.out.println("\nYou cart is empty, you cannot make payment right now.");
            System.out.println("\n-------------------------------------------------------");
            System.out.println("Please choose your option:");
            System.out.println("-------------------------------------------------------\n");
            return "m";
        } else {
            System.out.println("itemID\titem name\t\tprice\tnumber");
            Scanner sc = new Scanner(System.in);
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
            System.out.println("\n-------------------------------------------------------");
            System.out.println("Are you sure you want to make payment (y or n):");
            System.out.println("-------------------------------------------------------");
            String answer = sc.next();
            if (answer.equals("y")) {
                return "e";
            } else {
                return "m";
            }
        }

    }
}