import java.util.List;
import java.util.Arrays;

public class DataProcessingApplication {

    // Find last element of list
    public static <T> T LastElement(List<T> list) {
        // Check if list is empty; otherwise return null
        if (list == null || list.isEmpty()) {
            return null;
        }

        // If the list has one element, return that element
        if (list.size() == 1) {
            return list.get(0);
        }

        // Call method with subList
        return LastElement(list.subList(1, list.size()));
    }

    public static void main(String[] args) {
        // Test Case 1
        List<String> stringList = Arrays.asList("A", "B", "C");
        System.out.println(LastElement(stringList));

        // Test Case 2
        List<Integer> integerList = Arrays.asList(1, 2, 3);
        System.out.println(LastElement(integerList));
    }
}
