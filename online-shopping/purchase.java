public class purchase {
    public static int[] makePurchase(String info, int[] stock, int[] cartli) {
        //function that used to make purchase
        //It will check if the inout is valid first
        //If the item number is greater than the stock number, it would not allow the purchase
        String[] splited = info.split(" ");
        int value1 = 0;
        int value2 = 0;
        boolean canPurchase = true;
        try {
            value1 = Integer.parseInt(splited[0]);
            value2 = Integer.parseInt(splited[1]);
            if ((value1 < 1) || (value2 < 1)) {
                System.out.println("Both ID and number need to be positive");
                canPurchase = false;
            }
        } catch (NumberFormatException e) {
            System.out.println("You need to enter something valid");
            canPurchase = false;
        }
        if (canPurchase) {
            if (value1 > stock.length) {
                System.out.println("The item you want to buy does not exist");
            }else if ((value2 + cartli[value1-1]) > stock[value1-1])
            {
                System.out.println("We do not have that many item "+value1+" in stock.");
            }else{
                cartli[value1-1] = cartli[value1-1] + value2;
                System.out.println(value2 + " of item "+ value1 + " has been added into your cart");
            }
            
        }

        System.out.println("\n-------------------------------------------------------");
        System.out.println("Please choose your option:");
        System.out.println("-------------------------------------------------------");

        return cartli;
    }
}