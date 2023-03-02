import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b11505 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long[] arr = new long[N+1];
        for(int i=1; i<=N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }//1 2 3 4 5
        tree t = new tree(N, arr);
        t.init(1,N,1);//tree 초기화
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M+K; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());//명령 코드
            int b = Integer.parseInt(st.nextToken());//1: 바꾸려는 위치, 2:구간곱 시작 지점
            long c = Integer.parseInt(st.nextToken());//1: 바꾸려는 값, 2:구간곱 끝 지점
            if(a==1){
                t.update(1,N,1,b,c);//구간 변화
                t.arr[b]=c;
            }else {
                sb.append(t.interval_multiple(1,N,1,b,c)).append("\n");
            }
        }
        System.out.println(sb);
    }
}
class tree{
    final static long mod = 1000000007;
    long[] arr;
    long[] tree;
    int N;

    public tree(int n, long[] arr) {
        N = n;
        tree = new long[n*4];
        this.arr = arr;
    }

    public long init(int start, int end, int idx){
        if(start==end){
            return tree[idx]=arr[start];
        }
        int mid = (start+end)/2;
        return tree[idx]=init(start,mid,idx*2)*init(mid+1,end,idx*2+1)%mod;
    }
    public long interval_multiple(int start, int end, int idx, int left, long right){
        if(left>end || right<start){
            return 1;
        }
        if(left<=start && right>=end){
            return tree[idx];
        }
        int mid = (start+end)/2;
        return interval_multiple(start,mid,idx*2,left,right)*interval_multiple(mid+1,end,idx*2+1,left,right)%mod;
    }
    public void update(int start, int end, int idx, int what, long value){
        if(what<start || what>end){
            return;
        }

        if(start==end){
            tree[idx]=value;
            return;
        }

        int mid = (start+end)/2;

        update(start,mid,idx*2,what,value);
        update(mid+1,end,idx*2+1,what,value);

        tree[idx] = tree[2 * idx] * tree[2 * idx + 1]%mod;
    }
//    public void update(int start, int end, int idx, int what, long value){
//        if(what<start || what>end){
//            return;
//        }
//        tree[idx]*=value;
//        if(start==end){
//            return;
//        }
//        int mid = (start+end)/2;
//        update(start,mid,idx*2,what,value);
//        update(mid+1,end,idx*2+1,what,value);
//    }
}