import java.util.*;
import java.io.*;

public class Main{
    static int A[], N, M;
    static Pair tree[];

    public static void init(int node, int start, int end){
        if(start == end) {
            tree[node] = new Pair(start, A[start]);
        }else{
            init(node * 2, start, (start + end) / 2);
            init(node * 2 + 1, (start + end) / 2 + 1, end);

            if(tree[node * 2].value <= tree[node * 2 + 1].value){
                tree[node] = new Pair(tree[node * 2].index, tree[node * 2].value);
            }else{
                tree[node] = new Pair(tree[node * 2 + 1].index, tree[node * 2 + 1].value);
            }
        }
    }

    public static void update(int node, int start, int end, int index, int value){
        if (index < start || index > end){
            return;
        }
        if(start == end) {
            A[index] = value;
            tree[node] = new Pair(index, value);
            return;
        }
        update(node * 2, start, (start + end) / 2, index, value);
        update(node * 2 + 1, (start + end) / 2 + 1, end, index, value);

        if(tree[node * 2].value <= tree[node * 2 + 1].value){
            tree[node] = new Pair(tree[node * 2].index, tree[node * 2].value);
        }else{
            tree[node] = new Pair(tree[node * 2 + 1].index, tree[node * 2 + 1].value);
        }
    }

    public static Pair query(int node, int start, int end, int left, int right){
        if(left > end || right < start) {
            return new Pair(Integer.MAX_VALUE, Integer.MAX_VALUE);
        }

        if(left <= start && end <= right){
            return tree[node];
        }

        Pair l = query(node * 2, start, (start + end) / 2, left, right);
        Pair r = query(node * 2 + 1, (start + end) / 2 + 1, end, left, right);

        if(l.value <= r.value){
            return l;
        } else {
            return r;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        A = new int[N + 1];
        tree = new Pair[N * 4];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i < N + 1; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        init(1, 1, N);

        M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int index = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            if(num == 1){
                update(1, 1, N, index, value);
            }else{
                Pair temp = query(1, 1, N, index, value);
                sb.append(temp.index).append('\n');
            }
        }

        System.out.println(sb);
    }
}
class Pair{
    int index;
    int value;

    Pair(int i, int v) {
        index = i;
        value = v;
    }
}
