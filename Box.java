public class Box<T extends Comparable<T>> {
    private T content;

    public Box(T content) {
        this.content = content;
    }

    public boolean isGreaterThan(T other) {
        return content.compareTo(other) > 0;
    }

    public static void main(String[] args) {
        // Test Case 1: Compare Integer objects
        Box<Integer> iBox = new Box<>(5);
        System.out.println("Integer Test: " + iBox.isGreaterThan(3)); 

        // Test Case 2: Compare String objects
        Box<String> sBox = new Box<>("Java");
        System.out.println("String Test: " + sBox.isGreaterThan("C++"));
    }
}

