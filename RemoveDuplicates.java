import java.util.ArrayList;
import java.util.Scanner;

public class RemoveDuplicates {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();

        System.out.print("Enter 10 integers: ");
        for (int i = 0; i < 10; i++) {
            list.add(input.nextInt());
        }

        removeDuplicate(list);

        System.out.print("The distinct integers are ");
        for (Integer number : list) {
            System.out.print(number + " ");
        }
        input.close();
    }

    public static void removeDuplicate(ArrayList<Integer> list) {
        ArrayList<Integer> tempList = new ArrayList<>();
        for (Integer integer : list) {
            if (!tempList.contains(integer)) {
                tempList.add(integer);
            }
        }
        list.clear();
        list.addAll(tempList);
    }
}
