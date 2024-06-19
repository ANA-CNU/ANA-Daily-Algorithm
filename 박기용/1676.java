import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        BigInteger bigInteger = new BigInteger(String.valueOf(factorial(BigInteger.valueOf(num))));
        int zerocount = 0;

        while (true) {
            if (bigInteger.remainder(BigInteger.valueOf(10)).equals(BigInteger.valueOf(0))) {
                bigInteger = bigInteger.divide(BigInteger.valueOf(10));
                zerocount++;
            } else {
                break;
            }
        }

        bw.write(zerocount + "");
        bw.close();
    }

    static BigInteger factorial(BigInteger a) {
        if (a.equals(BigInteger.valueOf(1)) || a.equals(BigInteger.valueOf(0))) {
            return BigInteger.valueOf(1);
        } else {
            return a.multiply(factorial(a.subtract(BigInteger.valueOf(1))));
        }
    }
}
