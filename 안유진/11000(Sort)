import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Pair> priorityQueue = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if(o1.start == o2.start) {
                    return o1.end - o2.end;
                }else{
                    return o1.start - o2.start;
                }
            }
        });
        while (N --> 0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            priorityQueue.add(new Pair(start, end));
        }

        PriorityQueue<Integer> result = new PriorityQueue<>();
        result.add(priorityQueue.remove().end);

        while (!priorityQueue.isEmpty()) {
            Pair temp = priorityQueue.remove();

            if(!result.isEmpty()){
                int end = result.peek();
                if(temp.start >= end) {
                    result.remove();
                }
            }

            result.add(temp.end);
        }

        System.out.println(result.size());
    }
}
class Pair{
    int start;
    int end;
    Pair(int s, int e) {
        start = s;
        end = e;
    }
}
