public class VehiclePlateGenerator {
    public static void main(String[] args) {
        // Create empty string to store plate number
        String plateNumber = "";

        // Generate first random letter
        char firstLetter = (char) ('A' + (int) (Math.random() * 26));
        plateNumber = plateNumber + firstLetter;

        // Generate second random letter
        char secondLetter = (char) ('A' + (int) (Math.random() * 26));
        plateNumber = plateNumber + secondLetter;

        // Generate third random letter
        char thirdLetter = (char) ('A' + (int) (Math.random() * 26));
        plateNumber = plateNumber + thirdLetter;

        // Generate first random digit
        int firstDigit = (int) (Math.random() * 10);
        plateNumber = plateNumber + firstDigit;

        // Generate second random digit
        int secondDigit = (int) (Math.random() * 10);
        plateNumber = plateNumber + secondDigit;

        // Generate third random digit
        int thirdDigit = (int) (Math.random() * 10);
        plateNumber = plateNumber + thirdDigit;

        // Generate fourth random digit
        int fourthDigit = (int) (Math.random() * 10);
       plateNumber = plateNumber + fourthDigit;

        // Print generated plate number
        System.out.println(plateNumber);
    }
}
