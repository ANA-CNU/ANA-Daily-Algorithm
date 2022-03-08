package _2022_1학기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Deque<Integer> Q = new ArrayDeque<>();
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            String str = st.nextToken();
            switch (str){
                case "push":
                    Q.offer(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    System.out.println(Q.isEmpty() ? -1 : Q.pop());
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
