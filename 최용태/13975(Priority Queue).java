import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

    public static void init(PriorityQueue<Long> pq,int size) throws IOException {
        StringTokenizer s=new StringTokenizer(br.readLine()," ");
        for(int i=0;i<size;i++) pq.offer(Long.parseLong(s.nextToken()));
    }
    public static void main(String[] args) throws IOException {
        int T=Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++){
            int N=Integer.parseInt(br.readLine());
            long result=0;
            PriorityQueue<Long> pq=new PriorityQueue<>();
            init(pq,N);
            while(pq.size()>1){
                long c1=pq.poll();
                long c2=pq.poll();
                result+=c1+c2;
                pq.offer(c1+c2);
            }
            bw.write(result+"\n");
        }

        bw.flush();
    }
}