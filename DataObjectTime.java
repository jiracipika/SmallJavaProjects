import java.io.*;
import java.util.Date;

public class DataObjectTime {

    public static void main(String[] args) throws IOException {
        try (DataOutputStream output = new DataOutputStream(new FileOutputStream("file1.dat"))) {
            output.writeUTF(new Date().toString());
            output.writeDouble(2.5);
            int[] numbers = {1, 2, 3, 4, 5};
            for (int i : numbers) {
                output.writeInt(i);
            }
        }

        try (DataInputStream input = new DataInputStream(new FileInputStream("file1.dat"))) {
            System.out.println("Date: " + input.readUTF());
            System.out.println("Double value: " + input.readDouble());
            System.out.print("Int values: ");
            for (int i = 0; i < 5; i++) {
                System.out.print(input.readInt() + " ");
            }
        }
    }
}
