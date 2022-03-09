package _2022_1학기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Q10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Deque<Integer> Q = new ArrayDeque<>();
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            String str = st.nextToken();
            switch (str){
                case "push_front":
                    Q.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    Q.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    System.out.println(Q.isEmpty() ? -1 : Q.pollFirst());
                    break;
                case "pop_back":
                    System.out.println(Q.isEmpty() ? -1 : Q.pollLast());
                    break;
                case "size":
                    System.out.println(Q.size());
                    break;
                case "empty":
                    System.out.println(Q.isEmpty() ? 1 : 0);
                    break;
                case "front":
                    System.out.println(Q.isEmpty() ? -1 : Q.getFirst());
                    break;
                case "back":
                    System.out.println(Q.isEmpty() ? -1 : Q.getLast());
                    break;
            }
        }
    }
}
