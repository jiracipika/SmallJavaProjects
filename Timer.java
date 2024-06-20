class Timer {
    private int hours;
    private int minutes;
    private int seconds;

    // 1. No-arg constructor
    public Timer() {
        this(0, 0, 0);
    }

    // 2. Parameterized constructor
    public Timer(int hours, int minutes, int seconds) {
        setHours(hours);
        setMinutes(minutes);
        setSeconds(seconds);
    }

    // 3. & 4. Getters and Setters
    public void setHours(int hours) {
        this.hours = Math.max(hours, 0);
    }

    public void setMinutes(int minutes) {
        this.minutes = Math.max(minutes, 0);
    }

    public void setSeconds(int seconds) {
        this.seconds = Math.max(seconds, 0);
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }
}

class TestTimer {
    public static void main(String[] args) {
        java.util.Scanner input = new java.util.Scanner(System.in);
        Timer[] timers = new Timer[3];

        int totalHours = 0;
        int totalMinutes = 0;
        int totalSeconds = 0;

        for (int i = 0; i < 3; i++) {
            System.out.print("Enter the " + (i + 1) + 
                ordinal(i + 1) + " Timer object (hours minutes seconds): ");
            int h = input.nextInt();
            int m = input.nextInt();
            int s = input.nextInt();
            timers[i] = new Timer(h, m, s);

            // Summing the values
            totalHours += timers[i].getHours();
            totalMinutes += timers[i].getMinutes();
            totalSeconds += timers[i].getSeconds();
        }

        // Handle overflow from seconds and minutes to upper units
        totalMinutes += totalSeconds / 60;
        totalSeconds %= 60;
        totalHours += totalMinutes / 60;
        totalMinutes %= 60;
 
        input.close();

        System.out.println("The total number of hours is " + totalHours);
        System.out.println("The total number of minutes is " + totalMinutes);
        System.out.println("The total number of seconds is " + totalSeconds);
    }

    private static String ordinal(int i) {
        String[] ordinals = {"first", "second", "third"};
        return i > 0 && i <= 3 ? ordinals[i-1] : i + "th";
    }
}
