import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer>[] arr = new Queue[21];

        for(int i = 0; i < 21; i++) {
            arr[i] = new ArrayDeque<>();
        }

        long count = 0;
        for(int i = 1; i <= n; i++) {
            int length = br.readLine().length();

            while (!arr[length].isEmpty()) {
                if(i - arr[length].peek() <= k) {
                    count += arr[length].size();
                    break;
                }

                arr[length].remove();
            }

            arr[length].add(i);
        }

        System.out.println(count);
    }
}
