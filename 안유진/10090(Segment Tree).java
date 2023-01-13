import java.util.*;
import java.io.*;

public class Solution{
    static int A[];
    static long tree[];

    static int N;

    public static void update(int node, int start, int end, int index){
        if (index < start || index > end){
            return;
        }
        if(start == end){
            tree[node]++;
            return;
        }
        update(node * 2, start, (start + end) / 2, index);
        update(node * 2 + 1,(start + end) / 2 + 1, end, index);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    public static long query(int node, int start, int end, int left, int right){
        if(left > end || right < start) {
            return 0;
        }
        if(left <= start && end <= right){
            return tree[node];
        }
        long leftSum = query(node * 2, start, (start + end) / 2, left, right);
        long rightSum = query(node * 2 + 1, (start + end)/2 + 1, end, left, right);
        return leftSum + rightSum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        A = new int[N + 1];
        tree = new long[N * 4];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 1; i < N + 1; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        long answer = 0;
        for(int i = N; i >= 0; i--){
            update(1, 1, N, A[i]);
            answer += (query(1, 1, N, 1, A[i] - 1));
        }

        System.out.println(answer);
    }
}
