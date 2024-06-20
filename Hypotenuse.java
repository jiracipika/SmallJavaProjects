import java.text.DecimalFormat;
import java.util.Random;

/**
 * This class randomly models a right triangle and calculates its hypotenuse.
 * It shows the usage of random numbers, Math methods and number formatting.
 * 
 * @author Rajin Gajadhar
 * @version 1.0
 */
public class Hypotenuse {
    
    /**
     * A constant holding the value 2.0 for calculations.
     */
    public static final double TWO = 2.0;

    /**
     * The main method where the program starts.
     * @param args Command line arguments (not used).
     */
    public static void main(String[] args) {
        
        // Create a Random object to generate random numbers
        Random random = new Random();
        
        // Generate random numbers for base and height
        double base = random.nextDouble() * 6;
        double height = random.nextDouble() * 6;
        
        // Compute the hypotenuse using Pythagorean theorem
        double hypotenuse = Math.sqrt(Math.pow(base, TWO) + Math.pow(height, TWO));
        
        // Create a DecimalFormat object to format the output
        DecimalFormat formatter = new DecimalFormat("#.##");
        
        // Display the results
        System.out.println("Base of the right triangle: " + formatter.format(base));
        System.out.println("Height of the right triangle: " + formatter.format(height));
        System.out.println("Hypotenuse of the right triangle: " + formatter.format(hypotenuse));
    }
}
