import java.util.*;
import java.io.*;

public class Main{
    static int N, M, K;
    static long A[], tree[];

    public static void init(int node, int start, int end){
        if(start == end){
            tree[node] = A[start];
        }else{
            init(node * 2, start, (start + end) / 2);
            init(node * 2 + 1, (start + end) / 2 + 1, end);
            tree[node] = Math.min(tree[node * 2], tree[node * 2 + 1]);
        }
    }

    public static void update(int node, int start, int end, int index, int value){
        if(index < start || index > end){
            return;
        }
        if (start == end) {
            A[index] = value;
            tree[node] = value;
            return;
        }
        update(node * 2, start, (start + end) / 2, index, value);
        update(node * 2 + 1, (start + end) / 2 + 1, end, index, value);
        tree[node] = Math.min(tree[node * 2], tree[node * 2 + 1]);
    }

    public static long query(int node, int start, int end, int left, int right){
        if(left > end || right < start){
            return Long.MAX_VALUE;
        }
        if(left <= start && end <= right) {
            return tree[node];
        }
        long l = query(node * 2 , start, (start + end) / 2, left, right);
        long r = query(node * 2 + 1, (start + end) / 2 + 1, end, left, right);

        return Math.min(l, r);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        A = new long[N + 1];
        tree = new long[N * 4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i < N + 1; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        init(1, 1, N);

        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int what = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(what == 1) {
                update(1, 1, N, a, b);
            } else {
                sb.append(query(1, 1, N, a, b)).append('\n');
            }
        }

        System.out.println(sb);
    }
}
