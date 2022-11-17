import java.util.Scanner;

public class Problem2
{
    public void run()
    {
        //Variable declaration
        Scanner kb = new Scanner(System.in);
        int invCode;  //six digit code for inventory
        int numUnits;
        int itemCode;
        int trailingDigits;
        final int DIVISOR = 10000;
        double pricePerUnit;
        double invValue;
        double totalInventory = 0;
        
        //Prompt for user imput
        System.out.print("Please enter the six digit inventory code: ");
        invCode = kb.nextInt();
        System.out.print("Please enter the number of units: ");
        numUnits = kb.nextInt();
        System.out.print("Please enter the price per unit: ");
        pricePerUnit = kb.nextDouble();
        
        //while loop with nested if to accept unlimited entries, stopping with a negative number
        while (invCode > 0)
        {
            itemCode = invCode / DIVISOR;
            trailingDigits = invCode % DIVISOR;
            invValue = numUnits * pricePerUnit;
            totalInventory += invValue;
            
            System.out.println("\nInventory Code:  " + itemCode + "-" + trailingDigits);
            System.out.println("Number of Units: " + numUnits);
            System.out.printf("Price per Unit:  $%(8.2f%n", pricePerUnit);
            System.out.printf("Inventory Value: $%(8.2f%n", invValue);
            
            System.out.print("\n\nPlease enter the six digit inventory code: ");
            invCode = kb.nextInt();
            
            if (invCode > 0)
            {
                System.out.print("Please enter the number of units: ");
                numUnits = kb.nextInt();
                System.out.print("Please enter the price per unit: ");
                pricePerUnit = kb.nextDouble();
            }
        }
        
        //print out the total of all values previously calculated
        System.out.printf("%nTotal Inventory: $%(8.2f%n", totalInventory);
    }
}