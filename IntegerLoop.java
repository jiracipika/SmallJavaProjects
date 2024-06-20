public class IntegerLoop {
    public static void main(String[] args) {
        // Initialize counters for each divisor from 1 to 9
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int count4 = 0;
        int count5 = 0;
        int count6 = 0;
        int count7 = 0;
        int count8 = 0;
        int count9 = 0;

        // Loop through all integers from 1 to 1,000,000
        for (int i = 1; i <= 1000000; i++) {
            if (i % 1 == 0) {
                count1++;
            }
            if (i % 2 == 0) {
                count2++;
            }
            if (i % 3 == 0) {
                count3++;
            }
            if (i % 4 == 0) {
                count4++;
            }
            if (i % 5 == 0) {
                count5++;
            }
            if (i % 6 == 0) {
                count6++;
            }
            if (i % 7 == 0) {
                count7++;
            }
            if (i % 8 == 0) {
                count8++;
            }
            if (i % 9 == 0) {
                count9++;
            }
        }

        // Print out the counts
        System.out.println("There are " + count1 + " numbers divisible by 1");
        System.out.println("There are " + count2 + " numbers divisible by 2");
        System.out.println("There are " + count3 + " numbers divisible by 3");
        System.out.println("There are " + count4 + " numbers divisible by 4");
        System.out.println("There are " + count5 + " numbers divisible by 5");
        System.out.println("There are " + count6 + " numbers divisible by 6");
        System.out.println("There are " + count7 + " numbers divisible by 7");
        System.out.println("There are " + count8 + " numbers divisible by 8");
        System.out.println("There are " + count9 + " numbers divisible by 9");
    }
}
