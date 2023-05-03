import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder writer = new StringBuilder();
        PriorityQueue<Integer> left_pq = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> right_pq = new PriorityQueue<>();
        int N = Integer.parseInt(br.readLine());
        int mid=Integer.parseInt(br.readLine());
        writer.append(mid).append("\n");

        for (int size = 1; size < N; size++) {
            int n = Integer.parseInt(br.readLine());

            PriorityQueue<Integer> pq= mid < n ? right_pq : left_pq;
            pq.offer(n);

            int left=left_pq.size();
            int right=right_pq.size();

            if((left+right+1)%2==0 && mid > n) {
                int newMid = left_pq.poll();
                right_pq.offer(mid);
                mid=newMid;
            }else if(Math.abs(left - right)>1){
                int newMid=pq.poll();

                if(mid<=newMid) left_pq.offer(mid);
                else right_pq.offer(mid);

                mid=newMid;
            }

            writer.append(mid).append("\n");
        }
        System.out.println(writer);
    }
}