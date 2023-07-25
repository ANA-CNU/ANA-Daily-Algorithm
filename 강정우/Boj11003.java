import java.util.*;
import java.io.*;

public class Boj11003 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < n; i++) {
            while (!pq.isEmpty() && pq.peek() < i - l + 1) {
                pq.poll();
            }
            pq.offer(i);
            bw.write(arr[pq.peek()] + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
