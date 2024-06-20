/**
 * The CoinFlip class simulates flipping a coin and stores the results of 100 flips.
 */
public class CoinFlip {

    // Boolean array to store the results of coin flips
    private static boolean[] coinFlips = new boolean[100];

    /**
     * flipIt method flips the coin and stores result using the store method.
     */
    public static void flipIt() {
        for (int i = 0; i < coinFlips.length; i++) {
            boolean flipResult = Math.random() > .5;
            store(i, flipResult);
        }
    }

    /**
     * The store method stores result of the coin flips.
     * @param index The index in the array where the result will be stored.
     * @param flipResult The result of the coin flip.
     */
    private static void store(int index, boolean flipResult) {
        coinFlips[index] = flipResult;
    }

    /**
     * The display method displays the results of the coin flips in 10 rows and 10 columns,
     * and reports the total number of heads, tails, and the longest run of heads.
     */
    public static void display() {
        int headsCount = 0;
        int tailsCount = 0;
        int longestRun = 0;
        int currentRun = 0;

        for (int i = 0; i < coinFlips.length; i++) {
            if (i % 10 == 0) {
                System.out.println();
            }

            if (coinFlips[i]) {
                headsCount++;
                System.out.print("heads ");
                currentRun++;
            } else {
                tailsCount++;
                System.out.print("tails ");
                currentRun = 0;
            }

            int j = i;
            while (j < coinFlips.length && coinFlips[j]) {
                currentRun++;
                j++;
            }
            if (currentRun > longestRun) {
                longestRun = currentRun;
            }
        }

        System.out.println("\nHeads: " + headsCount);
        System.out.println("Tails: " + tailsCount);
        System.out.println("Longest run of heads is: " + longestRun);
    }

    /**
     * The main method demonstrates the usage of the CoinFlip class methods.
     */
    
    public static void main(String[] args) {
        CoinFlip.flipIt();
        CoinFlip.display();
    }
}
