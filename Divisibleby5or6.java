import java.math.BigInteger;

public class Divisibleby5or6 {
    public static void main(String[] args) {
        BigInteger value = BigInteger.valueOf(Long.MAX_VALUE).add(BigInteger.ONE);
        int count = 0;
        while (count < 10) {
            if (value.mod(BigInteger.valueOf(5)).equals(BigInteger.ZERO) || value.mod(BigInteger.valueOf(6)).equals(BigInteger.ZERO)) {
                System.out.println(value);
                count++;
            }
            value = value.add(BigInteger.ONE);
        }
    }
}
