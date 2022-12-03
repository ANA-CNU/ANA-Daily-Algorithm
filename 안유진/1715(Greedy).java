import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> arrayList = new ArrayList<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int i = 0; i < N; i++) {
            queue.add(Integer.parseInt(br.readLine()));
        }

        if(N == 1) {
            System.out.println(0);
            return;
        }

        while (true) {
            int first = queue.remove();
            int second = queue.remove();

            int sum = first + second;
            arrayList.add(sum);
            queue.add(sum);

            if(queue.size() == 1) {
                break;
            }
        }

        long totalSum = 0;

        for(int temp : arrayList) {
            totalSum += temp;
        }

        System.out.println(totalSum);
    }
}
