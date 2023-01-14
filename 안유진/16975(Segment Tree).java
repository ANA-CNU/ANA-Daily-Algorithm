import java.util.*;
import java.io.*;

public class Solution{
    static long A[], tree[], lazy[];
    static int N, M, K;

    public static void init(int node, int start, int end){
        if(start == end){
            tree[node] = A[start];
        }else{
            init(node * 2, start, (start + end) / 2);
            init(node * 2 + 1, (start + end) / 2 + 1, end);
            tree[node] = tree[node * 2] + tree[node * 2 + 1];
        }
    }

    public static void update(int node, int start, int end, int left, int right, long value){
        lazy_update(node, start, end);

        if(left > end || right < start){
            return;
        }
        if(left <= start && end <= right){
            tree[node] += ((end - start + 1) * value);
            if(start != end){
                lazy[node * 2] += value;
                lazy[node * 2 + 1] += value;
            }
            return;
        }
        update(node * 2, start, (start + end) / 2, left, right, value);
        update(node * 2 + 1, (start + end) / 2 + 1, end, left, right, value);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    public static long query(int node, int start, int end, int q){
        lazy_update(node, start, end);

        if(q > end || q < start){
            return 0;
        }

        if(q <= start && end <= q){
            return tree[node];
        }

        long l = query(node * 2, start, (start + end) / 2, q);
        long r = query(node * 2 + 1, (start + end) / 2 + 1, end, q);

        return (l + r);
    }

    public static void lazy_update(int node, int start, int end) {
        if(lazy[node] != 0){
            tree[node] += ((end - start + 1) * lazy[node]);
            if(start != end){
                lazy[node * 2] += lazy[node];
                lazy[node * 2 + 1] += lazy[node];
            }
            lazy[node] = 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        A = new long[N + 1];
        tree = new long[N * 4];
        lazy = new long[N * 4];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i < N + 1; i++) {
            A[i] = Long.parseLong(st.nextToken());
        }

        init(1, 1, N);

        M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());

            if(a == 1){
                int l = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                long c = Long.parseLong(st.nextToken());
                update(1, 1, N, l, r, c);
            }else{
                int q = Integer.parseInt(st.nextToken());
                sb.append(query(1, 1, N, q)).append('\n');
            }
        }

        System.out.println(sb);
    }
}
