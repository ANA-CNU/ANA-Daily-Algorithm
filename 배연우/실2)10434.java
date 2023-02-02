import com.sun.source.tree.Tree;

import java.util.*;
import java.io.*;
import java.util.stream.IntStream;

public class Main {
    static int[] arr = IntStream.rangeClosed(0, 10_000).toArray();
    static TreeSet<Integer> prime;
    static {
        arr[1] = 0;
    }

    public static void main(String[] args) throws IOException {
        ii();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < x; i++) {
            int tar = Integer.parseInt(br.readLine().split(" ")[1]);
            sb.append(i+1).append(" ").append(tar).append(" ");
            if (!(isPrime(tar) && isHappy(tar)))
                sb.append("NO");
            else
                sb.append("YES");
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void ii() {
        for (int i = 0; i < 10001; i++) {
            if (arr[i] == 0)
                continue;

            for (int j = arr[i] * 2; j < 10001; j += arr[i]) {
                arr[j] = 0;
            }
        }

        prime = new TreeSet<>();
        for (int i : arr) {
            if (i != 0)
                prime.add(i);
        }
    }

    public static boolean isPrime(int tar) {
        return prime.contains(tar);
    }

    public static boolean isHappy(int tar) {
        for (int i = 0; i < 1000; i++) {
            int tmp = 0;
            for (int j = tar; j != 0; j /= 10)
                tmp += Math.pow(j % 10, 2);
            if ((tar = tmp) == 1)
                return true;
            else if (tar == 4)
                return false;
        }
        return false;
    }
}