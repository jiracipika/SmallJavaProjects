public class Pair<T> {
    private T first;
    private T second;

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    public static void main(String[] args) {
        // Test Case 1
        Pair<Integer> pair1 = new Pair<>(1, 2);
        System.out.println("pair1.getFirst() = " + pair1.getFirst() + ", pair1.getSecond() = " + pair1.getSecond());

        // Test Case 2
        Pair<String> pair2 = new Pair<>("hello", "world");
        System.out.println("pair2.getFirst() = " + pair2.getFirst() + ", pair2.getSecond() = " + pair2.getSecond());
    }
}
