import java.util.Scanner;

public class Problem3
{
    public void run()
    {
        //Variable declaration
        Scanner kb = new Scanner(System.in);
        int assetNum;
        int usefulLife;
        int depYears;
        int counter = 1;
        final int MULTIPLIER = 200;
        String choice;
        char letter = 'Y';
        double salvageValue;
        double depRate;
        double depYearly = 0;
        double depAccumulated = 0;
        double purchasePrice;
        double bookValue;
    
    
        //encompassing while loop to control the user continue decision
        while (letter == 'Y')
        {
            //Prompt for user input
            System.out.print("Please enter the asset number: ");
            assetNum = kb.nextInt();
            System.out.print("Please enter the initial purchase price: ");
            purchasePrice = kb.nextDouble();
            System.out.print("Please enter the useful life: ");
            usefulLife = kb.nextInt();
            System.out.print("Please enter the salvage value: ");
            salvageValue = kb.nextDouble();
            System.out.print("Please enter the number of years of deprecation: ");
            depYears = kb.nextInt();
            
            //print out the inputed values
            System.out.println("\nAsset No: " + assetNum);
            System.out.printf("Initial Purchase Price: $%,8.0f", purchasePrice);
            System.out.println("\nUseful Life:  " + usefulLife + " years");
            System.out.printf("Salvage Value: $%,7.0f", salvageValue);
            
            //calculate depreciation rate
            depRate = 1.0 / usefulLife;
            bookValue = purchasePrice;
            
            //print out the remaining values
            System.out.printf("%nDouble Declining Rate:%,5.0f", depRate * MULTIPLIER);
            System.out.println("\nNumber of Years:  " + depYears + " years");
            
            //print header row for depreciation results
            System.out.println("\nYear\tYearly\t\tAccumulated\tBook");
            System.out.println("\tDepreciation\tDepreciation\tValue\n");
            
            //nested while & if else to calculate deprecation values
            while (counter <= depYears)
            {
                if (counter < usefulLife)
                {
                    depYearly = 2 * depRate * bookValue;
                    depAccumulated += depYearly;
                    bookValue -= depYearly;
                }
                
                else if (counter == usefulLife)
                {
                    depYearly = bookValue - salvageValue;
                    depAccumulated = purchasePrice - bookValue;
                    bookValue = salvageValue;
                }
                
                else if (counter > usefulLife)
                {
                    depYearly = 0;
                }
            
                System.out.print(counter);
                System.out.printf("\t%,6.0f\t\t%,6.0f\t\t%,6.0f%n",depYearly,depAccumulated,bookValue);
                counter++;
            }
        
            System.out.print("\nEnter more values? (Y)es or (N)o: ");
            choice = kb.next();
            letter = choice.toUpperCase().charAt(0);
            counter = 1;
            depAccumulated = 0;
            System.out.println();
        }
    }
}