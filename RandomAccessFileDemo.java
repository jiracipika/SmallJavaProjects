import java.io.*;

public class RandomAccessFileDemo {
    public static void main(String[] args) {
        try {
            RandomAccessFile inout = new RandomAccessFile("data.dat", "rw"); 
            inout.setLength(0); 

            writeIntAt(inout, 10, 15);
            writeIntAt(inout, 20, 0);

            inout.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeIntAt(RandomAccessFile inout, int i, long position) throws IOException {
        inout.seek(position * 4); 

        inout.writeInt(i);
    }
}
