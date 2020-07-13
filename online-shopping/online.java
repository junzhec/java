import java.util.function.*;
import java.util.Scanner;

public class online {
    //Main file let the user choose options
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] cars = { "Volvo", "BMW", "Ford", "Mazda" };
        int[] price = { 1000, 1000, 1000, 1000 };
        int[] stock = { 2, 4, 6, 8 };
        int[] cartli = { 0, 0, 0, 0 };
        String option = "";
        System.out.println("-------------------------------------------------------");
        System.out.println("Welcome to online shopping, please choose your option:");
        System.out.println("-------------------------------------------------------");
        while (!option.equals("e")) {
            System.out.println(
                    "A. See the menu \nB. Make purchase \nC. Cancel items \nD. View shopping cart\nM. Make payment\nE. Exit");
            System.out.print("Your answer:");
            option = sc.nextLine().toLowerCase();
            //switch case that handle different user input
            switch (option) {
                case "a":
                    menu.printMenu(cars, price, stock, cartli);
                    break;
                case "b":
                    System.out.println("You choose option B, Please enter itemID and number: (e.g. 3 2)\n");
                    System.out.print("Your answer:");
                    String purchaseInfo = sc.nextLine();
                    cartli = purchase.makePurchase(purchaseInfo, stock, cartli);
                    break;
                case "c":
                    int sum = 0;
                    for (int i = 0; i < cartli.length; i++) {
                        sum = sum + cartli[i];
                    }
                    if (sum == 0) {
                        System.out.println("\nYour cart is currently empty. You cannot cancel anything\n");
                    } else {
                        System.out.println("\nYou choose option C, Please enter itemID and number: (e.g. 3 2)");
                        System.out.print("Your answer:");
                        String cancelInfo = sc.nextLine();
                        cartli = cancel.cancelItem(cancelInfo, stock, cartli);
                    }
                    break;
                case "d":
                    cart.printCart(cars, price, cartli);
                    break;
                case "m":
                    option = payment.makePayment(cars, price, cartli);
                    break;
                case "e":
                    System.out.println("Thank you for using online shopping");
                    break;
                default:
                    System.out.println("Please enter somthing valid");
                    break;
            }
        }

    }

}