class Staircasecomplicated {
    public static void main(String[] args) {
        int numberOfLines = 4;  // Setting the number of lines to 4

        System.out.println("Staircase Pattern:");
        System.out.println();   // Move to the next line for visibility

        for (int row = 1; row <= numberOfLines; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print("#");
            }
            System.out.println();  // Move to the next line after each row
        }
    }
}
