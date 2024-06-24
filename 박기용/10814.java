import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        Queue<Object[]> arr = new LinkedList<>();

        for (int i = 0; i < count; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            String b = st.nextToken();
            arr.add(new Object[]{a, b});
        }

        Queue<Object[]> result;
        result = Divisor(arr);

        while (!result.isEmpty()) {
            bw.write(result.peek()[0] + " " + result.poll()[1]);
            bw.newLine();
        }
        bw.close();
    }

    static Queue<Object[]> Divisor (Queue<Object[]> a) {
        if (a.size() > 1) {
            int m = a.size() / 2;
            Queue<Object[]> s = new LinkedList<>();
            for (int j = 0; j < m; j++) {
                s.add(a.poll());
            }
            Queue<Object[]> d = new LinkedList<>();
            while (!a.isEmpty()) {
                d.add(a.poll());
            }

            return Sorter(Divisor(s), Divisor(d));
        } else {
            return a;
        }
    }

    static Queue<Object[]> Sorter (Queue<Object[]> a, Queue<Object[]> b) {
        Queue<Object[]> queue = new LinkedList<>();
        while (!a.isEmpty() && !b.isEmpty()) {
            if ((int) a.peek()[0] > (int) b.peek()[0]) {
                queue.add(b.poll());
            } else {
                queue.add(a.poll());
            }
        }

        while (!a.isEmpty()) {
            queue.add(a.poll());
        }
        while (!b.isEmpty()) {
            queue.add(b.poll());
        }

        return queue;
    }
}
