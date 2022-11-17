import java.util.Scanner;

public class Problem1
{
    public void run()
    {
        //Variable declaration
        Scanner kb = new Scanner(System.in);
        final double GRAVITY = 9.8;
        double initialVelocity;
        double begAngle;
        double endAngle;
        double increment;
        double launchAngleRad;
        double flightTime;   
        double maximumHeight;
        double horizontalRange;
        double incrementedAngle;
        int trial = 1;
        
        
        //Prompt for user imput
        System.out.print("Please enter the initial velocity (in meters/sec): ");
        initialVelocity = kb.nextDouble();
        System.out.print("Please enter the beginning angle (in degrees): ");
        begAngle = kb.nextDouble();
        System.out.print("Please enter the ending angle (in degrees): ");
        endAngle = kb.nextDouble();
        System.out.print("Please enter the angle increment (in degrees): ");
        increment = kb.nextDouble();
        incrementedAngle = begAngle;
        
        //while loop to calculate and print results based on user input
        while (incrementedAngle <= endAngle)
        {
            //Calculations
            launchAngleRad = Math.toRadians(incrementedAngle);
            flightTime = ((2.0 * initialVelocity) * Math.sin(launchAngleRad)) / GRAVITY;
            maximumHeight = Math.pow(initialVelocity,2) * Math.pow(Math.sin(launchAngleRad),2) / (2.0 * GRAVITY);
            horizontalRange = Math.pow(initialVelocity,2) * Math.sin(2.0 * launchAngleRad) / GRAVITY;
                    
            
            //Output report to user
            System.out.println("\nTrial " + trial);
    
            System.out.printf("%nInitial Velocity: %7.1f meters/sec%n", initialVelocity);
            System.out.printf("Angle of Launch: %8.1f degrees%n", incrementedAngle);
            
            System.out.printf("%nTime of Flight: %10.1f secs%n", flightTime);
            System.out.printf("Maximum Height: %10.1f meters%n", maximumHeight);
            System.out.printf("Horizontal Range: %8.1f meters%n", horizontalRange);
            incrementedAngle += increment;
            trial++;
        }
    }
}