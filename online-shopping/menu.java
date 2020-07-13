public class menu{
    public static void printMenu(String[] cars, int[] price, int[] stock, int[] cartli) {
        // function that print out the menu with item name, prize and stock number
        System.out.println("\nYou choose option A. Here is the menu");
        System.out.println("itemID\titem name\t\tprice\tnumber");
        for (int i = 0; i < cars.length; i++)
        {
            System.out.println(i+1+"\t"+cars[i]+"\t\t\t"+price[i]+"\t"+(stock[i]-cartli[i]));
        }
        System.out.println("\n-------------------------------------------------------");
        System.out.println("Please choose your option:");
        System.out.println("-------------------------------------------------------");
    }
}