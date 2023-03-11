import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b2357 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+1];
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++){
            arr[i]= Integer.parseInt(br.readLine());
        }
        tree t = new tree(N,arr);
        t.initMin(1,N,1);
        t.initMax(1,N,1);
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int u = t.interval_min(1,N,a,b,1);
            int v = t.interval_max(1,N,a,b,1);
            sb.append(u).append(" "+v).append("\n");
        }
        System.out.println(sb);
    }
}
class tree{
    int[] tree;
    int[] maxTree;
    int[] arr;
    public tree(int N, int[] arr){
        tree = new int[4*N];
        this.arr = arr;
        maxTree = new int[4*N];
    }
    public int initMin(int start, int end, int idx){

        if(start==end){
            return tree[idx]=arr[start];
        }
        int mid = (start+end)/2;
        return tree[idx]=Math.min(initMin(start,mid,idx*2),initMin(mid+1,end,idx*2+1));
    }

    public int interval_min(int start, int end, int left, int right, int idx){
//        if(start==end) return tree[start];
        if(left>end || right<start) return Integer.MAX_VALUE;
        if(left<=start && right>=end) return tree[idx];
        int mid = (start+end)/2;
        return Math.min(interval_min(start,mid,left,right,idx*2),interval_min(mid+1,end,left,right,idx*2+1));
    }

    public int initMax(int start, int end, int idx){
        if(start==end){
            return maxTree[idx]=arr[start];
        }
        int mid = (start+end)/2;
        return maxTree[idx]=Math.max(initMax(start,mid,idx*2),initMax(mid+1,end,idx*2+1));
    }

    public int interval_max(int start, int end, int left, int right, int idx){
        if(left>end || right<start) return Integer.MIN_VALUE;
        if(left<=start && right>=end) return maxTree[idx];
        int mid = (start+end)/2;
        return Math.max(interval_max(start,mid,left,right,idx*2),interval_max(mid+1,end,left,right,idx*2+1));
    }
}