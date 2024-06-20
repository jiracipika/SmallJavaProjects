public class PyramidPattern {
    public static void main(String[] args) {
        int maxNum = 128; // Maximum number in the pyramid
        int levels = (int)(Math.log(maxNum)/Math.log(2)) + 1; 
        
        for (int i = 1; i <= levels; i++) {
            int centerValue = (int) Math.pow(2, i - 1);
            
            int spaces = levels - i;
            for (int s = 0; s < spaces; s++) {
                System.out.print("    ");  //for each missing number
            }
            
            // Loop to print the left side and center of the pyramid level.
            for (int j = 1; j <= centerValue; j *= 2) {
                System.out.printf("%4d", j);
            }
            
            // Loop to print the right side of the pyramid level.
            for (int j = centerValue / 2; j >= 1; j /= 2) {
                System.out.printf("%4d", j);
            }
            
            // Move to the next line for the next level of the pyramid.
            System.out.println();
        }
    }
}
